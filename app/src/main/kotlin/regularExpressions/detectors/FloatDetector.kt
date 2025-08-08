package regularExpressions.detectors

import regularExpressions.Detector
import regularExpressions.State

class FloatDetector: Detector {
    private var state: State = FloatStart

    override fun accepts(input: String): Boolean {
        if (input.isEmpty()) return false
        state = FloatStart
        for (char in input) {
            state = state.on(char.toString()) ?: return false
        }
        return state.canAccept()
    }

    private object FloatStart: State {
        override fun on(char: String): State? {
            return when (char) {
                in "1".."9" -> FloatIntDigits
                "0" -> FloatZero
                "." -> FloatDot
                else -> null
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object FloatIntDigits: State {
        override fun on(char: String): State? {
            return when (char) {
                in "0".."9" -> FloatIntDigits
                "." -> FloatDot
                else -> null
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object FloatZero: State {
        override fun on(char: String): State? = if (char == ".") FloatDot else null

        override fun canAccept(): Boolean = false
    }

    private object FloatDot: State {
        override fun on(char: String): State? = if (char in "0".."9") FloatDecimal else null

        override fun canAccept(): Boolean = false
    }

    private object FloatDecimal: State {
        override fun on(char: String): State? = if (char in "0".."9") FloatDecimal else null

        override fun canAccept(): Boolean = true
    }

}