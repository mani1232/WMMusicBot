package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap

class ListCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("list", "Send list of tracks in queue")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.listCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.listCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.listCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.listCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.listCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.listCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.listCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.listCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.listCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.listCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.listCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.listCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.listCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.listCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.listCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.listCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.listCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.listCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.listCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.listCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.listCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.listCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.listCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.listCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.listCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.listCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.listCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.listCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.listCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.listCommandData)[LangCode.EN].description)
            )
        )
        val option = OptionData(OptionType.INTEGER, "count", "Max tracks count in list", false)
        option.setMaxValue(10)
        option.setMinValue(1)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.listCommandOptionData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.listCommandOptionData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.listCommandOptionData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.listCommandOptionData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.listCommandOptionData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.listCommandOptionData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.listCommandOptionData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.listCommandOptionData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.listCommandOptionData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.listCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.listCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.listCommandOptionData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.listCommandOptionData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.listCommandOptionData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.listCommandOptionData)[LangCode.EN].name)
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.listCommandOptionData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.listCommandOptionData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.listCommandOptionData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.listCommandOptionData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.listCommandOptionData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.listCommandOptionData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.listCommandOptionData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.listCommandOptionData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.listCommandOptionData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.listCommandOptionData)[LangCode.ZH].description),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN,
                    LangHashMap(language.listCommandOptionData)[LangCode.ZH].description
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.listCommandOptionData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.listCommandOptionData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.listCommandOptionData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.listCommandOptionData)[LangCode.EN].description)
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

            if (guildAudioPlayer.scheduler.queue.isEmpty()) {
                hook.editOriginalEmbeds(
                    LangHashMap(discordBot.language.emptyQueueData).generateEmbed(userLang)
                ).queue()
                return
            }

            var list = ""
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
                LangHashMap(discordBot.language.listCommandAnswerData).generateEmbed(userLang, list, list)
            ).queue()
            return
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
        ).queue()
    }
}