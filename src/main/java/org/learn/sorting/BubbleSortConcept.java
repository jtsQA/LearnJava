package org.learn.sorting;

import java.util.Arrays;

public class BubbleSortConcept {

    public static void main(String[] args) {
        int[] intArr1 = new int[]{3, 2, 6, 8, 4, 1, 5, 9, 7};
        System.out.println(Arrays.toString(bubbleSort(intArr1)));

        int[] intArr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(bubbleSort(intArr2)));

    }

    private static int[] bubbleSort(int[] intArr) {

        boolean flag = false;

        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[i] > intArr[j]) {
                    int temp = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        return intArr;
    }
}
