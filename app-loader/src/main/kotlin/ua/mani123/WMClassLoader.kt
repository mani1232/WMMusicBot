package ua.mani123

import dev.hypera.dragonfly.loading.IClassLoader
import java.net.URL
import java.net.URLClassLoader

class WMClassLoader : URLClassLoader(emptyArray()), IClassLoader {

    override fun addURL(p0: URL?) {
        if (p0 != null) {
            super.addURL(p0)
        }
    }

}