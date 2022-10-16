package org.example.objects;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorObject {
    WebDriver driver;

    public ConstructorObject(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    private final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = ".//span[contains(text(),'Булки')]")
    private WebElement bunButton;

    @FindBy(xpath = ".//span[contains(text(),'Соусы')]")
    private WebElement sauceButton;

    @FindBy(xpath = ".//span[contains(text(),'Начинки')]")
    private WebElement fillingButton;

    private final By bunsTitle = By.xpath("//h2[text()='Булки']");
    private final By sauceTitle = By.xpath("//h2[text()='Соусы']");
    private final By fillingTitle = By.xpath("//h2[text()='Начинки']");

    @Step("Нажать на кнопку")
    public ConstructorObject clickButton(WebElement button) {
        button.click();
        return this;
    }

    @Step("Проверить видимость элемента")
    public boolean isDisplayed(WebElement successElem) {
        boolean text = successElem.isDisplayed();
        return text;
    }

    @Step("Проверка видимости раздела с булками")
    public boolean isBunVisible() {
        return isElementVisible(bunsTitle);
    }

    @Step("Проверка видимости раздела с соусами")
    public boolean isSauceVisible() {
        return isElementVisible(sauceTitle);
    }

    @Step("Проверка видимости раздела с начинками")
    public boolean isFillingVisible() {
        return isElementVisible(fillingTitle);
    }

    public boolean isElementVisible(By obj) {
        try {
            WebElement element = driver.findElement((By) obj);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception timeout) {
            return false;
        }
    }

    public String getPageUrl() {
        return pageUrl;
    }

    @Step("Кнопка «Булки»")
    public WebElement getBunButton() {
        return bunButton;
    }

    @Step("Кнопка «Соусы»")
    public WebElement getSauceButton() {
        return sauceButton;
    }

    @Step("Кнопка «Начинки»")
    public WebElement getFillingButton() {
        return fillingButton;
    }

    public By getBunsTitle() {
        return bunsTitle;
    }

    public By getSauceTitle() {
        return sauceTitle;
    }

    public By getFillingTitle() {
        return fillingTitle;
    }
}
