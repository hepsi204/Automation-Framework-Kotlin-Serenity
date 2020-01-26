package features

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
        landingPage.getPage("main")
        assertTrue("Landing page did not load",landingPage.isPageLoaded())
    }

    @Given("I am on the (.*) page")
    fun iAmOnPage(pageName : String){
        landingPage.getPage(pageName)
    }

    @When("^I click on the (.*) link on the landing page$")
    fun iClickOnTheLink(elementToActOn : String){
        landingPage.getLinksUsingLinkText(elementToActOn).click()
    }

    @When("^I click on checkbox (.*)$")
    fun iClickOnCheckbox (checkboxId: String) {
       checkboxesPage.clickOnCheckbox(checkboxId)
    }

    @Then("^I see the checkboxes page$")
    fun iSeeTheCheckboxesPage( ){
        assertTrue("Checkboxes page did not load",checkboxesPage.isPageLoaded())
    }

    @And("^checkbox (.*) is shown as not selected$")
    fun checkboxIsShownAsNotSelected( checkboxId: String ){
        assertFalse("Checkbox $checkboxId is in selected state", checkboxesPage.isSelected(checkboxId))
    }

    @And("^^checkbox (.*) is shown as selected$")
    fun checkboxIsShownAsSelected( checkboxId: String ){
        assertTrue("Checkbox $checkboxId is not in selected state",checkboxesPage.isSelected(checkboxId))
    }
}