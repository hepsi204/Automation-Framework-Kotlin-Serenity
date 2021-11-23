package pages

import elements.BasePageElement
import helpers.SessionHelper
import helpers.SessionHelperIds
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import java.util.*

@At("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
class SimpleFormDemoPage : BasePageObject() {
    private val singleInputField = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "user-message",
        page = this
    )

    private val showMessageButton = BasePageElement(
        locatorType = Locators.XPATH,
        desktopLocator = "//button[@class='btn btn-default' and contains(., 'Show Message')]",
        page = this
    )

    val displayedText = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "display",
        page = this
    )

    val displayedValue = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "displayvalue",
        page = this
    )

    private val getTotalButton = BasePageElement(
        locatorType = Locators.XPATH,
        desktopLocator = "//button[@class='btn btn-default' and contains(., 'Get Total')]",
        page = this
    )

    private val twoInputFieldOne = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "sum1",
        page = this
    )

    private val twoInputFieldTwo = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "sum2",
        page = this
    )

    fun clickOnButton (buttonText : String) {
        return when (buttonText.lowercase(Locale.getDefault())) {
            "show message" -> showMessageButton.element.click()
            "get total" -> getTotalButton.element.click()
            else -> throw Exception("Button with text $buttonText not implemented for this page")
        }
    }

    fun typeIntoSingleInputField(message : String) : WebElementFacade {
        SessionHelper().setSessionHelper(SessionHelperIds.SINGLE_INPUT_FIELD_TEXT , message)
        return singleInputField.element.typeAndTab(message)
    }

    fun typeIntoTwoInputField(message : String, fieldId : TwoInputFieldId) : WebElementFacade {
        return when (fieldId) {
            TwoInputFieldId.ONE ->  {
                SessionHelper().setSessionHelper(SessionHelperIds.TWO_INPUT_FIELD_A_TEXT, message)
                twoInputFieldOne.element.type(message)
            }
            TwoInputFieldId.TWO -> {
                SessionHelper().setSessionHelper(SessionHelperIds.TWO_INPUT_FIELD_B_TEXT, message)
                twoInputFieldTwo.element.type(message)
            }
        }
    }

    override fun isPageLoaded() : Boolean {
        return singleInputField.element.isVisible
                && twoInputFieldOne.element.isVisible && twoInputFieldTwo.element.isVisible
    }

}

enum class TwoInputFieldId {
    ONE,
    TWO
}