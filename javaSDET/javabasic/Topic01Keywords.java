package javabasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic01Keywords {
    //Primitive Type
    char a = 'b';
    byte number = 10;
    short snumb = 100;
    int inumb = 1000;
    long lnumb = 10000;
    float fnumb = 15.7f;
    double dnumb = 15.26d;
    boolean bnumb = true;
    //Reference type
    String name = "Automation testing";
    WebDriver driver;

    public WebDriver getBrowser(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
            case "firefox":
                driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            i++;
        }
        int a = 0;
        while (a < 10) {
            System.out.println(a);
            a++;
        }
        int b = 0;
        do {
            System.out.println(b);
            b++;
        } while (
                b < 10
        );
    }

}

