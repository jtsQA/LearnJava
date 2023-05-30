package org.learn.concepts;

public class FinalizeConcept {

    private final String test;

    public FinalizeConcept(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        System.out.println("finalize is a method");

        String test = "finalize ";

        FinalizeConcept fc1 = new FinalizeConcept(test + 1);
        FinalizeConcept fc2 = new FinalizeConcept(test + 2);
        FinalizeConcept fc3 = new FinalizeConcept(test + 3);

        // Nullifying references to make objects eligible for garbage collection
        fc1 = null;
        fc2 = null;
        fc3 = null;

        // Requesting garbage collection
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("FinalizeConcept.finalize");
        try {
            // Perform finalization logic here
            System.out.println("FinalizeConcept.finalize - inside try block - test: " + test);
        } finally {
            // Call superclass finalize method
            System.out.println("FinalizeConcept.finalize - inside finally block");
            super.finalize();
        }
    }
}
