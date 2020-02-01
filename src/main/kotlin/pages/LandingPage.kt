package pages

import elements.BasePageElement
import net.serenitybdd.core.annotations.findby.By
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At

@At("https://www.seleniumeasy.com/test/")
class LandingPage : BasePageObject() {

    private val boardElements = BasePageElement(locatorType = Locators.CLASS,
                                              desktopLocator = "board",
                                              page = this)

    private val roundTabs = BasePageElement(locatorType = Locators.CLASS,
                                              desktopLocator = "round-tabs",
                                              page = this)


    fun interactiveBoardButtons(id : String) : WebElementFacade? {
        val elementMap = mutableMapOf<String,WebElementFacade>()
        val elementId = when (id){
                "main" -> "${roundTabs.desktopLocator} one"
                else -> throw Exception("not implemented")
        }

        roundTabs.elements.forEach{
            element ->
            elementMap[element.getAttribute("class")] = element
        }

        return elementMap[elementId]
    }
}