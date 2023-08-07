package ua.mani123.dataFromFile.data

import com.charleskorn.kaml.YamlComment
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class StatsData {
    @YamlComment("Unique UUID for bstats, dont edit")
    val serviceUUID: String = UUID.randomUUID().toString()

    @YamlComment("Bstats enabled?")
    val enabled: Boolean = true
}