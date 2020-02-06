package config

private const val DELAY_BY_MINUTES: Long = 2

class Config private constructor() {

    var url: String
    var showPageSourceForXPathQuery: String

    init {
        url = envOrDefault("url", "https://www.seleniumeasy.com/test/")
        showPageSourceForXPathQuery = envOrDefault("XPATH_PAGE_SOURCE", "false")
        val delayByMinutes = envOrDefault("DELAY_BY_MINUTES", DELAY_BY_MINUTES)
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
