package ua.mani123.dataFromFile

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import java.io.File

class ConfigUtils(val logger: Logger) {
    inline fun <reified T> loadFile(
        fileName: String, dataClass: T
    ): T {
        val file = File(fileName)
        try {
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
        } catch (e: SerializationException) {
            logger.error(
                """
                Error in file: ${file.name}
                ${e.message}
            """.trimIndent()
            )
            return dataClass
        }
    }
}