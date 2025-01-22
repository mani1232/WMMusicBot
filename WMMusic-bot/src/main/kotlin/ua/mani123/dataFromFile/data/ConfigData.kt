package ua.mani123.dataFromFile.data

import com.charleskorn.kaml.YamlComment
import kotlinx.serialization.Serializable

@Serializable
data class ConfigData(
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
    @YamlComment("Youtube settings")
    val youtube: Youtube = Youtube(),
    @YamlComment("Spotify settings")
    val spotify: Spotify = Spotify(),
    @YamlComment("FloweryTTS settings")
    val floweryTTS: FloweryTTS = FloweryTTS(),
    @YamlComment("Commands settings")
    val command: Command = Command()
) {
    @Serializable
    data class Youtube(
        val enable: Boolean = true,
        @YamlComment("Not supported yet")
        val allowSearch: Boolean = false,
    )

    @Serializable
    data class Spotify(
        val enable: Boolean = false,
        @YamlComment("You can find more info here: https://developer.spotify.com/dashboard")
        val clientId: String = "CHANGE_HERE",
        val clientSecret: String = "CHANGE_HERE",
        val countryCode: String = "UA"
    )

    @Serializable
    data class FloweryTTS(
        val enable: Boolean = false,
        @YamlComment("You can find more voices here: https://api.flowery.pw/v1/tts/voices")
        val voice: String = "Lesya",
        val translate: Boolean = false,
        val speed: Float = 1f
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
