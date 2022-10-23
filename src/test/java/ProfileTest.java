import io.qameta.allure.junit4.DisplayName;
import org.example.BaseTest;
import org.example.api.User;
import org.example.api.UserClient;
import org.example.objects.ProfileObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {
    private String token;
    UserClient userClient;
    User user;

    @Before
    public void create() {
        user = User.getRandomUser();
        userClient = new UserClient();
        token = userClient.create(user)
                .statusCode(200)
                .extract().path("accessToken");
    }

    @After
    public void delete() {
        userClient.delete(token);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToProfile() {
        ProfileObject profileObject = new ProfileObject(driver);

        profileObject
                .clickButton(profileObject.getProfilePage())
                .fillAuthInputs(user.getEmail(), user.getPassword())
                .clickButton(profileObject.getSignInButton())
                .clickButton(profileObject.getProfilePage());

        boolean result = profileObject.isDisplayed(profileObject.getProfileText());
        assertTrue(result);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void goToConstructor() {
        ProfileObject profileObject = new ProfileObject(driver);

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
    }

    @Test
    @DisplayName("Переход из личного на логотип Stellar Burgers")
    public void goToHeader() {
        ProfileObject profileObject = new ProfileObject(driver);

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
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void goToExit() {
        ProfileObject profileObject = new ProfileObject(driver);

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
    }
}
