package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level02_BasePage_III_Inheritance extends BasePage{
    private WebDriver driver;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password, loginText;

    @BeforeClass
    public void Before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce/");
        firstName = "Thomas";
        lastName = "Muller";
        day = "21";
        month = "April";
        year = "1998";
        emailAddress = "ab" + generateRandomNumber() + "@gmail.com";
        companyName = "ac";
        password = "12345678";
        loginText = "Welcome to our store";
    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");
        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");
        sendkeyToElement(driver, "//input[@id='FirstName']", "Thomas");
        sendkeyToElement(driver, "//input[@id='LastName']", "Muller");
        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Company']", companyName);
        sendkeyToElement(driver, "//input[@id='Password']", password);
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals((getElementText(driver, "//div[text()='Your registration completed']")), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver, "//a[text()='Log out']");
        clickToElement(driver, "//a[text()='Log out']");
//        waitForElementClickable(driver, "//a[text()='Continue']");
//        clickToElement(driver, "//a[text()='Continue']");
        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");
        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Password']", password);
        waitForElementClickable(driver, "//button[@class='button-1 login-button']");
        clickToElement(driver, "//button[@class='button-1 login-button']");
        Assert.assertTrue(isElementDisplayed(driver, "//h2[text()='Welcome to our store']"));
    }

    //
    @Test
    public void TC_03_Myaccount() {
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(isElementDisplayed(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), companyName);

    }

    //
    public void sleepInSecond(long sleep) {
        try {
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void After() {
        driver.quit();
    }

    private Integer generateRandomNumber() {
        return new Random().nextInt(99999999);
    }

}
