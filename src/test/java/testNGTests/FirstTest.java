package testNGTests;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public static void setup(String browser) {
        driver = DriverManager.initializeBrowser(browser);
        System.out.println("\nExecution started in " + browser + " browser - FirstTest");
    }

    @Test
    public static void sampleFirstTest() {

        List<String> footerList = new ArrayList<String>();

        try {
            driver.get("https://testvagrant.com/");
            driver.findElements(By.className("elementor-icon-list-text"))
                    .forEach(s -> footerList.add(s.getText()));

            System.out.println("The footer texts count: " + footerList.size() + ", and the list: ");
            footerList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void finish() {
        driver.quit();
    }
}
