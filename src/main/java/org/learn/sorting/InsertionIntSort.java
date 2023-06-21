package org.learn.sorting;

import java.util.Arrays;

public class InsertionIntSort {

    public static void main(String[] args) {
        int[] intArray1 = {17, 7, 54, 21, 79, 63, 98, 82, 44};
        insertionSort(intArray1);
    }

    private static void insertionSort(int[] intArray) {
        int n = intArray.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && intArray[j - 1] > intArray[j]) {
                int temp = intArray[j];
                intArray[j] = intArray[j - 1];
                intArray[j - 1] = temp;
                j--;
            }
        }

        System.out.println("Insertion sorted array = " + Arrays.toString(intArray));
    }
}
