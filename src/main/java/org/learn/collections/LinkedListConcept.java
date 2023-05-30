package org.learn.collections;

import com.github.dockerjava.api.model.Link;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class LinkedListConcept {

    public static void main(String[] args) {
        nonGenericLinkedList();
        stringLinkedList();
    }

    public static void nonGenericLinkedList() {
        LinkedList ll = new LinkedList();
        ll.add(123);
        ll.add('c');
        ll.add("LinkedList");
        ll.add(true);
        System.out.println("Non-Generic LinkedList: " + ll);
    }

    public static void stringLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("test");
        ll.add("String");
        ll.add("LinkedList");
        ll.add("Java");
        System.out.println("Generic - LinkedList<String>: " + ll);

        //Add first
        ll.addFirst("firstLL");
        //Add Last
        ll.addLast("lastLL");
        System.out.println("LinkedList<String> - addFirst and addLast: " + ll);
        //Add based on index
        ll.add(4, "List");
        ll.add(4, "String");
        ll.add(4, "Java");
        System.out.println("LinkedList<String> - add(4): " + ll);

        //Get value based on index
        System.out.println("LinkedList<String> - get(4): " + ll.get(4));
        //Get first value
        System.out.println("LinkedList<String> - getFirst(): " + ll.getFirst());
        //Get last value
        System.out.println("LinkedList<String> - getLast(): " + ll.getLast());

        //Set value based on index
        ll.set(4, "setTo4th");
        System.out.println("LinkedList<String> - set(4): " + ll);

        //Remove first
        ll.removeFirst();
        //Remove last
        ll.removeLast();
        System.out.println("LinkedList<String> - removeFirst and removeLast: " + ll);
        //Remove based on index
        ll.remove(0);
        System.out.println("LinkedList<String> - remove(0): " + ll);
        //Remove based first occurrence
        ll.removeFirstOccurrence("String");
        System.out.println("LinkedList<String> - removeFirstOccurrence(String): " + ll);
        //Remove based last occurrence
        ll.removeLastOccurrence("Java");
        System.out.println("LinkedList<String> - removeLastOccurrence(Java): " + ll);
        //Remove based on condition
        ll.removeIf(new StringPredicate());
        System.out.println("LinkedList<String> - removeIf(new StringPredicate()): " + ll);


        //Print all values from the LinkedList

        //Using for loop
        for (int i = 0; i < ll.size(); i++) {
            System.out.println("for loop: " + ll.get(i));
        }

        //Using advance for loop
        for (String s : ll) {
            System.out.println("advanced for loop: " + s);
        }

        //Using While loop
        int i = 0;
        while (i < ll.size()) {
            System.out.println("while loop: " + ll.get(i));
            i++;
        }

        //Using Iterator
        Iterator<String> itr = ll.iterator();
        while(itr.hasNext()){
            System.out.println("Iterator: " + itr.next());
        }

    }
}

class StringPredicate implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return s.startsWith("s") && s.contains("4");
    }
}
