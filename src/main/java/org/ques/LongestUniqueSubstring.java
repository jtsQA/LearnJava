package org.ques;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        String[] strArray = {"geeksforgeeks", "", "d", "abv", "abc", "aaihian", "abcdacdbedeab"};
        longestUniqueSubstringLength(strArray);
    }

    private static void longestUniqueSubstringLength(String[] strArray) {
        for (String str : strArray) {
            findLongestUniqueSubstringLength(str);
            findLongestUniqueSubstring(str);
        }
    }

    private static void findLongestUniqueSubstringLength(String str) {
        StringBuilder tempStr = new StringBuilder();
        int maxLength = -1;

        if (str.isEmpty()) {
            System.out.println("\nString is empty!");
        } else if (str.length() == 1) {
            System.out.println("\nLength of longest unique substring '" + str + "':  1");
        } else {
            for (char c : str.toCharArray()) {
                String currStr = String.valueOf(c);
                if (tempStr.toString().contains(String.valueOf(currStr))) {
                    tempStr = new StringBuilder(tempStr.substring(tempStr.indexOf(currStr) + 1));
                }
                tempStr.append(currStr);
                maxLength = Math.max(tempStr.length(), maxLength);
            }
            System.out.println("\nLength of longest unique substring in '" + str + "': " + maxLength);
        }
    }

    private static void findLongestUniqueSubstring(String str) {
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;
        int maxStartIndex = 0;

        if (str == null || str.isEmpty() || str.isBlank()) {
            System.out.println("\nString is empty!");
        } else {
            int n = str.length();
            Set<Character> set = new HashSet<>();

            while (endIndex < n) {
                char c = str.charAt(endIndex);
                if (!set.contains(c)) {
                    set.add(c);
                    int currLength = endIndex - startIndex + 1;
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        maxStartIndex = startIndex;
                    }
                    endIndex++;
                } else {
                    set.remove(str.charAt(startIndex));
                    startIndex++;
                }
            }
            System.out.println("\nLongest unique substring in '" + str + "': " + str.substring(maxLength, maxStartIndex + maxLength));
        }
    }

}
