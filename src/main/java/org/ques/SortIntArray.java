package org.ques;

import java.util.Arrays;

public class SortIntArray {

    /*
    Part 1 - Given an array of 0s and 1s.
             Write a program to arrange the array in ascending order such that the all the 0s will be on the left followed by 1s.
             Does not use any predefined functions or sorting techniques like bubble sort. Solve it using the same array.
                input - int[] intArray = {0,1,1,1,0,0,1};
                output - 0,0,0,1,1,1,1
    Part 2 - The solution should be able to handle 2s and 3s, etc... if provided.
    */

    public static void main(String[] args) {
        int[] intArr1 = {0, 1, 1, 1, 0, 0, 1};
        sortIntArray(intArr1);
        partitionArray(intArr1);

        int[] intArr2 = {0, 1, 1, 2, 2, 3, 1, 4, 5, 4, 0, 3, 2, 3, 2, 1, 0, 1, 0};
        sortIntArray(intArr2);
        partitionArray(intArr2);
    }

    private static void sortIntArray(int[] intArr) {
        int n = intArr.length;
        int left = 0;
        int right = n - 1;
        int i = 0;

        while (i <= right) {
            if (intArr[i] == 0) {
                swap(intArr, i, left);
                left++;
                i++;
            } else if (intArr[i] == 1) {
                i++;
            } else {
                swap(intArr, i, right);
                right--;
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(intArr));
    }

    private static void partitionArray(int[] arr) {
        dualPivotQuickSort(arr, 0, arr.length - 1);
    }

    private static void dualPivotQuickSort(int[] arr, int low, int high) {
        if (high <= low) {
            return;
        }

        int pivot1 = arr[low];
        int pivot2 = arr[high];

        if (pivot1 > pivot2) {
            swap(arr, low, high);
            pivot1 = arr[low];
            pivot2 = arr[high];
        } else if (pivot1 == pivot2) {
            while (pivot1 == pivot2 && low < high) {
                low++;
                pivot1 = arr[low];
            }
        }

        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i <= gt) {
            int current = arr[i];
            if (current < pivot1) {
                swap(arr, i, lt);
                i++;
                lt++;
            } else if (current > pivot2) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, low, lt - 1);
        swap(arr, gt + 1, high);

        dualPivotQuickSort(arr, low, lt - 2);
        dualPivotQuickSort(arr, gt + 2, high);
        if (pivot1 < pivot2) {
            dualPivotQuickSort(arr, lt, gt);
        }

        System.out.println("Sorted Array by partitioning: " + Arrays.toString(arr));

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
