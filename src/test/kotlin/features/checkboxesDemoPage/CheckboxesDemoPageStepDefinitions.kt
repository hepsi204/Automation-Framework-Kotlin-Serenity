package features.checkboxesDemoPage

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert
import pages.CheckboxesPage

class CheckboxesDemoPageStepDefinitions {

    private lateinit var checkboxesDemoPage: CheckboxesPage

    @Given("^I am on the Check Box Demo page and all the checkboxes in Multiple Checkbox Demo section are selected$")
    fun iOnThCheckboxDemoPageAndAllTheCheckboxesAreSelected(){
        checkboxesDemoPage.getPage("Check Box Demo")
        checkboxesDemoPage.clickMultipleCheckboxesButton("Check All")
        iCanSeeAllCheckboxesSelectedInMultipleCheckboxDemoSection()
    }

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

    @Then("^I can see all checkboxes selected in Multiple Checkbox Demo section$")
    fun iCanSeeAllCheckboxesSelectedInMultipleCheckboxDemoSection(){
        val numberOfCheckboxesRetrieved = checkboxesDemoPage.numberOfOptionsCheckboxesSelected()
        val expectedNumberOfCheckboxes = checkboxesDemoPage.expectedNumberOfOptionsCheckboxes


        Assert.assertTrue(
            "Expected $expectedNumberOfCheckboxes checkboxes to be selected in Multiple Checkbox " +
                    "Demo section, but actual is $numberOfCheckboxesRetrieved",
            expectedNumberOfCheckboxes == numberOfCheckboxesRetrieved
        )
    }

    @Then("^I can see all checkboxes unselected in Multiple Checkbox Demo section$")
    fun iCanSeeAllCheckboxesUnselectedInMultipleCheckboxDemoSection(){
        val numberOfCheckboxesRetrieved = checkboxesDemoPage.numberOfOptionsCheckboxesSelected()
        val expectedNumberOfCheckboxes = 0
        Assert.assertTrue(
            "Expected $expectedNumberOfCheckboxes checkboxes to be selected in Multiple Checkbox " +
                    "Demo section, but actual is $numberOfCheckboxesRetrieved",
            expectedNumberOfCheckboxes == numberOfCheckboxesRetrieved
        )
    }
}