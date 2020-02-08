package webdrivers

import config.Config
import io.appium.java_client.MobileElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import net.thucydides.core.webdriver.DriverSource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class IOSDriver : DriverSource {

    override fun newDriver() : WebDriver? {
        val driver : IOSDriver<MobileElement> = IOSDriver(URL(Config.instance.appiumServer),capabilities())
        driver.manage().timeouts().implicitlyWait(Config.instance.implicitDriverTimeOutDuration, TimeUnit.SECONDS)
        return driver
    }

    override fun takesScreenshots(): Boolean {
        return false
    }

    companion object {
        fun capabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,Config.instance.iosAppiumPlatformName)
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,Config.instance.iosAppiumAutomationName)

            //below capability can be set for any device name returned by
            //'instruments -s device' which returns a list of all known IOS devices - real and simulators
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,Config.instance.iosAppiumDeviceName)

            //below capability has to be set if you have device profiles for multiple os versions
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,Config.instance.iosAppiumPlatformVersion)
            return caps
        }
    }
}

