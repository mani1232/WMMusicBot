package ua.mani123.dataFromFile

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.slf4j.Logger
import java.io.File
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

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

    @Serializable
    data class LicenseUser(
        val licensekey: String, val product: String
    )

    @Serializable
    data class Answer(
        val status_id: String,
        val discord_id: String,
        val status_code: Int,
        val status_overview: String,
        val status_msg: String
    )

    fun checkKey(key: String): Boolean {
        try {
            val answer = Json.decodeFromString<Answer>(
                HttpClient.newBuilder().build().sendAsync(
                    HttpRequest.newBuilder().uri(URI.create("http://82.66.203.77:28015/api/client"))
                        .header("Content-Type", "application/json")
                        .header("Authorization", "rm7R9n2JVRKjskFhMW12mMwdSDaDPJE2lduvkdhR")
                        .POST(HttpRequest.BodyPublishers.ofString(Json.encodeToString(LicenseUser(key, "WMMusic"))))
                        .build(), HttpResponse.BodyHandlers.ofString()
                ).get().body()
            )
            return when (answer.status_id) {
                "SUCCESS" -> {
                    logger.warn("License is valid, thanks you for buying this bot")
                    true
                }

                else -> {
                    logger.error("License not valid, join to discord.worldmandia.cc for get help")
                    false
                }
            }
        } catch (e: Exception) {
            logger.error("You get error when check license")
            return false
        }
    }

}