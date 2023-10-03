package ua.mani123.loaders

import dev.hypera.dragonfly.Dragonfly
import dev.hypera.dragonfly.DragonflyBuilder
import dev.hypera.dragonfly.dependency.Dependency
import dev.hypera.dragonfly.loading.IClassLoader
import java.nio.file.Files
import java.nio.file.Path

class LibsLoader(private val classLoader: IClassLoader, path: Path) {

    private val libsLoader: Dragonfly
    val directory: Path

    init {
        libsLoader = DragonflyBuilder.create(classLoader, path).addRepositories(
            "https://oss.sonatype.org/content/repositories/snapshots",
            "https://jitpack.io/",
            "https://maven.arbjerg.dev/snapshots/",
            "https://maven.topi.wtf/snapshots/",
            "https://nexuslite.gcnt.net/repos/other/"
        ).build()
        directory = libsLoader.directory
    }

    fun loadDefaultLibs(): Boolean {
        return loadList(
            listOf(
                Dependency.maven("com.fasterxml.jackson.core", "jackson-databind", "2.15.2"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-core", "2.15.2"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-annotations", "2.15.2"),
                Dependency.maven("org.apache.httpcomponents", "httpclient", "4.5.14"),
                Dependency.maven("org.mozilla", "rhino-engine", "1.7.14"),
                Dependency.maven("dev.arbjerg", "lava-common", "2.0.2"),
                Dependency.maven(
                    "dev.arbjerg",
                    "lavaplayer-natives",
                    "2.0.2"
                ),
                Dependency.maven("org.mozilla", "rhino", "1.7.14"),
                Dependency.maven("org.json", "json", "20230618"),
                Dependency.maven("commons-logging", "commons-logging", "1.2"),
                Dependency.maven("org.apache.httpcomponents", "httpcore", "4.4.16"),
                Dependency.maven("commons-io", "commons-io", "2.13.0"),
                Dependency.maven("com.github.topi314.lavasearch", "lavasearch", "1.0.0-beta.1"),
                Dependency.maven("com.github.topi314.lavasrc", "lavasrc", "4.0.0-beta.6"),
                Dependency.maven("dev.arbjerg", "lavaplayer", "2.0.2"),
                Dependency.maven("org.slf4j", "slf4j-api", "2.0.9"),
                Dependency.maven("org.apache.commons", "commons-collections4", "4.4"),
                Dependency.maven("com.neovisionaries", "nv-websocket-client", "2.14"),
                Dependency.maven("com.squareup.okhttp3", "okhttp", "4.11.0"),
                Dependency.maven("club.minnced", "opus-java", "1.1.1"),
                Dependency.maven("net.java.dev.jna", "jna", "5.13.0"),
                Dependency.maven("net.sf.trove4j", "trove4j", "3.0.3"),
                Dependency.maven("com.squareup.okio", "okio", "3.5.0"),
                Dependency.maven("com.squareup.okio", "okio-jvm", "3.5.0"),
                Dependency.maven("net.dv8tion", "JDA", "5.0.0-beta.15")
            )
        )
    }

    fun loadList(listOfDepends: List<Dependency>): Boolean {
        val results = mutableListOf<Boolean>()
        for (i in listOfDepends.indices) {
            val depend = listOfDepends[i]
            if (!isDownloaded(depend)) {
                println("Loading dependency ${depend.fileName} (${i + 1}/${listOfDepends.size})")
                results.add(libsLoader.load(depend).get())
            } else {
                results.add(true)
            }
        }
        return results.all { it }
    }

    private fun isDownloaded(dependency: Dependency): Boolean {
        return if (Files.exists(directory.resolve(dependency.fileName))) {
            classLoader.addURL(directory.resolve(dependency.fileName).toUri().toURL())
            true
        } else {
            false
        }
    }

}