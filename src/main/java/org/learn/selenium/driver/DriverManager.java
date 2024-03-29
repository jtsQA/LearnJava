package org.learn.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver initializeBrowser(String browser) {
        return switch (browser) {
            case "chrome" -> chromeBrowser();
            case "safari" -> safariBrowser();
            case "edge" -> edgeBrowser();
            case "firefox" -> fifrefoxBrowser();
            default -> chromeBrowserHeadless();
        };
    }

    public static WebDriver chromeBrowserHeadless() {

        // Set path to chromedriver executable
        WebDriverManager.chromedriver().setup();

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode

        // Create ChromeDriver instance with headless options
        driver = new ChromeDriver(options);

        return driver;
    }

    public static WebDriver chromeBrowser() {

        // Set path to chromedriver executable
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance
        driver = new ChromeDriver();

        return driver;
    }

    public static WebDriver safariBrowserHeadless() {

        // Set up the Safari executable driver
        WebDriverManager.safaridriver().setup();

        // Set Safari options
        SafariOptions options = new SafariOptions();
        options.setCapability("safari:automaticInspection", false);
        options.setCapability("safari:automaticProfiling", false);

        // Create SafariDriver instance
        driver = new SafariDriver(options);

        // Set Safari window position off-screen
        driver.manage().window().setPosition(new Point(-2000, 0));

        return driver;
    }

    public static WebDriver safariBrowser() {

        // Set up the Safari executable driver
        WebDriverManager.safaridriver().setup();

        // Set Safari options
        SafariOptions options = new SafariOptions();
        options.setCapability("safari:automaticInspection", false);
        options.setCapability("safari:automaticProfiling", false);

        // Create SafariDriver instance
        driver = new SafariDriver(options);

        return driver;
    }

    public static WebDriver edgeBrowser() {

        // Set path to edgedriver executable
        WebDriverManager.edgedriver().setup();

        // Create EdgeDriver instance
        driver = new EdgeDriver();

        return driver;
    }

    public static WebDriver fifrefoxBrowser() {

        // Set path to firefoxdriver executable
        WebDriverManager.firefoxdriver().setup();

        // Create FirefoxDriver instance
        driver = new FirefoxDriver();

        return driver;
    }
}
