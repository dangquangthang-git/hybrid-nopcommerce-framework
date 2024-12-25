package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage {
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    @CacheLookup
    private WebElement GENDER_MALE_RADIO;
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@id='Company']")
    private WebElement COMPANY_TEXTBOX;


    public boolean isMaleGenderSelected() {
        return isElementSelected(GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {

        return getElementAttribute(FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        return getElementAttribute(LAST_NAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        return getElementAttribute(EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        return getElementAttribute(COMPANY_TEXTBOX, "value");
    }

    public void customerInfo(String attributeName) {
        isMaleGenderSelected();
        getFirstNameTextboxValue();
        getLastNameTextboxValue();
        getEmailTextboxValue();
        getCompanyTextboxValue();
    }
}
