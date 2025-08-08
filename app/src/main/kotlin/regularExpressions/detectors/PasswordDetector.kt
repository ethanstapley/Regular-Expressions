package regularExpressions.detectors

import regularExpressions.Detector
import regularExpressions.State

class PasswordDetector: Detector {
    private var state: State = PasswordNone

    override fun accepts(input: String): Boolean {
        if (input.isEmpty()) return false
        PasswordHasAll.acceptable = false
        state = PasswordNone
        var index = 0
        for (char in input) {
            index++
            state = state.on(char.toString()) ?: return false
        }
        return if (index >= 8) state.canAccept() else false
    }


    private object PasswordNone: State {
        private val specialChars = listOf("!", "@", "#", "$", "%", "&", "*")
        override fun on(char: String): State? {
            return when (char) {
                in specialChars -> PasswordOnlySpecial
                in "A".."Z" -> PasswordOnlyCapital
                else -> PasswordNone
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object PasswordOnlyCapital: State {
        private val specialChars = listOf("!", "@", "#", "$", "%", "&", "*")
        override fun on(char: String): State? {
            return when (char) {
                in specialChars -> PasswordHasAll
                else -> PasswordOnlyCapital
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object PasswordOnlySpecial: State {
        override fun on(char: String): State? {
            return when (char) {
                in "A".."Z" -> PasswordHasAll
                else -> PasswordOnlySpecial
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object PasswordHasAll: State {
        private val specialChars = listOf("!", "@", "#", "$", "%", "&", "*")
        var acceptable = false
        override fun on(char: String): State? {
            acceptable = char !in specialChars
            return PasswordHasAll
        }
        override fun canAccept(): Boolean = acceptable
    }
}