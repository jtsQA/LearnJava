package org.learn.streams.functionalinterfaces;

import java.util.function.*;

public class FunctionInterfaceConcept {
    /*
    Interface Function<T,R>
    Type Parameters:
    T - the type of the input to the function
    R - the type of the result of the function

    Represents a function that accepts one argument and produces a result.
    This is a functional interface whose functional method is apply(Object).

    Refer -
    https://devdocs.io/openjdk~17/java.base/java/util/function/function
    https://www.c-sharpcorner.com/article/java-8-functional-interfaces/

    */

    public static void main(String[] args) {
//        function();
        understandingFunctionalInterfaces();
    }


    private static void function() {
        Function<String, Integer> func1 = x -> x.length();
        int length1 = func1.apply("Functional Interface was introduced with Java 8");
        System.out.println("func1 = " + length1);

        Function<String, Integer> func2 = String::length;
        int length2 = func2.apply("I'm learning it.");
        System.out.println("func2 = " + length2);

        //chaining function
        Function<Integer, Integer> func3 = x -> x * 2;
        int result = func2.andThen(func3).apply("This is Jithin");
        System.out.println("func3 = " + result);
    }

    private static void understandingFunctionalInterfaces() {
        // take one argument and returns boolean. method declaration :  boolean test(T t);
        Predicate<String> stringLengthCheckPredicate = (str) -> str.length() > 5;
        System.out.println("\nPredicate returns a boolean. \nIs string len greater than 5 ? string is : ThisIsTestString - " + stringLengthCheckPredicate.test("This"));

        // accept one argument and returns nothing. Method declaration : void accept(T t)
        Consumer<String> consumerStr = (str) -> System.out.println(str);
        consumerStr.accept("\nDo some logging work using this consumer which does not returns anything");

        // accepts one argument and produces a result. method declaration : R apply(T t);
        Function<String, Integer> getLowerCaseStringFunction = (str) -> str.length();
        System.out.println("\nFunction check : get string length : " + getLowerCaseStringFunction.apply("what is length of this string"));

        // accepts no argument and produces a result. method declaration is :  T get();
        Supplier<String> supplierProducesString = () -> "this is returned from supplier";
        System.out.println("\nThe string returns from supplier without any argument provided : " + supplierProducesString.get());

        // accepts two inputs of same type and returns same return type ,method declaration is : T apply(T, T).
        BinaryOperator<Integer> binaryOperatorAddition = (a, b) -> a + b;
        System.out.println("\nBinary operator check addition of two numbers : " + binaryOperatorAddition.apply(10, 15));

        // accept one argument and returns a result with same like argument return type , method declaration is T apply(T)
        UnaryOperator<Integer> unaryOperatorMultiplication = (a) -> a * a;
        System.out.println("\nUnary operator accept one argument and return same type of argument : " + unaryOperatorMultiplication.apply(10));

        // BiFunction  takes two objects of any type and returns object of any type. method declaration is : R apply(T t, U u);
        BiFunction<String, String, Integer> biFunctionStringConcateAndCheckLength = (str1, str2) -> str1.concat(str2).length();
        System.out.println("\nBiFunction takes two argument of any type and return object of any type here taking two Strings concat them and returning total length of them together " + biFunctionStringConcateAndCheckLength.apply("AAA", "BGBG"));

    }

}
