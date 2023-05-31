package org.learn.selenium;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowHandlerWithStream {

    public static void main(String[] args) {

        List<String> footerList = new ArrayList<String>();
        WebDriver driver = DriverManager.chromeBrowser();

        try {
            driver.get("https://www.rrc.texas.gov/resource-center/research/gis-viewer/gis-popup-blocker-test/#");
            driver.findElement(By.cssSelector(".btn.goBtn")).click();
            String title = switchToWindowTest(driver, "Test Page");
            System.out.println("title = " + title);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static String switchToWindowTest(WebDriver driver, String title) {

        return driver.getWindowHandles()
                .stream()
                .map(w -> driver.switchTo().window(w).getTitle())
                .filter(s -> s.contains(title))
                .findFirst()
                .orElseThrow(() -> new NoSuchWindowException("No Such Window"));

    }
}
