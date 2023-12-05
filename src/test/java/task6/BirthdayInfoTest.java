package task6;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayInfoTest {

    @Test
    public void testCalculateAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1990, 5, 15);

        int actualAge = BirthdayInfo.calculateAge(birthDate, currentDate);
        int expectedAge = currentDate.getYear() - birthDate.getYear();

        assertEquals(expectedAge, actualAge);
    }

    @Test
    public void testGetDayOfWeekString() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        Locale polishLocale = new Locale("pl");

        String actualDayOfWeek = BirthdayInfo.getDayOfWeekString(birthDate, polishLocale);
        String expectedDayOfWeek = birthDate.getDayOfWeek().getDisplayName(TextStyle.FULL, polishLocale);

        assertEquals(expectedDayOfWeek, actualDayOfWeek);
    }

    @Test
    public void testGetWeekOfYear() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        int expectedWeekOfYear = birthDate.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
        int actualWeekOfYear = BirthdayInfo.getWeekOfYear(birthDate);

        assertEquals(expectedWeekOfYear, actualWeekOfYear);
    }

    @Test
    public void testDisplayInformation() {
        String birthday = "1990-05-15";
        LocalDate birthDate = LocalDate.parse(birthday);
        LocalDate currentDate = LocalDate.now();

        int age = BirthdayInfo.calculateAge(birthDate, currentDate);
        String dayOfWeekString = BirthdayInfo.getDayOfWeekString(birthDate, new Locale("pl"));
        int weekOfYear = BirthdayInfo.getWeekOfYear(birthDate);

        String expectedOutput = "Osoba ma " + age + " lat.\n" +
                "Urodziła się w dniu tygodnia: " + dayOfWeekString + "\n" +
                "To był " + weekOfYear + " tydzień roku.";

        assertEquals(expectedOutput, getDisplayInformationOutput(age, dayOfWeekString, weekOfYear));
    }

    private String getDisplayInformationOutput(int age, String dayOfWeekString, int weekOfYear) {
        return "Osoba ma " + age + " lat.\n" +
                "Urodziła się w dniu tygodnia: " + dayOfWeekString + "\n" +
                "To był " + weekOfYear + " tydzień roku.";
    }
}