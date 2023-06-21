package org.learn.sorting;

import java.util.Arrays;

public class BubbleSortIntConcept {

    public static void main(String[] args) {
        int[] intArr1 = new int[]{3, 2, 6, 8, 4, 1, 5, 9, 7};
        bubbleSort(intArr1);

        int[] intArr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        bubbleSort(intArr2);

        int[] intArr3 = new int[]{31, 12, 65, 84, 47, 19, 58, 96, 73};
        bubbleSortUsingRecursion(intArr3, intArr3.length);
        System.out.println("Bubble sorting using recursion: " + Arrays.toString(intArr3));
    }

    private static void bubbleSort(int[] intArray) {
        int n = intArray.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j + 1];
                    intArray[j + 1] = intArray[j];
                    intArray[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;      // If no two elements were swapped by inner loop, then break
            }
        }
        System.out.println("Bubble sorted array = " + Arrays.toString(intArray));
    }

    private static void bubbleSortUsingRecursion(int[] intArray, int n) {

        // Base case
        if (n == 1) return;

        int count = 0;

        // One pass of bubble sort. After this pass, the largest element is moved (or bubbled) to end.
        for (int i = 0; i < n - 1; i++) {
            if (intArray[i] > intArray[i + 1]) {
                int temp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = temp;
                count = count + 1;
            }
        }

        // Check if any recursion happens or not, If any recursion is not happen then return
        if (count == 0) return;

        // Largest element is fixed, recur for remaining array
        bubbleSortUsingRecursion(intArray, n - 1);
    }
}
