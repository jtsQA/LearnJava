package org.learn.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class FindAllLinks {

    public static void main(String[] args) {

        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        try {
            driver.get("https://www.amazon.in/");

            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Total links available in the page = " + links.size());

            /*
            //1. Using advanced for loop and printing all the links
            System.out.println("\nUsing advanced for loop: ");
            for (WebElement link : links) {
                System.out.println(link.getText());
            }
            */

            /*
            //2. Using forEach loop
            System.out.println("\nUsing for each loop: ");
            links.forEach(l -> System.out.println(l.getText()));
            */

            /*
            //3. Using streams
            System.out.println("\nUsing streams: ");
            long count = links.stream()
                    .map(WebElement::getText)
                    .filter(text -> !(text.isBlank() || text.isEmpty()) && text.length() > 15)
                    .peek(System.out::println)
                    .count();
            System.out.println("\nTotal links available in the page after filtering: " + count);
            */

            /*
            //4. Using streams to find first link
            String firstLink = links.stream()
                    .map(WebElement::getText)
                    .filter(text -> !(text.isBlank() || text.isEmpty()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("No links found"));
            System.out.println("\nUsing streams to find first link: " + firstLink);
            */

            //5. Using streams to find the links text starting with Amazon
            System.out.println("\nUsing streams to find the links text starting with Amazon: ");
            long count = links.stream()
                    .map(WebElement::getText)
                    .filter(text -> text.contains("Amazon"))
                    .peek(System.out::println)
                    .count();
            System.out.println("\nTotal links text starting with Amazon available in the page: " + count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

}
