package ua.mani123

import com.jcabi.manifests.Manifests

fun main() {
    println("Info: start ${Manifests.read("Main-Class")}, version: ${Manifests.read("Specification-Version")}")
    val discordBot = DiscordBot("config.yml", "lang.yml")
    discordBot.enableConsoleScanner()
    discordBot.runBot()
}

