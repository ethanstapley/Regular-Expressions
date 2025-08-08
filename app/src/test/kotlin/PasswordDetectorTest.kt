package regularExpressions.tests

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regularExpressions.detectors.PasswordDetector

class PasswordDetectorTest {

    private val detector = PasswordDetector()

    @Test
    fun validPasswords() {
        assertTrue(detector.accepts("aaaaH!aa"))
        assertTrue(detector.accepts("1234567*9J"))
        assertTrue(detector.accepts("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH"))
    }

    @Test
    fun invalidPasswords() {
        assertFalse(detector.accepts("a"))
        assertFalse(detector.accepts("aaaaaaa!"))
        assertFalse(detector.accepts("aaaHaaaaa"))
        assertFalse(detector.accepts("Abbbbbbb!"))
    }
}
