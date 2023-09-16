package ua.mani123

import ua.mani123.loaders.AppLoader
import ua.mani123.loaders.LibsLoader
import java.nio.file.Path


class LoaderManager(private val defaultPath: Path, private val licenseKey: String) {

    fun enableLoaders(): Any? {
        val urlClassLoader = WMClassLoader()
        println("Start loading libs")
        val libsPath = defaultPath.resolve("libs/")
        val libsLoader = LibsLoader(urlClassLoader, libsPath)
        if (libsLoader.loadDefaultLibs()) {
            println("Libs loaded, downloading application")
            urlClassLoader.addURL(
                AppLoader(
                    licenseKey,
                    "WMMusic",
                    libsPath
                ).loadedFile.toURI().toURL()
            )
            println("Application downloaded, starting...")
            return urlClassLoader.loadClass("ua.mani123.DiscordBot")
                .getDeclaredConstructor()
                .newInstance()
        } else {
            println("Failed download libs")
        }
        return null
    }

}