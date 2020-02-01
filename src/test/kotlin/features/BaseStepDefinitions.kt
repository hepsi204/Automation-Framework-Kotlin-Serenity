package features

import cucumber.api.java.en.And
import pages.LandingPage
import cucumber.api.java.en.Given
import cucumber.api.java.en.When

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage


    @Given("^I am a user who has retrieved the selenium test website$")
    fun iAmUserWhoHasRetrievedTheSeleniumTestWebsite(){
        landingPage.getPage("main")
//        assertTrue("Landing page did not load",landingPage.isPageLoaded())
    }

    @And("I can see the (.*) icon on the interactive board")
    fun iAmOnPage(iconName : String){
        landingPage.interactiveBoardButtons("main")!!.isVisible
    }

//    @When("^I click on the (.*) link on the landing page$")
//    fun iClickOnTheLink(elementToActOn : String){
//        landingPage.getLinksUsingLinkText(elementToActOn).click()
//    }
}