package regularExpressions.detectors

import regularExpressions.Detector
import regularExpressions.State

class EmailDetector: Detector {
    private var state: State = EmailStart

    override fun accepts(input: String): Boolean {
        if (input.isEmpty()) return false
        state = EmailStart
        for (char in input) {
            state = state.on(char.toString()) ?: return false
        }
        return state.canAccept()
    }

    private object EmailStart: State {
        override fun on(char: String): State? {
            return when (char) {
                "@" -> null
                " " -> null
                else -> EmailLocal
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object EmailLocal: State {
        override fun on(char: String): State? {
            return when (char) {
                "@" -> EmailAt
                " " -> null
                else -> EmailLocal
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object EmailAt: State{
        override fun on(char: String): State? {
            return when (char) {
                "@" -> null
                " " -> null
                "." -> null
                else -> EmailDomain
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object EmailDomain: State{
        override fun on(char: String): State? {
            return when (char) {
                "@" -> null
                " " -> null
                "." -> EmailDotAfterAt
                else -> EmailDomain
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object EmailDotAfterAt: State{
        override fun on(char: String): State? {
            return when (char) {
                "@" -> null
                " " -> null
                "." -> null
                else -> EmailTopLevelDomain
            }
        }

        override fun canAccept(): Boolean = false
    }

    private object EmailTopLevelDomain: State{
        override fun on(char: String): State? {
            return when (char) {
                "@" -> null
                " " -> null
                "." -> null
                else -> EmailTopLevelDomain
            }
        }

        override fun canAccept(): Boolean = true
    }
}