package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmbedData(
    val title: String = "empty_title",
    val description: String = "empty_description",
    val color: String = "#ffffff"
)
