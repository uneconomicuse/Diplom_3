package org.example.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInObject {
    WebDriver driver;

    public SignInObject(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    private final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = ".//button[contains(text(),'Войти в аккаунт')]")
    private WebElement signInButton;

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    private WebElement signInOnAuthPage;

    @FindBy(xpath = ".//p[contains(text(),'Личный Кабинет')]")
    private WebElement profilePage;

    @FindBy(xpath = ".//a[contains(text(),'Зарегистрироваться')]")
    private WebElement registerButton;

    @FindBy(xpath = ".//a[contains(text(),'Войти')]")
    private WebElement signInOnRegPage;

    @FindBy(xpath = ".//a[contains(text(),'Восстановить пароль')]")
    private WebElement recPassButton;

    @FindBy(xpath = ".//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]")
    private WebElement nameInput;

    @FindBy(xpath = ".//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    private WebElement emailInput;

    @FindBy(xpath = ".//button[contains(text(),'Зарегистрироваться')]")
    private WebElement registerConfirmButton;
    @FindBy(xpath = ".//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/input[1]")
    private WebElement passInput;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement emailAuthInput;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    private WebElement passwordAuthInput;

    @FindBy(xpath = ".//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]")
    private WebElement profileText;

    @FindBy(xpath = ".//button[contains(text(),'Оформить заказ')]")
    private WebElement createOrder;

    @Step("Нажать на кнопку")
    public SignInObject clickButton(WebElement button) {
        button.click();
        return this;
    }

    @Step("Заполнить регистрационные данные")
    public SignInObject fillRegisterInputs(String name, String email, String password) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
        return this;
    }

    @Step("Заполнить авторизационные данные")
    public SignInObject fillAuthInputs(String email, String password) {
        emailAuthInput.sendKeys(email);
        passwordAuthInput.sendKeys(password);
        return this;
    }

    @Step("Проверить видимость элемента")
    public boolean isDisplayed(WebElement successElem) {
        boolean text = successElem.isDisplayed();
        return text;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    @Step("Кнопка «Войти»")
    public WebElement getSignInButton() {
        return signInButton;
    }

    @Step("Кнопка «Войти» на странице авторизации")
    public WebElement getSignInOnAuthPage() {
        return signInOnAuthPage;
    }

    @Step("Кнопка «Личный кабинет»")
    public WebElement getProfilePage() {
        return profilePage;
    }

    @Step("Кнопка «Зарегистрироваться»")
    public WebElement getRegisterButton() {
        return registerButton;
    }

    @Step("Кнопка «Войти» на странице регистрации")
    public WebElement getSignInOnRegPage() {
        return signInOnRegPage;
    }

    @Step("Кнопка «Восстановить пароль»")
    public WebElement getRecPassButton() {
        return recPassButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPassInput() {
        return passInput;
    }

    public WebElement getRegisterConfirmButton() {
        return registerConfirmButton;
    }

    public WebElement getEmailAuthInput() {
        return emailAuthInput;
    }

    public WebElement getPasswordAuthInput() {
        return passwordAuthInput;
    }

    public WebElement getProfileText() {
        return profileText;
    }

    @Step("Кнопка «Создать заказ»")
    public WebElement getCreateOrder() {
        return createOrder;
    }
}
