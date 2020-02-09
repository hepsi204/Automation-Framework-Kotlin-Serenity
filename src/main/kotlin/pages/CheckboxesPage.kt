package pages

import elements.BasePageElement
import elements.mapElementsToLocators
import net.serenitybdd.core.annotations.findby.By
import net.serenitybdd.core.pages.WebElementFacade

class CheckboxesPage : BasePageObject() {

    val expectedNumberOfOptionsCheckboxes = 4

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

    private val checkboxesList = BasePageElement(
        locatorType = Locators.CLASS,
        desktopLocator = "checkbox",
        page = this
    )

    private fun getCheckboxesListWithSelectionState(sectionId : String) : ArrayList<Pair<String,Boolean>> {
        val elementMap = arrayListOf<Pair<String,Boolean>>()
        checkboxesList.elements.iterator().forEach {
            elementMap.add(Pair(it.textContent.trim(), it.find<WebElementFacade>(By.tagName("input")).isSelected))
        }
        val optionsCheckboxesList = arrayListOf<Pair<String,Boolean>>()
        val singleCheckboxSectionCheckboxesList = arrayListOf<Pair<String,Boolean>>()
        elementMap.iterator().forEach {
            if(it.first.contains("option", ignoreCase = true)){
                optionsCheckboxesList.add(it)
            } else {
                singleCheckboxSectionCheckboxesList.add(it)
            }
        }
        return when (sectionId.toLowerCase()) {
            "single" ->  singleCheckboxSectionCheckboxesList
            "multiple" -> optionsCheckboxesList
            else -> throw Exception()
        }
    }

    fun numberOfOptionsCheckboxesSelected() : Int {
        val checkboxElements = getCheckboxesListWithSelectionState("multiple")
        var numberOfCheckboxesRetrieved = 0
        checkboxElements.iterator().forEach {
            if (it.second)
                numberOfCheckboxesRetrieved++
        }
        return numberOfCheckboxesRetrieved
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
