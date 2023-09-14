package ua.mani123

import java.util.*
import kotlin.system.exitProcess

fun main() {
    val product = LibManager().loadLibs()
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