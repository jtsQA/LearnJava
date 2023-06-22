package org.learn.threads;

public class GoogleTestRunner {

    public static void main(String[] args) {
//        Thread t1 = new GoogleFeatureThread("chrome thread", "chrome");
        Thread t2 = new GoogleFeatureThread("safari thread", "safari");

//        t1.start();
        t2.start();
    }
}
