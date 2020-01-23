package pages

import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import net.thucydides.core.annotations.WhenPageOpens

@At("http://the-internet.herokuapp.com")
class LandingPage : BasePageObject() {

    private val heading = BasePageElement(locatorType=Locators.CLASS,
                                          desktopLocator = "heading",
                                          page = this )

    @WhenPageOpens
    override fun isPageLoaded() : Boolean
    {
        val heading = findByLocator(heading.locatorType,heading.desktopLocator)
        return heading.isDisplayed
    }

    fun getLinksUsingLinkText(linktextLocator : String) : WebElementFacade
    {
        return findByLocator(Locators.LINKTEXT, linktextLocator)
    }
}