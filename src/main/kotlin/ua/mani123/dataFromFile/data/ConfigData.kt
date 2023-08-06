package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable

@Serializable
data class ConfigData(
    val botToken: String = "CHANGE_HERE",
    val autoLeaveFromStage: Boolean = false,
    val debugCommandUsage: Boolean = false,
    val enableLocalSource: Boolean = false,
    val hexEmbedColor: String = "#d61313"
)
