package org.learn.selenium.javascriptexecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tasks.ExecutionFunctions;

import java.time.Duration;

public class ScrollFunctions {

    private static final String LOC_VIEW_ALL = "//a[normalize-space()='View all']";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            driver.get("https://testvagrant.myshopify.com/");

            // Wait till element is visible
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOC_VIEW_ALL)));
            WebElement element = driver.findElement(By.xpath(LOC_VIEW_ALL));

            // Scroll to the element
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Long scrollX1 = (Long) js.executeScript("return window.pageXOffset;");
            Double scrollY1 = (Double) js.executeScript("return window.pageYOffset;");
            System.out.println("Scroll position after scrolling to element: x = " + scrollX1 + ", and y = " + scrollY1);

            // Action with the element
            element.click();
            System.out.println("Clicked on 'View All' element");

            // Pause execution for 5 seconds
            ExecutionFunctions.pauseExecution(5);


            // Scroll to the bottom of the page
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Long scrollX2 = (Long) js.executeScript("return window.pageXOffset;");
            Long scrollY2 = (Long) js.executeScript("return window.pageYOffset;");
            System.out.println("Scroll position after scrolling to bottom of the page: x = " + scrollX2 + ", and y = " + scrollY2);

            // Pause execution for 5 seconds
            ExecutionFunctions.pauseExecution(5);


            // Horizontal scroll to the right
            js.executeScript("window.scrollBy(200, 0)");
            Long scrollX3 = (Long) js.executeScript("return window.pageXOffset;");
            Long scrollY3 = (Long) js.executeScript("return window.pageYOffset;");
            System.out.println("Scroll position after scrolling to right side of the page: x = " + scrollX3 + ", and y = " + scrollY3);

            // Pause execution for 5 seconds
            ExecutionFunctions.pauseExecution(5);


            // Scroll up to the top of the page
            js.executeScript("window.scrollTo(0, 0)");
            Long scrollX4 = (Long) js.executeScript("return window.pageXOffset;");
            Long scrollY4 = (Long) js.executeScript("return window.pageYOffset;");
            System.out.println("Scroll position after scrolling to top of the page: x = " + scrollX4 + ", and y = " + scrollY4);

            // Pause execution for 5 seconds
            ExecutionFunctions.pauseExecution(5);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
