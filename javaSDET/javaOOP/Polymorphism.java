package javaOOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Polymorphism {
    //Constructor
    public Polymorphism() {

    }

    public Polymorphism(WebDriver driver) {

    }

    public Polymorphism(WebDriver driver, WebDriverWait explicitWait) {

    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        Polymorphism polymorphism = new Polymorphism();
        polymorphism.a();

    }

    public void a() {
    }

}
