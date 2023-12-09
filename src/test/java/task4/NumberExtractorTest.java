package task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberExtractorTest {

    private NumberExtractor numberExtractor;
    private String text;

    @BeforeEach
    public void setUp() {
        numberExtractor = new NumberExtractor();
        text = "342\n" +
                "5.34\n" +
                "756\n" +
                "1.234e+07\n" +
                "7.234243E-02\n" +
                "6.09\n" +
                "3457\n" +
                "87\n" +
                "1.0001\n" +
                "3\n" +
                "5";
    }

    @Test
    public void testExtractIntegers() {
        // Given
        List<String> expectedIntegers = List.of("342", "756", "3457", "87", "3", "5");

        // When
        List<String> extractedIntegers = numberExtractor.extractIntegers(text);

        // Then
        assertEquals(expectedIntegers, extractedIntegers);
    }

    @Test
    public void testExtractFloatingPoint() {
        // Given
        List<String> expectedFloatingPoint = List.of("5.34", "6.09", "1.0001");

        // When
        List<String> extractedFloatingPoint = numberExtractor.extractFloatingPoint(text);

        // Then
        assertEquals(expectedFloatingPoint, extractedFloatingPoint);
    }

    @Test
    public void testExtractScientificNotation() {
        // Given
        List<String> expectedScientificNotation = List.of("1.234e+07", "7.234243E-02");

        // When
        List<String> extractedScientificNotation = numberExtractor.extractScientificNotation(text);

        // Then
        assertEquals(expectedScientificNotation, extractedScientificNotation);
    }
}