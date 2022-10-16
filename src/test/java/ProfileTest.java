import io.qameta.allure.junit4.DisplayName;
import org.example.BaseTest;
import org.example.api.User;
import org.example.api.UserClient;
import org.example.objects.ProfileObject;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {
    private String userId;

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToProfile() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        ProfileObject profileObject = new ProfileObject(driver);
        PageFactory.initElements(driver, profileObject);

        profileObject
                .clickButton(profileObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(profileObject.getSignInButton())
                .clickButton(profileObject.getProfilePage());

        boolean result = profileObject.isDisplayed(profileObject.getProfileText());
        assertTrue(result);

        userClient.delete(userId);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void goToConstructor() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        ProfileObject profileObject = new ProfileObject(driver);
        PageFactory.initElements(driver, profileObject);

        profileObject
                .clickButton(profileObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(profileObject.getSignInButton())
                .clickButton(profileObject.getProfilePage());

        boolean profileText = profileObject.isDisplayed(profileObject.getProfileText());
        assertTrue(profileText);

        profileObject
                .clickButton(profileObject.getConstructor());

        boolean createOrderButton = profileObject.isDisplayed(profileObject.getCreateOrder());
        assertTrue(createOrderButton);

        userClient.delete(userId);
    }

    @Test
    @DisplayName("Переход из личного на логотип Stellar Burgers")
    public void goToHeader() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        ProfileObject profileObject = new ProfileObject(driver);
        PageFactory.initElements(driver, profileObject);

        profileObject
                .clickButton(profileObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(profileObject.getSignInButton())
                .clickButton(profileObject.getProfilePage());

        boolean profileText = profileObject.isDisplayed(profileObject.getProfileText());
        assertTrue(profileText);

        profileObject
                .clickButton(profileObject.getHeader());

        boolean createOrderButton = profileObject.isDisplayed(profileObject.getCreateOrder());
        assertTrue(createOrderButton);

        userClient.delete(userId);
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void goToExit() {
        User user = User.getRandomUser();
        UserClient userClient = new UserClient();
        userId = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");

        ProfileObject profileObject = new ProfileObject(driver);
        PageFactory.initElements(driver, profileObject);

        profileObject
                .clickButton(profileObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(profileObject.getSignInButton())
                .clickButton(profileObject.getProfilePage());

        boolean profileText = profileObject.isDisplayed(profileObject.getProfileText());
        assertTrue(profileText);

        profileObject
                .clickButton(profileObject.getExitButton());

        boolean title = profileObject.isDisplayed(profileObject.getTitle());
        assertTrue(title);

        userClient.delete(userId);
    }
}
