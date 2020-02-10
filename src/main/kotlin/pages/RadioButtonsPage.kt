package pages

import elements.BasePageElement
import elements.mapElementsToLocators
import net.serenitybdd.core.pages.WebElementFacade

class RadioButtonsPage : BasePageObject() {

    val expectedNumberOfOptionsCheckboxes = 4

     private val radioButtonsListInRadioButtonDemoSection = BasePageElement(
        locatorType = Locators.NAME,
        desktopLocator = "gender",
        page = this
    )

    private val panelHeadingsLocator = BasePageElement(
        locatorType = Locators.CLASS,
        desktopLocator = "panel-heading",
        page = this
    )



    private fun getRadioButtonsListWithSelectionState() : ArrayList<Pair<String,Boolean>> {
        val elementMap = arrayListOf<Pair<String,Boolean>>()
        radioButtonsListInRadioButtonDemoSection.elements.iterator().forEach {
            elementMap.add(Pair(it.textContent.trim(), it.isSelected))
        }
        return elementMap
    }

    fun numberOfOptionsCheckboxesSelected() : Int {
        val checkboxElements = getRadioButtonsListWithSelectionState()
        var numberOfCheckboxesRetrieved = 0
        checkboxElements.iterator().forEach {
            if (it.second)
                numberOfCheckboxesRetrieved++
        }
        return numberOfCheckboxesRetrieved
    }


    private fun mapPanelHeadingsToElements(visibleText : String) : WebElementFacade {
        val panelElementsMap = panelHeadingsLocator.mapElementsToLocators("textContent")
        return panelElementsMap[visibleText]!!
    }

    override fun isPageLoaded(): Boolean {
        return mapPanelHeadingsToElements("Radio Button Demo").isVisible
                && mapPanelHeadingsToElements("Group Radio Buttons Demo").isVisible
    }
}
