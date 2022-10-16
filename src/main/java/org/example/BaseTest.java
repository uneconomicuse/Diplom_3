package org.example;

import org.example.extensions.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.getBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
