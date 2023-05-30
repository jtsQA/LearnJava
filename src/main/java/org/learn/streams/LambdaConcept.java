package org.learn.streams;

//SAM - Single Abstract Method
@FunctionalInterface
interface WebPage {

    /*
    FunctionalInterface -
    - allows only one abstract method
    - allows one static and default method from JDK 1.8 version
    - denoted by FunctionalInterface annotation
    */


    static void test1() {
    }

    void header(String title); //only one abstract method

    default void test2() {
    }
}

public class LambdaConcept {

    public static void main(String[] args) {

        WebPage wp1 = new WebPage() {
            @Override
            public void header(String title) {
                System.out.println("LambdaConcept.header - title: " + title);
            }
        };
        wp1.header("Override header method in WebPage interface");

        WebPage wp2 = n -> System.out.println("LambdaConcept.main - title: " + n);
        wp2.header("Lambda expression to override header method");
    }

}



