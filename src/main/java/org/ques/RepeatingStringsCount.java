package org.ques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatingStringsCount {

    private static Map<String, Long> stringsCountMap;

    public static void main(String[] args) {
        String[] strArray = {"java", "selenium", "testng", "Java", "maven", "selenium", "java", "testng", "selenium", "java"};
        findRepeatingStringUsingMap(strArray);
        findRepeatingStringUsingStreams(strArray);
        printRepeatingStrings(strArray);
    }

    private static void findRepeatingStringUsingMap(String[] strArray) {
        stringsCountMap = new HashMap<>();
        for (String s : strArray) {
            stringsCountMap.put(s, stringsCountMap.getOrDefault(s, 0L) + 1);
        }
        System.out.println("\nRepeating strings count using Map: \n" + stringsCountMap);
    }

    private static void findRepeatingStringUsingStreams(String[] strArray) {
        stringsCountMap = new HashMap<>();
        stringsCountMap = Arrays.stream(strArray).sorted().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("\nRepeating strings count using Stream: \n" + stringsCountMap);
    }

    private static void bubbleSort(String[] strArray) {
        int n = strArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (strArray[i].compareTo(strArray[j]) > 0) {
                    //swapping the values
                    String temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }
    }

    private static void printRepeatingStrings(String[] strArray) {
        bubbleSort(strArray);
        String currentItem = strArray[0];
        int count = 1;
        System.out.println("\nPrinting repeating strings count: ");
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[i].equalsIgnoreCase(currentItem)) {
                count++;
            } else {
                System.out.println(currentItem + " = " + count);
                currentItem = strArray[i];
                count = 1;
            }
        }
        System.out.println(currentItem + " = " + count);
    }
}
