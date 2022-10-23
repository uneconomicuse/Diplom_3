package org.example.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class UserClient extends BaseClient {
    private final String ROOT = "/auth";
    private final String USER = ROOT + "/user";
    private final String LOGIN = ROOT + "/login";
    private final String REG = ROOT + "/register";

    @Step("Создать пользователя")
    public ValidatableResponse create(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(REG)
                .then().log().all()
                .assertThat();
    }

    @Step("Войти в личный кабинет курьера")
    public ValidatableResponse login(UserCredentials creds) {
        return getSpec()
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat();
    }

    @Step("Удалить пользователя")
    public ValidatableResponse delete(String token) {
        return getSpec()
                .header("Authorization", token)
                .when()
                .delete(USER)
                .then().log().all()
                .assertThat()
                .statusCode(202);
    }
}
