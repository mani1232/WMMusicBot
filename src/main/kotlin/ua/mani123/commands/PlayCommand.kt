package ua.mani123.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.DiscordBot
import ua.mani123.audio.AudioLoadResultListener
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import java.awt.Color

class PlayCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("play", "Start playing or add to queue tracks")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandPlayName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandPlayName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandPlayName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandPlayName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandPlayName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandPlayName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandPlayName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandPlayName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandPlayName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandPlayName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandPlayName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandPlayName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandPlayName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandPlayName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandPlayName)[LangCode.EN])
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandPlayDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandPlayDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandPlayDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandPlayDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandPlayDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandPlayDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandPlayDescription)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandPlayDescription)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandPlayDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandPlayDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandPlayDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandPlayDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandPlayDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandPlayDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandPlayDescription)[LangCode.EN])
            )
        )
        val option = OptionData(OptionType.STRING, "url", "Url for track", true)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandPlayStringOptionName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandPlayStringOptionName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandPlayStringOptionName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandPlayStringOptionName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandPlayStringOptionName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandPlayStringOptionName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandPlayStringOptionName)[LangCode.ES]),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.commandPlayStringOptionName)[LangCode.PT]
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandPlayStringOptionName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandPlayStringOptionName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandPlayStringOptionName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandPlayStringOptionName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandPlayStringOptionName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandPlayStringOptionName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandPlayStringOptionName)[LangCode.EN])
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.ES]),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.commandPlayStringOptionDescription)[LangCode.PT]
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.JA]),
                Pair(
                    DiscordLocale.CHINESE_CHINA,
                    LangHashMap(language.commandPlayStringOptionDescription)[LangCode.ZH]
                ),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN,
                    LangHashMap(language.commandPlayStringOptionDescription)[LangCode.ZH]
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandPlayStringOptionDescription)[LangCode.EN])
            )
        )
        command.addOptions(option)
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
        if (voiceChannel == null) {
            hook.editOriginalEmbeds(
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    LangHashMap(discordBot.language.joinRequired)[userLang]
                ).build()
            ).queue()
            return
        }

        val audioManager = event.guild!!.audioManager

        if (audioManager.isConnected && audioManager.connectedChannel != voiceChannel) {
            hook.editOriginalEmbeds(
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    LangHashMap(discordBot.language.alreadyBotJoined)[userLang]
                ).build()
            ).queue()
            return
        }

        audioManager.openAudioConnection(voiceChannel)

        discordBot.playerManager.loadItemOrdered(
            discordBot.getGuildAudioPlayer(event.guild!!, true),
            event.getOption("url")!!.asString,
            AudioLoadResultListener(event, discordBot, userLang)
        )
    }
}