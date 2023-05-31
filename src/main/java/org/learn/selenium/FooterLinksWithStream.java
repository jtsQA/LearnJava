package org.learn.selenium;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class FooterLinksWithStream {

    public static void main(String[] args) {

        List<String> footerList = new ArrayList<String>();
        WebDriver driver = DriverManager.chromeBrowser();

        try {
            driver.get("https://testvagrant.com/");
            driver.findElements(By.className("elementor-icon-list-text"))
                    .forEach(s -> footerList.add(s.getText()));

            System.out.println("The footer texts count: " + footerList.size() + ", and the list: ");
            footerList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
