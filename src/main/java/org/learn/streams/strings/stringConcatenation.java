package org.learn.streams.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stringConcatenation {

    /*
    Set 1: String concatenation
    1. Concatenate two strings together using streams.
    2. Append a character to an existing string using streams.
    3. Join a list of strings into a single string using streams.
    4. Merge multiple strings with a delimiter using streams.
    5. Concatenate strings conditionally based on a certain criterion using streams.
    */

    public static void main(String[] args) {

        String str1 = "Concatenation ";
        String str2 = "Appending";
        String delimiter = ", ";
        char c = '!';

        String[] strArray = {"Java", "Selenium", "TestNG", "Maven", "Jenkins"};
        List<String> strList = List.of("Java", "Selenium", "TestNG", "Maven", "Jenkins");

        System.out.println("String concatenation: ");

//        1. Concatenate two strings together using streams.
        concatStrings(str1, str2);
        concatStringArray(strArray);

//        2. Append a character to an existing string using streams.
        appendCharToString(str2, c);

//        3. Join a list of strings into a single string using streams.
        joinListOfString(strList);

//        4. Merge multiple strings with a delimiter using streams.
        mergeStringArrayWithDelimiter(strArray, delimiter);

//        5. Concatenate strings conditionally based on a certain criterion using streams.
        conditionalConcatenation(strList);
    }

    private static void concatStrings(String str1, String str2) {
        String str3 = String.join("", str1, str2);
        System.out.printf("\nConcat '%s' and '%s' using String.join: %s", str1, str2, str3);

        String str4 = Stream.of(str1, str2).collect(Collectors.joining());
        System.out.printf("\nConcat '%s' and '%s' using Streams: %s", str1, str2, str4);
    }

    private static void concatStringArray(String[] strArray) {
        System.out.printf("\n\nConcat String Array: %s", Arrays.toString(strArray));

        String str1 = String.join("", strArray);
        System.out.printf("\nUsing String.join: %s", str1);

        String str2 = Arrays.stream(strArray).collect(Collectors.joining());
        System.out.printf("\nUsing Streams: %s", str2);
    }

    private static void appendCharToString(String str, char c) {
        System.out.printf("\n\nAppend '%s' and '%s'", str, c);

        String str1 = String.join("", str, String.valueOf(c));
        System.out.printf("\nUsing String.join: %s", str1);

        String str2 = Stream.of(str, String.valueOf(c)).collect(Collectors.joining());
        System.out.printf("\nUsing Streams: %s", str2);
    }

    private static void joinListOfString(List<String> strList) {
        System.out.printf("\n\nJoin List of string: %s", strList);

        String str1 = String.join("", strList);
        System.out.printf("\nUsing String.join: " + str1);

        String str2 = strList.stream().collect(Collectors.joining());
        System.out.printf("\nUsing Streams: " + str2);

    }

    private static void mergeStringArrayWithDelimiter(String[] strArray, String delimiter) {
        System.out.printf("\n\nMerge String: '%s' with String Array: %s", delimiter, Arrays.toString(strArray));

        String str1 = String.join(delimiter, strArray);
        System.out.printf("\nUsing String.join: %s", str1);

        String str2 = Arrays.stream(strArray).collect(Collectors.joining(delimiter));
        System.out.printf("\nUsing Streams: %s", str2);
    }

    private static void conditionalConcatenation(List<String> strList) {
        String str = strList.stream().filter(s -> !s.contains("i")).collect(Collectors.joining());
        System.out.println("\n\nFiltering string conditionally using Streams: " + str);
    }

}
