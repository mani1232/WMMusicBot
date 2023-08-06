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

class SkipCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("skip", "Skip current track")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandSkipName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandSkipName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandSkipName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandSkipName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandSkipName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandSkipName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandSkipName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandSkipName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandSkipName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandSkipName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandSkipName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandSkipName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandSkipName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandSkipName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandSkipName)[LangCode.EN])
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandSkipDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandSkipDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandSkipDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandSkipDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandSkipDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandSkipDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandSkipDescription)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandSkipDescription)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandSkipDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandSkipDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandSkipDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandSkipDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandSkipDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandSkipDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandSkipDescription)[LangCode.EN])
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
            val hasNextTrack = guildAudioPlayer.scheduler.nextTrack()
            if (hasNextTrack) {
                hook.editOriginalEmbeds(
                    EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                        LangHashMap(discordBot.language.skipCommandAnswer)[userLang]
                    ).build()
                ).queue()
            } else {
                hook.editOriginalEmbeds(
                    EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                        LangHashMap(discordBot.language.skipEmptyQueueCommandAnswer)[userLang]
                    ).build()
                ).queue()
                guildAudioPlayer.player.destroy()
                discordBot.musicManagers.remove(event.guild!!.id.toLong())
                event.guild!!.audioManager.closeAudioConnection()
            }
            return
        }

        hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.skipCommandError)[userLang]
            ).build()
        ).queue()
    }
}