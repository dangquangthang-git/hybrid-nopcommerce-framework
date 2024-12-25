package javabasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_04_Driver_Info {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("SessionId: " + sessionId);
        System.out.println("Driver: " + driver.toString());
        driver.quit();
    }
}
