package features

import pages.LandingPage
import helpers.SessionHelper
import helpers.SessionHelperIds
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.assertTrue
import pages.CheckboxesPage
import pages.RadioButtonsPage
import pages.SimpleFormDemoPage
import java.util.*

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage
    private lateinit var simpleFormDemoPage: SimpleFormDemoPage
    private lateinit var checkboxesDemoPage: CheckboxesPage
    private lateinit var radioButtonsPage: RadioButtonsPage

    @Given("^I am a user who has retrieved the selenium test website$")
    fun iAmUserWhoHasRetrievedTheSeleniumTestWebsite(){
        landingPage.getPage("main")
        assertTrue("Landing page is not loaded",landingPage.isPageLoaded())
    }

    @Given("^I am on the (.*) page$")
    fun iAmOnThePage( pageId : String ){
        landingPage.getPage(pageId)
    }

    @When("^I click on the (.*) button on the (.*) page$")
    fun iClickOnTheButton(buttonText: String, pageName: String) {
        when (pageName.lowercase(Locale.getDefault())) {
            "landing", "main" -> landingPage.clickOnButton(buttonText)
            "simple form demo" -> simpleFormDemoPage.clickOnButton(buttonText)
        }
    }

    @When("^I click on (.*) link within basic tab section$")
    fun iClickOnLinkWithinBasicTabSection( linkTextString : String ){
        landingPage.getLinkWithinBasicTab(linkTextString).click()
    }

    @Then("^I can see the (.*) toggle tab section displayed on the Landing page$")
    fun iCanSeeTheToggleTabSectionDisplayedOnTheLandingPage( sectionId: String ){
        assertTrue( "Basic toggle tab section is not displayed",
            landingPage.checkToggleTabSectionDisplayed(sectionId))
    }

    @Then("^I see the (.*) page loaded$")
    fun iSeeThePageLoaded ( pageId : String ) {
        val pageLoaded = when (pageId.lowercase(Locale.getDefault())) {
            "landing page", "main" -> landingPage.isPageLoaded()
            "simple form demo" -> simpleFormDemoPage.isPageLoaded()
            "check box demo" -> checkboxesDemoPage.isPageLoaded()
            "radio buttons demo" -> radioButtonsPage.isPageLoaded()
            else -> throw Exception("Page loaded check not implemented for $pageId page")
        }
        assertTrue("$pageId page is not loaded", pageLoaded)
    }

    @And("^I have opened the (.*) tab section on the Landing page$")
    fun iHaveOpenedTheTabSectionOnTheLandingPage(sectionId: String) {
        when (sectionId.lowercase(Locale.getDefault())) {
            "basic" -> landingPage.clickOnButton("Start practising")
        }
    }

    @And("I can see the (.*) toggle tab on the interactive board")
    fun iCanSeeTheToggleTabOnTheInteractiveBoard(toggleTabId : String){
        landingPage.getToggleTabElement(toggleTabId)!!.isVisible
    }
}