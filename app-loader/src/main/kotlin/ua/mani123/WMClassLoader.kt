package ua.mani123

import dev.hypera.dragonfly.loading.IClassLoader
import java.net.URL
import java.net.URLClassLoader

class WMClassLoader : URLClassLoader(emptyArray()), IClassLoader {

    val urls = ArrayList<URL>()

    override fun addURL(p0: URL?) {
        if (p0 != null) {
            urls.add(p0)
        }
    }

}