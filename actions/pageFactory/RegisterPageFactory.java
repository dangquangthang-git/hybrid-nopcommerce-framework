package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement GENDER_MALE_RADIO;
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@id='Company']")
    private WebElement COMPANY_TEXTBOX;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement CONFIRM_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement REGISTER_BUTTON;
    @FindBy(xpath = "//div[@class='result']")
    private WebElement REGISTER_SUCCESS_MESSAGE;
    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement LOG_OUT_LINK;


    public void clickToMaleRadio() {
        waitForElementClickable(driver, GENDER_MALE_RADIO);
        clickToElement(GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, FIRST_NAME_TEXTBOX);
        sendkeyToElement(FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, LAST_NAME_TEXTBOX);
        sendkeyToElement(LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        sendkeyToElement(EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextBox(String companyName) {
        waitForElementVisible(driver, COMPANY_TEXTBOX);
        sendkeyToElement(COMPANY_TEXTBOX, companyName);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, PASSWORD_TEXTBOX);
        sendkeyToElement(PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextBox(String password) {
        waitForElementVisible(driver, CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, REGISTER_BUTTON);
        clickToElement(REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, REGISTER_SUCCESS_MESSAGE);
        return getElementText(REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutButton() {
        waitForElementClickable(driver, LOG_OUT_LINK);
        clickToElement(LOG_OUT_LINK);

    }

    public void registerSystem(String password, String firstName, String lastName, String emailAddress, String companyName) {
        clickToMaleRadio();
        enterToFirstNameTextBox(firstName);
        enterToLastNameTextBox(lastName);
        enterToEmailTextBox(emailAddress);
        enterToCompanyTextBox(companyName);
        enterToPasswordTextBox(password);
        enterToConfirmPasswordTextBox(password);
        clickToRegisterButton();
        getRegisterSuccessMessage();
        clickToLogoutButton();
    }
}
