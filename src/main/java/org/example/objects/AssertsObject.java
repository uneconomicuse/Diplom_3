package org.example.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertsObject {

    WebDriver driver;

    public AssertsObject(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    private final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @Step("Проверить видимость элемента")
    public boolean isDisplayed(WebElement elem) {
        return elem.isDisplayed();
    }

}
