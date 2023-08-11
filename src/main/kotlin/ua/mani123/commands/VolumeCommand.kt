package ua.mani123.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import ua.mani123.libs.JDA.DiscordBot
import ua.mani123.dataFromFile.LangCode
import ua.mani123.dataFromFile.LangHashMap

class VolumeCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("volume", "Edit player volume")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.volumeCommandData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.volumeCommandData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.volumeCommandData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.volumeCommandData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.volumeCommandData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.volumeCommandData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.volumeCommandData)[LangCode.ES].name),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.volumeCommandData)[LangCode.PT].name),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.volumeCommandData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.volumeCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.volumeCommandData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.volumeCommandData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.volumeCommandData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.volumeCommandData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.volumeCommandData)[LangCode.EN].name)
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.volumeCommandData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.volumeCommandData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.volumeCommandData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.volumeCommandData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.volumeCommandData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.volumeCommandData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.volumeCommandData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.volumeCommandData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.volumeCommandData)[LangCode.JA].description),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.volumeCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.volumeCommandData)[LangCode.ZH].description),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.volumeCommandData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.volumeCommandData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.volumeCommandData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.volumeCommandData)[LangCode.EN].description)
            )
        )
        val option = OptionData(OptionType.INTEGER, "volume", "Value for volume", false, true)
        option.setMinValue(0)
        option.setMaxValue(200)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.RU].name),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.volumeCommandOptionData)[LangCode.EN].name),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.UK].name),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.volumeCommandOptionData)[LangCode.DE].name),
                Pair(DiscordLocale.POLISH, LangHashMap(language.volumeCommandOptionData)[LangCode.PL].name),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.volumeCommandOptionData)[LangCode.FR].name),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.volumeCommandOptionData)[LangCode.ES].name),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.PT].name
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.volumeCommandOptionData)[LangCode.JA].name),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.volumeCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.volumeCommandOptionData)[LangCode.ZH].name),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.BG].name),
                Pair(DiscordLocale.HINDI, LangHashMap(language.volumeCommandOptionData)[LangCode.HI].name),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.HU].name),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.volumeCommandOptionData)[LangCode.EN].name)
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.RU].description),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.volumeCommandOptionData)[LangCode.EN].description),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.UK].description),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.volumeCommandOptionData)[LangCode.DE].description),
                Pair(DiscordLocale.POLISH, LangHashMap(language.volumeCommandOptionData)[LangCode.PL].description),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.volumeCommandOptionData)[LangCode.FR].description),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.volumeCommandOptionData)[LangCode.ES].description),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.volumeCommandOptionData)[LangCode.PT].description
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.volumeCommandOptionData)[LangCode.JA].description),
                Pair(
                    DiscordLocale.CHINESE_CHINA, LangHashMap(language.volumeCommandOptionData)[LangCode.ZH].description
                ),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.volumeCommandOptionData)[LangCode.ZH].description
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.BG].description),
                Pair(DiscordLocale.HINDI, LangHashMap(language.volumeCommandOptionData)[LangCode.HI].description),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.volumeCommandOptionData)[LangCode.HU].description),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.volumeCommandOptionData)[LangCode.EN].description)
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
        if (voiceChannel == null || event.guild!!.audioManager.connectedChannel != voiceChannel) {
            hook.editOriginalEmbeds(
                LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
            ).queue()
            return
        }

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)

        if (guildAudioPlayer != null && guildAudioPlayer.player.playingTrack != null) {
            val volume = event.getOption("volume")?.asInt
            return if (volume != null) {
                hook.editOriginalEmbeds(
                    LangHashMap(discordBot.language.volumeCommandAnswerData).generateEmbed(
                        userLang,
                        volume.toString(),
                        volume.toString()
                    )
                ).queue()
                guildAudioPlayer.player.volume = volume
            } else {
                hook.editOriginalEmbeds(
                    LangHashMap(discordBot.language.volumeCommandInfoData).generateEmbed(
                        userLang,
                        guildAudioPlayer.player.volume.toString(),
                        guildAudioPlayer.player.volume.toString()
                    )
                ).queue()
            }
        }

        hook.editOriginalEmbeds(
            LangHashMap(discordBot.language.cantUseData).generateEmbed(userLang)
        ).queue()
    }
}