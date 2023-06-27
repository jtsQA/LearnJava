package org.learn.streams.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpAndMethodReferences {
    private static List<String> movies;

    public static void main(String[] args) {

        movies = new ArrayList<String>();
        movies.add("Kantara");
        movies.add("Guppy");
        movies.add("The Sky Is Pink");
        movies.add("Taare Zameen Par");
        movies.add("3 Idiots");
        movies.add("Kumbalangi Nights");

        usingAnonymousClass();
        usingLambdaExp();
        usingMethodReferences();
    }

    //1. Using Anonymous Class:
    public static void usingAnonymousClass() {
        System.out.println("Using Anonymous Class - ");
        movies.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("movie: " + s);
            }
        });
    }

    //2. Using Lambda Expression:
    public static void usingLambdaExp() {
        System.out.println("\nUsing Lambda Expression - ");
        movies.forEach(s -> System.out.println("movie: " + s));
    }

    //3. Using Method References:
    public static void usingMethodReferences() {
        System.out.println("\nUsing Method References - ");
        movies.forEach(System.out::println);
    }
}
