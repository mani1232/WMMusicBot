package ua.mani123.listeners

import net.dv8tion.jda.api.entities.channel.concrete.StageChannel
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import ua.mani123.DiscordBot

class VoiceListeners(private val discordBot: DiscordBot) : ListenerAdapter() {

    override fun onGuildVoiceUpdate(event: GuildVoiceUpdateEvent) {
        if (event.channelLeft != null && event.guild.audioManager.connectedChannel != null && event.channelLeft!!.id == event.guild.audioManager.connectedChannel!!.id && (event.channelLeft!!.members.size <= 1 && event.channelLeft is VoiceChannel) || (event.channelLeft is StageChannel == discordBot.config.autoLeaveFromStage)) {
            val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild, false)
            if (guildAudioPlayer != null) {
                guildAudioPlayer.player.destroy()
                discordBot.musicManagers.remove(event.guild.id.toLong())
                event.guild.audioManager.closeAudioConnection()
            }
        }
    }
}