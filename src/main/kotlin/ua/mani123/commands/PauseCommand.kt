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

class PauseCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("pause", "Pause track")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandPauseName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandPauseName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandPauseName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandPauseName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandPauseName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandPauseName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandPauseName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandPauseName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandPauseName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandPauseName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandPauseName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandPauseName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandPauseName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandPauseName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandPauseName)[LangCode.EN])
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandPauseDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandPauseDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandPauseDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandPauseDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandPauseDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandPauseDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandPauseDescription)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandPauseDescription)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandPauseDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandPauseDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandPauseDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandPauseDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandPauseDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandPauseDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandPauseDescription)[LangCode.EN])
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
            val player = guildAudioPlayer.player
            player.isPaused = !player.isPaused

            hook.editOriginalEmbeds(
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    String.format(
                        LangHashMap(discordBot.language.pauseCommandAnswer)[userLang], player.isPaused
                    )
                ).build()
            ).queue()
        }
    }
}