package features.radioButtonsDemoPage

import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import net.thucydides.core.annotations.Managed
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(features = ["src/test/kotlin/features/radioButtonsDemoPage"], glue = ["features"])
class RadioButtonDemoPageTestRunner {
    @Managed
    lateinit var driver: WebDriver
}