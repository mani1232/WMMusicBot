package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData

interface CommandApi {
    fun getCommandData(): SlashCommandData
    fun run(event: SlashCommandInteractionEvent)
}