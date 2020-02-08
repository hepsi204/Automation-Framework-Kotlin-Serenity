package webdrivers

import config.Config
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import net.thucydides.core.webdriver.DriverSource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class AndroidDriver : DriverSource {

    override fun newDriver() : WebDriver {
        val driver : AndroidDriver<MobileElement> = AndroidDriver(URL(Config.instance.appiumServer),capabilities())
        driver.manage().timeouts().implicitlyWait(Config.instance.implicitDriverTimeOutDuration, TimeUnit.SECONDS)
        return driver
    }

    override fun takesScreenshots(): Boolean {
        return false
    }

    companion object {
        fun capabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,Config.instance.androidAppiumPlatformName)
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,Config.instance.androidAppiumAutomationName)
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,Config.instance.androidAppiumDeviceName)
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,Config.instance.androidAppiumPlatformVersion)

            return caps
        }
    }
}

