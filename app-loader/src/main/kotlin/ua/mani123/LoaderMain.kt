package ua.mani123

import java.io.File
import java.nio.file.Path
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val licenseFile = File("licenseKey")
    licenseFile.createNewFile()
    val license = licenseFile.readText().trim()
    if (license.isEmpty()) {
        exitProcess(0)
    }

    val product = LoaderManager(
        Path.of(File(object {}.javaClass.protectionDomain.codeSource.location.toURI().path).parent),
        license
    ).enableLoaders()
    if (product != null) {
        product.enable("config.yml", "lang.yml", "stats.yml", "ConsoleApp")
        enableConsoleScanner(product)
    } else {
        println("Error")
        exitProcess(0)
    }
}

private fun enableConsoleScanner(product: Product) {
    Runtime.getRuntime().addShutdownHook(Thread {
        product.disable()
    })
    val scanner = Scanner(System.`in`)
    Thread {
        while (true) {
            when (scanner.next()) {
                "/stop" -> {
                    exitProcess(0)
                }

                else -> {
                    println(
                        """
                            <-- Command info -->
                            /stop - Stop bot
                        """.trimIndent()
                    )
                }
            }
        }
    }.start()
}