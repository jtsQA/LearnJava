package org.learn.streams.streamsexercises.strings;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StringLength {

    /**
     * Set 4: String length
     * 1. Calculate the length of a string using streams.
     * 2. Determine the longest string in a list using streams.
     * 3. Find the average length of strings in a collection using streams.
     * 4. Count the number of strings with a specific length in a list using streams.
     * 5. Identify the shortest and longest strings in a list using streams.
     *
     * @author Jithin
     * @since 22/06/2023
     */

    public static void main(String[] args) {

        String str = "Java is simple and very powerful";
        List<String> strList = List.of("Java", "Selenium", "TestNG", "Maven", "Jenkins", "Code");
        int length = 4;

        String target = "a";
        String replacement = "i";
        char character = 'a';

//        1. Calculate the length of a string using streams.
        calculateStringLength(str);

//        2. Determine the longest string in a list using streams.
        findLongestString(strList);

//        3. Find the average length of strings in a collection using streams.
        calculateAverageStringLength(strList);

//        4. Count the number of strings with a specific length in a list using streams.
        countStringsWithLength(strList, length);

//        5. Identify the shortest and longest strings in a list using streams.
        findShortestAndLongestStrings(strList);
    }

    /**
     * Calculate the length of a string using streams.
     * {@code calculateStringLength} method uses the chars() method of the String class to obtain an IntStream of the characters in the string.
     * Then, the count() method is applied to the stream to calculate the length of the string.
     */
    private static void calculateStringLength(String str) {
        long count = str.chars().count();
        System.out.printf("\nCalculate the length of a string using streams: \n Input  - %s\n Output - %d\n", str, count);
    }

    /**
     * Determine the longest string in a list using streams.
     * {@code findLongestString} method uses the stream() method of the List class to obtain a stream of strings.
     * Then, the max() method is applied to the stream using a comparator that compares the strings based on their lengths.
     * The orElse("") method is used to handle the case when the list is empty and return an empty string.
     */
    private static void findLongestString(List<String> strList) {
        String str = strList.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.printf("\nDetermine the longest string in a list using streams: \n Input  - %s\n Output - %s\n", strList, str);
    }

    /**
     * Find the average length of strings in a collection using streams.
     * {@code calculateAverageStringLength} method uses the stream() method of the Collection class to obtain a stream of strings.
     * Then, the mapToInt() method is applied to convert each string to its length as an integer.
     * The average() method is used to calculate the average of the lengths.
     * The orElse(0) method is used to handle the case when the collection is empty and return 0.
     */
    private static void calculateAverageStringLength(List<String> strList) {
        double count = strList.stream().mapToInt(String::length).average().orElse(0);
        System.out.printf("\nFind the average length of strings in a collection using streams: \n Input  - %s\n Output - %s\n", strList, count);
    }

    /**
     * Count the number of strings with a specific length in a list using streams.
     * {@code countStringsWithLength} method uses the stream() method of the List class to obtain a stream of strings.
     * Then, the filter() method is applied to the stream to filter out the strings with the specified length.
     * Finally, the count() method is used to count the number of filtered strings.
     */
    private static void countStringsWithLength(List<String> strList, int length) {
        long count = strList.stream().filter(s -> s.length() == length).count();
        System.out.printf("\nCount the number of strings with a specific length in a list using streams: \n Input  - %s\n Output - %s\n", strList, count);
    }

    /**
     * Identify the shortest and longest strings in a list using streams.
     * {@code findShortestAndLongestStrings}
     * method uses two streams: one to find the minimum length (shortest string) and another to find the maximum length (longest string).
     * The min() and max() methods are used with a comparator that compares the strings based on their lengths.
     * The orElse("") method is used to handle the case when the list is empty and return an empty string.
     * Finally, the shortest and longest strings are printed to the console.
     */
    private static void findShortestAndLongestStrings(List<String> strList) {
        Optional<String> shortStr = strList.stream().min(Comparator.comparingInt(String::length));
        Optional<String> longStr = strList.stream().max(Comparator.comparingInt(String::length));
        System.out.printf("\nIdentify the shortest and longest strings in a list using streams: \n Input  - %s\n Output - Shortest string:%s, Longest String:%s\n", strList, shortStr, longStr);
    }
}
