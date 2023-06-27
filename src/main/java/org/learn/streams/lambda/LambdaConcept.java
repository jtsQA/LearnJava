package org.learn.streams.lambda;

import java.util.stream.IntStream;

//SAM - Single Abstract Method
@FunctionalInterface
interface WebInterface {

    /*
    FunctionalInterface -
    - allows only one abstract method
    - allows one static and default method from JDK 1.8 version
    - denoted by FunctionalInterface annotation
    */

    static void test1() {
    }

    void title(String title); //only one abstract method

    default void test2() {
    }
}

public class LambdaConcept {

    public static void main(String[] args) {

//        sumOfNumbers(17);

        lambdasConcept();
    }

    /*
    Lambdas are anonymous functions that can be used to express computations in a concise way.
    Lambda expressions can be only used where functional interface is expected.
    It let us provide implementation of functional interface directly inline and treat whole expression as instance of a functional interface.
    */

    private static void lambdasConcept() {
        WebInterface wp1 = new WebInterface() {
            @Override
            public void title(String title) {
                System.out.println("\n\nLambdaConcept.title - title: " + title);
            }
        };

        WebInterface wp2 = new WebInterface() {
            @Override
            public void title(String title) {
                System.out.println("\n\nLambdaConcept.title - title: " + title);
            }
        };

        wp1.title("\nOverride title method in WebInterface - wp1");
        wp2.title("\nOverride title method in WebInterface - wp2");


        WebInterface wp3 = n -> System.out.println("LambdaConcept.main - title: " + n);
        wp3.title("\nLambda expression to override title method - wp3");
    }

    private static void sumOfNumbers(int n) {

        int sum = IntStream.range(0, n + 1).reduce(0, (a, b) -> a + b);
//        int sum = IntStream.range(0, n + 1).reduce(0, Integer::sum);

        /*
        The lambda expression takes two integers as input and returns an integer.
        In this case, the lambda expression simply adds the two integers together.
        */

        System.out.printf("Sum of numbers from 0 to %d = %d", n, sum);
    }
}



