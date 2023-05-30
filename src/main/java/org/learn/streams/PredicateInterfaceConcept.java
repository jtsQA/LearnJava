package org.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterfaceConcept {

    /*
    Interface Predicate<T>
    Type Parameters:
    T - the type of the input to the predicate

    Represents a predicate (boolean-valued function) of one argument.
    This is a functional interface whose functional method is test(Object).

    Refer - https://devdocs.io/openjdk~17/java.base/java/util/function/predicate
            https://devdocs.io/openjdk~17/java.sql.rowset/javax/sql/rowset/predicate
    */

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> func1 = x -> x > 2 & x < 8;

//        List<Integer> numList = intList.stream().filter(func1).collect(Collectors.toList());
        List<Integer> numList1 = intList.stream().filter(func1).toList();
        System.out.println("numList1 = " + numList1);

        //predicate with && operator:
        List<Integer> numList2 = intList.stream().filter(x -> x > 3 && x < 7).toList();
        System.out.println("numList2 = " + numList2);

        //predicate with negate():
        List<String> strList = Arrays.asList("Jithin", "Jithi", "Jitin", "ji", "Java", "Jav", "ja");
        Predicate<String> func2 = x -> x.startsWith("Ja");

        List<String> nameList = strList.stream().filter(func2.negate()).toList();
        System.out.println("nameList = " + nameList);

    }
}
