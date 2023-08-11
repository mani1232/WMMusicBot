package ua.mani123.listeners

import net.dv8tion.jda.api.events.guild.GuildJoinEvent
import net.dv8tion.jda.api.events.guild.GuildReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import ua.mani123.libs.JDA.DiscordBot

class GuildListener(private val discordBot: DiscordBot) : ListenerAdapter() {

    override fun onGuildReady(event: GuildReadyEvent) {
        event.guild.updateCommands().addCommands(
            discordBot.commands.map { it.getCommandData() }
        ).queue()
        discordBot.logger.debug("Commands updated in guild: ${event.guild.name}")
    }

    override fun onGuildJoin(event: GuildJoinEvent) {
        event.guild.updateCommands().addCommands(
            discordBot.commands.map { it.getCommandData() }
        ).queue()
        discordBot.logger.info("Commands updated in new guild: ${event.guild.name}")
    }
}