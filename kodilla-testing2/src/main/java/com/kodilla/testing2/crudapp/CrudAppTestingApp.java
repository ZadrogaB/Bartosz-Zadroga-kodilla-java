package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp{
    public static final String XPATH_INPUT = "//html/body/main/section/form/fieldset/input"; // [1]
    public static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea"; // [1]
    public static final String XPATH_WAIT_FOR  = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"task-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://zadrogab.github.io/");                      // [2]

        WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));    // [3]
        searchField.sendKeys("New robotic task");                              // [4]

        WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));  // [2]
        textareaField.sendKeys("The robotic content");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));      // [2]
        Select selectBoard = new Select(selectCombo);                             // [3]
        selectBoard.selectByIndex(1);
    }
}