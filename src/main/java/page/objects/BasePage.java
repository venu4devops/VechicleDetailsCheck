package page.objects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

public class BasePage {

    public void initDriver() {
        String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.get("https://cartaxcheck.co.uk/");
        Constants.WEBDRIVERS.set(webdriver);
    }

    @Before
    public void beforeHook() {
        initDriver();
        System.setProperty("cucumber.publish.enabled", "true");
    }

    @After
    public void afterHook() {
        Constants.WEBDRIVERS.get().quit();
    }

}
