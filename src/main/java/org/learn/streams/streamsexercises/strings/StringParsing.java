package org.learn.streams.streamsexercises.strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParsing {

    /**
     * Set 10: String parsing
     * 1. Parse an integer value from a string using streams.
     * 2. Extract all floating-point numbers from a string using streams.
     * 3. Parse a date string into a Date object using streams.
     * 4. Split a string into key-value pairs using a specific delimiter and parse them into a map using streams.
     * 5. Parse a complex string representation of an object into the corresponding object using streams.
     *
     * @author Jithin
     * @since 28/06/2023
     */

    public static void main(String[] args) {

        String integerStr = "345";
        String integerStrWithChar = "a456cd789efg123";
        String floatingPointStr = "256 3.14 2.718 33 1.618";
        String dateStr = "2023-05-23";
        String dateFormat = "yyyy-MM-dd";
        String keyValueStr = "key1:value1,key2:value2,key3:value3";
        String delimiter = ",";
        String complexString = "John Doe:25:New York";


//        1. Parse an integer value from a string using streams.
        parseInteger(integerStr);
        parseInteger(integerStrWithChar);

//        2. Extract all floating-point numbers from a string using streams.
        extractFloatingPointNumbers(floatingPointStr);

//        3. Parse a date string into a Date object using streams.
        parseDate(dateStr, dateFormat);

//        4. Split a string into key-value pairs using a specific delimiter and parse them into a map using streams.
        parseKeyValuePairs(keyValueStr, delimiter);

//        5. Parse a complex string representation of an object into the corresponding object using streams.
        parseComplexObject(complexString);

    }

    /**
     * Parse an integer value from a string using streams.
     * {@code parseInteger} method takes a string str as input and returns an Optional<Integer> that represents the parsed integer value.
     * Using the stream {Stream.of}, we create a stream containing only the input string.
     * The map operation is applied to each element in the stream, where we use Integer.parseInt to parse the string into an integer.
     * Finally, findFirst is used to retrieve the first element of the stream as an Optional<Integer>.
     * If the string cannot be parsed into an integer, it will return an empty Optional.
     */
    private static void parseInteger(String str) {
        if (str.chars().allMatch(Character::isDigit)) {
            Optional<Integer> parseInt = Stream.of(str)
                    .map(Integer::parseInt)
                    .findFirst();
            System.out.printf("\nParse an integer value from a string using streams: \n Input  - %s (Contains only numeric values)\n Output - %s\n", str, parseInt);
        } else {
            int[] parsesInt = Pattern.compile("\\d+")
                    .matcher(str)
                    .results()
                    .map(MatchResult::group)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.printf("\nParse an integer value from a string using streams: \n Input  - %s\n Output - %s\n", str, Arrays.toString(parsesInt));
        }
    }

    /**
     * Extract all floating-point numbers from a string using streams.
     * {@code extractFloatingPointNumbers} method uses a regular expression pattern to find all occurrences of floating-point numbers in the input string (\\d+\\.\\d+).
     * The approach is similar to parseInteger method, but here the pattern is for floating-point numbers.
     * The matched numbers are mapped to Double using parseDouble() method, and collected into a list using collect(Collectors.toList()).
     */
    private static void extractFloatingPointNumbers(String str) {
        List<Double> extractedNumbers = Pattern.compile("\\d+\\.\\d+")
                .matcher(str)
                .results()
                .map(MatchResult::group)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.printf("\nExtract all floating-point numbers from a string using streams: \n Input  - %s\n Output - %s\n", str, extractedNumbers);
    }

    /**
     * Parse a date string into a Date object using streams.
     * {@code parseDate} method takes a date string and a format string as input.
     * It creates a SimpleDateFormat object with the provided format.
     * The input string is wrapped in a stream using Stream.of(), and each string is parsed into a Date object using the parse() method of DateFormat.
     * In this code, we wrap the ParseException in a RuntimeException and re-throw it within the lambda expression using throw new RuntimeException(e).
     * Then, we catch the RuntimeException outside the lambda expression and handle it accordingly.
     * Please note that throwing a RuntimeException or its subclass makes the exception unchecked, which means it does not need to be declared in the method signature or caught explicitly.
     * Finally, findFirst() is used to get the parsed date as an Optional<Date>.
     */
    private static void parseDate(String str, String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        Optional<Date> date = Stream.of(str).map(s -> {
            try {
                return format.parse(s);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).findFirst();
        System.out.printf("\nParse a date string into a Date object using streams: \n Input  - %s\n Output - %s\n", str, date);
    }

    /**
     * Split a string into key-value pairs using a specific delimiter and parse them into a map using streams.
     * {@code parseKeyValuePairs} method splits the input string into key-value pairs using the provided delimiter.
     * It uses Pattern.compile() and splitAsStream() methods to split the string.
     * Each split string is further split into a key-value pair using split(":").
     * The resulting arrays are then collected into a map using Collectors.toMap().
     */
    private static void parseKeyValuePairs(String str, String delimiter) {
        Map<String, String> keyValueMap = Pattern.compile(delimiter).splitAsStream(str).map(s -> s.split(":")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
        System.out.printf("\nSplit a string into key-value pairs using a specific delimiter and parse them into a map using streams: \n Input  - String: '%s', delimiter: '%s'\n Output - %s\n", str, delimiter, keyValueMap);
    }

    /**
     * Parse a complex string representation of an object into the corresponding object using streams.
     * {@code parseComplexObject} method is left as an example with an empty implementation.
     * The logic for parsing a complex string representation of an object depends on the specific format and object type.
     * This method can be customized accordingly.
     */
    private static void parseComplexObject(String str) {
        Person person = parsePerson(str);
        System.out.printf("\nParse a complex string representation of an object into the corresponding object using streams: \n Input  - %s\n Output - %s\n", str, person.toString());
    }

    private static Person parsePerson(String input) {
        return Arrays.stream(input.split(":"))
                .map(String::trim)
                .collect(Collector.of(
                        () -> new String[3],
                        (arr, value) -> {
                            if (arr[0] == null) {
                                arr[0] = value;
                            } else if (arr[1] == null) {
                                arr[1] = value;
                            } else if (arr[2] == null) {
                                arr[2] = value;
                            } else {
                                throw new IllegalStateException("Unexpected input format");
                            }
                        },
                        (arr1, arr2) -> {
                            throw new IllegalStateException("Unexpected parallel execution");
                        },
                        arr -> {
                            if (arr[0] != null && arr[1] != null && arr[2] != null) {
                                return new Person(arr[0], Integer.parseInt(arr[1]), arr[2]);
                            } else {
                                throw new IllegalStateException("Invalid input format");
                            }
                        }
                ));
    }

    record Person(String name, int age, String city) {

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append(", city='").append(city).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}
