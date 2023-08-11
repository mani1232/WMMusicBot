package ua.mani123.libs.JDA

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.slf4j.Logger
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class Connection(private val logger: Logger, private val key: String) {

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

    fun testConnection(): Boolean {
        try {
            val answer = Json.decodeFromString<Answer>(
                HttpClient.newBuilder().build().sendAsync(
                    HttpRequest.newBuilder().uri(URI.create("http://play.worldmandia.cc:28015/api/client"))
                        .header("Content-Type", "application/json")
                        .header("Authorization", "rm7R9n2JVRKjskFhMW12mMwdSDaDPJE2lduvkdhR")
                        .POST(HttpRequest.BodyPublishers.ofString(Json.encodeToString(LicenseUser(key, "WMMusic"))))
                        .build(), HttpResponse.BodyHandlers.ofString()
                ).get().body()
            )
            return when (answer.status_id) {
                "SUCCESS" -> {
                    logger.info("The license is valid, thank you for purchasing this bot")
                    true
                }

                else -> {
                    logger.error("The license is not valid, join to discord.worldmandia.cc for get help")
                    false
                }
            }
        } catch (e: Exception) {
            logger.error("You get error when check license")
            return false
        }
    }

}