package pageObjects.subPageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;

public class OrderPageObject extends SidebarPageObject {
    private WebDriver driver;

    public OrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
