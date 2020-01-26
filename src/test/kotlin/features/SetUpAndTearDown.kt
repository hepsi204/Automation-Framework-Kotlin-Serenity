package features

import cucumber.api.java.Before
import net.serenitybdd.core.Serenity

class SetUpAndTearDown {
   @Before
   fun beforeEachScenario() {
     Serenity.getCurrentSession().clear()
   }
}