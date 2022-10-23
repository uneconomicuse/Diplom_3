package org.example.extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver getBrowser() {
        String browserName;
        try {
            browserName = System.getProperty("browser", "chrome");
        } catch (RuntimeException e) {
            e.printStackTrace();
            browserName = "chrome";
        }
        String path = System.getProperty("user.dir");
        switch (browserName) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\yandexdriver.exe");
                return new ChromeDriver();
            }
            default: {
                WebDriverManager.chromedriver().setup();
                throw new RuntimeException("Unknown browser name!");
            }
        }
    }
}
