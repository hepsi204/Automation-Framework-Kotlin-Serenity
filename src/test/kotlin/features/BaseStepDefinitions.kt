package features.landingPage

import config.PageName
import pages.LandingPage
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import org.junit.Assert.assertTrue

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage

    @Given("^I am a user who has retrieved the-internet website$")
    fun iAmUserWhoHasRetrievedTheInternetWebsite(){
        landingPage.getPage(PageName.LANDING_PAGE)
        assertTrue("Landing page did not load",landingPage.isPageLoaded())
    }

    @When("^I click on the (.*) link$")
    fun iClickOnTheLink(elementToActOn : String){
        landingPage.getLinksUsingLinkText(elementToActOn).click()
    }
}