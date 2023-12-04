package task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isPasswordValid("Abcdefg1"));
        assertTrue(PasswordValidator.isPasswordValid("Password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(PasswordValidator.isPasswordValid("weakpass"));
        assertFalse(PasswordValidator.isPasswordValid("2021Insecure"));
        assertFalse(PasswordValidator.isPasswordValid("Short1"));
    }
}