package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {
    public static final String XPATH_COOKIES = "//div[contains(@class, \"_4t2a\")]/div/div/div/div[3]/button[2]";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "//form[contains(@class, \"_featuredLogin__formContainer\")]/div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_WAIT_FOR = "//div[@class=\"_n8 _3qx _8idq _8esf _8f3m _8fgk uiLayer _3qw\"]";

    public static final String XPATH_DATE_OF_BIRTH_DAY = "//select[@id=\"day\"]";
    public static final String XPATH_DATE_OF_BIRTH_MONTH = "//select[@id=\"month\"]";
    public static final String XPATH_DATE_OF_BIRTH_YEAR = "//select[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebElement acceptCookiesButton = driver.findElement(By.xpath(XPATH_COOKIES));
        acceptCookiesButton.click();

        WebElement createNewAccountButton = driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        createNewAccountButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_DATE_OF_BIRTH_DAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(2);

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_DATE_OF_BIRTH_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(3);

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_DATE_OF_BIRTH_YEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByIndex(25);

    }
}
