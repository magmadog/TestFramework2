import org.example.api.model.User;
import org.example.api.service.NetService;
import org.example.api.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestGetAuthToken {

    @Test
    public void testGetToken() throws IOException {
        String username = "testuser1";
        User user = UserService.getUserByLogin(username);
        Assertions.assertNotEquals(
                null,
                user,
                "Can't get user data from yaml file"
        );

        NetService apiService = new NetService();
        apiService.getToken(user);

        Assertions.assertNotEquals(
                "",
                user.getAuthToken(),
                "Failed to get auth token from postman mock server");
    }
}
