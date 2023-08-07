package ua.mani123.audio

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import ua.mani123.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap


class AudioLoadResultListener(
    private val event: SlashCommandInteractionEvent,
    private val discordBot: DiscordBot,
    private val userLang: LangCode,
    private val guildAudioManager: GuildMusicManager
) : AudioLoadResultHandler {

    override fun trackLoaded(track: AudioTrack) {
        guildAudioManager.scheduler.queue(track)
        event.hook.editOriginalEmbeds(LangHashMap(discordBot.language.trackLoadedData).generateEmbed(userLang)).queue()
    }

    override fun playlistLoaded(playlist: AudioPlaylist) {
        guildAudioManager.scheduler.queue(playlist)
        event.hook.editOriginalEmbeds(LangHashMap(discordBot.language.playlistLoadedData).generateEmbed(userLang))
            .queue()
    }

    override fun noMatches() {
        event.hook.editOriginalEmbeds(LangHashMap(discordBot.language.noMatchesData).generateEmbed(userLang)).queue()
    }

    override fun loadFailed(exception: FriendlyException) {
        event.hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.filedLoadData).generateEmbed(
                userLang,
                exception.message!!,
                exception.message!!
            )
        ).queue()
    }
}