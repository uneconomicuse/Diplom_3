import io.qameta.allure.junit4.DisplayName;
import org.example.BaseTest;
import org.example.api.User;
import org.example.api.UserClient;
import org.example.objects.AssertsObject;
import org.example.objects.SignInObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class SignInTest extends BaseTest {

    private String token;
    private AssertsObject assertsObject;
    private User user;
    private UserClient userClient;
    private SignInObject signInObject;

    @Before
    public void create() {
        user = User.getRandomUser();
        userClient = new UserClient();
        token = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        signInObject = new SignInObject(driver);
        assertsObject = new AssertsObject(driver);
    }

    @After
    public void delete() {
        userClient.delete(token);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void signInMainPage() {
        signInObject
                .clickButton(signInObject.getSignInButton())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = assertsObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void signInProfile() {
        signInObject
                .clickButton(signInObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = assertsObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInRegPage() {
        signInObject
                .clickButton(signInObject.getProfilePage())
                .clickButton(signInObject.getRegisterButton())
                .clickButton(signInObject.getSignInOnRegPage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = assertsObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInRecPage() {
        signInObject
                .clickButton(signInObject.getProfilePage())
                .clickButton(signInObject.getRecPassButton())
                .clickButton(signInObject.getSignInOnRegPage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(signInObject.getSignInOnAuthPage());

        boolean result = assertsObject.isDisplayed(signInObject.getCreateOrder());
        assertTrue(result);
    }
}
