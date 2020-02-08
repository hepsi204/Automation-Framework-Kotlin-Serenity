package features

import cucumber.api.java.en.And
import pages.LandingPage
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import helpers.SessionHelper
import helpers.SessionHelperIds
import org.junit.Assert.assertTrue
import pages.CheckboxesPage
import pages.SimpleFormDemoPage

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage
    private lateinit var simpleFormDemoPage: SimpleFormDemoPage
    private lateinit var checkboxesDemoPage: CheckboxesPage

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
    fun iClickOnTheButton( buttonText : String , pageName : String ){
        when (pageName.toLowerCase()){
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
    fun iSeeThePageLoaded ( pageId : String ){
      val pageLoaded =   when (pageId.toLowerCase()) {
          "landing page", "main" -> landingPage.isPageLoaded()
          "simple form demo" -> simpleFormDemoPage.isPageLoaded()
          "check box demo" -> checkboxesDemoPage.isPageLoaded()
          else -> throw Exception("Page loaded check not implemented for $pageId page")
        }
      assertTrue( "$pageId page is not loaded", pageLoaded )
    }

    @And("^I have opened the (.*) tab section on the Landing page$")
    fun iHaveOpenedTheTabSectionOnTheLandingPage ( sectionId : String ){
        when (sectionId.toLowerCase()) {
            "basic" -> landingPage.clickOnButton("Start practising")
        }
    }

    @And("I can see the (.*) toggle tab on the interactive board")
    fun iCanSeeTheToggleTabOnTheInteractiveBoard(toggleTabId : String){
        landingPage.getToggleTabElement(toggleTabId)!!.isVisible
    }
}