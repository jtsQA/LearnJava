package org.learn.streams.functionalinterfaces;

import java.util.function.Supplier;

public class SupplierInterfaceConcept {

    /*
    Interface Supplier<T>
    Type Parameters:
    T - the type of results supplied by this supplier

    All Known Subinterfaces:
    ServiceLoader.Provider<S>

    All Known Implementing Classes:
    GuardingDynamicLinkerExporter

    Refer - https://devdocs.io/openjdk~17/java.base/java/util/function/supplier
    */

    public static void main(String[] args) {
        getText(() -> "Supplier");
        getText(() -> "Interface");
        getText(() -> "Learning");
    }

    public static void getText(Supplier<String> text) {
        System.out.println("\ntext = " + text.get());
        System.out.println("text length = " + text.get().length());
    }

}
