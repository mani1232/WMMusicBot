package ua.mani123.loaders

import java.io.File
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Path
import java.time.Duration
import java.util.*
import kotlin.system.exitProcess

class AppLoader(key: String, product: String, path: Path) {

    val loadedFile: File

    init {
        val file = path.resolve("/$product-latest.jar").toFile()
        file.createNewFile()

        val client: HttpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build()

        val versionRequest = HttpRequest.newBuilder()
            .uri(URI("http://82.66.203.77:8080/$product/latest-version"))
            .GET()
            .header("license-key", key)
            .timeout(Duration.ofSeconds(10))
            .build()

        val answer = client.sendAsync(versionRequest, HttpResponse.BodyHandlers.ofString()).get()
        val latestVersion = answer.body()
        if (answer.statusCode() == 200) {
            val fileRequest = HttpRequest.newBuilder()
                .uri(URI("http://82.66.203.77:8080/$product/$latestVersion"))
                .GET()
                .header("license-key", key)
                .header("hwid", getHwid())
                .timeout(Duration.ofSeconds(10))
                .build()

            client.sendAsync(fileRequest, HttpResponse.BodyHandlers.ofFile(file.toPath())).get()
        } else {
            println("--- Error: $latestVersion")
            exitProcess(0)
        }
        loadedFile = file
    }

    private fun getHwid(): String {
        val hwid = System.getProperty("os.name") + System.getProperty("user.name") + Runtime.getRuntime()
            .availableProcessors() + System.getProperty("os.arch") + System.getenv("COMPUTERNAME")
        return Base64.getEncoder().encodeToString(hwid.toByteArray())
    }

}