package org.learn.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIteration {

    private static ArrayList<String> movies;

    public static void main(String[] args) {

        movies = new ArrayList<String>();
        movies.add("Kantara");
        movies.add("Guppy");
        movies.add("The Sky Is Pink");
        movies.add("Taare Zameen Par");
        movies.add("3 Idiots");
        movies.add("Kumbalangi Nights");

        usingForLoop();
        usingAdvancedForLoop();
        usingForEachLoopAndLambdaExpression();
        usingIteratorWithWhileLoop();
        usingIteratorWithLambdaAndForEachRemaining();
        usingListIterator();

    }

    //1. Using for loop with order/index
    public static void usingForLoop() {
        System.out.println("Using for loop with order/index - ");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(" movie " + (i + 1) + ": " + movies.get(i));
        }
    }

    //2. Using advanced for loop
    public static void usingAdvancedForLoop() {
        System.out.println("\nUsing advanced for loop - ");
        for (String s : movies) {
            System.out.println(" movie: " + s);
        }
    }

    //3. Using Java 8 with for each loop and lambda expression
    public static void usingForEachLoopAndLambdaExpression() {
        System.out.println("\nUsing Java 8 with for each loop and lambda expression - ");
        movies.forEach(movie -> {
            System.out.println("movie: " + movie);
        });
    }

    //4. Using Iterator with while loop
    public static void usingIteratorWithWhileLoop() {
        System.out.println("\nUsing Iterator with while loop - ");
        Iterator<String> movie = movies.iterator();
        while (movie.hasNext()) {
            System.out.println("movie: " + movie.next());
        }
    }

    //5. Using Iterator, Java 8 Lambda Expression and forEachRemaining method
    public static void usingIteratorWithLambdaAndForEachRemaining() {
        System.out.println("\nUsing Iterator, Java 8 Lambda Expression and forEachRemaining method - ");
        Iterator<String> movie = movies.iterator();
        movie.forEachRemaining(m -> System.out.println("movie: " + m));
    }

    //6. Using listIterator() to transverse in both direction
    public static void usingListIterator() {
        System.out.println("\nUsing listIterator() to transverse in both direction - ");
        ListIterator<String> strListItr = movies.listIterator(movies.size());
        while (strListItr.hasPrevious()) {
            System.out.println("movie: " + strListItr.previous());
        }
    }
}
