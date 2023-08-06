package ua.mani123.audio

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import ua.mani123.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import java.awt.Color


class AudioLoadResultListener(
    private val event: SlashCommandInteractionEvent,
    private val discordBot: DiscordBot,
    private val userLang: LangCode
) : AudioLoadResultHandler {

    private val guildAudioManager = discordBot.getGuildAudioPlayer(event.guild!!, true)

    override fun trackLoaded(track: AudioTrack) {
        guildAudioManager!!.scheduler.queue(track)
        event.hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.trackLoaded)[userLang]
            ).build()
        ).queue()
    }

    override fun playlistLoaded(playlist: AudioPlaylist) {
        guildAudioManager!!.scheduler.queue(playlist)
        event.hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor))
                .setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.playlistLoaded)[userLang]
            ).build()
        ).queue()
    }

    override fun noMatches() {
        event.hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.noMatches)[userLang]
            ).build()
        ).queue()
    }

    override fun loadFailed(exception: FriendlyException) {
        event.hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                String.format(
                    LangHashMap(discordBot.language.failedLoad)[userLang], exception.message
                )
            ).build()
        ).queue()
    }
}