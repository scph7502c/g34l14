package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlValidatorTest {

    private UrlValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new UrlValidator();
    }

    @Test
    public void testValidURL() {
        String[] validUrls = {
                "http://www.onet.pl",
                "https://mail.google.com",
                "http://wiadmosci.onet.pl",
                "http://onet.pl",
                "http://www.google.com"
        };

        for (String url : validUrls) {
            assertTrue(validator.validateURL(url), "Expected " + url + " to be a valid URL.");
        }
    }

    @Test
    public void testInvalidURL() {
        String[] invalidUrls = {
                "ftp://example.com",
                "htp://invalid.com",
                "http://.com"
        };

        for (String url : invalidUrls) {
            assertFalse(validator.validateURL(url), "Expected " + url + " to be an invalid URL.");
        }
    }
}