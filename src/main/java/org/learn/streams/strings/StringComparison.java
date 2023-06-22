package org.learn.streams.strings;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StringComparison {

    /**
     * Set 2: String comparison
     * 1. Compare two strings lexicographically using streams.
     * 2. Check if two strings are equal ignoring case using streams.
     * 3. Determine if a string starts with a specific prefix using streams.
     * 4. Check if a string ends with a specific suffix using streams.
     * 5. Compare a portion of two strings using streams.
     */

    public static void main(String[] args) {

        String str1 = "Java";
        String str2 = "Selenium";
        String delimiter = ", ";
        char c = '!';
        int startIndex = 1;
        int endIndex = 4;

        String[] strArray = {"Java", "Selenium", "TestNG", "Maven", "Jenkins"};
        List<String> strList = List.of("Java", "Selenium", "TestNG", "Maven", "Jenkins");

        System.out.println("String comparison: ");

//        1. Compare two strings lexicographically using streams.
        compareStrings(str1, str2);
        compareStrings(str1, str1);

//        2. Check if two strings are equal ignoring case using streams.
        areStringsEqualIgnoreCase(str1, str2);
        areStringsEqualIgnoreCase(str1, str1);

//        3. Determine if a string starts with a specific prefix using streams.
        startsWithPrefix(str1, "J");
        startsWithPrefix(str1, "a");


//        4. Check if a string ends with a specific suffix using streams.
        endsWithSuffix(str1, "a");
        endsWithSuffix(str1, "v");

//        5. Compare a portion of two strings using streams.
        System.out.println("\n\nComparison of substrings:");
        compareSubstring(str1, str2, startIndex, endIndex);
        compareSubstring(str1, str1, startIndex, endIndex);

    }

    private static void compareStrings(String str1, String str2) {
        int count = Stream.of(str1, str2)
                .min(Comparator.naturalOrder())
                .orElse("")
                .compareTo(Stream.of(str1, str2)
                        .max(Comparator.naturalOrder())
                        .orElse(""));
        System.out.printf("\nCompare '%s' and '%s' using Streams: %d", str1, str2, count);
    }

    private static void areStringsEqualIgnoreCase(String str1, String str2) {
        System.out.printf("\n\nStrings '%s' and '%s' are equal when ignoring case - ", str1, str2);

        boolean result1 = Stream.of(str1, str2)
                .map(String::toLowerCase)
                .distinct()
                .count() == 1;
        System.out.println("\nUsing map, distinct and count in Streams: " + result1);

        boolean result2 = Stream.of(str1, str2)
                .allMatch(s -> s.equalsIgnoreCase(str1));
        System.out.println("Using allMatch and equalIgnoreCase in Streams: " + result2);
    }

    private static void startsWithPrefix(String str, String prefix) {
        boolean result = Stream.of(str).anyMatch(s -> s.startsWith(prefix));
        System.out.printf("\nString '%s' starts with prefix '%s' using Streams: %b", str, prefix, result);
    }

    private static void endsWithSuffix(String str, String suffix) {
        boolean result = Stream.of(str).anyMatch(s -> s.endsWith(suffix));
        System.out.printf("\nString '%s' ends with suffix '%s' using Streams: %b", str, suffix, result);
    }

    private static void compareSubstring(String str1, String str2, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > str1.length() || endIndex > str2.length()) {
            System.out.println("\nInvalid substring indices for comparing Strings");
        } else {
            String substring1 = str1.substring(startIndex, endIndex);
            String substring2 = str2.substring(startIndex, endIndex);

            int count1 = substring1.compareTo(substring2);
            System.out.printf("\nCompare substring of '%s' and '%s' using compareTo function: %d", str1, str2, count1);

            int count2 = Optional.of(substring1)
                    .orElse("")
                    .compareTo(Optional.of(substring2)
                            .orElse(""));
            System.out.printf("\nCompare substring of '%s' and '%s' using Optional: %d", str1, str2, count2);
        }
    }

}
