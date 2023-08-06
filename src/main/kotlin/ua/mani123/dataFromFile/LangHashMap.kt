package ua.mani123.dataFromFile

class LangHashMap(private val hashMap: HashMap<LangCode, String>) : HashMap<LangCode, String>() {
    override operator fun get(key: LangCode): String {
        return try {
            if (hashMap.containsKey(key)) {
                hashMap[key] ?: throw NullPointerException("Why containsKey allow it!?")
            } else {
                hashMap[LangCode.EN] ?: throw NullPointerException("Default locale not found")
            }
        } catch (e: NullPointerException) {
            return e.message.toString()
        }
    }
}