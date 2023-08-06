package ua.mani123.dataFromFile.data

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class StatsData {
    val serviceUUID: String = UUID.randomUUID().toString()
    val enabled: Boolean = true
}