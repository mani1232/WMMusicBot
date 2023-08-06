package ua.mani123.listeners

import ua.mani123.DiscordBot
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class CommandsListener(private val discordBot: DiscordBot) : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (discordBot.config.debugCommandUsage) {
            discordBot.logger.info("User ${event.member!!.nickname} from guild ${event.guild!!.id} used command /${event.fullCommandName}")
        }
        event.deferReply(true).queue()
        discordBot.commands.first { it.getCommandData().name == event.name }.run(event)
    }
}