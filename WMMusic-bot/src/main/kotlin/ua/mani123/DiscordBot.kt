package ua.mani123

import com.github.topi314.lavasrc.flowerytts.FloweryTTSSourceManager
import com.github.topi314.lavasrc.spotify.SpotifySourceManager
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder
import net.dv8tion.jda.api.sharding.ShardManager
import net.dv8tion.jda.api.utils.Compression
import net.dv8tion.jda.api.utils.MemberCachePolicy
import net.dv8tion.jda.api.utils.cache.CacheFlag
import org.bstats.MetricsBase
import org.bstats.charts.SingleLineChart
import org.bukkit.Bukkit
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ua.mani123.audio.GuildMusicManager
import ua.mani123.commands.*
import ua.mani123.dataFromFile.ConfigUtils
import ua.mani123.dataFromFile.data.ConfigData
import ua.mani123.dataFromFile.data.LanguageData
import ua.mani123.dataFromFile.data.StatsData
import ua.mani123.listeners.*
import java.lang.reflect.Method
import kotlin.system.exitProcess


class DiscordBot : Product {

    var configPath = "/config.yml"
    var languagePath = "/lang.yml"
    var statsPath = "/bstats.yml"
    var logger = LoggerFactory.getLogger(this.javaClass) as Logger
    lateinit var config: ConfigData
    lateinit var language: LanguageData
    private lateinit var stats: StatsData
    val musicManagers: MutableMap<Long, GuildMusicManager> = mutableMapOf()
    val commands: MutableSet<CommandApi> = mutableSetOf()
    private lateinit var metrics: MetricsBase
    val playerManager = DefaultAudioPlayerManager()
    private var serviceEnabled = false
    lateinit var jda: ShardManager

    private fun runBot() {
        config = ConfigUtils(logger).loadFile(configPath, ConfigData())
        language = ConfigUtils(logger).loadFile(languagePath, LanguageData())
        stats = ConfigUtils(logger).loadFile(statsPath, StatsData())
        if (config.command.current) commands.add(CurrentCommand(this))
        if (config.command.stop) commands.add(StopCommand(this))
        if (config.command.list) commands.add(ListCommand(this))
        if (config.command.next) commands.add(NextCommand(this))
        if (config.command.repeat) commands.add(RepeatCommand(this))
        if (config.command.pause) commands.add(PauseCommand(this))
        if (config.command.play) commands.add(PlayCommand(this))
        if (config.command.skip) commands.add(SkipCommand(this))
        if (config.command.volume) commands.add(VolumeCommand(this))
        try {
            jda = DefaultShardManagerBuilder.createLight(config.botToken).setCompression(Compression.ZLIB)
                .setMemberCachePolicy(MemberCachePolicy.VOICE).enableCache(
                    mutableListOf(
                        CacheFlag.VOICE_STATE
                    )
                ).enableIntents(
                    mutableListOf(
                        GatewayIntent.GUILD_VOICE_STATES
                    )
                ).addEventListeners(
                    CommandsListener(this),
                    GuildListener(this),
                    ReadyListener(this),
                    AutoCompleteListener(this),
                    VoiceListeners(this)
                ).build()
            if (config.spotify.enable) {
                playerManager.registerSourceManager(
                    SpotifySourceManager(
                        null,
                        config.spotify.clientId,
                        config.spotify.clientSecret,
                        config.spotify.countryCode,
                        playerManager
                    )
                )
            }
            if (config.floweryTTS.enable) {
                val floweryTTS = FloweryTTSSourceManager(config.floweryTTS.voice)
                floweryTTS.setTranslate(config.floweryTTS.translate)
                floweryTTS.setSpeed(config.floweryTTS.speed)
                playerManager.registerSourceManager(
                    floweryTTS
                )
            }
            AudioSourceManagers.registerRemoteSources(playerManager)
            if (config.enableLocalSource) {
                AudioSourceManagers.registerLocalSource(playerManager)
            }
            serviceEnabled = true
        } catch (e: Exception) {
            logger.error(e.message)
            shutdown()
        }
    }

    private fun enableMetrics(platform: String, version: String) {
        if (stats.enabled) {
            metrics = MetricsBase(
                "bukkit",
                stats.serviceUUID,
                19414,
                true,
                {
                    it.appendField("serverSoftware", platform)
                    it.appendField("playerAmount", getPlayerAmount())
                    it.appendField("javaVersion", System.getProperty("java.version"))
                    it.appendField("osName", System.getProperty("os.name"))
                    it.appendField("osArch", System.getProperty("os.arch"))
                    it.appendField("osVersion", System.getProperty("os.version"))
                    it.appendField("coreCount", Runtime.getRuntime().availableProcessors())
                },
                {
                    it.appendField("pluginVersion", version)
                },
                { it.run() },
                { serviceEnabled },
                { message, error -> logger.error(message, error) },
                { message -> logger.info(message) },
                false,
                false,
                false
            )
            metrics.addCustomChart(SingleLineChart("guilds") {
                jda.guilds.size
            })
            metrics.addCustomChart(SingleLineChart("total_guilds_members") {
                var totalMembers = 0
                jda.guilds.forEach { totalMembers += it.memberCount }
                totalMembers
            })
        }
    }

    private fun getPlayerAmount(): Int {
        return try {
            val onlinePlayersMethod: Method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers")
            if (onlinePlayersMethod.returnType == (MutableCollection::class.java)) (onlinePlayersMethod.invoke(
                Bukkit.getServer()
            ) as Collection<*>).size else (onlinePlayersMethod.invoke(Bukkit.getServer()) as Array<*>).size
        } catch (e: Exception) {
            0
        }
    }

    @Synchronized
    fun shutdown() {
        logger.info("Disabling bot")
        if (serviceEnabled) {
            serviceEnabled = false
            musicManagers.forEach { (_, u) ->
                u.player.stopTrack()
                u.player.destroy()
            }
            jda.guilds.forEach {
                if (it.audioManager.isConnected) {
                    it.audioManager.closeAudioConnection()
                }
            }
            playerManager.shutdown()
            jda.shutdown()
            if (stats.enabled) {
                metrics.shutdown()
            }
        }
        logger.info("Bot is disabled")
    }

    @Synchronized
    fun getGuildAudioPlayer(guild: Guild, createNew: Boolean): GuildMusicManager? {
        val guildId: Long = guild.id.toLong()
        var musicManager = musicManagers[guildId]
        if (musicManager == null && createNew) {
            musicManager = GuildMusicManager(playerManager, this)
            musicManagers[guildId] = musicManager
        }
        if (musicManager != null) {
            guild.audioManager.sendingHandler = musicManager.getSendHandler()
        }
        return musicManager
    }

    override fun enable(configPath: String, languagePath: String, statsPath: String, platform: String) {
        this.configPath = configPath
        this.languagePath = languagePath
        this.statsPath = statsPath
        runBot()
        enableMetrics(platform, "1.0.1.0")
    }

    override fun disable() {
        shutdown()
    }

}