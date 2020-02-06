package helpers

import net.serenitybdd.core.Serenity

class SessionHelper {
    fun setSessionHelper(helperId : SessionHelperIds, value : Any) {
        Serenity.setSessionVariable(helperId).to(value)
    }

    fun <T>getSessionHelper( helperId : SessionHelperIds) : T {
       return Serenity.sessionVariableCalled<T>(helperId)
    }
}

enum class SessionHelperIds {
    SINGLE_INPUT_FIELD_TEXT,
    DOUBLE_INPUT_FIELD_ONE_TEXT,
    DOUBLE_INPUT_FIELD_TWO_TEXT
}