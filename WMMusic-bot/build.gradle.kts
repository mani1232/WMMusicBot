plugins {
    kotlin("plugin.serialization") version "1.9.21"
}

val projectName = findProperty("wmMusicBotName")!!

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.1")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    compileOnly("com.github.topi314.lavasrc:lavasrc:4.0.0-beta.6")
    compileOnly("dev.arbjerg:lavaplayer:2.0.3")
    implementation("org.bstats:bstats-base:3.0.2")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    compileOnly("com.github.discord-jda:JDA:5.0.0-beta.18")

    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
}

tasks.shadowJar {
    relocate("org.bstats", "ua.mani123.libs.bstats")
    archiveFileName.set("${projectName}-$version-all.jar")
}