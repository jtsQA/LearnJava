package org.learn.selenium;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FindAllBrokenLinks {

    private static WebDriver driver;
    private static List<String> validLinks, invalidLinks;
    private static long t1, t2;

    public static void main(String[] args) {
//        findBrokenLinksUsingAdvancedForLoop(); //execution time in safari mode is 138 seconds
        findBrokenLinksUsingStreams(); //execution time in chrome headless mode is 114 seconds
    }

    public static void findBrokenLinksUsingAdvancedForLoop() {
        try {
            validLinks = new ArrayList<>();
            invalidLinks = new ArrayList<>();
            driver = DriverManager.safariBrowserHeadless();
            driver.get("https://www.amazon.in/");
            List<WebElement> links = driver.findElements(By.tagName("a"));

            t1 = System.currentTimeMillis();
            for (WebElement link : links) {
                String url = link.getAttribute("href");

                if (url != null && !url.isEmpty() && !url.isBlank()) {
                    try {
                        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
                        connection.setRequestMethod("HEAD");

                        if (connection.getResponseCode() >= 400) {
                            invalidLinks.add(url);
                        } else {
                            validLinks.add(url);
                        }
                    } catch (IOException e) {
                        System.out.println("Error checking link: " + url);
                    }
                }
            }
            t2 = System.currentTimeMillis();
            System.out.println("Total execution time in seconds: " + (t2 - t1) / 1000);

            System.out.println("\n Valid links count: " + validLinks.size() + ", and the links are: ");
            for (String link : validLinks) {
                System.out.println(link);
            }

            System.out.println("\n Invalid links count: " + invalidLinks.size() + ", and the links are: ");
            for (String link : invalidLinks) {
                System.out.println(link);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void findBrokenLinksUsingStreams() {
        try {
            validLinks = new ArrayList<>();
            invalidLinks = new ArrayList<>();
            driver = DriverManager.chromeBrowserHeadless();
            driver.get("https://www.amazon.in/");
            List<WebElement> links = driver.findElements(By.tagName("a"));

            t1 = System.currentTimeMillis();
            links.stream()
                    .map(link -> link.getAttribute("href"))
                    .filter(url -> url != null && !(url.isEmpty() && url.isBlank()))
                    .forEach(url -> {
                        try {
                            HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
                            connection.setRequestMethod("HEAD");

                            if (connection.getResponseCode() >= 400) {
                                invalidLinks.add(url);
                            } else {
                                validLinks.add(url);
                            }
                        } catch (IOException e) {
                            System.out.println("Error checking link: " + url);
                        }
                    });
            t2 = System.currentTimeMillis();
            System.out.println("Total execution time in seconds: " + (t2 - t1) / 1000);

            System.out.println("\n Valid links are: ");
            long validCount = validLinks.stream()
                    .peek(System.out::println)
                    .count();
            System.out.println("Valid links count = " + validCount);

            System.out.println("\n Invalid links are: ");
            long invalidCount = invalidLinks.stream()
                    .peek(System.out::println)
                    .count();
            System.out.println("Invalid links count = " + invalidCount);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
