package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class ConfigData(
    val botToken: String = "CHANGE_HERE",
    val autoLeaveFromStage: Boolean = false,
    val debugCommandUsage: Boolean = false,
    val enableLocalSource: Boolean = false,
    val hexEmbedColor: String = "#d61313",
    val serviceUUID: String = UUID.randomUUID().toString(),
)
