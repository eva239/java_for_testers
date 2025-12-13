package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{
    @Test
    void canRegisterUser() throws InterruptedException {
        String username = CommonFunctions.randomString(8);
        String email = username+"@localhost";
        String password = "password";
        app.jamesCli().addUser(email, password);
        app.session().signup(username,email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(90));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            app.session().goToLink(url);
            app.session().editAccount(username,password);
        }
        app.session().goToLink(app.property("web.baseUrl"));
        app.session().login(username,password);
        Assertions.assertTrue(app.session().isLoggedIn());
    }
}
