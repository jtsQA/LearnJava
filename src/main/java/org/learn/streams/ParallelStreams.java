package org.learn.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {

        ForkJoinPool corePool = ForkJoinPool.commonPool();
        System.out.println("No: of cores: " + corePool.getParallelism());

        System.out.println("\nNormal Stream to print all names from Stream: ");
        Stream.of("Aaron", "Sanju", "Kumar", "Don", "Nelson")
                .forEach(System.out::println);

        System.out.println("\nParallel Stream to print all names from Stream: ");
        Stream.of("Aaron", "Sanju", "Kumar", "Don", "Nelson")
                .parallel()
                .forEach(System.out::println);

        System.out.println("\nNormal Stream to print all names from Array: ");
        Arrays.asList("Aaron", "Sanju", "Kumar", "Don", "Nelson")
                .forEach(System.out::println);

        System.out.println("\nParallel Stream to print all names from Array: ");
        Arrays.asList("Aaron", "Sanju", "Kumar", "Don", "Nelson")
                .parallelStream()
                .forEach(System.out::println);

        System.out.println("\nNormal Stream to print values from 100 to 111: ");
        IntStream.rangeClosed(100, 111)
                .forEach(System.out::println);

        System.out.println("\nParallel Stream to print values from 100 to 111: ");
        IntStream.rangeClosed(100, 111)
                .parallel()
                .forEach(System.out::println);

        System.out.println("\nNormal Stream to print alphabets: ");
        getAlphabetList()
                .forEach(System.out::println);

        System.out.println("\nParallel  Stream to print alphabets: ");
        getAlphabetList()
                .parallelStream()
                .forEach(System.out::println);

        System.out.println("Verify whether it is Parallel execution or not: " +
                IntStream.rangeClosed(11, 18)
                        .isParallel());

        System.out.println("Verify whether it is Parallel execution or not: " +
                IntStream.rangeClosed(11, 18)
                        .parallel()
                        .isParallel());

    }

    public static List<String> getAlphabetList() {
        List<String> alphabets = new ArrayList<String>();
        int i = 97;
        while (i <= 122) {
            char c = (char) i;
            alphabets.add(String.valueOf(c));
            i++;
        }
        return alphabets;
    }
}
