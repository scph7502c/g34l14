package task6;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class BirthdayInfo {
    public static void main(String[] args) {
        String birthday = "1990-05-15";

        LocalDate birthDate = LocalDate.parse(birthday);
        LocalDate currentDate = LocalDate.now();

        int age = calculateAge(birthDate, currentDate);
        String dayOfWeekString = getDayOfWeekString(birthDate, new Locale("pl"));
        int weekOfYear = getWeekOfYear(birthDate);

        displayInformation(age, dayOfWeekString, weekOfYear);
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    public static String getDayOfWeekString(LocalDate birthDate, Locale locale) {
        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, locale);
    }

    public static int getWeekOfYear(LocalDate birthDate) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return birthDate.get(weekFields.weekOfWeekBasedYear());
    }

    public static void displayInformation(int age, String dayOfWeekString, int weekOfYear) {
        System.out.println("Osoba ma " + age + " lat.");
        System.out.println("Urodziła się w dniu tygodnia: " + dayOfWeekString);
        System.out.println("To był " + weekOfYear + " tydzień roku.");
    }
}
