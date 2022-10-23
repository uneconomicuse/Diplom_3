package org.example.api;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class UserCredentials {
    private String email;
    private String password;

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Step("Авторизоваться в системе")
    public static UserCredentials from(User user) {
        return new UserCredentials(user.getEmail(), user.getPassword());
    }
}