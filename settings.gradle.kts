pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://repo.hypera.dev/snapshots/")
        maven("https://maven.lavalink.dev/releases")
        maven("https://maven.lavalink.dev/snapshots")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://jitpack.io/")
        maven("https://maven.arbjerg.dev/snapshots")
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.topi.wtf/snapshots/")
        maven("https://maven.topi.wtf/releases")
        maven("https://nexuslite.gcnt.net/repos/other/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "WMMusic"
include("app-loader")
include("WMMusic-bot")
