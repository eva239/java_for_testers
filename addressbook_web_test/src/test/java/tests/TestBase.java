package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {
    protected static ApplicationManager app;
    //    String browser = "chrome";
    String browser = "firefox";

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser", browser));
        }

    }

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (var i = 0; i < n; i++) {
            result = result + (char) ('a' + rnd.nextInt(26));
        }
        //       if (n<20) {
        //          result = result + '\'';
        //      }
        return result;
    }
}
