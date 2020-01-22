package config

class PageUrlFactory {

    private val map: HashMap<PageName, String> =
        hashMapOf(
            PageName.ADD_REMOVE_ELEMENTS to "/add_remove_elements",
            PageName.BASIC_AUTH to "/basic_auth"
            )


    fun getPageUrl(pageName: PageName): String {
        val path = map[pageName]

        return "${Config.instance.url}$path"
    }
}

enum class PageName {
    ADD_REMOVE_ELEMENTS,
    BASIC_AUTH
}

