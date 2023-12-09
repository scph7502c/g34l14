package task6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BirthdayInfoTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Locale originalLocale;
    private BirthdayInfo birthdayInfo;

    @BeforeEach
    public void setUp() {
        originalLocale = Locale.getDefault();

        birthdayInfo = new BirthdayInfo("1990-05-15", Locale.forLanguageTag("pl"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        Locale.setDefault(originalLocale);
    }

    @Test
    public void testDisplayInfo() {
        // Given
        System.setOut(new PrintStream(outContent));
        String expectedOutput = "Osoba ma 33 lat.\nUrodziła się w dniu tygodnia: wtorek\nTo był 20 tydzień roku.\n";

        // When
        birthdayInfo.displayInformation();

        // Then
        String normalizedExpected = expectedOutput.replaceAll("\\R", "\n");
        String normalizedActual = outContent.toString().replaceAll("\\R", "\n");
        assertEquals(normalizedExpected, normalizedActual);
    }

    @Test
    public void testInvalidDateException() {
        // Given
        String invalidDate = "1990-05-45";

        // When, Then
        assertThrows(DateTimeParseException.class, () -> new BirthdayInfo(invalidDate, Locale.getDefault()));
    }
}