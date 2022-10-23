import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.api.User;
import org.example.api.UserClient;
import org.example.api.UserCredentials;
import org.example.objects.RegisterObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    private String token;
    private String pass = "1234";
    private User user;
    private UserClient userClient;
    private RegisterObject registerObject;


    @Before
    public void create() {
        registerObject = new RegisterObject(driver);
        user = User.getRandomUser();
        userClient = new UserClient();
    }

    @After
    public void delete() {
        UserCredentials creds = UserCredentials.from(user);
        Response response = userClient.login(creds)
                .extract().response();

        token = response.path("accessToken");
        if (token != null) {
            userClient.delete(token);
        } else {
            assertEquals(401, response.statusCode());
        }
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void newUserRegister() {
        registerObject
                .clickButton(registerObject.getProfilePage())
                .clickButton(registerObject.getRegisterButton())
                .fillRegisterInputs(user.getName(), user.getEmail(), user.getPassword())
                .clickButton(registerObject.getRegisterConfirmButton());

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));

        registerObject
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(registerObject.getSignInButton());

        boolean result = registerObject.isDisplayed(registerObject.getCreateOrder());
        assertTrue(result);
    }

    @Test
    @DisplayName("Регистрация нового пользователя с неверным паролем")
    public void newUserInvalidPassword() {
        registerObject
                .clickButton(registerObject.getProfilePage())
                .clickButton(registerObject.getRegisterButton())
                .fillRegisterInputs(user.getName(), user.getEmail(), pass)
                .clickButton(registerObject.getRegisterConfirmButton());

        boolean result = registerObject.isDisplayed(registerObject.getWarningText());
        assertTrue(result);

        user.setPassword(pass);
    }
}
