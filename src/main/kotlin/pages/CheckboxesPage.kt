package pages

import elements.BasePageElement
import elements.mapElementsToLocators
import elements.mapElementsToValue
import elements.mapElementsValueToSelectionState
import net.serenitybdd.core.pages.WebElementFacade

class CheckboxesPage : BasePageObject() {

    private val panelHeadingsLocator = BasePageElement(
        locatorType = Locators.CLASS,
        desktopLocator = "panel-heading",
        page = this
    )

    val singleCheckboxElement = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "isAgeSelected",
        page = this
    )

    private val multipleCheckboxesButton = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "check1",
        page = this
    )

    val singleCheckboxSuccessMessage = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "txtAge",
        page = this
    )

    private val optionCheckboxes = BasePageElement(
        locatorType = Locators.CLASS,
        desktopLocator = "cb1-element",
        page = this
    )

    fun checkIfOptionsCheckboxesAreSelected(){
        val elementsMap = optionCheckboxes.mapElementsValueToSelectionState()
    }

    fun clickMultipleCheckboxesButton(expectedText : String) {
        val button = multipleCheckboxesButton.element
        val buttonText = multipleCheckboxesButton.element.value
        if (buttonText == expectedText)
            button.click()
        else
            throw Exception("Button text should be $expectedText to click it but is $buttonText")
    }

    private fun mapPanelHeadingsToElements(visibleText : String) : WebElementFacade {
        val panelElementsMap = panelHeadingsLocator.mapElementsToLocators("textContent")
        return panelElementsMap[visibleText]!!
    }

    override fun isPageLoaded(): Boolean {
        return mapPanelHeadingsToElements("Single Checkbox Demo").isVisible
                && mapPanelHeadingsToElements("Multiple Checkbox Demo").isVisible
    }
}