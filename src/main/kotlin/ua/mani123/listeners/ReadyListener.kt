package ua.mani123.listeners

import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import ua.mani123.libs.JDA.DiscordBot

class ReadyListener(private val discordBot: DiscordBot) : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {
        discordBot.logger.info("Discord bot run in guilds: ${event.jda.guilds.map { it.name }}")
        discordBot.logger.info("Done!")
    }
}