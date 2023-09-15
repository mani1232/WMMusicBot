package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmbedData(
    val title: String = "",
    val description: String = "",
    val color: String = "#d61313"
)
