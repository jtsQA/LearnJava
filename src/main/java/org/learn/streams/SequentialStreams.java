package org.learn.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialStreams {

    public static void main(String[] args) {

        System.out.println("\nFirst name containing u: ");
        Stream.of("Aaron", "Sanju", "Kumar", "Don", "Nelson")
                .filter(x -> x.contains("u"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\nMax first num from String: ");
        Arrays.asList("a1", "b2", "c3", "a2", "b3", "c1", "a3", "b1", "c2")
                .stream()
                .filter(x -> x.contains("3"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\nNumbers from 1 to 10: ");
        IntStream.range(1, 11).forEach(System.out::println);
        System.out.println("\nSum of number from 10 to 20: " + IntStream.rangeClosed(10, 20).sum());
        System.out.println("\nInteger summary from 19 to 32: \n" + IntStream.rangeClosed(19, 32).summaryStatistics().toString());

        System.out.println("\nAverage of given numbers with condition: ");
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .map(n -> n * 3 + 1)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\nAverage of given numbers using IntStream: ");
        Arrays.stream(IntStream.rangeClosed(100, 121).toArray())
                .map(n -> n * 3 + 1)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\nMax value from String:");
        Stream.of("n11", "n13", "n19", "n37", "n44", "n58", "n62")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("\nDouble to String objects:");
        Stream.of(1.3, 4.6, 7.2, 6.1, 9.5, 2.8)
                .mapToInt(Double::intValue)
                .filter(i -> i % 2 == 0)
                .sorted()
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        System.out.println("\nIterate, limit and filter odd numbers:");
        Stream.iterate(5, n -> n + 1)
                .filter(n -> n % 2 != 0)
                .limit(8)
                .forEach(System.out::println);


    }

}
