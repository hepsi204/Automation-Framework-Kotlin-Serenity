package webdrivers

import config.Config
import io.github.bonigarcia.wdm.WebDriverManager
import net.thucydides.core.webdriver.DriverSource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.concurrent.TimeUnit

open class ChromeDriver : DriverSource {

    override fun newDriver() : WebDriver? {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver(ChromeOptions())
    }

    override fun takesScreenshots(): Boolean {
        return false
    }
}

