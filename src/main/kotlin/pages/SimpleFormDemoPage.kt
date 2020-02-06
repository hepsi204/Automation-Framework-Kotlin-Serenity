package pages

import elements.BasePageElement
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import org.junit.Assert.assertTrue

@At("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
class SimpleFormDemoPage : BasePageObject() {
    private val singleInputField = BasePageElement(
        locatorType = Locators.ID,
        desktopLocator = "user-message",
        page = this
    )

    private val showMessageButton = BasePageElement(
        locatorType = Locators.XPATH,
        desktopLocator = "//.*button[@class='btn btn-default'][.='Show Message’]",
        page = this
    )

    private val getTotalButton = BasePageElement(
        locatorType = Locators.LINKTEXT,
        desktopLocator = "Get Total",
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

    fun clickOnButton ( buttonText : String) {
       return  when (buttonText.toLowerCase()) {
            "show message" -> showMessageButton.element.click()
            "get total" -> getTotalButton.element.click()
            else -> throw Exception("Button with text $buttonText not implemented for this page")
        }
    }

    fun typeIntoSingleInputField( message : String ) : WebElementFacade {
        return singleInputField.element.typeAndTab(message)
    }

    fun typeIntoTwoInputField( message : String,  fieldId : String ) : WebElementFacade {
        return when (fieldId) {
            "1" ->  twoInputFieldOne.element.type(message)
            "2" -> twoInputFieldTwo.element.type(message)
            else -> throw Exception("Only two input fields available")
        }
    }

    override fun isPageLoaded() : Boolean {
        return singleInputField.element.isVisible
    }

}