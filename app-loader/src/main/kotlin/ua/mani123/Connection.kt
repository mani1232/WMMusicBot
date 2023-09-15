package ua.mani123

import okhttp3.OkHttpClient
import okhttp3.Request
import okio.BufferedSink
import okio.buffer
import okio.sink
import java.io.File
import java.util.*


class Connection(private val key: String, private val product: String) {

    private var client = OkHttpClient()

    fun loadApp(): File {
        val checkVersionUrl = "http://82.66.203.77:8080/$product/latest-version"

        val latestVersionRequest: Request = Request.Builder()
            .url(checkVersionUrl)
            .get()
            .addHeader("license-key", key)
            .build()

        var latestVersion: String

        client.newCall(latestVersionRequest).execute().use { response -> latestVersion = response.body!!.string() }

        val getFileUrl = "http://82.66.203.77:8080/$product/$latestVersion"

        val file = File("libs/$product-latest.jar")
        file.createNewFile()

        val fileRequest: Request = Request.Builder()
            .url(getFileUrl)
            .get()
            .addHeader("license-key", key)
            .addHeader("hwid", getHwid())
            .build()

        client.newCall(fileRequest).execute().use { response ->
            val source = response.body!!.source()
            val sink: BufferedSink = file.sink().buffer()
            sink.writeAll(source)
            sink.close()
        }

        return file
    }

    private fun getHwid(): String {
        val hwid = System.getProperty("os.name") + System.getProperty("user.name") + Runtime.getRuntime()
            .availableProcessors() + System.getProperty("os.arch") + System.getenv("COMPUTERNAME")
        return Base64.getEncoder().encodeToString(hwid.toByteArray())
    }

}