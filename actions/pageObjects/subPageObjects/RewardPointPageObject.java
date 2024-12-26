package pageObjects.subPageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;

public class RewardPointPageObject extends SidebarPageObject {
    private WebDriver driver;

    public RewardPointPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
