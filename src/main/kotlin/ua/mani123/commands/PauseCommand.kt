package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import ua.mani123.libs.JDA.DiscordBot

class PauseCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("pause", "Pause track")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.pauseCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.pauseCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.pauseCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.pauseCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.pauseCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.pauseCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.pauseCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.pauseCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.pauseCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.pauseCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.pauseCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.pauseCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.pauseCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.pauseCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.pauseCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.pauseCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.pauseCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.pauseCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.pauseCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.pauseCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.pauseCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.pauseCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.pauseCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.pauseCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.pauseCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.pauseCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.pauseCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.pauseCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.pauseCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.pauseCommandData)[LangCode.EN].name)
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
                LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
            ).queue()
            return
        }

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)
        if (guildAudioPlayer != null) {
            val player = guildAudioPlayer.player
            player.isPaused = !player.isPaused

            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.pauseCommandAnswerData).generateEmbed(
                    userLang,
                    player.isPaused.toString(),
                    player.isPaused.toString()
                )
            ).queue()
        } else {
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
            ).queue()
        }
    }
}