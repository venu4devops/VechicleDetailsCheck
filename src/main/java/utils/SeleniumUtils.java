package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    public static void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVERS.get(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
