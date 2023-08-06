package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable
import ua.mani123.dataFromFile.LangCode

@Serializable
data class LanguageData(
    // list supported langs
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
    // Commands
    val commandCurrentName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "current")
        )
    ),
    val commandCurrentDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Send info about current track")
        )
    ),
    val commandStopName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "stop")
        )
    ),
    val commandStopDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Stops the player")
        )
    ),
    val commandVolumeName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "volume")
        )
    ),
    val commandVolumeDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Edit player volume")
        )
    ),
    val commandVolumeOptionName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "volume")
        )
    ),
    val commandVolumeOptionDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Value for volume")
        )
    ),
    val commandVolumeAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Volume set to %s")
        )
    ),
    val commandVolumeError: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "You cant set volume")
        )
    ),
    val commandVolumeInfo: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Volume: %s")
        )
    ),
    val commandSkipName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "skip")
        )
    ),
    val commandSkipDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Skip current track and start play next")
        )
    ),
    val commandListName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "list")
        )
    ),
    val commandListDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Send list of tracks in queue")
        )
    ),
    val commandPlayName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "play")
        )
    ),
    val commandPlayDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Starts playing a track")
        )
    ),
    val commandPlayStringOptionName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "url")
        )
    ),
    val commandPlayStringOptionDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "music url")
        )
    ),
    val commandListOptionName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "count")
        )
    ),
    val commandListOptionDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Max tracks count in list")
        )
    ),
    val commandPauseName: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "pause")
        )
    ),
    val commandPauseDescription: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Pauses the current track")
        )
    ),
    // embed answers
    val joinRequired: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Pls, join to voice channel")
        )
    ),
    val pauseCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Track paused status %s")
        )
    ),
    val skipCommandError: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Player dont have queue")
        )
    ),
    val listCommandError: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Queue is empty")
        )
    ),
    val listCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Queue list")
        )
    ),
    val listCommandEmpty: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Queue is empty")
        )
    ),
    val stopCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Stopped")
        )
    ),
    val botConnected: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Bot connected")
        )
    ),
    val trackLoaded: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Track loaded and started playing")
        )
    ),
    val playlistLoaded: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Playlist loaded and started playing first track")
        )
    ),
    val noMatches: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "No Matches")
        )
    ),
    val skipCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Skiped music and start play next")
        )
    ),
    val skipEmptyQueueCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Queue is empty for skip")
        )
    ),
    val currentEmptyTrackCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Current track not found")
        )
    ),
    val currentTrackCommandAnswer: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Current track: %s")
        )
    ),
    val alreadyBotJoined: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Bot already joined and play music in another voice channel")
        )
    ),
    val cantUseCommand: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "You cant use this command")
        )
    ),
    val alreadyBotStopped: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Bot already stopped")
        )
    ),
    val currentTrackInfo: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Current playing track info")
        )
    ),
    val failedLoad: HashMap<LangCode, String> = HashMap(
        mapOf(
            Pair(LangCode.EN, "Failed load with error message %s")
        )
    ),
    val testCustomEmbed: HashMap<LangCode, CustomEmbedData> = HashMap(
        mapOf(
            Pair(LangCode.EN, CustomEmbedData())
        )
    )
)
