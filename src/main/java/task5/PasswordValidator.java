package task5;

public class PasswordValidator {

    public boolean isPasswordValid(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?!.*2021|21)(.{7,})$";
        boolean isValid = password.matches(regex);

        if (isValid) {
            System.out.println("Hasło jest poprawne.");
        } else {
            System.out.println("Hasło nie spełnia wymagań.");
        }

        return isValid;
    }
}