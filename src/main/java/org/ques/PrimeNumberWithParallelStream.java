package org.ques;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberWithParallelStream {

    public static void main(String[] args) {

        long t1, t2;
        t1 = System.currentTimeMillis();
        long count = Stream.iterate(0, n -> n + 1)
                .limit(500000)
                .parallel() //comment this line for sequential execution
                .filter(PrimeNumberWithParallelStream::isPrime)
                .peek(System.out::println)
                .count();

        System.out.println("Total count of prime numbers: " + count);
        t2 = System.currentTimeMillis();
        System.out.println("Total execution time: " + (t2 - t1) / 1000 + "sec");

        /*
        Sequential Execution - time: 36 seconds and count: 41538
        Parallel Execution   - time: 15 seconds and count: 41538
        */
    }

    public static boolean isPrime(int n) {
        return (n > 1 && IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0));
    }
}
