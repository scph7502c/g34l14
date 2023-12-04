package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeselValidatorTest {

    @Test
    public void testValidPesel() {
        String validPesel = "12345678901"; // Poprawny numer PESEL
        assertTrue(PeselValidator.validatePesel(validPesel));
    }

    @Test
    public void testInvalidPesel() {
        String invalidPesel = "abcdefghijk"; // Niepoprawny numer PESEL (znaki inne niż cyfry)
        assertFalse(PeselValidator.validatePesel(invalidPesel));
    }

    @Test
    public void testShortPesel() {
        String shortPesel = "12345"; // Numer PESEL za krótki
        assertFalse(PeselValidator.validatePesel(shortPesel));
    }

    @Test
    public void testLongPesel() {
        String longPesel = "1234567890123"; // Numer PESEL za długi
        assertFalse(PeselValidator.validatePesel(longPesel));
    }
}
