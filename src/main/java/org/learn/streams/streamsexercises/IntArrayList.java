package org.learn.streams.streamsexercises;

import java.util.HashSet;
import java.util.List;

public class IntArrayList {

    public static void main(String[] args) {
        List<Integer> intList1 = List.of(1, 2, 3, 4, 5, 6, 8, 8, 7, 6, 5, 4, 3, 2);
        List<Integer> intList2 = List.of(1, -2, 3, 4, 5, -6, 8, -8, -7, 2, 6, 5, 4, -3, 2);

//        sumOfNumbersInArrayList(intList1);
//        sumOfNumbersInArrayList(intList2);
//
//        averageOfNumbersInArrayList(intList1);
//        averageOfNumbersInArrayList(intList2);

        squareAndGetAvgForNumbersGreaterThan100(intList1);

//        getNumbersStaringWith(intList2, 2);
//        getEvenAndOddNumbers(intList1);
//        getDuplicates(intList1);
    }

    private static void sumOfNumbersInArrayList(List<Integer> intList) {
        Integer sum1 = intList.stream().reduce(0, (a, b) -> a + b);
        Integer sum2 = intList.stream().reduce(0, Integer::sum);

        System.out.println("\nSum of numbers using lambdas: " + sum1);
        System.out.println("Sum of numbers using method reference: " + sum2);
    }

    private static void averageOfNumbersInArrayList(List<Integer> intList) {
        double average1 = intList.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("\nAverage of numbers using average function: " + average1);

        double average2 = intList.stream().mapToInt(Integer::intValue).summaryStatistics().getAverage();
        System.out.println("Average of numbers using summaryStatistics: " + average2);
    }

    private static void squareAndGetAvgForNumbersGreaterThan100(List<Integer> intList) {
        double calNum1 = intList.stream().map(e -> e * e).filter(e -> e > 100).mapToInt(e -> e).average().getAsDouble();
        System.out.println("\nSquare and get average for numbers greater than 100 using average function: " + calNum1);

        double calNum2 = intList.stream().map(x -> x * x).filter(x -> x > 100).mapToInt(Integer::intValue).summaryStatistics().getAverage();
        System.out.println("\nSquare and get average for numbers greater than 100 using summaryStatistics: " + calNum2);
    }

    private static void getNumbersStaringWith(List<Integer> intList, int n) {
        System.out.println("\nGetNumbersStaringWith '" + n + "' are: ");
        intList.stream().filter(x -> x.toString().startsWith("2") || x.toString().startsWith("-2")).forEach(System.out::println);
    }

    private static void getEvenAndOddNumbers(List<Integer> intList) {
        System.out.println("\nEven Numbers: ");
        intList.stream().sorted().filter(x -> x % 2 == 0).forEach(System.out::println);
        System.out.println("\nOdd Numbers: ");
        intList.stream().sorted().filter(x -> x % 2 != 0).forEach(System.out::println);
    }

    private static void getDuplicates(List<Integer> intList) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println("\nDuplicate Numbers: ");
        intList.stream().filter(x -> !set.add(x)).forEach(System.out::println);
    }

}
