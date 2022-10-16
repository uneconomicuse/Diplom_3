import io.qameta.allure.junit4.DisplayName;
import org.example.BaseTest;
import org.example.api.User;
import org.example.api.UserClient;
import org.example.objects.SignInObject;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class SignInTest extends BaseTest {

    private String userId;

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void signInMainPage() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        SignInObject signInObject = new SignInObject(driver);
        PageFactory.initElements(driver, signInObject);

        signInObject
                .clickButton(signInObject.getSignInButton())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = signInObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);

        userClient.delete(userId);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void signInProfile() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        SignInObject signInObject = new SignInObject(driver);
        PageFactory.initElements(driver, signInObject);

        signInObject
                .clickButton(signInObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = signInObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);

        userClient.delete(userId);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInRegPage() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        SignInObject signInObject = new SignInObject(driver);
        PageFactory.initElements(driver, signInObject);

        signInObject
                .clickButton(signInObject.getProfilePage())
                .clickButton(signInObject.getRegisterButton())
                .clickButton(signInObject.getSignInOnRegPage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = signInObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);

        userClient.delete(userId);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInRecPage() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        SignInObject signInObject = new SignInObject(driver);
        PageFactory.initElements(driver, signInObject);

        signInObject
                .clickButton(signInObject.getProfilePage())
                .clickButton(signInObject.getRecPassButton())
                .clickButton(signInObject.getSignInOnRegPage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = signInObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);

        userClient.delete(userId);
    }
}
