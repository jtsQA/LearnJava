package org.learn.threads;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;

    public WebDriver setUp(String browser) {
        driver = DriverManager.initializeBrowser(browser);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        return driver;
    }


}
