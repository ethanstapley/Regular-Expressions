package regularExpressions.detectors

import regularExpressions.Detector
import regularExpressions.State

class BinaryDetector: Detector {
    private var state: State = BinaryStart

    override fun accepts(input: String): Boolean {
        if (input.isEmpty()) return false
        state = BinaryStart
        for (char in input) {
            state = state.on(char.toString()) ?: return false
        }
        return state.canAccept()
    }

    private object BinaryStart: State {
        override fun on(char: String): State? = if (char == "1") BinaryIsOne else null

        override fun canAccept(): Boolean = false
    }

    private object BinaryIsOne: State {
        override fun on(char: String): State? {
            return when (char) {
                "1" -> BinaryIsOne
                "0" -> BinaryIsZero
                else -> null
            }
        }

        override fun canAccept(): Boolean = true
    }

    private object BinaryIsZero: State {
        override fun on(char: String): State? {
            return when (char) {
                "1" -> BinaryIsOne
                "0" -> BinaryIsZero
                else -> null
            }
        }

        override fun canAccept(): Boolean = false
    }

}