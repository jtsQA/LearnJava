package org.learn.streams.streamsexercises.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCaseConversion {

    /**
     * Set 7: String case conversion
     * 1. Convert a string to uppercase using streams.
     * 2. Convert a string to lowercase using streams.
     * 3. Toggle the case of characters in a string using streams.
     * 4. Capitalize the first character of each word in a string using streams.
     * 5. Convert a mixed case string to title case using streams.
     *
     * @author Jithin
     * @since 22/06/2023
     */

    public static void main(String[] args) {

        String str = "No need to light a night-Light on a light night like toNight";
        String subStr = "notice";
        char ch = 'i';

//        1. Convert a string to uppercase using streams.
        convertToUppercase(str);

//        2. Convert a string to lowercase using streams.
        convertToLowercase(str);

//        3. Toggle the case of characters in a string using streams.
        toggleCase(str);

//        4. Capitalize the first character of each word in a string using streams.
        capitalizeFirstCharacter(str);

//        5. Convert a mixed case string to title case using streams.
        convertToTitleCase(str);

    }

    /**
     * Convert a string to uppercase using streams.
     * {@code convertToUppercase} method converts a string to uppercase using streams.
     * It uses the chars() method to get an IntStream of character codes, then maps each character code to its uppercase equivalent using Character::toUpperCase.
     * Finally, it collects the characters back into a String using a StringBuilder.
     */
    private static void convertToUppercase(String str) {
        String strOutput = str.chars()
                .mapToObj(Character::toUpperCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.printf("\nConvert a string to uppercase using streams: \n Input  - %s\n Output - %s\n", str, strOutput);
    }

    /**
     * Convert a string to lowercase using streams.
     * {@code convertToLowercase} method converts a string to lowercase using streams.
     * It uses the chars() method to get an IntStream of character codes, then maps each character code to its lowercase equivalent using Character::toLowerCase.
     * Finally, it collects the characters back into a String using a StringBuilder.
     */
    private static void convertToLowercase(String str) {
        String strOutput = str.chars()
                .mapToObj(Character::toLowerCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.printf("\nConvert a string to lowercase using streams: \n Input  - %s\n Output - %s\n", str, strOutput);
    }

    /**
     * Toggle the case of characters in a string using streams.
     * {@code toggleCase} method toggles the case of characters in a string using streams.
     * It maps each character code to its opposite case using a ternary operator and Character::isUpperCase and Character::toLowerCase.
     * The resulting characters are collected back into a String using a StringBuilder.
     */
    private static void toggleCase(String str) {

        //Using Streams
        String strOutput1 = str.chars()
                .mapToObj(ch -> Character.isUpperCase(ch) ? Character.toLowerCase((char) ch) : Character.toUpperCase((char) ch))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        //Using loop and conditions
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            } else if (Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        String strOutput2 = new String(chars);

        System.out.printf("\nToggle the case of characters in a string using streams: \n Input  - %s\n Output using streams - %s\n Output using loops   - %s\n", str, strOutput1, strOutput2);
    }

    /**
     * Capitalize the first character of each word in a string using streams.
     * {@code capitalizeFirstCharacter} method capitalizes the first character of each word in a string using streams.
     * It splits the string into words using the regex pattern \\s (matches whitespace), then maps each word by capitalizing the first character and concatenating it with the rest of the word.
     * Finally, it joins the capitalized words back into a single string using Collectors.joining with a space separator.
     */
    private static void capitalizeFirstCharacter(String str) {
        String strOutput = Arrays.stream(str.split("\\s"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.printf("\nCapitalize the first character of each word in a string using streams: \n Input  - %s\n Output - %s\n", str, strOutput);
    }

    /**
     * Convert a mixed case string to title case using streams.
     * {@code convertToTitleCase} method converts a mixed case string to title case using streams.
     * It follows a similar approach to capitalizeFirstCharacter, but also converts the remaining characters of each word to lowercase using String::toLowerCase.
     * This ensures that only the first character of each word is capitalized, while the rest of the characters are in lowercase.
     * The capitalized and lowercase words are then joined back into a single string with space as the separator.
     */
    private static void convertToTitleCase(String str) {
        String strOutput = Arrays.stream(str.split("\\s"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        System.out.printf("\nConvert a mixed case string to title case using streams: \n Input  - %s\n Output - %s\n", str, strOutput);
    }


}
