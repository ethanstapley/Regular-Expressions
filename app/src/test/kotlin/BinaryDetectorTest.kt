package regularExpressions.tests

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regularExpressions.detectors.BinaryDetector

class BinaryDetectorTest {

    private val detector = BinaryDetector()

    @Test
    fun validBinaries() {
        assertTrue(detector.accepts("1"))
        assertTrue(detector.accepts("11"))
        assertTrue(detector.accepts("101"))
        assertTrue(detector.accepts("111111"))
        assertTrue(detector.accepts("10011010001"))
    }

    @Test
    fun invalidBinaries() {
        assertFalse(detector.accepts("01"))
        assertFalse(detector.accepts("10"))
        assertFalse(detector.accepts("1000010"))
        assertFalse(detector.accepts("100a01"))
    }
}
