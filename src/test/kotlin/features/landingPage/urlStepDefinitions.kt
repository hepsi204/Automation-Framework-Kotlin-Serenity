package features.landingPage

import config.Config
import config.PageName
import config.PageUrlFactory
import pages.LandingPage
import cucumber.api.java.en.Given

class UrlStepDefinitions {

    private lateinit var landingPage: LandingPage

    @Given("^I am a user$")
    fun iAmaUser(){
        landingPage.getPage(PageName.ADD_REMOVE_ELEMENTS)
    }
}