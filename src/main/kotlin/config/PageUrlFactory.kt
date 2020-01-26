package config

class PageUrlFactory {

    enum class PageName (val path: String) {
        LANDING_PAGE("/"),
        ADD_REMOVE_ELEMENTS("/add_remove_elements/"),
        BASIC_AUTH("/basic_auth/"),
        CHECKBOXES("/checkboxes")
    }

    private val map: HashMap<String, String> =
        hashMapOf(
            "main" to PageName.LANDING_PAGE.path,
            "add remove elements" to PageName.ADD_REMOVE_ELEMENTS.path,
            "basic auth" to PageName.BASIC_AUTH.path,
            "checkboxes" to PageName.CHECKBOXES.path
        )

    fun getPageUrl(pageName: String): String {
        val path = map[pageName.toLowerCase()]
        return "${Config.instance.url}$path"
    }
}