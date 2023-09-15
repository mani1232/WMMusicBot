package ua.mani123

interface Product {

    fun enable(configPath: String, languagePath: String, statsPath: String, platform: String)
    fun disable()

}