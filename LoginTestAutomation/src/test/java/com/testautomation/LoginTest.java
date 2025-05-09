package com.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/msiva/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        boolean loginSuccess = driver.getPageSource().contains("Logged In Successfully");
        Assert.assertTrue(loginSuccess, "Login was not successful with valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("submit")).click();

        boolean errorShown = driver.getPageSource().contains("Your username is invalid!");
        Assert.assertTrue(errorShown, "Error message not displayed for invalid login");
    }
 

    @Test
    public void testEmptyFields() {
        driver.findElement(By.id("submit")).click();

        boolean validationError = driver.getPageSource().contains("Your username is invalid!");
        Assert.assertTrue(validationError, "Validation error not shown for empty fields");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
