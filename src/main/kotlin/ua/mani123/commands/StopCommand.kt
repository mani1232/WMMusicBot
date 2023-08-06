package ua.mani123.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import java.awt.Color

class StopCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("stop", "Stop bot playing and leave from voice channel")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandStopName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandStopName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandStopName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandStopName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandStopName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandStopName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandStopName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandStopName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandStopName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandStopName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandStopName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandStopName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandStopName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandStopName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandStopName)[LangCode.EN])
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandStopDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandStopDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandStopDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandStopDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandStopDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandStopDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandStopDescription)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandStopDescription)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandStopDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandStopDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandStopDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandStopDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandStopDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandStopDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandStopDescription)[LangCode.EN])
            )
        )
    }

    override fun getCommandData(): SlashCommandData {
        return command
    }

    override fun run(event: SlashCommandInteractionEvent) {
        val hook = event.hook

        val userLang = try {
            LangCode.valueOf(event.userLocale.locale.substring(0, 2).uppercase())
        } catch (e: IllegalArgumentException) {
            LangCode.EN
        }

        val voiceChannel = event.member!!.voiceState!!.channel
        if (voiceChannel == null || event.guild!!.audioManager.connectedChannel != voiceChannel) {
            hook.editOriginalEmbeds(
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    LangHashMap(discordBot.language.cantUseCommand)[userLang]
                ).build()
            ).queue()
            return
        }

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)

        if (guildAudioPlayer != null) {
            hook.editOriginalEmbeds(
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    LangHashMap(discordBot.language.stopCommandAnswer)[userLang]
                ).build()
            ).queue()
            guildAudioPlayer.player.destroy()
            discordBot.musicManagers.remove(event.guild!!.id.toLong())
            event.guild!!.audioManager.closeAudioConnection()
            return
        }

        hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.alreadyBotStopped)[userLang]
            ).build()
        ).queue()
    }
}