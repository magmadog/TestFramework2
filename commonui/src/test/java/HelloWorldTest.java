import org.example.BaseTest;

import org.example.lib.MainPageObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleTest extends BaseTest {

    @Test
    void testSearchHelloWorld(){
        var mpo = new MainPageObject();

        Assertions.assertEquals(
                "Hello World!",
                mpo.getHelloWorldText(),
                "Expected text not found!"
        );
    }
}