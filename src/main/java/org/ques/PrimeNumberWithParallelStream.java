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
                .filter(PrimeNumberWithParallelStream::isPrimeWithStream)
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

    public static boolean isPrimeWithStream(int n) {
        return (n > 1 && IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0));
    }

    public static boolean isPrimeOptimised(int n) {

        if (n <= 1) return false;

        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }

    public static boolean isPrime(int n) {

        // Corner case
        if (n <= 1) return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
