package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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
    public void RemoveContact(ContactData contact) {
        OpenContactsPage();
        selectContact(contact);
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
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
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

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value = '%s']",contact.id())));
//        click(By.name("selected[]"));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    public int getCount() {
        OpenContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        OpenContactsPage();
        var contacts = new ArrayList<ContactData>();
        var rows = manager.driver.findElements(By.name("entry"));
        for (var row : rows){
            var td = row.findElements(By.tagName("td"));
            var lastname = td.get(1).getText();
            var firstname = td.get(2).getText();
            var checkbox = row.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");

            contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        OpenContactsPage();
        selectContact(contact);
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }
    private void initContactModification() {
        click(By.xpath("//td[@class='center']/a/img[@src='icons/pencil.png']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
    }
    private void submitContactModification() {
        click(By.name("update"));
    }


}