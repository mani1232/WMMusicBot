package ua.mani123.bukkitLoader

import com.tcoded.folialib.FoliaLib
import org.bukkit.plugin.java.JavaPlugin
import ua.mani123.LibManager
import ua.mani123.Product


class PaperDiscordBot : JavaPlugin() {

    private var foliaLib = FoliaLib(this)
    private var product: Product? = null

    override fun onLoad() {
        saveDefaultConfig()
    }

    override fun onEnable() {
        foliaLib.impl.runAsync {
            product = LibManager().loadLibs()
            product!!.enable("config.yml", "lang.yml", "stats.yml", "Minecraft bukkit plugin")
            //discordBot.configPath = "${dataFolder.path}/botConfig.yml"
            //discordBot.languagePath = "${dataFolder.path}/lang.yml"
            //discordBot.statsPath = "${dataFolder.path}/bstats.yml"
            //discordBot.logger = slF4JLogger
            logger.info("Starting discord bot as minecraft plugin")
            //discordBot.runBot()
            //discordBot.enableMetrics("Minecraft bukkit plugin", this.pluginMeta.version)
        }
    }

    override fun onDisable() {
        product!!.disable()
    }
}