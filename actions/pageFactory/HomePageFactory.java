package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage {
    private WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "")
    private WebElement registerLink;
    @FindAll({
            @FindBy(xpath = "//a[@class='ico-login']"),
            @FindBy(xpath = "//a[@class='ico-register']")
    })
    private WebElement myAccountLink;


    public void clickToRegisterLink() {
        waitForElementVisible(driver, registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginButton() {

    }

    public boolean isMyaccountLinkDisplayed() {
        waitForElementVisible(driver, myAccountLink);
        return isElementDisplayed(myAccountLink);
    }

    public void clickToMyaccountLink() {
        waitForElementVisible(driver, myAccountLink);
        clickToElement(myAccountLink);
    }
}
