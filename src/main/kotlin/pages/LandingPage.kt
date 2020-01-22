package pages

import config.Config
import net.thucydides.core.annotations.DefaultUrl
import net.thucydides.core.annotations.Managed
import pages.BasePageObject

@DefaultUrl("http://the-internet.herokuapp.com")
class LandingPage : BasePageObject() {
    override val urlForThisPage = Config.instance.url

}

