package ua.mani123

import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.exceptions.InvalidTokenException
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.Compression
import net.dv8tion.jda.api.utils.MemberCachePolicy
import net.dv8tion.jda.api.utils.cache.CacheFlag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ua.mani123.audio.GuildMusicManager
import ua.mani123.commands.*
import ua.mani123.dataFromFile.ConfigUtils
import ua.mani123.dataFromFile.data.ConfigData
import ua.mani123.dataFromFile.data.LanguageData
import ua.mani123.listeners.*
import java.util.*
import kotlin.system.exitProcess


class DiscordBot(configPath: String, languagePath: String) {

    var logger = LoggerFactory.getLogger(this.javaClass) as Logger
    val config = ConfigUtils().loadFile(configPath, ConfigData())
    val language = ConfigUtils().loadFile(languagePath, LanguageData())
    val musicManagers: HashMap<Long, GuildMusicManager> = HashMap()
    val commands: MutableSet<CommandApi> = mutableSetOf(
        CurrentCommand(this),
        PlayCommand(this),
        SkipCommand(this),
        StopCommand(this),
        VolumeCommand(this),
        ListCommand(this),
        PauseCommand(this)
    )
    val playerManager = DefaultAudioPlayerManager()
    var jda: JDA? = null

    fun runBot() {
        try {
            jda = JDABuilder.createLight(config.botToken)
                .setCompression(Compression.ZLIB)
                .setMemberCachePolicy(MemberCachePolicy.VOICE)
                .enableCache(
                    mutableListOf(
                        CacheFlag.VOICE_STATE
                    )
                )
                .enableIntents(
                    mutableListOf(
                        GatewayIntent.GUILD_VOICE_STATES
                    )
                )
                .addEventListeners(
                    CommandsListener(this),
                    GuildListener(this),
                    ReadyListener(this),
                    AutoCompleteListener(this),
                    VoiceListeners(this)
                ).build()
            AudioSourceManagers.registerRemoteSources(playerManager)
            AudioSourceManagers.registerLocalSource(playerManager)
        } catch (e: InvalidTokenException) {
            logger.error(e.message)
        }
    }

    fun enableConsoleScanner() {
        Runtime.getRuntime().addShutdownHook(Thread {
            shutdown()
        })
        val scanner = Scanner(System.`in`)
        Thread {
            while (true) {
                when (scanner.next()) {
                    "/stop" -> {
                        exitProcess(0)
                    }

                    else -> {
                        logger.info(
                            """
                            <-- Command info -->
                            /stop - Stop bot
                        """.trimIndent()
                        )
                    }
                }
            }
        }.start()
    }

    @Synchronized
    fun shutdown() {
        logger.info("Disabling bot")
        musicManagers.forEach { (_, u) ->
            u.player.stopTrack()
            u.player.destroy()
        }
        jda?.guilds?.forEach {
            if (it.audioManager.isConnected) {
                it.audioManager.closeAudioConnection()
            }
        }
        playerManager.shutdown()
        jda?.shutdownNow()
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
}