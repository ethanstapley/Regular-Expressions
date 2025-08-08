package regularExpressions.tests

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regularExpressions.detectors.IntegerDetector

class IntegerDetectorTest {

    private val detector = IntegerDetector()

    @Test
    fun validIntegers() {
        assertTrue(detector.accepts("1"))
        assertTrue(detector.accepts("123"))
        assertTrue(detector.accepts("3452342352434534524346"))
    }

    @Test
    fun invalidIntegers() {
        assertFalse(detector.accepts(""))
        assertFalse(detector.accepts("0123"))
        assertFalse(detector.accepts("132a"))
        assertFalse(detector.accepts("0"))
    }
}
