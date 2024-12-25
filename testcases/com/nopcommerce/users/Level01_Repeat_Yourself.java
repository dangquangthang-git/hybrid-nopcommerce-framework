package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level01_Repeat_Yourself {
    private WebDriver driver;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password, loginText;

    @BeforeClass
    public void Before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce/");
        firstName = "a";
        lastName = "b";
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
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@value='M']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);

        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
//        new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).selectByVisibleText(day);
//        new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).selectByVisibleText(month);
//        new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).selectByVisibleText(year);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='register-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText(), "Your registration completed");


    }

    @Test
    public void TC_02_Login() {
        sleepInSecond(2);
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText(), loginText);


    }

    //
    @Test
    public void TC_03_Myaccount() {
        driver.findElement(By.xpath("//a[text()='My account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio']")).isSelected());
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), lastName);
//        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), day);
//        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), month);
//        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), year);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='Email']")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='Company']")).getAttribute("value"), companyName);


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
