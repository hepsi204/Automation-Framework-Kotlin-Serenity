package features

import config.PageName
import cucumber.api.java.en.And
import pages.LandingPage
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import pages.CheckboxesPage

class BaseStepDefinitions {

    private lateinit var landingPage: LandingPage
    private lateinit var checkboxesPage: CheckboxesPage

    @Given("^I am a user who has retrieved the-internet website$")
    fun iAmUserWhoHasRetrievedTheInternetWebsite(){
        landingPage.getPage(PageName.LANDING_PAGE)
        assertTrue("Landing page did not load",landingPage.isPageLoaded())
    }

    @When("^I click on the (.*) link on the landing page$")
    fun iClickOnTheLink(elementToActOn : String){
        landingPage.getLinksUsingLinkText(elementToActOn).click()
    }

    @Then("^I see the checkboxes page$")
    fun iSeeTheCheckboxesPage( ){
        assertTrue("Checkboxes page did not load",checkboxesPage.isPageLoaded())
    }

    @And("^I see checkbox 1 not selected on the page$")
    fun iSeeCheckbox1NotSelectedOnThePage( ){
        assertFalse("Checkbox 1 selection state incorrect",checkboxesPage.checkboxOne.element.isSelected)
    }

    @And("^I see checkbox 2 is selected on the page$")
    fun iSeeCheckbox2IsSelectedOnThePage( ){
        assertTrue("Checkbox 2 selection state incorrect",checkboxesPage.checkboxTwo.element.isSelected)
    }
}