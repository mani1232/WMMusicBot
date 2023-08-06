package ua.mani123

import com.jcabi.manifests.Manifests

fun main() {
    println("Info: start ${Manifests.read("Main-Class")}, version: ${Manifests.read("Specification-Version")}")
    val discordBot = DiscordBot("config.yml", "lang.yml", "bstats.yml")
    discordBot.enableConsoleScanner()
    discordBot.runBot()
    discordBot.enableMetrics("Default", "1.0.1.0")
}

