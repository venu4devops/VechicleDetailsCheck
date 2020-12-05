package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;

public class HomePage {

    private WebDriver driver;

    @FindBy(id="vrm-input")
    WebElement input;

    @FindBy(xpath = "//button[contains(text(), 'Free Car Check')]")
    WebElement freeCarCheck;

    public HomePage() {
        driver = Constants.WEBDRIVERS.get();
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get("https://cartaxcheck.co.uk/");
    }

    public void enterRegistrationNumber(String registrationNumber) {
        input.sendKeys(registrationNumber);
    }

    public void freeCarCheck() {
        freeCarCheck.click();
    }




}
