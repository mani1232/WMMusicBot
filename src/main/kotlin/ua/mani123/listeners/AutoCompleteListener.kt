package ua.mani123.listeners

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.Command
import ua.mani123.libs.JDA.DiscordBot


class AutoCompleteListener(private val discordBot: DiscordBot) : ListenerAdapter() {
    private val volumes = mutableListOf(25L, 50, 75L, 100L)

    override fun onCommandAutoCompleteInteraction(event: CommandAutoCompleteInteractionEvent) {
        if (event.name == "volume" && event.focusedOption.name == "volume") {
            val options: List<Command.Choice> = volumes.filter { word ->
                word.toString().startsWith(
                    event.focusedOption.value
                )
            }
                .map { word ->
                    Command.Choice(
                        word.toString(),
                        word
                    )
                }
            event.replyChoices(options).queue()
        } else if (event.name == "next" && event.focusedOption.name == "next") {
            val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)
            if (guildAudioPlayer != null && guildAudioPlayer.player.playingTrack != null) {

                val options: List<Command.Choice> = mutableListOf(
                    "${(guildAudioPlayer.player.playingTrack.position / 1000)} min",
                    "${(guildAudioPlayer.player.playingTrack.duration / 1000)} max"
                ).filter { word ->
                    word.startsWith(
                        event.focusedOption.value
                    )
                }
                    .map { word ->
                        Command.Choice(
                            word,
                            word
                        )
                    }
                event.replyChoices(options).queue()
            }
        }
    }
}