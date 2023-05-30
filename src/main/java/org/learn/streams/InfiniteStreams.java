package org.learn.streams;

import java.util.Random;
import java.util.stream.IntStream;

public class InfiniteStreams {

    public static void main(String[] args) {
        /*
        infinite streams used to generate infinite stream of data
        */

        //1. iterate()
        System.out.println("\nIterate: ");
        IntStream.iterate(1, n -> n * 11)
                .boxed() //is used instead of mapToObj(Integer::valueOf)
                .limit(9)
                .toList()
                .forEach(System.out::println);

        //2.generate()
        System.out.println("\nGenerate: ");
        Random random = new Random();
        random.ints(999, 10000)
                .boxed()
                .limit(9)
                .toList()
                .forEach(System.out::println);

    }
}
