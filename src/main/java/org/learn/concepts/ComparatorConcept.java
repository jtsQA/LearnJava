package org.learn.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorConcept {

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Sort by rating : (1) Create an object of ratingCompare
        //                  (2) Call Collections.sort
        //                  (3) Print Sorted list
        System.out.println("\nSorted by rating: ");
        RatingCompare ratingCompare = new RatingCompare();
        list.sort(ratingCompare);
        for (Movie movie : list)
            System.out.printf("Movie: %s | Rating: %.1f | Year: %d%n", movie.name(), movie.rating(), movie.year());

        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name: ");
        NameCompare nameCompare = new NameCompare();
        list.sort(nameCompare);
        for (Movie movie : list)
            System.out.printf("Movie: %s | Rating: %.1f | Year: %d%n", movie.name(), movie.rating(), movie.year());

        // Uses Comparable to sort by year
        System.out.println("\nSorted by year: ");
        Collections.sort(list);
        for (Movie movie : list)
            System.out.printf("Movie: %s | Rating: %.1f | Year: %d%n", movie.name(), movie.rating(), movie.year());
    }
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Double.compare(m1.rating(), m2.rating());
    }
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.name().compareTo(m2.name());
    }
}