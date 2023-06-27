package org.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsConcept {

    /**
     * Streams Flowchart:  source --> stream --> filter --> map --> collect --> sink
     * <p>
     * source: A source can be a collection, an array or an I/O channel.
     * filter: The filter method takes a predicate as an argument.
     * map: The map method takes a function as an argument.
     * collect: The collect method takes a collector as an argument.
     * sink: The sink consumes the stream.
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Create a stream from the list of numbers.
        Stream<Integer> stream = numbers.stream();

        // Filter the stream to only include even numbers.
        stream = stream.filter(number -> number % 2 == 0);

        // Map the stream to a new stream of strings that represent the square of each number.
        stream = stream.map(number -> number * number);

        // Collect the stream into a list.
        List<Integer> squares = stream.toList();

        // Print the list of squares.
        System.out.println(squares); // [4, 16, 36]


        //Stream operation to find even numbers in a list and getting the square of those numbers.
        numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).toList().forEach(System.out::println);
    }
}
