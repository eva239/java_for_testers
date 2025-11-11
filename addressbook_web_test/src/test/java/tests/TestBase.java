package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static ApplicationManager app;
    String browser = "chrome";
//    String browser = "firefox";

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser",browser));
        }

    }

}
