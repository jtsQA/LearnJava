package org.learn.streams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorInterfaceConcept {

    /*
    Interface BinaryOperator<T>
    Type Parameters:
    T - the type of the operands and result of the operator

    All Superinterfaces:
    BiFunction<T,T,T>

    Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
    This is a specialization of BiFunction for the case where the operands and the result are all of the same type.
    This is a functional interface whose functional method is BiFunction.apply(Object, Object).

    Refer - https://devdocs.io/openjdk~17/java.base/java/util/function/binaryoperator
    */

    public static void main(String[] args) {

        //Extends the BiFunction Interface and implements the same function
        BinaryOperator<Integer> func1 = (x1, x2) -> x1 + x2;
        int result1 = func1.apply(10, 20);
        System.out.println("func1 = " + result1);

        //BiFunction Interface
        BiFunction<Integer, Integer, Integer> func2 = Integer::sum;
        int result2 = func1.apply(30, 40);
        System.out.println("func2 = " + result2);

    }
}
