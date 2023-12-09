package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class NumberExtractor {
    public List<String> extractIntegers(String text) {
        List<String> extractedNumbers = new ArrayList<>();
        String integerRegex = "(?<!\\S)\\d+(?!\\S)";
        Pattern integerPattern = Pattern.compile(integerRegex);
        Matcher integerMatcher = integerPattern.matcher(text);

        while (integerMatcher.find()) {
            extractedNumbers.add(integerMatcher.group());
        }

        System.out.println("Liczby całkowite:");
        for (String integer : extractedNumbers) {
            System.out.println(integer);
        }

        return extractedNumbers;
    }

    public List<String> extractFloatingPoint(String text) {
        List<String> extractedNumbers = new ArrayList<>();
        String floatingPointRegex = "\\b\\d+\\.\\d+\\b";
        Pattern floatingPointPattern = Pattern.compile(floatingPointRegex);
        Matcher floatingPointMatcher = floatingPointPattern.matcher(text);

        while (floatingPointMatcher.find()) {
            extractedNumbers.add(floatingPointMatcher.group());
        }

        System.out.println("\nLiczby zmiennoprzecinkowe:");
        for (String floatingPoint : extractedNumbers) {
            System.out.println(floatingPoint);
        }

        return extractedNumbers;
    }

    public List<String> extractScientificNotation(String text) {
        List<String> extractedNumbers = new ArrayList<>();
        String scientificNotationRegex = "\\b\\d+(\\.\\d+)?[eE][+-]?\\d+\\b";
        Pattern scientificNotationPattern = Pattern.compile(scientificNotationRegex);
        Matcher scientificNotationMatcher = scientificNotationPattern.matcher(text);

        while (scientificNotationMatcher.find()) {
            extractedNumbers.add(scientificNotationMatcher.group());
        }

        System.out.println("\nLiczby w notacji naukowej:");
        for (String scientificNotation : extractedNumbers) {
            System.out.println(scientificNotation);
        }

        return extractedNumbers;
    }
}