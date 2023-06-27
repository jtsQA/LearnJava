package org.learn.streams.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceConcept {

    /*
    Interface Consumer<T>
    Type Parameters:
    T - the type of the input to the operation

    All Known Subinterfaces:
    Stream.Builder<T>

    Refer - https://devdocs.io/openjdk~17/java.base/java/util/function/consumer
    */

    public static void main(String[] args) {

        Consumer<String> func1 = x -> System.out.println("func1 = " + x);
        func1.accept("Learning Consumer Interface");

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        intList.forEach(x -> System.out.println("intList = " + x));

    }
}
