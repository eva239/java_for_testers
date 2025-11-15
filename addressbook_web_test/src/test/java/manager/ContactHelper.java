package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        OpenContactsPage();
        initContactCreation();
        fillGroupForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }
    public void RemoveContact() {
        OpenContactsPage();
        selectContact();
        removeSelectedContact();
        returnToContactsPage();
    }

    private void returnToContactsPage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillGroupForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("middlename"), contact.middlename());

    }


    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        OpenContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void OpenContactsPage() {
        if (!manager.isElementPresent(By.name("firstname"))) {
            click(By.linkText("home"));
        }
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    public int getCount() {
        OpenContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}