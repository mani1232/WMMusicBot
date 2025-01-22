package ua.mani123.loaders

import dev.hypera.dragonfly.Dragonfly
import dev.hypera.dragonfly.DragonflyBuilder
import dev.hypera.dragonfly.dependency.Dependency
import dev.hypera.dragonfly.loading.IClassLoader
import java.nio.file.Files
import java.nio.file.Path

class LibsLoader(private val classLoader: IClassLoader, path: Path) {

    private val libsLoader: Dragonfly = DragonflyBuilder.create(classLoader, path).addRepositories(
        "https://maven.lavalink.dev/releases",
        "https://maven.lavalink.dev/snapshots",
        "https://oss.sonatype.org/content/repositories/snapshots",
        "https://jitpack.io/",
        "https://maven.arbjerg.dev/snapshots/",
        "https://maven.topi.wtf/snapshots/",
        "https://maven.topi.wtf/releases/",
        "https://nexuslite.gcnt.net/repos/other/"
    ).build()
    val directory: Path = libsLoader.directory

    fun loadDefaultLibs(): Boolean {
        return loadList(
            listOf(
                Dependency.url("lavalink-youtube", "1.11.3", "https://maven.lavalink.dev/releases/dev/lavalink/youtube/v2/1.11.3/v2-1.11.3.jar"),
                Dependency.url("lavalink-youtube-common", "1.11.3", "https://maven.lavalink.dev/releases/dev/lavalink/youtube/common/1.11.3/common-1.11.3.jar"),
                Dependency.maven("dev.arbjerg", "lava-common", "2.2.2"),
                Dependency.maven("com.github.topi314.lavasrc", "lavasrc", "4.3.0"),
                Dependency.maven("com.github.topi314.lavasearch", "lavasearch", "1.0.0"),
                Dependency.maven("com.github.topi314.lavalyrics", "lavalyrics", "1.0.0"),
                Dependency.maven("org.apache.httpcomponents", "httpclient", "4.5.14"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-core", "2.17.2"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-databind", "2.17.2"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-annotations", "2.17.2"),
                Dependency.maven("dev.arbjerg", "lavaplayer", "2.2.2"),
                Dependency.maven("com.github.discord-jda", "JDA", "5.2.2"),
                Dependency.maven("club.minnced", "opus-java", "1.1.1"),
                Dependency.maven("com.neovisionaries", "nv-websocket-client", "2.14"),
                Dependency.maven("com.squareup.okhttp3", "okhttp", "4.12.0"),
                Dependency.maven("org.apache.commons", "commons-collections4", "4.4"),
                Dependency.maven("org.slf4j", "slf4j-api", "2.0.13"),
                Dependency.maven("org.mozilla", "rhino-engine", "1.7.15"),
                Dependency.maven("org.mozilla", "rhino", "1.7.14"),
                Dependency.maven("com.grack", "nanojson", "1.7"),
                Dependency.maven("dev.arbjerg", "lavaplayer-natives", "2.2.2"),
                Dependency.maven("commons-io", "commons-io", "2.13.0"),
                Dependency.maven("org.jsoup", "jsoup", "1.16.1"),
                Dependency.maven("net.iharder", "base64", "2.3.9"),
                Dependency.maven("org.json", "json", "20240303"),
                Dependency.maven("dev.schlaubi.lyrics", "protocol-jvm", "2.5.0"),
                Dependency.maven("net.sf.trove4j", "core", "3.1.0"),
                Dependency.maven("org.apache.httpcomponents", "httpcore", "4.4.16"),
                Dependency.maven("commons-logging", "commons-logging", "1.3.4"),
                Dependency.maven("com.google.crypto.tink", "tink", "1.16.0"),
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