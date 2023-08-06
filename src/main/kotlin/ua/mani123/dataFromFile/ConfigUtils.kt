package ua.mani123.dataFromFile

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import java.io.File

class ConfigUtils {
    inline fun <reified T> loadFile(
        fileName: String, dataClass: T
    ): T {
        val file = File(fileName)
        val dataClassComplete = if (file.createNewFile()) {
            file.bufferedWriter().use {
                it.write(Yaml.default.encodeToString(dataClass))
                it.close()
            }
            dataClass
        } else {
            Yaml.default.decodeFromString(file.reader().use {
                it.readLines().joinToString(separator = "\n")
            })
        }
        return dataClassComplete
    }
}