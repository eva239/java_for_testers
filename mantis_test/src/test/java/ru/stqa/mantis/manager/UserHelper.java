package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{
    private ApplicationManager app;

    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void startCreation(String user) {
            click(By.xpath("//a[contains(text(),'Signup for a new account')]"));
            type(By.name("username"),user);
            type(By.name("email"),user+"@localhost");
            click(By.cssSelector("input[type='submit']"));
            }

    public void finistCreation(String url, String username, String password)     {
        manager.driver().get(url);
        type(By.name("realname"),username);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.cssSelector("[type='submit']"));
 //       manager.driver().get(url);
    }

}
