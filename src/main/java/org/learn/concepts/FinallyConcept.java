package org.learn.concepts;

public class FinallyConcept {

    public static void main(String[] args) {
        System.out.println("finally is a block");
        test1();
        test2();
        division(10);
    }

    public static void test1() {
        try {
            System.out.println("FinallyConcept.test1 - inside try block");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("FinallyConcept.test1 - inside catch block - Exception");
        } finally {
            System.out.println("FinallyConcept.test1 - inside finally block");
        }
    }

    public static void test2() {
        try {
            System.out.println("FinallyConcept.test2 - inside try block");
        } finally {
            System.out.println("FinallyConcept.test2 - inside finally block");
        }
    }

    public static void division(int i) {
        try {
            System.out.println("FinallyConcept.division - inside try block");
            System.out.println("Division by 0 => ArithmeticException, but using wrong Exception in Catch block does not catches the actual exception");
            int k = i/0;
        } catch (NullPointerException e) {
            System.out.println("FinallyConcept.division - inside catch block - NullPointerException");
        } finally {
            System.out.println("FinallyConcept.division - inside finally block");
        }
    }
}
