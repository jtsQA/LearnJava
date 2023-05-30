package org.ques;

public class RepeatingNumbersCount {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 4, 3, 2, 3, 2, 3};
        findRepeatingNumbersCount(array);
    }

    public static void findRepeatingNumbersCount(int[] array) {
        // Sort the array using sort function
//        Arrays.sort(array);

        // Sort the array using for loops
        int temp = 0;   // Variable to store the temp value
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        // Variables to store the current item and count
        int currentItem = array[0];
        int count = 1;

        // Iterate through the array starting from the second element
        for (int i = 1; i < array.length; i++) {

            // If the current element is the same as the previous one, increase the count
            if (array[i] == currentItem) {
                count++;
            } else {
                // Print the count of the previous item
                System.out.println("Item " + currentItem + ": " + count);

                // Update the current item and reset the count for the new item
                currentItem = array[i];
                count = 1;
            }
        }

        // Print the count of the last item
        System.out.println("Item " + currentItem + ": " + count);
    }

}
