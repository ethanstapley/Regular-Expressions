package regularExpressions.detectors

import regularExpressions.Detector
import regularExpressions.State

class IntegerDetector: Detector {
    private var state: State = IntegerStart

    override fun accepts(input: String): Boolean {
        if (input.isEmpty()) return false
        state = IntegerStart
        for (char in input) {
            state = state.on(char.toString()) ?: return false
        }
        return state.canAccept()
    }

    private object IntegerStart: State {
        override fun on(char: String): State? = if (char in "1".."9") IntegerDigits else null

        override fun canAccept(): Boolean = false
    }

    private object IntegerDigits: State {
        override fun on(char: String): State? = if (char in "0".."9") IntegerDigits else null

        override fun canAccept(): Boolean = true
    }
}