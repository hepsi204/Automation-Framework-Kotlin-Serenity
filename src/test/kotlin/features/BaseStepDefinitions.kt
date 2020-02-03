package features

import cucumber.api.java.en.And
import pages.LandingPage
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert.assertTrue
import pages.SimpleFormDemoPage

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage
    private lateinit var simpleFormDemoPage: SimpleFormDemoPage

    @Given("^I am a user who has retrieved the selenium test website$")
    fun iAmUserWhoHasRetrievedTheSeleniumTestWebsite(){
        landingPage.getPage("main")
        assertTrue("Landing page is not loaded",landingPage.isPageLoaded())
    }

    @Given("^I have retrieved (.*) page$")
    fun iAmOnPage( pageId : String ){
        landingPage.getPage(pageId)
    }

    @When("^I click on the (.*) button on the (.*) page$")
    fun iClickOnTheButton( buttonText : String , pageName : String ){
        when (pageName.toLowerCase()){
            "landing", "main" -> landingPage.clickOnButton(buttonText)
            "simple form demo" -> simpleFormDemoPage.clickOnButton(buttonText)
        }
    }

    @When("^I type into the (.*) text box$")
    fun iTypeIntoTheTextBox( textBoxId : String ){
        when (textBoxId.toLowerCase()){
            "enter message" -> simpleFormDemoPage.typeIntoSingleInputField("test")
            "enter a" -> simpleFormDemoPage.typeIntoTwoInputField("4","1")
            "enter b" -> simpleFormDemoPage.typeIntoTwoInputField("6","2")
        }
    }

    @When("^I click on (.*) link within basic tab section$")
    fun iClickOnLinkWithinBasicTabSection( linkTextString : String ){
        landingPage.getLinkWithinBasicTab(linkTextString).click()
    }

    @And("^I have opened the (.*) tab section$")
    fun iHaveOpenedTheTabSection ( sectionId : String ){
        when (sectionId.toLowerCase()) {
            "basic" -> landingPage.clickOnButton("Start practising")
        }
    }

    @Then("^I can see the (.*) toggle tab section displayed$")
    fun iCanSeeTheToggleTabSectionDisplayed( sectionId: String ){
        assertTrue( "Basic toggle tab section is not displayed", landingPage.checkToggleTabSectionDisplayed(sectionId))
    }

    @Then("^I see the (.*) page loaded$")
    fun iSeeThePageLoaded ( pageId : String ){
      val pageLoaded =   when (pageId.toLowerCase()) {
          "landing page", "main" -> landingPage.isPageLoaded()
          "simple form demo" -> simpleFormDemoPage.isPageLoaded()
          else -> throw Exception("Page loaded check not implemented for $pageId page")
        }
      assertTrue( "$pageId page is not loaded", pageLoaded )
    }

    @And("I can see the (.*) toggle tab on the interactive board")
    fun iCanSeeTheToggleTabOnTheInteractiveBoard(toggleTabId : String){
        landingPage.getToggleTabElement(toggleTabId)!!.isVisible
    }
}