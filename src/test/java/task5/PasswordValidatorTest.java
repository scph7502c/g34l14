package task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void testValidPassword() {
        assertTrue(passwordValidator.isPasswordValid("Abcdefg1"));
        assertTrue(passwordValidator.isPasswordValid("Password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(passwordValidator.isPasswordValid("weakpass"));
        assertFalse(passwordValidator.isPasswordValid("2021abcdefgh"));
        assertFalse(passwordValidator.isPasswordValid("Short1"));
    }
}