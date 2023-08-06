package ua.mani123.audio

import ua.mani123.DiscordBot
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue


class TrackScheduler(private val player: AudioPlayer, private val discordBot: DiscordBot) : AudioEventAdapter() {

    val queue: BlockingQueue<AudioTrack> = LinkedBlockingQueue()

    fun queue(track: AudioTrack) {
        if (!player.startTrack(track, true)) {
            queue.add(track)
        }
    }

    fun queue(playlist: AudioPlaylist) {
        var firstTrack = playlist.selectedTrack

        if (firstTrack == null) {
            firstTrack = playlist.tracks[0]
        }

        if (!player.startTrack(firstTrack, true)) {
            queue.addAll(playlist.tracks)
        } else {
            playlist.tracks.remove(firstTrack)
            queue.addAll(playlist.tracks)
        }
    }

    fun nextTrack(): Boolean {
        val track = queue.poll()
        return if (track != null) {
            player.startTrack(track, false)
            true
        } else {
            false
        }
    }

    override fun onPlayerPause(player: AudioPlayer) {
        super.onPlayerPause(player)
    }

    override fun onPlayerResume(player: AudioPlayer) {
        super.onPlayerResume(player)
    }

    override fun onTrackStart(player: AudioPlayer, track: AudioTrack) {
        super.onTrackStart(player, track)
    }

    override fun onTrackEnd(player: AudioPlayer, track: AudioTrack, endReason: AudioTrackEndReason) {
        if (endReason.mayStartNext && !nextTrack()) {
            discordBot.musicManagers.filter { it.value.player == player }.firstNotNullOf {
                discordBot.jda!!.getGuildById(it.key)!!.audioManager.closeAudioConnection()
                it.value.player.destroy()
                discordBot.musicManagers.remove(it.key)
            }
        }
    }

    override fun onTrackException(player: AudioPlayer, track: AudioTrack, exception: FriendlyException) {
        super.onTrackException(player, track, exception)
    }
}