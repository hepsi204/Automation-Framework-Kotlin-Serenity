package pages

import config.PageName
import config.PageUrlFactory
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException

abstract class BasePageObject : PageObject() {

    private val pageUrlFactory by lazy { PageUrlFactory() }

    fun getPage(pageName : PageName) {
        return driver.get(pageUrlFactory.getPageUrl(pageName))
    }

    abstract fun isPageLoaded() : Boolean

    fun findByLocator(locatorType : Locators, locator: String): WebElementFacade {
        val elementRequested: WebElementFacade
        try {
            elementRequested = when(locatorType) {
                Locators.XPATH -> find(By.xpath(locator))
                Locators.ID -> find(By.id(locator))
                Locators.CSS -> find(By.cssSelector(locator))
                Locators.CLASS -> find(By.className(locator))
                Locators.LINKTEXT -> find(By.linkText(locator))
                Locators.NAME -> find(By.name(locator))
                Locators.TAGNAME -> find(By.tagName(locator))
//                else -> throw Exception("No implementation found for the locator type passed - $locatorType")
            }
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("No element found on page with locator $locator :\n${driver.pageSource}", e)
        }
        return elementRequested
    }
}

enum class Locators {
    ID,
    XPATH,
    CSS,
    CLASS,
    LINKTEXT,
    TAGNAME,
    NAME
}