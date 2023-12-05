package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeselValidatorTest {

    @Test
    public void testValidPesel() {
        String validPesel = "12345678901";
        assertTrue(PeselValidator.validatePesel(validPesel));
    }

    @Test
    public void testInvalidPesel() {
        String invalidPesel = "abcdefghijk";
        assertFalse(PeselValidator.validatePesel(invalidPesel));
    }

    @Test
    public void testShortPesel() {
        String shortPesel = "12345";
        assertFalse(PeselValidator.validatePesel(shortPesel));
    }

    @Test
    public void testLongPesel() {
        String longPesel = "1234567890123";
        assertFalse(PeselValidator.validatePesel(longPesel));
    }
}