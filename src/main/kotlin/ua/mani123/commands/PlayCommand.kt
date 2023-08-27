package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.audio.AudioLoadResultListener
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import ua.mani123.libs.JDA.DiscordBot

class PlayCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("play", "Starts playing track")

    init {
        /* ¯\_(ツ)_/¯
        val nameList : MutableMap<DiscordLocale, String> = mutableMapOf()
        for (langCode in LangCode.entries) {
            nameList[DiscordLocale.from(langCode.name.lowercase())] = LangHashMap(language.playCommandData)[langCode].name
        }
     */
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.playCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.playCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.playCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.playCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.playCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.playCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.playCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.playCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.playCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.playCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.playCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.playCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.playCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.playCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.playCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.playCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.playCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.playCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.playCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.playCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.playCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.playCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.playCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.playCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.playCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.playCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.playCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.playCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.playCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.playCommandData)[LangCode.EN].description)
            )
        )
        val option = OptionData(OptionType.STRING, "url", "Url for track", false)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.playCommandOptionData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.playCommandOptionData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.playCommandOptionData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.playCommandOptionData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.playCommandOptionData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.playCommandOptionData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.playCommandOptionData)[LangCode.ES].name),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.playCommandOptionData)[LangCode.PT].name
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.playCommandOptionData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.playCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.playCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.playCommandOptionData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.playCommandOptionData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.playCommandOptionData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.playCommandOptionData)[LangCode.EN].name)
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.playCommandOptionData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.playCommandOptionData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.playCommandOptionData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.playCommandOptionData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.playCommandOptionData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.playCommandOptionData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.playCommandOptionData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.playCommandOptionData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.playCommandOptionData)[LangCode.JA].description),
                Pair(
                    DiscordLocale.CHINESE_CHINA,
                    LangHashMap(language.playCommandOptionData)[LangCode.ZH].description
                ),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN,
                    LangHashMap(language.playCommandOptionData)[LangCode.ZH].description
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.playCommandOptionData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.playCommandOptionData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.playCommandOptionData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.playCommandOptionData)[LangCode.EN].description)
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
                LangHashMap(discordBot.language.joinRequiredData).generateEmbed(userLang)
            ).queue()
            return
        }

        val audioManager = event.guild!!.audioManager

        if (audioManager.isConnected && audioManager.connectedChannel != voiceChannel) {
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.botAlreadyJoinedData).generateEmbed(userLang)
            ).queue()
            return
        }

        if (event.getOption("url") != null) {
            audioManager.openAudioConnection(voiceChannel)

            val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, true)

            discordBot.playerManager.loadItemOrdered(
                guildAudioPlayer,
                event.getOption("url")!!.asString.replace(" ", "%20"),
                AudioLoadResultListener(event, discordBot, userLang, guildAudioPlayer!!)
            )
        } else {
            val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)
            if (guildAudioPlayer != null && guildAudioPlayer.scheduler.queue.isNotEmpty()) {
                audioManager.openAudioConnection(voiceChannel)
                guildAudioPlayer.scheduler.nextTrack(guildAudioPlayer.repeat)
            } else {
                hook.editOriginalEmbeds(
                    LangHashMap(discordBot.language.emptyQueueData).generateEmbed(userLang)
                ).queue()
            }
        }
    }
}