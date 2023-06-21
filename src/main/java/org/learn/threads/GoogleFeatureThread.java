package org.learn.threads;

public class GoogleFeatureThread extends Thread {

    public String browser;
    GooglePage googlePage;

    public GoogleFeatureThread(String threadName, String browser) {
        super(threadName);
        this.browser = browser;
        googlePage = new GooglePage();
    }

    @Override
    public void run() {
        System.out.println("\nThread started --> " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            googlePage.googleSearchText(browser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            googlePage.tearDown();
        }
        System.out.println("Thread ended --> " + Thread.currentThread().getName());
    }
}
