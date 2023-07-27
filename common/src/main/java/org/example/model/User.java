package org.example.model;

import lombok.Data;

@Data
public class User {
    private String login;
    private String password;
    private Token authToken;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.authToken = new Token();
    }
}
