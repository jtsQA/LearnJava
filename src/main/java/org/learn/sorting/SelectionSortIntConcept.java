package org.learn.sorting;

import java.util.Arrays;

public class SelectionSortIntConcept {

    public static void main(String[] args) {
        int[] intArray1 = {17, 7, 54, 21, 79, 63, 98, 82, 44};
        selectionSort(intArray1);

        int[] intArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        selectionSort(intArray2);
    }

    private static void selectionSort(int[] intArray) {
        int n = intArray.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {                   //n-1 --> find the second last index of the unsorted array
            int minIndex = i;                               //find the minimum element in unsorted array
            for (int j = i + 1; j < n; j++) {               //n --> find the last index of the unsorted array
                if (intArray[j] < intArray[minIndex]) {
                    minIndex = j;
                }
            }
            stableSwap(intArray, minIndex, i);            //swap the found minimum element with the first element
        }
        System.out.println("Selection Sort = " + Arrays.toString(intArray));
    }

    private static void swap(int[] intArray, int minIndex, int i) {
        int temp = intArray[minIndex];
        intArray[minIndex] = intArray[i];
        intArray[i] = temp;
    }

    private static void stableSwap(int[] intArray, int minIndex, int i) {
        int key = intArray[minIndex];
        while (minIndex > i) {
            intArray[minIndex] = intArray[minIndex - 1];
            minIndex--;
        }
        intArray[i] = key;
    }
}
