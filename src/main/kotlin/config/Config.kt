package config

private const val DURATION_IN_SECONDS: Long = 5

class Config private constructor() {

    var url: String
    var showPageSourceForXPathQuery: String
    var appiumServer : String
    var androidAppiumAutomationName : String
    var androidAppiumPlatformName : String
    var androidAppiumDeviceName : String
    var androidAppiumPlatformVersion : String
    var implicitDriverTimeOutDuration : Long
    var iosAppiumAutomationName : String
    var iosAppiumPlatformName : String
    var iosAppiumDeviceName : String
    var iosAppiumPlatformVersion : String

    init {
        url = envOrDefault("url", "https://www.seleniumeasy.com/test/")
        showPageSourceForXPathQuery = envOrDefault("XPATH_PAGE_SOURCE", "false")
        implicitDriverTimeOutDuration = envOrDefault("IMPLICIT_DRIVER_TIMEOUT_DURATION", DURATION_IN_SECONDS)

        appiumServer = envOrDefault("APPIUM_SERVER_URL", "")

        // Appium Android specific driver settings
        androidAppiumAutomationName = envOrDefault("ANDROID_APPIUM_AUTOMATION_NAME", "Appium")
        androidAppiumPlatformName = envOrDefault("ANDROID_APPIUM_PLATFORM_NAME", "ANDROID")
        androidAppiumDeviceName = envOrDefault("ANDROID_APPIUM_DEVICE_NAME", "")
        androidAppiumPlatformVersion = envOrDefault("ANDROID_APPIUM_PLATFORM_VERSION", "")

        // Appium IOS specific driver settings
        iosAppiumAutomationName = envOrDefault("IOS_APPIUM_AUTOMATION_NAME", "XCUITest")
        iosAppiumPlatformName = envOrDefault("IOS_APPIUM_PLATFORM_NAME", "iOS")
        iosAppiumDeviceName = envOrDefault("IOS_APPIUM_DEVICE_NAME", "")
        iosAppiumPlatformVersion = envOrDefault("IOS_APPIUM_PLATFORM_VERSION", "")
    }

    private fun envOrDefault(key: String, defaultValue: String): String {
        return (System.getenv(key) ?: defaultValue)
                .also { println("$key set as $it") }
    }

    private fun envOrDefault(key: String, defaultValue: Long): Long {

        return (System.getenv(key)?.toLong() ?: defaultValue)
                .also { println("$key set as $it") }
    }

    companion object {
        val instance: Config by lazy { createConfig() }
        private fun createConfig(): Config {
            return Config()
        }
    }
}
