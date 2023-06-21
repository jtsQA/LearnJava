package org.learn.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage {
    private WebDriver driver;

    public void googleSearchText(String browser) throws InterruptedException {
        driver = setUp(browser);
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("TestVagrant");
        driver.findElement(By.name("q")).submit();
        driver.findElements(By.xpath("//h3")).forEach(ele -> System.out.println("ele.getText(): " + ele.getText()));
    }

    public void tearDown() {
        driver.quit();
    }
}
