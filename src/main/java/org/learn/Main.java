package org.learn;


import static org.learn.Main.testStatic;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }

        testStatic();

        Main m = new Main();
        m.test();
        Test.mainSub();
    }

    public void test() {
        System.out.println("Main Class - test method");
    }

    public static void testStatic(){
        System.out.println("Main Class - testStatic method");
    }

}

class Test {
    public static void mainSub() {
//        testStatic();
        Main m = new Main();
        m.test();
        Main.testStatic();
    }
}