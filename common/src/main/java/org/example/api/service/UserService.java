package org.example.api.service;

import org.example.model.User;
import org.example.util.YAMLFileReader;

import java.util.ArrayList;
import java.util.Map;

public class UserService extends YAMLFileReader {

    private static final String USER_FILE = "users.yml";
    private static final ArrayList<User> users = new ArrayList<>();

    static {
        load(UserService.class.getClassLoader().getResourceAsStream(USER_FILE));
        for (Map<String, String> user : data) {
            users.add(new User(user.get("login"), user.get("password")));
        }
    }

    public static User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
