package pageObjects.subPageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;

public class AddressPageObject extends SidebarPageObject {
    private WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
