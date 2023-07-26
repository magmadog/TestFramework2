import org.example.api.service.AuthService;
import org.example.api.service.UserService;
import org.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TestGetAuthToken {

    @Test
    void testGetToken() throws IOException {
        String username = "testuser1";
        User user = UserService.getUserByLogin(username);
        Assertions.assertNotEquals(
                null,
                user,
                "Can't get user data from yaml file"
        );

        AuthService apiService = new AuthService();
        apiService.getToken(user);

        Assertions.assertNotEquals(
                "",
                user.getAuthToken(),
                "Failed to get auth token from postman mock server");
    }
}
