package task2;

import java.util.regex.*;

public class PeselValidator {
    private static final String PESEL_REGEX = "\\d{11}";

    public static boolean validatePesel(String pesel) {
        Pattern pattern = Pattern.compile(PESEL_REGEX);
        Matcher matcher = pattern.matcher(pesel);
        return matcher.matches();
    }
}