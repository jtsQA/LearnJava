package org.ques.shared;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueMaxLenSubString {

    public static void main(String[] args) {
        String[] strArray = {"geeksforgeeks", "", "d", "abv", "abc", "aaihian", "abcdacdbedeab"};
        uniqueMaxLenSubString(strArray);
    }

    private static void uniqueMaxLenSubString(String[] strArray) {
        for (String str : strArray) {
            findUniqueMaxLenSubStringUsingStream(str);
            findUniqueMaxLenSubStringUsingSubString(str);
        }
    }

    private static void findUniqueMaxLenSubStringUsingStream(String string) {
        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<>();
        String uniqueSubString = null;
        int uniqueSubStringLength = 0;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (!charPosMap.containsKey(ch)) {
                charPosMap.put(ch, i);
            } else {
                i = charPosMap.get(ch);
                charPosMap.clear();
//                continue;
            }
            if (charPosMap.size() > uniqueSubStringLength) {
                uniqueSubStringLength = charPosMap.size();
                uniqueSubString = charPosMap.keySet()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining());
            }
        }
        System.out.println("\nUsing Stream and Linked HashMap - Unique substring: " + uniqueSubString);
    }

    private static void findUniqueMaxLenSubStringUsingSubString(String str) {
        Map<Character, Integer> charPosMap = new HashMap<>();
        String uniqueSubStr = null;
        int uniqueSubStrLen = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (charPosMap.containsKey(ch)) {
                start = Math.max(start, charPosMap.get(ch) + 1);
            }

            charPosMap.put(ch, i);

            int currentLength = i - start + 1;

            if (currentLength > uniqueSubStrLen) {
                uniqueSubStrLen = currentLength;
                uniqueSubStr = str.substring(start, i + 1);
            }
        }

        System.out.println("Using Substring and HashMap - Unique substring: " + uniqueSubStr);
    }

}


