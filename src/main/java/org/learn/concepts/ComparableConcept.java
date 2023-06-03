package org.learn.concepts;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableConcept {

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println("\nMovies after sorting: ");
        for (Movie movie : list) {
            System.out.printf("Movie: %s | Rating: %.1f | Year: %d%n", movie.name(), movie.rating(), movie.year());
        }
    }
}

// A class 'Movie' that implements Comparable
record Movie(String name, double rating, int year) implements Comparable<Movie> {

    // Used to sort movies by year
    public int compareTo(Movie m) {
        return this.year - m.year;
    }
}