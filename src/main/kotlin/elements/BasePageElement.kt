package elements

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