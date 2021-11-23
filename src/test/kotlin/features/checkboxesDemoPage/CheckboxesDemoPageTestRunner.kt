package features.checkboxesDemoPage

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import net.thucydides.core.annotations.Managed
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(features = ["src/test/kotlin/features/checkboxesDemoPage"], glue = ["features"])
class CheckboxesDemoPageTestRunner {
    @Managed
    lateinit var driver: WebDriver
}