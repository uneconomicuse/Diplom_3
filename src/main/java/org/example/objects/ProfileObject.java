package org.example.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileObject {
    WebDriver driver;

    public ProfileObject(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

    private final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = ".//p[contains(text(),'Личный Кабинет')]")
    private WebElement profilePage;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement emailAuthInput;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    private WebElement passwordAuthInput;

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    private WebElement signInButton;

    @FindBy(xpath = ".//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]")
    private WebElement profileText;

    @FindBy(xpath = ".//p[contains(text(),'Конструктор')]")
    private WebElement constructor;

    @FindBy(xpath = ".//header/nav[1]/div[1]/a[1]")
    private WebElement header;

    @FindBy(xpath = ".//button[contains(text(),'Оформить заказ')]")
    private WebElement createOrder;

    @FindBy(xpath = ".//button[contains(text(),'Выход')]")
    private WebElement exitButton;

    @FindBy(xpath = ".//h2[contains(text(),'Вход')]")
    private WebElement title;

    @Step("Нажать на кнопку")
    public ProfileObject clickButton(WebElement button) {
        button.click();
        return this;
    }

    @Step("Заполнить авторизационные данные")
    public ProfileObject fillAuthInputs(String email, String password) {
        emailAuthInput.sendKeys(email);
        passwordAuthInput.sendKeys(password);
        return this;
    }

    @Step("Проверить видимость элемента на странице")
    public boolean isDisplayed(WebElement successElem) {
        boolean text = successElem.isDisplayed();
        return text;
    }


    public String getPageUrl() {
        return pageUrl;
    }

    @Step("Кнопка «Личный кабинет»")
    public WebElement getProfilePage() {
        return profilePage;
    }

    public WebElement getEmailAuthInput() {
        return emailAuthInput;
    }

    public WebElement getPasswordAuthInput() {
        return passwordAuthInput;
    }

    @Step("Кнопка «Войти»")
    public WebElement getSignInButton() {
        return signInButton;
    }

    @Step("Кнопка «Личный кабинет»")
    public WebElement getProfileText() {
        return profileText;
    }

    @Step("Кнопка «Конструктор»")
    public WebElement getConstructor() {
        return constructor;
    }

    @Step("Логотип «Stellar Burger»")
    public WebElement getHeader() {
        return header;
    }

    @Step("Кнопка «Оформить заказ»")
    public WebElement getCreateOrder() {
        return createOrder;
    }

    @Step("Кнопка «Выход»")
    public WebElement getExitButton() {
        return exitButton;
    }

    @Step("Кнопка «Вход»")
    public WebElement getTitle() {
        return title;
    }
}
