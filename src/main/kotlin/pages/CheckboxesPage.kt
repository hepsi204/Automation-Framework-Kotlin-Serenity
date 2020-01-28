package pages

import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.annotations.At
import org.junit.Assert
import org.openqa.selenium.By

@At("http://the-internet.herokuapp.com/checkboxes")
class CheckboxesPage : BasePageObject() {

    private val heading = BasePageElement( locatorType=Locators.XPATH,
                                            desktopLocator = "//*[@id=\"content\"]/div/h3",
                                            page = this )

    private val checkboxOne = BasePageElement(locatorType=Locators.XPATH,
                                      desktopLocator = "//*[@id=\"checkboxes\"]/input[1]",
                                      page = this )
    private val checkboxTwo = BasePageElement(locatorType=Locators.XPATH,
                                      desktopLocator = "//*[@id=\"checkboxes\"]/input[2]",
                                      page = this )

    fun clickOnCheckbox(checkboxId : String){
       when(checkboxId){
            "1" -> checkboxOne.element.click()
            "2" -> checkboxTwo.element.click()
            else -> throw  Exception("No implementation found for checkbox $checkboxId")
        }
    }

    fun isSelected(checkboxId : String) : Boolean {
        return when(checkboxId){
            "1" -> checkboxOne.element.isSelected
            "2" -> checkboxTwo.element.isSelected
            else -> throw  Exception("No implementation found for checkbox $checkboxId")
        }
    }

    override fun isPageLoaded() : Boolean
    {
        Assert.assertTrue("Incorrect header on Checkboxes page",heading.element.text == "Checkboxes")
        return heading.element.isDisplayed
    }
}