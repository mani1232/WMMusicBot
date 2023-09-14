package ua.mani123.audio

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason
import ua.mani123.DiscordBot
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue


class TrackScheduler(private val player: AudioPlayer, private val discordBot: DiscordBot) : AudioEventAdapter() {

    val queue: BlockingQueue<AudioTrack> = LinkedBlockingQueue()

    fun queue(track: AudioTrack, repeat: Boolean) {
        if (!player.startTrack(track, true)) {
            queue.add(track)
        } else if (repeat) {
            queue.add(track.makeClone())
        }
    }

    fun queue(playlist: AudioPlaylist, repeat: Boolean) {
        var firstTrack = playlist.selectedTrack

        if (firstTrack == null) {
            firstTrack = playlist.tracks[0]
        }

        if (!player.startTrack(firstTrack, true)) {
            queue.addAll(playlist.tracks)
        } else {
            if (!repeat) {
                playlist.tracks.remove(firstTrack)
            }
            queue.addAll(playlist.tracks)
        }
    }

    fun nextTrack(repeat: Boolean): Boolean {
        val track = queue.poll()
        return if (track != null) {
            player.startTrack(track, false)
            if (repeat) queue.add(track.makeClone())
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
        if (endReason.mayStartNext) {
            discordBot.musicManagers.filter { it.value.player == player }.firstNotNullOf {
                if (!nextTrack(it.value.repeat)) {
                    discordBot.jda.getGuildById(it.key)!!.audioManager.closeAudioConnection()
                    it.value.player.destroy()
                    //discordBot.musicManagers.remove(it.key)
                }
            }
        }
    }

    override fun onTrackException(player: AudioPlayer, track: AudioTrack, exception: FriendlyException) {
        super.onTrackException(player, track, exception)
    }
}