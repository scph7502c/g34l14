package task6;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayInfoTest {

    @Test
    public void testCalculateAge() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        LocalDate currentDate = LocalDate.of(2022, 12, 1);
        int expectedAge = 32;

        int actualAge = BirthdayInfo.calculateAge(birthDate, currentDate);

        assertEquals(expectedAge, actualAge);
    }

    @Test
    public void testGetDayOfWeekString() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        Locale polishLocale = new Locale("pl");
        String expectedDayOfWeek = "wtorek";

        String actualDayOfWeek = BirthdayInfo.getDayOfWeekString(birthDate, polishLocale);

        assertEquals(expectedDayOfWeek, actualDayOfWeek);
    }

    @Test
    public void testGetWeekOfYear() {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        int expectedWeekOfYear = 20;

        int actualWeekOfYear = BirthdayInfo.getWeekOfYear(birthDate);

        assertEquals(expectedWeekOfYear, actualWeekOfYear);
    }
}