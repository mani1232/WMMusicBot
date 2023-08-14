package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import ua.mani123.libs.JDA.DiscordBot

class StopCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("stop", "Stop bot playing and leave from voice channel")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.stopCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.stopCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.stopCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.stopCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.stopCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.stopCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.stopCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.stopCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.stopCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.stopCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.stopCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.stopCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.stopCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.stopCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.stopCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.stopCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.stopCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.stopCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.stopCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.stopCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.stopCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.stopCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.stopCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.stopCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.stopCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.stopCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.stopCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.stopCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.stopCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.stopCommandData)[LangCode.EN].description)
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
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.stopCommandAnswerData).generateEmbed(userLang)
            ).queue()
            guildAudioPlayer.player.destroy()
            //discordBot.musicManagers.remove(event.guild!!.id.toLong())
            event.guild!!.audioManager.closeAudioConnection()
            return
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.alreadyStoppedData).generateEmbed(userLang)
        ).queue()
    }
}