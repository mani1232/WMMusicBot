package ua.mani123.dataFromFile.data

import com.charleskorn.kaml.YamlComment
import kotlinx.serialization.Serializable
import ua.mani123.dataFromFile.LangCode

@Serializable
data class LanguageData(
    @YamlComment("List of supported languages")
    val testString: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, LangCode.EN.langName),
            Pair(LangCode.RU, LangCode.RU.langName),
            Pair(LangCode.UK, LangCode.UK.langName),
            Pair(LangCode.ES, LangCode.ES.langName),
            Pair(LangCode.HU, LangCode.HU.langName),
            Pair(LangCode.HI, LangCode.HI.langName),
            Pair(LangCode.BG, LangCode.BG.langName),
            Pair(LangCode.PT, LangCode.PT.langName),
            Pair(LangCode.FR, LangCode.FR.langName),
            Pair(LangCode.DE, LangCode.DE.langName),
            Pair(LangCode.PL, LangCode.PL.langName),
            Pair(LangCode.JA, LangCode.JA.langName),
            Pair(LangCode.ZH, LangCode.ZH.langName)
        )
    ),
    @YamlComment("Embeds")
    val cantUseData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "You cant use this command"))
        )
    ),
    val repeatCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Repeat is: %s"))
        )
    ),
    val pauseCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Player paused: %s"))
        )
    ),
    val skipCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Current track skipped and start playing next track"))
        )
    ),
    val currentCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Current track", description = "%s"))
        )
    ),
    val listCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Queue", description = "%s"))
        )
    ),
    val volumeCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Volume set to %s"))
        )
    ),
    val volumeCommandInfoData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Volume %s"))
        )
    ),
    val stopCommandAnswerData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Player stopped"))
        )
    ),
    val alreadyStoppedData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "This bot already stopped"))
        )
    ),
    val emptyQueueData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Queue is empty"))
        )
    ),
    val trackLoadedData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Track loaded"))
        )
    ),
    val playlistLoadedData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Playlist loaded"))
        )
    ),
    val noMatchesData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "No matches"))
        )
    ),
    val filedLoadData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Filed load with error message %s"))
        )
    ),
    val botAlreadyJoinedData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "Bot already joined to voice channel"))
        )
    ),
    val joinRequiredData: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData(title = "You need join to voice channel for use this command"))
        )
    ),
    @YamlComment("Commands")
    val stopCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(
                LangCode.EN,
                CustomCommandData(name = "stop", description = "Stop bot playing and leave from voice channel")
            )
        )
    ),
    val pauseCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "pause", description = "Pause track"))
        )
    ),
    val skipCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "skip", description = "Skip current track"))
        )
    ),
    val repeatCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "repeat", description = "Enable repeat mode"))
        )
    ),
    val repeatCommandOptionOneData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "status", description = "Enable or disable repeat mode"))
        )
    ),
    val repeatCommandOptionTwoData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "add-track", description = "Add current playing track in repeat queue"))
        )
    ),
    val volumeCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "volume", description = "Edit player volume"))
        )
    ),
    val volumeCommandOptionData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "volume", description = "Value for volume"))
        )
    ),
    val listCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "list", description = "Send list of tracks in queue"))
        )
    ),
    val listCommandOptionData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "count", description = "Max tracks count in list"))
        )
    ),
    val currentCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "current", description = "Send info about current track"))
        )
    ),
    val playCommandData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "play", description = "Starts playing track"))
        )
    ),
    val playCommandOptionData: HashMap<LangCode, CustomCommandData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomCommandData(name = "url", description = "Url for track"))
        )
    )
)
