package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);  // [1]
        driver.get("https://www.google.com");
        // [2]
        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));      // [4]
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }

}