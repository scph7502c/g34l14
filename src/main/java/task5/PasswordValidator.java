package task5;

import java.time.Year;

public class PasswordValidator {

    public boolean isPasswordValid(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?!.*\\b" + Year.now().getValue() + "\\b|\\b\\d{2}\\b)(?!.*[a-zA-Z]\\d{2})(.{7,})$";
        boolean isValid = password.matches(regex);

        if (isValid) {
            System.out.println("Hasło jest poprawne.");
        } else {
            System.out.println("Hasło nie spełnia wymagań.");
        }

        return isValid;
    }
}
