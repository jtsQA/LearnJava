package org.learn.streams.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorInterfaceConcept {

    /*
    Interface UnaryOperator<T>
    Type Parameters:
    T - the type of the operand and result of the operator

    All Superinterfaces:
    Function<T,T>

    Represents an operation on a single operand that produces a result of the same type as its operand.
    This is a specialization of Function for the case where the operand and result are of the same type.
    This is a functional interface whose functional method is Function.apply(Object).

    Refer - https://devdocs.io/openjdk~17/java.base/java/util/function/unaryoperator
    */

    public static void main(String[] args) {

        //Extends the Function Interface and implements the same function
        UnaryOperator<Integer> func1 = x -> x * 5;
        int result1 = func1.apply(21);
        System.out.println("func1 = " + result1);

        //Function Interface
        Function<Integer, Integer> func2 = x -> x * 3;
        int result2 = func2.apply(33);
        System.out.println("func2 = " + result2);

        List<String> langList = new ArrayList<String>();
        langList.add("Java");
        langList.add("Python");
        langList.add("TypeScript");
        System.out.println("langList = " + langList);

        langList.replaceAll(ele -> ele + " programming");
        System.out.println("langList = " + langList);
    }
}
