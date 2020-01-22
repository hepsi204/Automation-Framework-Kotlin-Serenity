package pages

import config.PageName
import config.PageUrlFactory
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException

abstract class BasePageObject : PageObject() {

    private val pageUrlFactory by lazy { PageUrlFactory() }

    abstract val urlForThisPage : String

    fun getPage(pageName : PageName) {
        return driver.get(pageUrlFactory.getPageUrl(pageName))
    }

    fun findByLocator(locatorType : Locators, locator: String): WebElementFacade {
        val elementRequested: WebElementFacade
        try {
            elementRequested = when(locatorType) {
                Locators.XPATH -> find(By.xpath(locator))
                Locators.ID -> find(By.id(locator))
                Locators.CSS -> find(By.cssSelector(locator))
                else -> throw Exception("Invalid locator passed - $locator")
            }
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("No element found on page:\n${driver.pageSource}", e)
        }
        return elementRequested
    }
}

enum class Locators {
    ID,
    XPATH,
    CSS,
    LINKTEXT,
    VISIBLE_TEXT,
    LABEL
}