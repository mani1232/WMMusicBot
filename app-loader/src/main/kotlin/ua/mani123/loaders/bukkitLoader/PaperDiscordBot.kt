package ua.mani123.loaders.bukkitLoader

import com.tcoded.folialib.FoliaLib
import org.bukkit.plugin.java.JavaPlugin
import ua.mani123.LoaderManager
import ua.mani123.Product


class PaperDiscordBot : JavaPlugin() {

    private var foliaLib = FoliaLib(this)
    private var product: Product? = null

    override fun onLoad() {
        saveDefaultConfig()
    }

    override fun onEnable() {
        foliaLib.impl.runAsync {
            val license = config.getString("license-key")
            if (!license.isNullOrEmpty()) {
                product = LoaderManager(dataFolder.toPath(), license).enableLoaders()
                product!!.enable(
                    "${dataFolder.path}/config.yml",
                    "${dataFolder.path}/lang.yml",
                    "${dataFolder.path}/stats.yml",
                    "Minecraft bukkit plugin"
                )
                logger.info("Starting discord bot as minecraft plugin")
            } else {
                logger.warning("License not valid")
            }
        }
    }

    override fun onDisable() {
        product!!.disable()
    }
}