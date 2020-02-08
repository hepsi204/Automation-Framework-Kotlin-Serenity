package features.checkboxesDemoPage

import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import helpers.SessionHelper
import helpers.SessionHelperIds
import org.junit.Assert
import pages.CheckboxesPage
import pages.SimpleFormDemoPage
import pages.TwoInputFieldId

class CheckboxesDemoPageStepDefinitions {

    private lateinit var checkboxesDemoPage: CheckboxesPage

    @When("^I select the Checkbox in Single Checkbox Demo section$")
    fun iSelectTheCheckboxInSingleCheckboxDemoPage(){
       checkboxesDemoPage.singleCheckboxElement.element.click()
    }

    @When("^I click on the (.*) button in Multiple Checkbox Demo section$")
    fun iClickTheButtonInMultipleCheckboxDemoPage(visibleTextOnElement : String){
      checkboxesDemoPage.clickMultipleCheckboxesButton(visibleTextOnElement)
    }

    @Then("^I see the success message displayed in Single Checkbox Demo section$")
    fun iSeeTheSuccessMessageDisplayedInSingleCheckboxDemoSection(){
        Assert.assertTrue(
            "Success message not displayed when checkbox is selected in single checkbox demo section",
            checkboxesDemoPage.singleCheckboxSuccessMessage.element.isVisible
        )
    }
}