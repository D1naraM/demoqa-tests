package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class JunitExamples {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
    }
    @Test
    void positiveTest() {
        Assertions.assertTrue(3>2);
    }

    @Test
    void test() {
        open("https://google.com");
    }

}
