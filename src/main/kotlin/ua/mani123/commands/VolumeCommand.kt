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

class VolumeCommand(private val discordBot: DiscordBot) : CommandApi {

    private val command: SlashCommandData = Commands.slash("volume", "Edit player volume")

    init {
        command.setGuildOnly(true)
        command.setNSFW(false)
        val language = discordBot.language
        command.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandVolumeName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandVolumeName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandVolumeName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandVolumeName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandVolumeName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandVolumeName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandVolumeName)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandVolumeName)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandVolumeName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandVolumeName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandVolumeName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandVolumeName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandVolumeName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandVolumeName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandVolumeName)[LangCode.EN])
            )
        )
        command.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandVolumeDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandVolumeDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandVolumeDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandVolumeDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandVolumeDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandVolumeDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandVolumeDescription)[LangCode.ES]),
                Pair(DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandVolumeDescription)[LangCode.PT]),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandVolumeDescription)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandVolumeDescription)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandVolumeDescription)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandVolumeDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandVolumeDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandVolumeDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandVolumeDescription)[LangCode.EN])
            )
        )
        val option = OptionData(OptionType.INTEGER, "volume", "Value for volume", false, true)
        option.setMinValue(0)
        option.setMaxValue(200)
        option.nameLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandVolumeOptionName)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandVolumeOptionName)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandVolumeOptionName)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandVolumeOptionName)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandVolumeOptionName)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandVolumeOptionName)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandVolumeOptionName)[LangCode.ES]),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN, LangHashMap(language.commandVolumeOptionName)[LangCode.PT]
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandVolumeOptionName)[LangCode.JA]),
                Pair(DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandVolumeOptionName)[LangCode.ZH]),
                Pair(DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandVolumeOptionName)[LangCode.ZH]),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandVolumeOptionName)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandVolumeOptionName)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandVolumeOptionName)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandVolumeOptionName)[LangCode.EN])
            )
        )
        option.descriptionLocalizations.setTranslations(
            mutableMapOf(
                Pair(DiscordLocale.RUSSIAN, LangHashMap(language.commandVolumeOptionDescription)[LangCode.RU]),
                Pair(DiscordLocale.ENGLISH_US, LangHashMap(language.commandVolumeOptionDescription)[LangCode.EN]),
                Pair(DiscordLocale.UKRAINIAN, LangHashMap(language.commandVolumeOptionDescription)[LangCode.UK]),
                Pair(DiscordLocale.DUTCH, LangHashMap(language.commandVolumeOptionDescription)[LangCode.DE]),
                Pair(DiscordLocale.POLISH, LangHashMap(language.commandVolumeOptionDescription)[LangCode.PL]),
                Pair(DiscordLocale.FRENCH, LangHashMap(language.commandVolumeOptionDescription)[LangCode.FR]),
                Pair(DiscordLocale.SPANISH, LangHashMap(language.commandVolumeOptionDescription)[LangCode.ES]),
                Pair(
                    DiscordLocale.PORTUGUESE_BRAZILIAN,
                    LangHashMap(language.commandVolumeOptionDescription)[LangCode.PT]
                ),
                Pair(DiscordLocale.JAPANESE, LangHashMap(language.commandVolumeOptionDescription)[LangCode.JA]),
                Pair(
                    DiscordLocale.CHINESE_CHINA, LangHashMap(language.commandVolumeOptionDescription)[LangCode.ZH]
                ),
                Pair(
                    DiscordLocale.CHINESE_TAIWAN, LangHashMap(language.commandVolumeOptionDescription)[LangCode.ZH]
                ),
                Pair(DiscordLocale.BULGARIAN, LangHashMap(language.commandVolumeOptionDescription)[LangCode.BG]),
                Pair(DiscordLocale.HINDI, LangHashMap(language.commandVolumeOptionDescription)[LangCode.HI]),
                Pair(DiscordLocale.HUNGARIAN, LangHashMap(language.commandVolumeOptionDescription)[LangCode.HU]),
                Pair(DiscordLocale.ENGLISH_UK, LangHashMap(language.commandVolumeOptionDescription)[LangCode.EN])
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
                EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                    LangHashMap(discordBot.language.cantUseCommand)[userLang]
                ).build()
            ).queue()
            return
        }

        val guildAudioPlayer = discordBot.getGuildAudioPlayer(event.guild!!, false)

        if (guildAudioPlayer != null && guildAudioPlayer.player.playingTrack != null) {
            val volume = event.getOption("volume")?.asInt
            if (volume != null) {
                hook.editOriginalEmbeds(
                    EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                        String.format(
                            LangHashMap(discordBot.language.commandVolumeAnswer)[userLang], volume
                        )
                    ).build()
                ).queue()
                guildAudioPlayer.player.volume = volume
                return
            } else {
                hook.editOriginalEmbeds(
                    EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                        String.format(
                            LangHashMap(discordBot.language.commandVolumeInfo)[userLang], guildAudioPlayer.player.volume
                        )
                    ).build()
                ).queue()
                return
            }
        }

        hook.editOriginalEmbeds(
            EmbedBuilder().setColor(Color.decode(discordBot.config.hexEmbedColor)).setTitle(
                LangHashMap(discordBot.language.commandVolumeError)[userLang]
            ).build()
        ).queue()
    }
}