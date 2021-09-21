package pages

import elements.BasePageElement
import elements.mapElementsToLocators
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import java.util.*

@At("https://www.seleniumeasy.com/test/")
class LandingPage : BasePageObject() {

    private val startPractisingButton = BasePageElement(locatorType = Locators.ID,
                                              desktopLocator = "btn_basic_example",
                                              page = this)

    private val interactiveRoundToggleTabs = BasePageElement(locatorType = Locators.CLASS,
                                               desktopLocator = "round-tabs",
                                               page = this)

    private val basicSection = BasePageElement(locatorType = Locators.ID,
                                                   desktopLocator = "basic",
                                                   page = this)

    fun getLinkWithinBasicTab (linkTextString : String ) : WebElementFacade {
        return findByLocator(Locators.LINKTEXT,linkTextString)
    }

    fun clickOnButton ( buttonText : String ) {
        return when (buttonText.lowercase(Locale.getDefault())) {
            "start practising" -> startPractisingButton.element.click()
            else -> throw Exception("Button with text $buttonText not implemented for this page")
        }
    }

    fun getToggleTabElement (id : String) : WebElementFacade? {
        val toggleTabElementMap =
            interactiveRoundToggleTabs.mapElementsToLocators("class")
        val toggleTabElementId = getToggleTabElementClassName(id)

        return toggleTabElementMap[toggleTabElementId]
    }

    fun checkToggleTabSectionDisplayed( sectionName : String ) : Boolean {
        return when (sectionName.lowercase(Locale.getDefault())) {
            "basic" -> basicSection.element.isVisible
            else -> throw Exception("$sectionName section display check is not implemented")
        }
    }

    private fun getToggleTabElementClassName( id : String) : String {
        return when (id.lowercase(Locale.getDefault())) {
            "welcome" -> "${interactiveRoundToggleTabs.desktopLocator} one"
            "basic" -> "${interactiveRoundToggleTabs.desktopLocator} two"
            "intermediate" -> "${interactiveRoundToggleTabs.desktopLocator} three"
            "advanced" -> "${interactiveRoundToggleTabs.desktopLocator} four"
            "completed" -> "${interactiveRoundToggleTabs.desktopLocator} five"
            else -> throw Exception("Toggle element $id not implemented")
        }
    }

    override fun isPageLoaded() : Boolean {
        return startPractisingButton.element.isVisible
    }
}