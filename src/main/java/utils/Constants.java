package utils;

import org.openqa.selenium.WebDriver;

public class Constants {
    public static final String FOLDER_NAME = "files/";
    public static ThreadLocal<WebDriver> WEBDRIVERS = new ThreadLocal<>();
}
