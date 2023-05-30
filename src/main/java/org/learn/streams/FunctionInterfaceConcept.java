package org.learn.streams;

import java.util.function.Function;

public class FunctionInterfaceConcept {
    /*
    Interface Function<T,R>
    Type Parameters:
    T - the type of the input to the function
    R - the type of the result of the function

    Represents a function that accepts one argument and produces a result.
    This is a functional interface whose functional method is apply(Object).

    Refer - https://devdocs.io/openjdk~17/java.base/java/util/function/function
    */

    public static void main(String[] args) {
        Function<String, Integer> func1 = x -> x.length();
        int length1 = func1.apply("This is Java 17");
        System.out.println("func1 = " + length1);

        Function<String, Integer> func2 = String::length;
        int length2 = func2.apply("I'm learning it.");
        System.out.println("func2 = " + length2);

        //chaining function
        Function<Integer, Integer> func3 = x -> x * 2;
        int result = func2.andThen(func3).apply("This is Jithin");
        System.out.println("func3 = " + result);

    }

}
