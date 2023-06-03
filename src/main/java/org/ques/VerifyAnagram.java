package org.ques;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VerifyAnagram {

    private final static int ALPHABETS_COUNT = 26;

    public static void main(String[] args) {

        String[] aArray = {"Earth", "listen", "java", "Night", "Save", "Madonna Louise Ciccone", "debit card", "state", "football", "soon"};
        String[] bArray = {"heart", "Silent", "python", "thing", "face", "one cool dance musician", "bad credit", "taste", "baseball", "moon"};
        String[] words = {"cat", "dog", "tac", "god", "act"};

        anagramsValidation(aArray, bArray);
        anagramsValidationUsingStreams(aArray, bArray);
        isAnagramPalindrome("Malayalam");
//        isAnagramPalindrome("English");
        findMinAnagramChanges("Football", "Baseball");
//        findMinAnagramChanges("Football", "Basketball");
        findLongestAnagramSubsequence("Football", "Baseball");
//        findLongestAnagramSubsequence("earth", "heart");
//        findLongestAnagramSubsequence("save", "face");
        findAnagramSubstrings("BACDGABCDA", "abcd");
        anagramGrouping(words);

    }

    private static void timeTaken(long t1, long t2) {
        System.out.println("\nTime taken: " + (t2 - t1) + " milliSeconds\n");
    }

    private static String preprocessString(String str) {
        return str.toLowerCase().replaceAll("\\s+", "");
    }

    private static boolean isInvalidInput(String a, String b) {
        return a.isEmpty() || a.isBlank() || b.isEmpty() || b.isBlank();
    }

    private static String sortString(String s) {
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length - 1; i++) {
            for (int j = i + 1; j < c.length; j++) {
                if (c[i] > c[j]) {
                    char temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
            }
        }
        return new String(c);
    }

    private static void anagramsValidation(String[] aArray, String[] bArray) {
        long t1 = System.currentTimeMillis();
        System.out.println("\nAnagram validation using advanced for loop: ");
        if (aArray.length == bArray.length) {
            for (int i = 0; i < aArray.length; i++) {
                String a = preprocessString(aArray[i]);
                String b = preprocessString(bArray[i]);

                if (isInvalidInput(a, b)) {
                    System.out.printf("The two strings '%s' and '%s' are not valid.%n", a, b);
                } else if (a.length() != b.length()) {
                    System.out.printf("The two strings '%s' and '%s' have different lengths.%n", a, b);
                } else if (areAnagramsUsingArray(a, b)) {
                    System.out.printf("The two strings '%s' and '%s' are anagrams.%n", a, b);
                } else {
                    System.out.printf("The two strings '%s' and '%s' are not anagrams.%n", a, b);
                }
            }
        } else {
            System.out.println("The arrays must have the same length.");
        }
        long t2 = System.currentTimeMillis();
        timeTaken(t1, t2);
    }

    private static void anagramsValidationUsingStreams(String[] aArray, String[] bArray) {
        long t1 = System.currentTimeMillis();
        System.out.println("\nAnagram validation using Stream and IntStream: ");

        boolean arraysHaveSameLength = aArray.length == bArray.length;

        IntStream.range(0, aArray.length)
                .filter(i -> arraysHaveSameLength)
                .forEach(i -> {
                    String a = preprocessString(aArray[i]);
                    String b = preprocessString(bArray[i]);

                    if (isInvalidInput(a, b)) {
                        System.out.printf("The two strings '%s' and '%s' are not valid.%n", a, b);
                    } else if (a.length() != b.length()) {
                        System.out.printf("The two strings '%s' and '%s' have different lengths.%n", a, b);
                    } else if (areAnagramsUsingStreamAndArray(a, b)) {
                        System.out.printf("The two strings '%s' and '%s' are anagrams.%n", a, b);
                    } else {
                        System.out.printf("The two strings '%s' and '%s' are not anagrams.%n", a, b);
                    }
                });

        if (!arraysHaveSameLength) {
            System.out.println("The arrays must have the same length.");
        }
        long t2 = System.currentTimeMillis();
        timeTaken(t1, t2);
    }

    private static boolean areAnagrams(String a, String b) {
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (char c : a.toCharArray()) {
            aMap.put(c, aMap.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            bMap.put(c, bMap.getOrDefault(c, 0) + 1);
        }

        return aMap.equals(bMap);
    }

    private static boolean areAnagramsUsingStreamsAndCollectors(String a, String b) {

        Map<Integer, Long> aMap = a.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> bMap = b.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return aMap.equals(bMap);
    }

    private static boolean areAnagramsUsingStreamsAndStringBuilder(String a, String b) {

        String aStr = a.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String bStr = b.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return aStr.equals(bStr);
    }

    private static boolean areAnagramsUsingSorting(String a, String b) {
        return sortString(a).equals(sortString(b));
    }

    private static boolean areAnagramsUsingArray(String a, String b) {
        int alphabetCount = 26;
        int[] charCount = new int[alphabetCount];

        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
            charCount[b.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean areAnagramsUsingStreamAndArray(String a, String b) {
        int[] charCount = new int[ALPHABETS_COUNT];

        IntStream.range(0, a.length())
                .forEach(i -> {
                    charCount[a.charAt(i) - 'a']++;
                    charCount[b.charAt(i) - 'a']--;
                });

        return Arrays.stream(charCount)
                .allMatch(count -> count == 0);
    }

    private static void isAnagramPalindrome(String a) {

        int[] charCount = new int[ALPHABETS_COUNT];
        for (char c : a.toLowerCase().toCharArray()) {
            charCount[c - 'a']++;
        }

        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount <= 1) {
            System.out.printf("\nThe string '%s' is an Anagram Palindrome.%n", a);
        } else {
            System.out.printf("\nThe string '%s' is not an Anagram Palindrome.%n", a);
        }
    }

    private static void findMinAnagramChanges(String a, String b) {

        if (a.length() == b.length()) {
            int[] charCount = new int[ALPHABETS_COUNT];

            for (char c : a.toLowerCase().toCharArray()) {
                charCount[c - 'a']++;
            }
            for (char c : b.toLowerCase().toCharArray()) {
                charCount[c - 'a']--;
            }

            int changes = 0;
            for (int count : charCount) {
                if (count > 0) {
                    changes += count;
                }
            }

            System.out.printf("\nMinimum no: of character changes required to make anagram of '%s' from '%s': %d.%n", a, b, changes);
        } else {
            System.out.printf("\nThe two strings '%s' and '%s' cannot be anagram as the length is different.%n", a, b);
        }

    }

    private static void findLongestAnagramSubsequence(String a, String b) {

        int[] charCount = new int[ALPHABETS_COUNT];

        for (char c : a.toLowerCase().toCharArray()) {
            charCount[c - 'a']++;
        }

        int longestSubsequence = 0;
        for (char c : b.toLowerCase().toCharArray()) {
            if (charCount[c - 'a'] > 0) {
                longestSubsequence++;
                charCount[c - 'a']--;
            }
        }

        System.out.printf("\nLongest subsequence of characters in '%s' and '%s': %d.%n", a, b, longestSubsequence);
    }

    private static void findAnagramSubstrings(String textStr, String patternStr) {

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> textMap = new HashMap<>();

        String text = preprocessString(textStr);
        String pattern = preprocessString(patternStr);

        int patternLength = pattern.length();
        int textLength = text.length();

        // Convert the pattern string to a character frequency map
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window technique to check anagram substrings
        for (int i = 0; i < textLength; i++) {
            char c = text.charAt(i);
            textMap.put(c, textMap.getOrDefault(c, 0) + 1);

            // Remove the character outside the window from the text map
            if (i >= patternLength) {
                char prevChar = text.charAt(i - patternLength);
                if (textMap.get(prevChar) == 1) {
                    textMap.remove(prevChar);
                } else {
                    textMap.put(prevChar, textMap.get(prevChar) - 1);
                }
            }

            // Compare the text map with the pattern map
            if (textMap.equals(patternMap)) {
                result.add(i - patternLength + 1);
            }
        }
        System.out.printf("\nAnagram substring positions for text '%s' and pattern '%s' are: %s%n", text, pattern, result);
    }

    private static void anagramGrouping(String[] words) {

        Map<String, List<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            List<String> groups = map.getOrDefault(sortedWord, new ArrayList<>());
            groups.add(word);
            map.put(sortedWord, groups);
        }

        for (List<String> group : map.values()) {
            result.addAll(group);
        }

        System.out.printf("\nAnagram grouped: %s%n", result);
    }

}

