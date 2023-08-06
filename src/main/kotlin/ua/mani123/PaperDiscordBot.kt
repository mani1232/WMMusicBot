package ua.mani123

import com.tcoded.folialib.FoliaLib
import org.bukkit.plugin.java.JavaPlugin


class PaperDiscordBot : JavaPlugin() {

    lateinit var discordBot: DiscordBot
    private var foliaLib = FoliaLib(this)

    override fun onLoad() {
        saveDefaultConfig()
    }

    override fun onEnable() {
        foliaLib.impl.runAsync {
            discordBot = DiscordBot(
                "${dataFolder.path}/botConfig.yml",
                "${dataFolder.path}/lang.yml",
                "${dataFolder.path}/bstats.yml"
            )
            discordBot.logger = slF4JLogger
            logger.info("Starting discord bot as minecraft plugin")
            discordBot.runBot()
            discordBot.enableMetrics("Minecraft bukkit plugin", this.pluginMeta.version)
        }
    }

    override fun onDisable() {
        discordBot.shutdown()
    }
}