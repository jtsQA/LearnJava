package org.ques;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String[] strArray1 = {"ADOBECODEBANC", "ADOBECODBAN", "ADBECODEBAN", "ADOBEODANC"};
        String str2 = "ABC";
        minimumWindowSubstring(strArray1, str2);
    }

    private static void minimumWindowSubstring(String[] strArray1, String str2) {
        System.out.printf("\nMinimum window substring: ");

        for (String str1 : strArray1) {
            findMinimumWindowSubstring(str1, str2);
        }
    }


    private static void findMinimumWindowSubstring(String str1, String str2) {
        Map<Character, Integer> windowMap = new HashMap<>();    //stores the frequency of each character in the target string str2
        Map<Character, Integer> targetMap = new HashMap<>();    //stores the frequency of characters in the current window.

        for (char c : str2.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;                //to define the window boundaries.
        int minStart = 0, minEnd = 0;           //to keep track of the start and end indices of the minimum window substring
        int count = 0;                          //to keep track of the no:of characters in str2 that are included in the window
        int minLength = Integer.MAX_VALUE;      //to store the minimum length of the window substring found so far.

        /*
        1. Move the right pointer to expand the window:
            * Increment the frequency of the character at right in windowMap.
            * If the frequency of the current character in windowMap is less than or equal to its frequency in targetMap, increment count.

        2. When all characters in str2 are included in the window (i.e., count equals the length of str2):
            > Update the minimum length and the minimum window indices if the current window is smaller.
            > Move the left pointer to contract the window:
                >> Decrement the frequency of the character at left in windowMap.
                >> If the frequency of the character becomes less than its frequency in targetMap, decrement count.
            > Repeat step 4 until count is less than the length of str2.

        3. Repeat steps 3-4 until the right pointer reaches the end of the string.

        4. If a minimum window substring is found, return it; otherwise, return an empty string.
        */

        while (right < str1.length()) {
            char rightChar = str1.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (targetMap.containsKey(rightChar) && windowMap.get(rightChar) <= targetMap.get(rightChar)) {
                count++;        //
            }

            while (count == str2.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;       //to store the substring length
                    minStart = left;                    //to store the substring start index
                    minEnd = right + 1;                 //to store the substring end index
                }

                char leftChar = str1.charAt(left);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);

                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    count--;
                }
                left++;
            }
            right++;
        }

        String minWindowStr = str1.substring(minStart, minEnd);
        System.out.printf("\nString '%s' containing '%s': %s and length: %d", str1, str2, minWindowStr, minLength);
    }

    /*
    Time and Space complexity -
    The time complexity of this solution is O(m + n), where m is the length of string str1 and n is the length of string str2.
    The space complexity is O(m + n) as well, considering the space required for the frequency maps.
    */

}
