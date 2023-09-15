package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable

@Serializable
data class CustomCommandData(
    val name: String = "empty_command_name",
    val description: String = "empty_command_description"
)