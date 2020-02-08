package features.simpleFormDemoPage

import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import helpers.SessionHelper
import helpers.SessionHelperIds
import org.junit.Assert
import pages.SimpleFormDemoPage
import pages.TwoInputFieldId

class SimpleFormDemoPageStepDefinitions {

    private lateinit var simpleFormDemoPage: SimpleFormDemoPage

    @When("^I type (.*) into the (.*) text box on Simple Form Demo page$")
    fun iTypeIntoTheTextBoxOnSimpleFormDemoPage(  textToType : String , textBoxId : String ){
        when (textBoxId.toLowerCase()){
            "enter message" -> simpleFormDemoPage.typeIntoSingleInputField(textToType)
            "enter a" -> simpleFormDemoPage.typeIntoTwoInputField(textToType, TwoInputFieldId.ONE)
            "enter b" -> simpleFormDemoPage.typeIntoTwoInputField(textToType,TwoInputFieldId.TWO)
        }
    }

    @Then("^I can see the text entered displayed next to 'Your Message' label on Simple Form Demo page$")
    fun iCanSeeTheTextEnteredDisplayedNextToYourMessageLabel(){
        val textToAssert =  SessionHelper().getSessionHelper<String>(SessionHelperIds.SINGLE_INPUT_FIELD_TEXT)
        Assert.assertTrue(
            "Incorrect text displayed for single input field on simple demo form",
            simpleFormDemoPage.displayedText.element.textValue!! == textToAssert
        )
    }

    @Then("^I can see (.*) displayed next to 'Total a \\+ b \\=' label on Simple Form Demo page$")
    fun iCanSeeTheResultDisplayedNextToTotalAPlusBLabelOnSimpleDemoFormPage(result : String){
        val textA =  SessionHelper().getSessionHelper<String>(SessionHelperIds.TWO_INPUT_FIELD_A_TEXT).toIntOrNull()
        val textB =  SessionHelper().getSessionHelper<String>(SessionHelperIds.TWO_INPUT_FIELD_B_TEXT).toIntOrNull()
        val valueDisplayed  = simpleFormDemoPage.displayedValue.element.text!!
        if ( textA != null && textB != null){
            val total = textA + textB
            Assert.assertTrue(
                "Incorrect text displayed for two input field on simple demo form",
                valueDisplayed.toInt() == result.toInt()
            )
        } else {
            Assert.assertTrue(
                "Incorrect text displayed for two input field on simple demo form",
                valueDisplayed == result
            )
        }
    }
}