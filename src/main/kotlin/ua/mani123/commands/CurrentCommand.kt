package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import ua.mani123.libs.JDA.DiscordBot

class CurrentCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("current", "Send info about current track")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.currentCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.currentCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.currentCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.currentCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.currentCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.currentCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.currentCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.currentCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.currentCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.currentCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.currentCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.currentCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.currentCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.currentCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.currentCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.currentCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.currentCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.currentCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.currentCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.currentCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.currentCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.currentCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.currentCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.currentCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.currentCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.currentCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.currentCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.currentCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.currentCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.currentCommandData)[LangCode.EN].description)
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

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)

        if (guildAudioPlayer != null) {
            val player = guildAudioPlayer.player
            val currentTrack = "[${player.playingTrack.info.title}](${player.playingTrack.info.uri})"
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.currentCommandAnswerData).generateEmbed(
                    userLang,
                    currentTrack,
                    currentTrack
                )
            ).queue()
            return
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.emptyQueueData).generateEmbed(userLang)
        ).queue()
    }
}