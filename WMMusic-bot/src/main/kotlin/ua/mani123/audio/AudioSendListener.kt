package ua.mani123.audio

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame
import net.dv8tion.jda.api.audio.AudioSendHandler
import java.nio.Buffer
import java.nio.ByteBuffer


class AudioSendListener(private var audioPlayer: AudioPlayer) : AudioSendHandler {
    private var buffer: ByteBuffer = ByteBuffer.allocate(2048)
    private var lastFrame: MutableAudioFrame = MutableAudioFrame()

    init {
        lastFrame.setBuffer(buffer)
    }

    override fun canProvide(): Boolean {
        return audioPlayer.provide(lastFrame)
    }

    override fun provide20MsAudio(): ByteBuffer {
        (buffer as Buffer).flip()
        return buffer
    }

    override fun isOpus(): Boolean {
        return true
    }
}