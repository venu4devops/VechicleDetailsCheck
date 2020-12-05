package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;

import static utils.SeleniumUtils.waitUntilClickable;

public class VehicleIdentityPage {
    @FindBy(xpath = "//dt[contains(text(),'Registration')]/following-sibling::dd")
    WebElement registration;

    @FindBy(xpath = "//dt[contains(text(),'Make')]/following-sibling::dd")
    WebElement make;

    @FindBy(xpath = "//dt[contains(text(),'Model')]/following-sibling::dd")
    WebElement model;

    @FindBy(xpath = "//dt[contains(text(),'Colour')]/following-sibling::dd")
    WebElement colour;

    @FindBy(xpath = "//dt[contains(text(),'Year')]/following-sibling::dd")
    WebElement year;

    public VehicleIdentityPage() {
        PageFactory.initElements(Constants.WEBDRIVERS.get(), this);
    }

    public String getRegistration() {
        waitUntilClickable(registration);
        return registration.getText();
    }

    public String getMake() {
        waitUntilClickable(make);
        return make.getText();
    }

    public String getModel() {
        waitUntilClickable(model);
        return model.getText();
    }

    public String getColour() {
        waitUntilClickable(colour);
        return colour.getText();
    }

    public String getYear() {
        waitUntilClickable(year);
        return year.getText();
    }
}
