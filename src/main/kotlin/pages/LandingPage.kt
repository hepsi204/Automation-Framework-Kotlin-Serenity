package pages

import elements.BasePageElement
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import org.junit.Assert.assertTrue

@At("https://www.seleniumeasy.com/test/")
class LandingPage : BasePageObject() {

    val startPractisingButton = BasePageElement(locatorType = Locators.ID,
                                              desktopLocator = "btn_basic_example",
                                              page = this)

    private val interactiveRoundToggleTabs = BasePageElement(locatorType = Locators.CLASS,
                                               desktopLocator = "round-tabs",
                                               page = this)

    private val toggleTabSection = BasePageElement(locatorType = Locators.ID,
                                                   desktopLocator = "basic",
                                                   page = this)

    fun getLinksWithinBasicTab (id : String ) : WebElementFacade {
        return findByLocator(Locators.LINKTEXT,BasicTabLinks.SIMPLE_FORM.linkTextLocator)
    }

    fun getToggleTabElement (id : String) : WebElementFacade? {
        val toggleTabElementMap = mapToggleTabElements()
        val toggleTabElementId = getToggleTabElementId(id)

        return toggleTabElementMap[toggleTabElementId]
    }

    fun checkToggleTabSectionDisplayed() : Boolean {
        val sectionText = "BASIC EXAMPLES TO START WITH SELENIUM"
        val heading = toggleTabSection.element
        return heading.isVisible
    }

    private fun getToggleTabElementId(id : String) : String {
        return when (id.toLowerCase()){
            "welcome" -> "${interactiveRoundToggleTabs.desktopLocator} one"
            "basic" -> "${interactiveRoundToggleTabs.desktopLocator} two"
            "intermediate" -> "${interactiveRoundToggleTabs.desktopLocator} three"
            "advanced" -> "${interactiveRoundToggleTabs.desktopLocator} four"
            "completed" -> "${interactiveRoundToggleTabs.desktopLocator} five"
            else -> throw Exception("Toggle element id not implemented")
        }
    }

    private fun mapToggleTabElements() : MutableMap<String,WebElementFacade>{
        val toggleTabElementMap = mutableMapOf<String,WebElementFacade>()
        interactiveRoundToggleTabs.elements.forEach{
                element ->
            toggleTabElementMap[element.getAttribute("class")] = element
        }
        return toggleTabElementMap
    }

    override fun isPageLoaded() : Boolean {
        return startPractisingButton.element.isVisible
    }
}

enum class BasicTabLinks( val path : String, val linkTextLocator : String) {
    SIMPLE_FORM("basic-first-form-demo.html","Simple Form Demo"),
    CHECK_BOX("basic-checkbox-demo.html", "Check Box Demo"),
    RADIO_BUTTONS("basic-radiobutton-demo.html", "Radio Buttons Demo"),
    DROPDOWN_LIST("basic-select-dropdown-demo.html", "Select Dropdown List"),
    JAVASCRIPT_ALERTS("javascript-alert-box-demo.html", "Javascript Alerts"),
    POP_UPS("window-popup-modal-demo.html", "Window Pop Up Modal"),
    BOOTSTRAP_ALERTS("bootstrap-alert-messages-demo.html", "Bootstrap Alerts"),
    BOOTSTRAP_MODAL("bootstrap-modal-demo.html", "Bootstrap Modal")
}