import org.example.BaseTest;
import org.example.lib.MainPageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloWorldTest extends BaseTest {

    @Test
    void testSearchHelloWorldOnScreen() {
        var mpo = new MainPageObject();

        Assertions.assertEquals(
                "Hello World!",
                mpo.getHelloWorldText(),
                "Expected text not found!"
        );
    }
}