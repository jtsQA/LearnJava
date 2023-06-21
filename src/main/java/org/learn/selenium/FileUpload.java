package org.learn.selenium;

import org.learn.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {

    public static void main(String[] args) {

        WebDriver driver = DriverManager.chromeBrowser();

        try {
            driver.get("https://tinywow.com/image/to-text");

            // Find the file upload button
            WebElement fileUploadButton = driver.findElement(By.cssSelector("button.file-uploads-drop"));

            // Click the file upload button
            fileUploadButton.click();

            // Wait for the file explorer to open (optional)
            // You can add a delay here to allow the file explorer to open

            // Provide the file path to upload
            String filePath = "/Users/testvagrant/Documents/AI_generated_wallpaper.webp";
            WebElement fileInput = driver.findElement(By.id("file"));
            fileInput.sendKeys(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
