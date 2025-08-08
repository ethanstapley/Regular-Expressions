package regularExpressions.tests

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regularExpressions.detectors.FloatDetector

class FloatDetectorTest {

    private val detector = FloatDetector()

    @Test
    fun validFloats() {
        assertTrue(detector.accepts("1.0"))
        assertTrue(detector.accepts("123.34"))
        assertTrue(detector.accepts("0.20000"))
        assertTrue(detector.accepts("12349871234.12340981234098"))
        assertTrue(detector.accepts(".123"))
    }

    @Test
    fun invalidFloats() {
        assertFalse(detector.accepts("123"))
        assertFalse(detector.accepts("123.123."))
        assertFalse(detector.accepts("123.02a"))
        assertFalse(detector.accepts("123."))
        assertFalse(detector.accepts("012.4"))
    }
}
