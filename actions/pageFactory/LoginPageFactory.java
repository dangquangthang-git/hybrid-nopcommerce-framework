package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='email']")
    private WebElement emailTextbox;
    @FindBy(xpath = "//input[@class='password']")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(emailTextbox, emailAddress);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(emailTextbox, password);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, loginButton);
        clickToElement(loginButton);
    }

    public void loginSystem(String emailAddress, String password) {
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
    }
}
