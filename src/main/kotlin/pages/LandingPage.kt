package pages

import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import org.junit.Assert

@At("http://the-internet.herokuapp.com")
class LandingPage : BasePageObject() {

    private val heading = BasePageElement(locatorType=Locators.CLASS,
                                          desktopLocator = "heading",
                                          page = this )

    override fun isPageLoaded() : Boolean
    {
        Assert.assertTrue("Incorrect header on Checkboxes page",heading.element.text == "Welcome to the-internet")
        return heading.element.isDisplayed
    }

    fun getLinksUsingLinkText(linktextLocator : String) : WebElementFacade
    {
        return findByLocator(Locators.LINKTEXT, linktextLocator)
    }
}