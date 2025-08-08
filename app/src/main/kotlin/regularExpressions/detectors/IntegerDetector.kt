package regularExpressions.detectors

import regularExpressions.Detector
import regularExpressions.State

class IntegerDetector: Detector {
    private var state: State = Start

    override fun accepts(input: String): Boolean {
        if (input.isEmpty()) return false
        state = Start
        for (char in input) {
            state = state.on(char.toString()) ?: return false
        }
        return state.canAccept()
    }

    private object Start: State {
        override fun on(char: String): State? = if (char in "1".."9") Digits else null

        override fun canAccept(): Boolean = false
    }

    private object Digits: State {
        override fun on(char: String): State? = if (char in "0".."9") Digits else null

        override fun canAccept(): Boolean = true
    }
}