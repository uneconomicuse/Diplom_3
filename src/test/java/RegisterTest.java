import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.BaseTest;
import org.example.objects.RegisterObject;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    private String name = "Yandex";
    private String email = RandomStringUtils.randomAlphanumeric(10) + "@example.com";
    private String password = "123456";

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void newUserRegister() {
        RegisterObject registerObject = new RegisterObject(driver);
        PageFactory.initElements(driver, registerObject);

        registerObject
                .clickButton(registerObject.getProfilePage())
                .clickButton(registerObject.getRegisterButton())
                .fillRegisterInputs(name, email, password)
                .clickButton(registerObject.getRegisterConfirmButton());

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));

        registerObject
                .fillAuthInputs(email, password)
                .clickButton(registerObject.getSignInButton());

        boolean result = registerObject.isDisplayed(registerObject.getCreateOrder());
        assertTrue(result);
    }

    @Test
    @DisplayName("Регистрация нового пользователя с неверным паролем")
    public void newUserInvalidPassword() {
        RegisterObject registerObject = new RegisterObject(driver);
        PageFactory.initElements(driver, registerObject);

        registerObject
                .clickButton(registerObject.getProfilePage())
                .clickButton(registerObject.getRegisterButton())
                .fillRegisterInputs(name, email, "1234")
                .clickButton(registerObject.getRegisterConfirmButton());

        boolean result = registerObject.isDisplayed(registerObject.getWarningText());
        assertTrue(result);
    }
}
