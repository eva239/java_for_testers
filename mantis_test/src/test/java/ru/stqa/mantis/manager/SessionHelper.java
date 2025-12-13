package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {
    public SessionHelper(ApplicationManager manager) {
        super(manager);

    }

    public void login(String user, String password) {
        type(By.name("username"),user);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"),password);
        click(By.cssSelector("input[type='submit']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("span.user-info"));
    }

    public void signup(String user, String email) {
        click(By.xpath("//a[contains(text(),'Signup for a new account')]"));
        type(By.name("username"),user);
        type(By.name("email"),email);
        click(By.cssSelector("input[type='submit']"));
    }

    public void editAccount(String username, String password) {
        type(By.name("realname"),username);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.cssSelector("[type='submit']"));
    }
    public void goToLink(String url) {
        manager.driver().get(url);
    }

}
