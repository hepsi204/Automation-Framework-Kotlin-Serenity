package elements

import net.serenitybdd.core.annotations.findby.By
import net.serenitybdd.core.pages.WebElementFacade
import pages.BasePageObject
import pages.Locators

open class BasePageElement(
    var locatorType : Locators,
    var desktopLocator :  String,
    val page: BasePageObject
) {
    val element : WebElementFacade
      get (){
        return page.findByLocator(locatorType,desktopLocator)
    }

    val elements : List<WebElementFacade>
        get (){
            return page.findAllByLocator(locatorType,desktopLocator)
        }
}

fun BasePageElement.mapElementsToLocators(getAttributeId : String ) : MutableMap<String, WebElementFacade>{
    val elementMap = mutableMapOf<String,WebElementFacade>()
    this.elements.forEach{
       element -> elementMap[element.getAttribute(getAttributeId)] = element
    }
    return elementMap
}

fun BasePageElement.mapElementsToValue() : MutableMap<String, WebElementFacade>{
    val elementMap = mutableMapOf<String,WebElementFacade>()
    this.elements.forEach{
            element ->
        elementMap[element.value] = element
    }
    return elementMap
}

fun BasePageElement.mapElementsTextContentToSelectionState() : ArrayList<Pair<String,Boolean>>{
    val elementMap = arrayListOf<Pair<String,Boolean>>()
    this.elements.iterator().forEach { elementMap.add(Pair(it.textContent, it.find<WebElementFacade>(By.tagName("input")).isSelected  )) }
    return elementMap
}