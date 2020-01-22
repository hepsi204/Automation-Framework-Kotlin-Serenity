package config


// notes: try accessing SESSION_EXPIRY_MINUTES from a different class
private const val SESSION_EXPIRY_MINUTES: Long = 2

// notes: class SomeClassName private constructor() - purpose of constructor
class Config private constructor() {

// notes: use of var and val, inside and outside init  block
    var url: String
    var showPageSourceForXPathQuery: String

    init {
        url = envOrDefault("url", "http://the-internet.herokuapp.com")
        showPageSourceForXPathQuery = envOrDefault("XPATH_PAGE_SOURCE", "false")
        val sessionExpiryMinutes = envOrDefault("SESSION_EXPIRY_MINUTES", SESSION_EXPIRY_MINUTES)
    }

// notes: Method overloads below
    private fun envOrDefault(key: String, defaultValue: String): String {
        return (System.getenv(key) ?: defaultValue)
                .also { println("$key set as $it") }
    }

    private fun envOrDefault(key: String, defaultValue: Long): Long {

        return (System.getenv(key)?.toLong() ?: defaultValue)
                .also { println("$key set as $it") }
    }

// notes: companion object,  by lazy - purpose
    companion object {
        val instance: Config by lazy { createConfig() }

        private fun createConfig(): Config {
            return Config()
        }
    }
}
