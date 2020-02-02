package features

import cucumber.api.java.en.And
import pages.LandingPage
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert.assertTrue

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage

    @Given("^I am a user who has retrieved the selenium test website$")
    fun iAmUserWhoHasRetrievedTheSeleniumTestWebsite(){
        landingPage.getPage("main")
//        assertTrue("Landing page did not load",landingPage.isPageLoaded())
    }

    @When("^I click on the Start Practising button$")
    fun iClickOnTheStartPractisingButton(){
        landingPage.startPractisingButton.element.click()
    }

    @Then("^I can see the Basic toggle tab section displayed$")
    fun iCanSeeTheToggleTabSectionDisplayed(){
        assertTrue( landingPage.checkToggleTabSectionDisplayed())
    }

    @And("I can see the (.*) toggle tab on the interactive board")
    fun iCanSeeTheToggleTabOnTheInteractiveBoard(toggleTabId : String){
        landingPage.getToggleTabElement(toggleTabId)!!.isVisible
    }
}