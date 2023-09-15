package ua.mani123

import dev.hypera.dragonfly.DragonflyBuilder
import dev.hypera.dragonfly.dependency.Dependency
import java.io.File
import java.nio.file.Path


class LibManager {

    fun loadLibs(): Product? {
        println("Start loading libs")
        val urlClassLoader = WMClassLoader()

        val licenseFile = File("licenseKey")
        licenseFile.createNewFile()
        val license = licenseFile.readText()

        if (license.isNotEmpty()) {
            val dragonfly = DragonflyBuilder.create(urlClassLoader, Path.of("libs/")).addRepositories(
                "https://oss.sonatype.org/content/repositories/snapshots",
                "https://jitpack.io/",
                "https://maven.arbjerg.dev/snapshots/",
                "https://maven.topi.wtf/snapshots/",
                "https://nexuslite.gcnt.net/repos/other/"
            ).build()

            val result = dragonfly.load(
                Dependency.maven("com.fasterxml.jackson.core", "jackson-databind", "2.15.2"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-core", "2.15.2"),
                Dependency.maven("com.fasterxml.jackson.core", "jackson-annotations", "2.15.2"),
                Dependency.maven("org.apache.httpcomponents", "httpclient", "4.5.14"),
                Dependency.maven("org.mozilla", "rhino-engine", "1.7.14"),
                Dependency.maven("dev.arbjerg", "lava-common", "2.0.1"),
                Dependency.maven(
                    "dev.arbjerg",
                    "lavaplayer-natives",
                    "2.0.1"
                ),
                Dependency.maven("org.mozilla", "rhino", "1.7.14"),
                Dependency.maven("org.json", "json", "20230618"),
                Dependency.maven("commons-logging", "commons-logging", "1.2"),
                Dependency.maven("org.apache.httpcomponents", "httpcore", "4.4.16"),
                Dependency.maven("commons-io", "commons-io", "2.13.0"),
                Dependency.maven("com.github.topi314.lavasearch", "lavasearch", "1.0.0-beta.1"),
                Dependency.maven("com.github.topi314.lavasrc", "lavasrc", "4.0.0-beta.6"),
                Dependency.maven("dev.arbjerg", "lavaplayer", "2.0.1"),
                Dependency.maven("org.slf4j", "slf4j-api", "2.0.9"),
                Dependency.maven("org.apache.commons", "commons-collections4", "4.4"),
                Dependency.maven("com.neovisionaries", "nv-websocket-client", "2.14"),
                Dependency.maven("com.squareup.okhttp3", "okhttp", "4.11.0"),
                Dependency.maven("club.minnced", "opus-java", "1.1.1"),
                Dependency.maven("net.java.dev.jna", "jna", "5.13.0"),
                Dependency.maven("net.sf.trove4j", "trove4j", "3.0.3"),
                Dependency.maven("com.squareup.okio", "okio", "3.5.0"),
                Dependency.maven("com.squareup.okio", "okio-jvm", "3.5.0"),
                Dependency.maven("net.dv8tion", "JDA", "5.0.0-beta.13")
            ).get()

            if (result) {
                println("Libs loaded, loading application")
                urlClassLoader.addURL(
                    dragonfly.directory.resolve(
                        Connection(
                            licenseFile.readText().trim(),
                            "WMMusic"
                        ).loadApp().name
                    ).toUri().toURL()
                )
                println("Application loaded, starting...")
                return urlClassLoader.loadClass("ua.mani123.DiscordBot")
                    .getDeclaredConstructor()
                    .newInstance() as Product
            } else {
                println("Filed download dependices")
            }
        } else {
            println("License is empty")
        }
        return null
    }

}