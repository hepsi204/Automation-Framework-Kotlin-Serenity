package features

import io.cucumber.java.Before
import net.serenitybdd.core.Serenity

class SetUpAndTearDown {
   @Before
   fun beforeEachScenario() {
     Serenity.getCurrentSession().clear()
   }
}