package org.ques;

import java.util.Arrays;

public class ArrangeOddEvenArray {

    public static void main(String[] args) {
        int[] intArray = {1, 3, 2, 5, 6, 4, 7, 8, 9};
        arrangeOddEvenArray(intArray);
    }

    private static void arrangeOddEvenArray(int[] intArray) {


        int lastIndex = intArray.length;

        int evenIndex = 0;
        for (int i = 0; i < lastIndex; i++) {
            if (intArray[i] % 2 == 0) {
                swap(intArray, i, evenIndex);
                evenIndex++;
            }
        }

        // Sort even numbers in ascending order
        bubbleSort(intArray, 0, evenIndex);

        // Sort odd numbers in ascending order
        bubbleSort(intArray, evenIndex, lastIndex);

        System.out.println("Array arranged in even and odd order: " + Arrays.toString(intArray));
    }

    private static void swap(int[] intArray, int i, int j) {
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }

    private static void bubbleSort(int[] intArray, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            for (int j = start; j < end - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    swap(intArray, j, j + 1);
                }
            }
        }
    }

}
