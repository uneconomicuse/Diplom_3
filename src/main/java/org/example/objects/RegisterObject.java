package org.example.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterObject {
    WebDriver driver;

    public RegisterObject(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    public final String pageUrl = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = ".//p[contains(text(),'Личный Кабинет')]")
    private WebElement profilePage;

    @FindBy(xpath = "//a[contains(text(),'Зарегистрироваться')]")
    private WebElement registerButton;

    @FindBy(xpath = ".//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement nameInput;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@name=\"Пароль\"]")
    private WebElement passInput;

    @FindBy(xpath = ".//button[contains(text(),'Зарегистрироваться')]")
    private WebElement registerConfirmButton;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement emailAuthInput;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    private WebElement passwordAuthInput;

    @FindBy(xpath = ".//button[contains(text(),'Войти')]")
    private WebElement signInButton;

    @FindBy(xpath = ".//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]")
    private WebElement profileText;

    @FindBy(xpath = ".//p[contains(text(),'Некорректный пароль')]")
    private WebElement warningText;

    @FindBy(xpath = ".//button[contains(text(),'Оформить заказ')]")
    private WebElement createOrder;

    // Метод для клика по кнопке
    @Step("Нажать на кнопку")
    public RegisterObject clickButton(WebElement button) {
        button.click();
        return this;
    }

    // Метод для заполнения данных при регистрации
    @Step("Заполнить регистрационные данные")
    public RegisterObject fillRegisterInputs(String name, String email, String password) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
        return this;
    }

    // Метод для заполнения данных при авторизации
    @Step("Заполнить авторизационные данные")
    public RegisterObject fillAuthInputs(String email, String password) {
        emailAuthInput.sendKeys(email);
        passwordAuthInput.sendKeys(password);
        return this;
    }

    // Метод для проверки успешной регистрации
    @Step("Проверить видимость элемента на странице")
    public boolean isDisplayed(WebElement successElem) {
        boolean text = successElem.isDisplayed();
        return text;
    }

    @Step("Кнопка «Личный кабинет»")
    public WebElement getProfilePage() {
        return profilePage;
    }

    @Step("Кнопка «Зарегистрироваться»")
    public WebElement getRegisterButton() {
        return registerButton;
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

    @Step("Кнопка «Зарегистрироваться»")
    public WebElement getRegisterConfirmButton() {
        return registerConfirmButton;
    }

    @Step("Кнопка «Войти»")
    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getProfileText() {
        return profileText;
    }

    public WebElement getEmailAuthInput() {
        return emailAuthInput;
    }

    public WebElement getPasswordAuthInput() {
        return passwordAuthInput;
    }

    @Step("Текст предупреждения")
    public WebElement getWarningText() {
        return warningText;
    }

    @Step("Кнопка «Оформить заказ»")
    public WebElement getCreateOrder() {
        return createOrder;
    }
}
