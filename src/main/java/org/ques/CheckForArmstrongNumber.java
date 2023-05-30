package org.ques;

public class CheckForArmstrongNumber {

    public static void main(String[] args) {
        int number = 9474;

        if (isArmstrongNumber(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
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
}
