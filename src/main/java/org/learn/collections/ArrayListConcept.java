package org.learn.collections;

import java.util.ArrayList;

public class ArrayListConcept {

    public static void main(String[] args) {
        nonGenericArrayList();
    }

    public static void nonGenericArrayList() {
        ArrayList al = new ArrayList();
        al.add(123);
        al.add('c');
        al.add("ArrayList");
        al.add(true);

        System.out.println("Non-Generic ArrayList: " + al);
    }

}
