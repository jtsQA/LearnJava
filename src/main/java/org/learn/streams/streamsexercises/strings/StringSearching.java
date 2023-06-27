package org.learn.streams.streamsexercises.strings;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StringSearching {

    /**
     * Set 6: String searching
     * 1. Find the first occurrence of a character in a string using streams.
     * 2. Determine the index of the last occurrence of a substring in a string using streams.
     * 3. Check if a string contains any digit using streams.
     * 4. Find all occurrences of a substring in a string using streams.
     *
     * @author Jithin
     * @since 22/06/2023
     */

    public static void main(String[] args) {

        String str = "1. If you notice this notice, you will notice that this notice is worth noticing.";
        String subStr = "notice";
        char ch = 'i';

//        1. Find the first occurrence of a character in a string using streams.
        findFirstCharIndex(str, ch);

//        2. Determine the index of the last occurrence of a substring in a string using streams.
        findLastSubstringIndex(str, subStr);

//        3. Check if a string contains any digit using streams.
        containsDigit(str);

//        4. Find all occurrences of a substring in a string using streams.
        findAllSubstringIndices(str, subStr);

    }

    /**
     * Find the first occurrence of a character in a string using streams.
     * {@code findFirstCharIndex} method uses the IntStream.range() method to generate a stream of indices from 0 to str.length() - 1.
     * Then, the filter() method is applied to the stream to filter out the indices where the character at that index matches the given character ch.
     * Finally, the findFirst() method is used to retrieve the index of the first occurrence of the character as an Optional<Integer>.
     */
    private static void findFirstCharIndex(String str, char ch) {
        OptionalInt index = IntStream.range(0, str.length()).filter(i -> str.charAt(i) == ch).findFirst();
        System.out.printf("\nFind the first occurrence of a character in a string using streams: \n Input  - String: '%s', Character: '%s'\n Output - %s\n", str, ch, index);
    }

    /**
     * Determine the index of the last occurrence of a substring in a string using streams.
     * {@code findLastSubstringIndex} method splits the input sentence into words using whitespace as a delimiter.
     * Then, it reduces the stream by concatenating words in reverse order,
     * effectively reversing the order of words in the sentence.
     */
    private static void findLastSubstringIndex(String str, String subStr) {
        int lastIndex = str.lastIndexOf(subStr);
        Optional<Integer> index = lastIndex == -1 ? Optional.empty() : Optional.of(lastIndex);
        System.out.printf("\nDetermine the index of the last occurrence of a substring in a string using streams: \n Input  - String: '%s', SubString: '%s'\n Output - %s\n", str, subStr, index);
    }

    /**
     * Check if a string contains any digit using streams.
     * {@code containsDigit} method converts the string into an IntStream using the chars() method.
     * Then, the anyMatch() method is applied to check if any character in the stream satisfies the condition of being a digit using the Character::isDigit method reference.
     */
    private static void containsDigit(String str) {
        boolean result = str.chars().anyMatch(Character::isDigit);
        System.out.printf("\nCheck if a string contains any digit using streams: \n Input  - %s\n Output - %b\n", str, result);
    }

    /**
     * Find all occurrences of a substring in a string using streams.
     * {@code findAllSubstringIndices} method generates a stream of indices using IntStream.range() from 0 to str.length() - length, where length is the length of the substring.
     * Then, the filter() method is applied to the stream to filter out the indices where the substring matches the substring of the same length starting from that index.
     * Finally, the indices are boxed to Integer objects and collected into a list using the toList().
     */
    private static void findAllSubstringIndices(String str, String subStr) {
        int subLength = subStr.length();
        List<Integer> intList = IntStream.range(0, str.length() - subLength + 1)
                .filter(i -> str.substring(i, i + subLength).equals(subStr))
                .boxed()
                .toList();
        System.out.printf("\nFind all occurrences of a substring in a string using streams: \n Input  - String: '%s', SubString: '%s'\n Output - %s\n", str, subStr, intList);
    }

}
