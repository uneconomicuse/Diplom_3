package org.example.objects;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorObject {
    WebDriver driver;

    public ConstructorObject(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

    private final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = ".//span[contains(text(),'Булки')]")
    private WebElement bunButton;

    @FindBy(xpath = ".//span[contains(text(),'Соусы')]")
    private WebElement sauceButton;

    @FindBy(xpath = ".//span[contains(text(),'Начинки')]")
    private WebElement fillingButton;

//    private final By bunsTitle = By.xpath("//h2[text()='Булки']");
//    private final By sauceTitle = By.xpath("//h2[text()='Соусы']");
//    private final By fillingTitle = By.xpath("//h2[text()='Начинки']");

    @FindBy(xpath = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect' and contains(span, 'Булки')]")
    private WebElement bunsTab;

    @FindBy(xpath = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect' and contains(span, 'Соусы')]")
    private WebElement sauceTab;

    @FindBy(xpath = "//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect' and contains(span, 'Начинки')]")
    private WebElement fillingTab;

    @Step("Нажать на кнопку")
    public ConstructorObject clickButton(WebElement button) {
        button.click();
        return this;
    }

    @Step("Проверить видимость элемента")
    public boolean isDisplayed(WebElement elem) {
        return elem.isDisplayed();
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

    @Step("Вкладка «Булки»")
    public WebElement getBunsTab() {
        return bunsTab;
    }

    @Step("Вкладка «Соусы»")
    public WebElement getSauceTab() {
        return sauceTab;
    }

    @Step("Вкладка «Начинки»")
    public WebElement getFillingTab() {
        return fillingTab;
    }

}
