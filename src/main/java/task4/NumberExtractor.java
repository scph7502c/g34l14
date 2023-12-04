package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class NumberExtractor {
    public static void main(String[] args) {
        String text = "342\n" +
                "5.34\n" +
                "756\n" +
                "1.234e+07\n" +
                "7.234243E-02\n" +
                "6.09\n" +
                "3457\n" +
                "87\n" +
                "1.0001\n" +
                "3\n" +
                "5\n";

        List<String> integers = extractIntegers(text);
        List<String> floatingPointNumbers = extractFloatingPointNumbers(text);
        List<String> scientificNotationNumbers = extractScientificNotationNumbers(text);

        System.out.println("Liczby całkowite:");
        for (String integer : integers) {
            System.out.println(integer);
        }

        System.out.println("\nLiczby zmiennoprzecinkowe:");
        for (String floatingPoint : floatingPointNumbers) {
            System.out.println(floatingPoint);
        }

        System.out.println("\nLiczby w notacji naukowej:");
        for (String scientificNotation : scientificNotationNumbers) {
            System.out.println(scientificNotation);
        }
    }

    public static List<String> extractIntegers(String text) {
        List<String> extractedNumbers = new ArrayList<>();
        String integerRegex = "\\b\\d+\\b";
        Pattern integerPattern = Pattern.compile(integerRegex);
        Matcher integerMatcher = integerPattern.matcher(text);

        while (integerMatcher.find()) {
            extractedNumbers.add(integerMatcher.group());
        }

        return extractedNumbers;
    }

    public static List<String> extractFloatingPointNumbers(String text) {
        List<String> extractedNumbers = new ArrayList<>();
        String floatingPointRegex = "\\b\\d+\\.\\d+\\b";
        Pattern floatingPointPattern = Pattern.compile(floatingPointRegex);
        Matcher floatingPointMatcher = floatingPointPattern.matcher(text);

        while (floatingPointMatcher.find()) {
            extractedNumbers.add(floatingPointMatcher.group());
        }

        return extractedNumbers;
    }

    public static List<String> extractScientificNotationNumbers(String text) {
        List<String> extractedNumbers = new ArrayList<>();
        String scientificNotationRegex = "\\b\\d+(\\.\\d+)?[eE][+-]?\\d+\\b";
        Pattern scientificNotationPattern = Pattern.compile(scientificNotationRegex);
        Matcher scientificNotationMatcher = scientificNotationPattern.matcher(text);

        while (scientificNotationMatcher.find()) {
            extractedNumbers.add(scientificNotationMatcher.group());
        }

        return extractedNumbers;
    }
}