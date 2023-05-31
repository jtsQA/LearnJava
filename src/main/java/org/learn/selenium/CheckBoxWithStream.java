package org.learn.selenium;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxWithStream {

    public static void main(String[] args) {
        WebDriver driver = DriverManager.chromeBrowser();
        try {
            driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
            List<WebElement> checkBoxList = driver.findElements(By.cssSelector("td.select-checkbox"));
            checkBoxList.forEach(WebElement::click);
            System.out.println("Successfully clicked on all checkboxes");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
