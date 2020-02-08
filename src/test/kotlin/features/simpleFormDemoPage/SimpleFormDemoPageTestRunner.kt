package features.simpleFormDemoPage

import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import net.thucydides.core.annotations.Managed
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(features = ["src/test/kotlin/features/simpleFormDemoPage"], glue = ["features"])
class SimpleFormDemoPageTestRunner {
    @Managed
    lateinit var driver: WebDriver
}