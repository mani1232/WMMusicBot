package ua.mani123.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import java.awt.Color

class ListCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("list", "Send list of tracks in queue")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandListName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandListName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandListName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandListName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandListName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandListName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandListName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandListName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandListName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandListName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandListName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandListName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandListName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandListName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandListName)[LangCode.EN])
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandListDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandListDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandListDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandListDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandListDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandListDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandListDescription)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandListDescription)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandListDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandListDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandListDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandListDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandListDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandListDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandListDescription)[LangCode.EN])
            )
        )
        val option = OptionData(OptionType.INTEGER, "count", "Max tracks count in list", false)
        option.setMaxValue(10)
        option.setMinValue(1)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandListOptionName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandListOptionName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandListOptionName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandListOptionName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandListOptionName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandListOptionName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandListOptionName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandListOptionName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandListOptionName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandListOptionName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandListOptionName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandListOptionName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandListOptionName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandListOptionName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandListOptionName)[LangCode.EN])
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandListOptionDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandListOptionDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandListOptionDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandListOptionDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandListOptionDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandListOptionDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandListOptionDescription)[LangCode.ES]),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.commandListOptionDescription)[LangCode.PT]
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandListOptionDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandListOptionDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandListOptionDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandListOptionDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandListOptionDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandListOptionDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandListOptionDescription)[LangCode.EN])
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
        var count = event.getOption("count")?.asInt
        if (count == null) {
            count = 5
        }

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)

        if (guildAudioPlayer != null) {
            var list = LangHashMap(discordBot.language.listCommandEmpty)[userLang]
            if (guildAudioPlayer.scheduler.queue.isNotEmpty()) {
                list = buildString {
                    guildAudioPlayer.scheduler.queue.forEachIndexed { index, audioTrack ->
                        val finalIndex = index + 1
                        if (finalIndex <= count) {
                            append("${finalIndex}. [${audioTrack.info.title}](${audioTrack.info.uri})\n")
                        }
                    }
                }
            }
            hook.editOriginalEmbeds(
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    LangHashMap(discordBot.language.listCommandAnswer)[userLang]
                ).setDescription(list).build()
            ).queue()
            return
        }

        hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.listCommandError)[userLang]
            ).build()
        ).queue()
    }
}