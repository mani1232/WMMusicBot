package ua.mani123.dataFromFile

import kotlinx.serialization.decodeFromString
import net.mamoe.yamlkt.Yaml
import java.io.File

class ConfigUtils {
    inline fun <reified T> loadFile(
        fileName: String, dataClass: T
    ): T {
        val file = File(fileName)
        val dataClassComplete = if (file.createNewFile()) {
            file.bufferedWriter().use {
                it.write(Yaml.encodeToString(dataClass))
                it.close()
            }
            dataClass
        } else {
            Yaml.decodeFromString(file.reader().use {
                it.readLines().joinToString(separator = "\n")
            })
        }
        return dataClassComplete
    }
}