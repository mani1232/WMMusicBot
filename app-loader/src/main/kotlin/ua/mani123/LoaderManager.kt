package ua.mani123

import ua.mani123.loaders.AppLoader
import ua.mani123.loaders.LibsLoader
import java.nio.file.Path


class LoaderManager(private val defaultPath: Path, private val licenseKey: String) {

    fun enableLoaders(): Product? {
        val urlClassLoader = WMClassLoader()
        println("Start loading libs")
        val libsLoader = LibsLoader(urlClassLoader, defaultPath.resolve("libs/"))
        if (libsLoader.loadDefaultLibs()) {
            println("Libs loaded, downloading application")
            urlClassLoader.addURL(
                libsLoader.directory.resolve(
                    AppLoader(
                        licenseKey,
                        "WMMusic"
                    ).loadedFile.name
                ).toUri().toURL()
            )
            println("Application downloaded, starting...")
            return urlClassLoader.loadClass("ua.mani123.DiscordBot")
                .getDeclaredConstructor()
                .newInstance() as Product
        } else {
            println("Failed download libs")
        }
        return null
    }

}