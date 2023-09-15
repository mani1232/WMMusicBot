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

class NextCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("next", "Rewinds the current song")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.nextCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.nextCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.nextCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.nextCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.nextCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.nextCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.nextCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.nextCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.nextCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.nextCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.nextCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.nextCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.nextCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.nextCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.nextCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.nextCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.nextCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.nextCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.nextCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.nextCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.nextCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.nextCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.nextCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.nextCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.nextCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.nextCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.nextCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.nextCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.nextCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.nextCommandData)[LangCode.EN].description)
            )
        )
        val option = OptionData(OptionType.STRING, "seconds", "How many seconds", true, true)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.nextCommandOptionData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.nextCommandOptionData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.nextCommandOptionData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.nextCommandOptionData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.nextCommandOptionData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.nextCommandOptionData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.nextCommandOptionData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.nextCommandOptionData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.nextCommandOptionData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.nextCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.nextCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.nextCommandOptionData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.nextCommandOptionData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.nextCommandOptionData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.nextCommandOptionData)[LangCode.EN].name)
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.nextCommandOptionData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.nextCommandOptionData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.nextCommandOptionData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.nextCommandOptionData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.nextCommandOptionData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.nextCommandOptionData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.nextCommandOptionData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.nextCommandOptionData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.nextCommandOptionData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.nextCommandOptionData)[LangCode.ZH].description),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN,
                    LangHashMap(language.nextCommandOptionData)[LangCode.ZH].description
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.nextCommandOptionData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.nextCommandOptionData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.nextCommandOptionData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.nextCommandOptionData)[LangCode.EN].description)
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

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)

        if (guildAudioPlayer != null && guildAudioPlayer.player.playingTrack != null) {
            val sec = event.getOption("seconds")!!.asString.split(" ")[0].toLong() * 1000
            val position = guildAudioPlayer.player.playingTrack.position
            if (sec <= guildAudioPlayer.player.playingTrack.duration) {
                guildAudioPlayer.player.playingTrack.position = position + sec
            }
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.nextCommandAnswerData).generateEmbed(
                    userLang,
                    (guildAudioPlayer.player.playingTrack.position / 1000).toString(),
                    (guildAudioPlayer.player.playingTrack.duration / 1000).toString()
                )
            ).queue()
            return
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
        ).queue()
    }
}