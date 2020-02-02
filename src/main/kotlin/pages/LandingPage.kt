package pages

import elements.BasePageElement
import net.serenitybdd.core.annotations.findby.By
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At

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
}