package helpers

import net.serenitybdd.core.Serenity

class SessionHelper {
    fun setSessionHelper(helperId : SessionHelperIds, value : Any) {
        Serenity.setSessionVariable(helperId).to(value)
    }

    fun <T>getSessionHelper( helperId : SessionHelperIds) : T {
       return Serenity.sessionVariableCalled(helperId)
    }
}

enum class SessionHelperIds {
    SINGLE_INPUT_FIELD_TEXT,
    TWO_INPUT_FIELD_A_TEXT,
    TWO_INPUT_FIELD_B_TEXT
}