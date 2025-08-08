package regularExpressions.tests

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regularExpressions.detectors.EmailDetector

class EmailDetectorTest {

    private val detector = EmailDetector()

    @Test
    fun validEmails() {
        assertTrue(detector.accepts("a@b.c"))
        assertTrue(detector.accepts("joseph.ditton@usu.edu"))
        assertTrue(detector.accepts("{}*$.&$*(@*$%&.*&*"))
    }

    @Test
    fun invalidEmails() {
        assertFalse(detector.accepts("@b.c"))
        assertFalse(detector.accepts("a@b@c.com"))
        assertFalse(detector.accepts("a.b@b.b.c"))
        assertFalse(detector.accepts("ethan stapley@usu.edu"))
    }
}
