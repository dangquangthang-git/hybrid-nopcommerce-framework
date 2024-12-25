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

public class Level02_BasePage_I_Initial {
    private WebDriver driver;
    BasePage basePage;
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
        basePage = new BasePage();
    }

    @Test
    public void TC_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");
        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Thomas");
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Muller");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
        basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals((basePage.getElementText(driver, "//div[text()='Your registration completed']")), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver, "//a[text()='Log out']");
        basePage.clickToElement(driver, "//a[text()='Log out']");
//        basePage.waitForElementClickable(driver, "//a[text()='Continue']");
//        basePage.clickToElement(driver, "//a[text()='Continue']");
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
        basePage.waitForElementClickable(driver, "//button[@class='button-1 login-button']");
        basePage.clickToElement(driver, "//button[@class='button-1 login-button']");
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//h2[text()='Welcome to our store']"));
    }

    //
    @Test
    public void TC_03_Myaccount() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementDisplayed(driver, "//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']", "value"), companyName);

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
