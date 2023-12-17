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
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(passwordValidator.isPasswordValid("weakpass"));
        assertFalse(passwordValidator.isPasswordValid("2023abcdefgh"));
        assertFalse(passwordValidator.isPasswordValid("Short1"));
        assertFalse(passwordValidator.isPasswordValid("Password123"));
    }
}