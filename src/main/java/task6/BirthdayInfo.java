package task6;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class BirthdayInfo {
    private final LocalDate birthDate;
    private final Locale locale;

    public BirthdayInfo(String birthday, Locale locale) throws DateTimeParseException {
        try {
            this.birthDate = LocalDate.parse(birthday);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Nieprawidłowy format daty", birthday, e.getErrorIndex());
        }
        this.locale = locale;
    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(this.birthDate, currentDate).getYears();
    }

    public String getDayOfWeekString() {
        DayOfWeek dayOfWeek = this.birthDate.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, this.locale);
    }

    public int getWeekOfYear() {
        WeekFields weekFields = WeekFields.of(this.locale);
        return this.birthDate.get(weekFields.weekOfWeekBasedYear());
    }

    public void displayInformation() {
        int age = calculateAge();
        String dayOfWeekString = getDayOfWeekString();
        int weekOfYear = getWeekOfYear();

        System.out.println("Osoba ma " + age + " lat.");
        System.out.println("Urodziła się w dniu tygodnia: " + dayOfWeekString);
        System.out.println("To był " + weekOfYear + " tydzień roku.");
    }
}