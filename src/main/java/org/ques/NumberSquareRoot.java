package org.ques;

import java.util.stream.IntStream;

public class NumberSquareRoot {

    public static void main(String[] args) {

        int startNumber = 1;
        int endNumber = 50;

        IntStream.range(startNumber, endNumber)
                .parallel()
                .filter(num -> {
                    double squareRoot = findSquareRootUsingWhileLoop(num);
                    int roundedSquareRoot = (int) squareRoot;
                    return roundedSquareRoot * roundedSquareRoot == num;
                })
                .forEachOrdered(num -> {
                    double squareRoot = findSquareRootUsingWhileLoop(num);
                    System.out.printf("Square root of %d = %.2f%n", num, squareRoot);
                });

    }

    private static double findSquareRootUsingDoWhileLoop(int num) {

        double guess;
        double squareRoot = (double) num / 2;

        do {
            guess = squareRoot;
            squareRoot = (guess + (num / guess)) / 2;
        } while ((guess - squareRoot) != 0);

        return squareRoot;
    }

    private static double findSquareRootUsingWhileLoop(int num) {

        double guess = num / 2.0;
        double squareRoot = 0.0;

        while (squareRoot != guess) {
            squareRoot = guess;
            guess = (num / guess + guess) / 2.0;
        }

        return squareRoot;
    }
}
