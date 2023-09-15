package ua.mani123.dataFromFile

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import ua.mani123.dataFromFile.data.CustomEmbedData
import java.awt.Color

class LangHashMap<T>(private val hashMap: HashMap<LangCode, T>) : HashMap<LangCode, T>() {
    override operator fun get(key: LangCode): T {
        return if (hashMap.containsKey(key)) {
            hashMap[key] ?: throw NullPointerException("Why containsKey allow it!?")
        } else {
            hashMap[LangCode.EN]!!
        }
    }

    fun generateEmbed(key: LangCode, placeholderTitle: String, placeholderDescription: String): MessageEmbed {
        val customEmbed = get(key) as CustomEmbedData
        return EmbedBuilder().setDescription(String.format(customEmbed.description, placeholderDescription))
            .setTitle(String.format(customEmbed.title, placeholderTitle)).setColor(Color.decode(customEmbed.color))
            .build()
    }

    fun generateEmbed(key: LangCode): MessageEmbed {
        val customEmbed = get(key) as CustomEmbedData
        return EmbedBuilder().setDescription(customEmbed.description).setTitle(customEmbed.title)
            .setColor(Color.decode(customEmbed.color)).build()
    }
}