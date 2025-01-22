plugins {
    kotlin("plugin.serialization") version "2.1.20-Beta1"
}

val projectName = findProperty("wmMusicBotName")!!

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.8.0")
    implementation("com.charleskorn.kaml:kaml:0.67.0")
    compileOnly("com.github.topi314.lavasrc:lavasrc:4.3.0")
    compileOnly("dev.arbjerg:lavaplayer:2.2.2")
    compileOnly("dev.lavalink.youtube:v2:1.11.3")
    implementation("org.bstats:bstats-base:3.1.0")
    implementation("ch.qos.logback:logback-classic:1.5.16")
    compileOnly("com.github.discord-jda:JDA:5.2.2")

    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}

tasks.shadowJar {
    relocate("org.bstats", "ua.mani123.libs.bstats")
    archiveFileName.set("${projectName}-$version-all.jar")
}