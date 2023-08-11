package ua.mani123.init

import com.jcabi.manifests.Manifests
import ua.mani123.libs.JDA.DiscordBot

fun main() {
    println("Info: start ${Manifests.read("Main-Class")}, version: ${Manifests.read("Specification-Version")}")
    val discordBot = DiscordBot("config.yml", "lang.yml", "bstats.yml")
    discordBot.enableConsoleScanner()
    discordBot.runBot()
    discordBot.enableMetrics("ConsoleApp", "1.0.1.0")
}

