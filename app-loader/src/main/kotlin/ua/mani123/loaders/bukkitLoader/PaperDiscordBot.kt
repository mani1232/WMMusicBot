package ua.mani123.loaders.bukkitLoader

import com.tcoded.folialib.FoliaLib
import org.bukkit.plugin.java.JavaPlugin
import org.slf4j.Logger
import ua.mani123.LoaderManager


class PaperDiscordBot : JavaPlugin() {

    private var foliaLib = FoliaLib(this)
    private var product: Any? = null

    override fun onLoad() {
        saveDefaultConfig()
    }

    override fun onEnable() {
        foliaLib.impl.runAsync {
            val license = config.getString("license-key")
            if (!license.isNullOrEmpty()) {
                product = LoaderManager(dataFolder.toPath(), license).enableLoaders()
                //product!!.javaClass.getMethod("changeLogger", Logger::class.java).invoke(product, slF4JLogger) class not found
                product!!.javaClass.getMethod(
                    "enable",
                    String::class.java,
                    String::class.java,
                    String::class.java,
                    String::class.java
                ).invoke(
                    product, "${dataFolder.path}/app-config.yml",
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
        product!!.javaClass.getMethod("disable").invoke(product)
    }
}