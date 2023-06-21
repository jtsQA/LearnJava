package org.ques;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class MergeSortedArrays {

    /*
    Given two sorted array, create one array using them which should also be sorted.
        Array 1 : [10,30,50,70,90]
        Array 2 : [20, 40, 60, 80, 100]
        Expected : [10,20,30,40,50,60,70,80,90,100]
    */

    public static void main(String[] args) {
        int[] array1 = {10, 30, 100, 110, 120};
        int[] array2 = {20, 40, 50, 60, 70, 80, 90};
        usingWhileLoopInMergeSortAlgorithm(array1, array2);
        usingForLoopInMergeSortAlgorithm(array1, array2);
        usingTreeSet(array1, array2);
        usingPriorityQueue(array1, array2);
    }

    private static void usingWhileLoopInMergeSortAlgorithm(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                mergedArray[k] = array1[i];
                i++;
            } else {
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from array1, if any
        while (i < array1.length) {
            mergedArray[k] = array1[i];
            i++;
            k++;
        }

        // Copy the remaining elements from array2, if any
        while (j < array2.length) {
            mergedArray[k] = array2[j];
            j++;
            k++;
        }

        System.out.println("\nUsing while loop in Merge Sort Algorithm = " + Arrays.toString(mergedArray));
    }

    private static void usingForLoopInMergeSortAlgorithm(int[] array1, int[] array2) {
        int arrLen1 = array1.length;
        int arrLen2 = array2.length;
        int mergedArrLen = arrLen1 + arrLen2;

        int[] mergedArray = new int[mergedArrLen];
        int i = 0, j = 0, k = 0;

        for (; i < arrLen1 && j < arrLen2 && k < mergedArrLen; k++) {
            if (array1[i] <= array2[j]) {
                mergedArray[k] = array1[i];
                i++;
            } else {
                mergedArray[k] = array2[j];
                j++;
            }
        }

        // Copy the remaining elements from array1, if any
        for (; i < arrLen1 && k < mergedArrLen; i++, k++) {
            mergedArray[k] = array1[i];
        }

        // Copy the remaining elements from array2, if any
        for (; j < arrLen2 && k < mergedArrLen; j++, k++) {
            mergedArray[k] = array2[j];
        }

        System.out.println("\nUsing for loop in Merge Sort Algorithm = " + Arrays.toString(mergedArray));
    }

    private static void usingTreeSet(int[] array1, int[] array2) {
        // Create a tree set to store the elements in sorted order
        Set<Integer> intSet = new TreeSet<>();

        // Add all elements from both arrays to the tree set
        for (int i : array1) {
            intSet.add(i);
        }

        for (int j : array2) {
            intSet.add(j);
        }

        System.out.println("\nUsing TreeSet = " + intSet);
    }

    private static void usingPriorityQueue(int[] array1, int[] array2) {
        // Create a priority queue to store the elements in sorted order
        PriorityQueue<Integer> intPQ = new PriorityQueue<>();

        // Add all elements from both arrays to the priority queue
        for (int i : array1) {
            intPQ.add(i);
        }

        for (int j : array2) {
            intPQ.add(j);
        }

        // Create a new array to store the merged result
        int[] merged = new int[array1.length + array2.length];

        // Extract the elements from the priority queue in sorted order
        for (int i = 0; i < merged.length; i++) {
            merged[i] = intPQ.poll();
        }

        System.out.println("\nUsing Priority Queue = " + Arrays.toString(merged));
    }

}
