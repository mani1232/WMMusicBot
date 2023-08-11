package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.libs.JDA.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap

class SkipCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("skip", "Skip current track")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.skipCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.skipCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.skipCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.skipCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.skipCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.skipCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.skipCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.skipCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.skipCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.skipCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.skipCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.skipCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.skipCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.skipCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.skipCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.skipCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.skipCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.skipCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.skipCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.skipCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.skipCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.skipCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.skipCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.skipCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.skipCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.skipCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.skipCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.skipCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.skipCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.skipCommandData)[LangCode.EN].description)
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
            val hasNextTrack = guildAudioPlayer.scheduler.nextTrack()
            if (hasNextTrack) {
                hook.editOriginalEmbeds(
                    LangHashMap(discordBot.language.skipCommandAnswerData).generateEmbed(userLang)
                ).queue()
            } else {
                hook.editOriginalEmbeds(
                    LangHashMap(discordBot.language.emptyQueueData).generateEmbed(userLang)
                ).queue()
                guildAudioPlayer.player.destroy()
                discordBot.musicManagers.remove(event.guild!!.id.toLong())
                event.guild!!.audioManager.closeAudioConnection()
            }
            return
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
        ).queue()
    }
}