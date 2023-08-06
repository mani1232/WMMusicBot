package ua.mani123.audio

import ua.mani123.DiscordBot
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager


class GuildMusicManager(manager: AudioPlayerManager, discordBot: DiscordBot) {

    val player: AudioPlayer = manager.createPlayer()
    val scheduler: TrackScheduler = TrackScheduler(player, discordBot)

    init {
        player.addListener(scheduler)
    }

    fun getSendHandler(): AudioSendListener {
        return AudioSendListener(player)
    }

}