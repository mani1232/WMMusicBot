plugins {
    kotlin("plugin.serialization") version "1.9.20-Beta"
}

val projectName = findProperty("wmMusicBotName")!!

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.0")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    compileOnly(project(mapOf("path" to ":app-loader")))
    compileOnly("com.github.topi314.lavasrc:lavasrc:4.0.0-beta.6")
    compileOnly("dev.arbjerg:lavaplayer:2.0.1")
    implementation("org.bstats:bstats-base:3.0.2")
    implementation("ch.qos.logback", "logback-classic", "1.4.11")
    compileOnly("com.github.discord-jda:JDA:5.0.0-beta.13")

    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

tasks.shadowJar {
    relocate("org.bstats", "ua.mani123.libs.bstats")
    archiveFileName.set("${projectName}-$version-all.jar")
}