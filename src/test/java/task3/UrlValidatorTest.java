package task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.*;

public class UrlValidatorTest {
    private static final String URL_REGEX = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9._%+-]+)*$";

    public static boolean validateUrl(String url) {
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    @Test
    public void testValidUrls() {
        String[] validUrls = {
                "http://www.onet.pl",
                "https://mail.google.com",
                "http://wiadmosci.onet.pl",
                "http://onet.pl"
        };

        for (String url : validUrls) {
            assertTrue(validateUrl(url), url + " - Oczekiwano poprawnego URL.");
        }
    }

    @Test
    public void testInvalidUrls() {
        String[] invalidUrls = {
                "www.invalidurl", // Brak protokołu
                "https://invalidurl.", // Brak domeny
                "ftp://invalidurl.com", // Nieobsługiwany protokół
                "http://invalid url.com" // Spacje w adresie URL
        };

        for (String url : invalidUrls) {
            assertFalse(validateUrl(url), url + " - Oczekiwano niepoprawnego URL.");
        }
    }
}