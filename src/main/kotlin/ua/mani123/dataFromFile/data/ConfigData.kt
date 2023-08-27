package ua.mani123.dataFromFile.data

import com.charleskorn.kaml.YamlComment
import kotlinx.serialization.Serializable

@Serializable
data class ConfigData(
    @YamlComment("Bot license, you can get it here: https://discord.worldmandia.cc")
    val botLicense: String = "LICENSE_HERE",
    @YamlComment("Bot token, from https://discord.com/developers/applications")
    val botToken: String = "CHANGE_HERE",
    @YamlComment("You can fully disable auto-leave")
    val autoLeaveFeature: Boolean = true,
    @YamlComment("If the number of players in the Stage < 2, should the bot exit")
    val autoLeaveFromStage: Boolean = false,
    @YamlComment("Writing in console message with info if user used any command")
    val debugCommandUsage: Boolean = false,
    @YamlComment("Use local files?")
    val enableLocalSource: Boolean = false,
    @YamlComment("Spotify settings")
    val spotify: Spotify = Spotify(),
    @YamlComment("Commands settings")
    val command: Command = Command()
) {
    @Serializable
    data class Spotify(
        val enable: Boolean = false,
        @YamlComment("You can find more info here: https://developer.spotify.com/dashboard")
        val clientId: String = "CHANGE_HERE",
        val clientSecret: String = "CHANGE_HERE",
        val countryCode: String = "UA"
    )

    @Serializable
    data class Command(
        val current: Boolean = true,
        val list: Boolean = true,
        val next: Boolean = true,
        val pause: Boolean = true,
        val play: Boolean = true,
        val repeat: Boolean = true,
        val skip: Boolean = true,
        val stop: Boolean = true,
        val volume: Boolean = true,
    )
}
