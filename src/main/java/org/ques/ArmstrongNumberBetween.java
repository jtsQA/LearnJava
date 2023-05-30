package org.ques;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumberBetween {

    public static void main(String[] args) {

        int start = 999;
        int end = 9999999;

        System.out.println("Armstrong numbers between " + start + " and " + end + ":");
        for (int number : findArmstrongNumbers(start, end)) {
            System.out.println(number);
        }
    }

    public static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        int digit;
        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static List<Integer> findArmstrongNumbers(int startNumber, int endNumber) {
        List<Integer> list = new ArrayList<>();
        for (int i = startNumber; i <= endNumber; i++) {
            if (isArmstrongNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
