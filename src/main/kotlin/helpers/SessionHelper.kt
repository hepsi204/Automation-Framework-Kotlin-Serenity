package helpers

import net.serenitybdd.core.Serenity

class SessionHelper {
    fun setSessionHelper(value : Any, helperId : SessionHelperIds) {
        Serenity.setSessionVariable(helperId).to(value)
    }

    fun getSessionHelper( helperId : SessionHelperIds) {
        Serenity.sessionVariableCalled<Any>(helperId)
    }
}

enum class SessionHelperIds