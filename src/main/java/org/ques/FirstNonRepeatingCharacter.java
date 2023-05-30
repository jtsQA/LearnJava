package org.ques;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "aabcdcb";
        char firstNonRepeatingChar = findFirstNonRepeatingCharacter(input);
        if (firstNonRepeatingChar != '\0') {
            System.out.println("First non-repeating character: " + firstNonRepeatingChar);
        } else {
            System.out.println("No non-repeating character found in the input string.");
        }
    }

    public static char findFirstNonRepeatingCharacter(String input) {

        Map<Character, Integer> charCounts = new HashMap<>();

        // Count the occurrences of each character
        for (char c : input.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        //  Find the first non-repeating characters
        for (char c : input.toCharArray()) {
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        // If no non-repeating character found, return a default value
        return '\0';
    }

}
