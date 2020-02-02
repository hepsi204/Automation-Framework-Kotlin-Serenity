package config

import cucumber.api.java.jv.Lan

class PageUrlFactory {

    enum class PageName (val path: String) {
        LANDING_PAGE("/")
    }

    enum class LandingPageBasicTabLinks( val path : String) {
        SIMPLE_FORM("basic-first-form-demo.html"),
        CHECK_BOX("basic-checkbox-demo.html"),
        RADIO_BUTTONS("basic-radiobutton-demo.html"),
        DROPDOWN_LIST("basic-select-dropdown-demo.html"),
        JAVASCRIPT_ALERTS("javascript-alert-box-demo.html"),
        POP_UPS("window-popup-modal-demo.html"),
        BOOTSTRAP_ALERTS("bootstrap-alert-messages-demo.html"),
        BOOTSTRAP_MODAL("bootstrap-modal-demo.html")
    }

    private val pathMap: HashMap<String, String> =
        hashMapOf(
            "main" to PageName.LANDING_PAGE.path,
            "simple form demo" to LandingPageBasicTabLinks.SIMPLE_FORM.path,
            "check box demo" to LandingPageBasicTabLinks.CHECK_BOX.path,
            "radio buttons demo" to LandingPageBasicTabLinks.RADIO_BUTTONS.path,
            "select dropdown list" to LandingPageBasicTabLinks.DROPDOWN_LIST.path,
            "javascript alerts" to LandingPageBasicTabLinks.JAVASCRIPT_ALERTS.path,
            "window pop up modal" to LandingPageBasicTabLinks.POP_UPS.path,
            "bootstrap alerts" to LandingPageBasicTabLinks.BOOTSTRAP_ALERTS.path,
            "bootstrap modal" to LandingPageBasicTabLinks.BOOTSTRAP_MODAL.path
        )

    fun getPageUrl(pageName: String): String {
        val path = pathMap[pageName.toLowerCase()]
        return "${Config.instance.url}$path"
    }
}