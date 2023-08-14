package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap
import ua.mani123.libs.JDA.DiscordBot

class RepeatCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("repeat", "Enable repeat mode")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.repeatCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.repeatCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.repeatCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.repeatCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.repeatCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.repeatCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.repeatCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.repeatCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.repeatCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.repeatCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.repeatCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.repeatCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.repeatCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.repeatCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.repeatCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.repeatCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.repeatCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.repeatCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.repeatCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.repeatCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.repeatCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.repeatCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.repeatCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.repeatCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.repeatCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.repeatCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.repeatCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.repeatCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.repeatCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.repeatCommandData)[LangCode.EN].description)
            )
        )
        val optionOne = OptionData(OptionType.BOOLEAN, "status", "Enable or disable repeat mode", false)
        optionOne.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.repeatCommandOptionOneData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.ES].name),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.PT].name
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.repeatCommandOptionOneData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.repeatCommandOptionOneData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.repeatCommandOptionOneData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.repeatCommandOptionOneData)[LangCode.EN].name)
            )
        )
        optionOne.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.repeatCommandOptionOneData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.repeatCommandOptionOneData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.repeatCommandOptionOneData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.repeatCommandOptionOneData)[LangCode.JA].description),
                Pair(
                    DiscordLocale.CHINESE_CHINA, LangHashMap(language.repeatCommandOptionOneData)[LangCode.ZH].description
                ),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.ZH].description
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.repeatCommandOptionOneData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.repeatCommandOptionOneData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.repeatCommandOptionOneData)[LangCode.EN].description)
            )
        )
        val optionTwo = OptionData(OptionType.BOOLEAN, "add_track", "Add current playing track in repeat queue", false)
        optionOne.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.ES].name),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.PT].name
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.EN].name)
            )
        )
        optionOne.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.repeatCommandOptionTwoData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.JA].description),
                Pair(
                    DiscordLocale.CHINESE_CHINA, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.ZH].description
                ),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.ZH].description
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.repeatCommandOptionTwoData)[LangCode.EN].description)
            )
        )
        command.addOptions(optionOne)
        command.addOptions(optionTwo)
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

        if (guildAudioPlayer != null && guildAudioPlayer.player.playingTrack != null) {
            val status = event.getOption("status")?.asBoolean
            if (status != null) {
                if (event.getOption("add_track") != null && event.getOption("add_track")!!.asBoolean) {
                    guildAudioPlayer.scheduler.queue.add(guildAudioPlayer.player.playingTrack.makeClone())
                }
                guildAudioPlayer.repeat = status
            }
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.repeatCommandAnswerData).generateEmbed(
                    userLang,
                    guildAudioPlayer.repeat.toString(),
                    guildAudioPlayer.repeat.toString()
                )
            ).queue()
            return
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
        ).queue()
    }
}