package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillGroupForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }


    public void create(ContactData contact, GroupData group) {
        initContactCreation();
        fillGroupForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToContactsPage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
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
        attach(By.name("photo"), contact.photo());
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
        click(By.cssSelector(String.format("input[value = '%s']", contact.id())));
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
        for (var row : rows) {
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
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }

    private void initContactModification(ContactData contact) {
        click(By.xpath(String.format("//a[@href='edit.php?id=%s']", contact.id())));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    public void addContactInGroup(ContactData contact, GroupData group) {
        OpenContactsPage();
        selectContact(contact);
        selectGrouptoAdd(group);
        submitContactToGroup();
    }

    private void selectGrouptoAdd(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void submitContactToGroup() {
        click(By.name("add"));
    }

    public void deleteContactFromGroup(ContactData contact, GroupData group) {
        OpenContactsPage();
        selectGroupToDelete(group);
        selectContact(contact);
        submitDeleteContactToGroup();
    }

    private void selectGroupToDelete(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }
    private void submitDeleteContactToGroup() {
        click(By.name("remove"));
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[6]",contact.id()))).getText();
    }

    public String getAddress(ContactData contact) {
        selectContact(contact);
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[4]",contact.id()))).getText();
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[5]",contact.id()))).getText();
    }

//    public Map<String,String> getPhones(ContactData contact) {
//        var result = new HashMap<String,String >();
//        selectContact(contact);
//        List< WebElement> rows = manager.driver.findElements(By.name("entry"));
//        for (WebElement row:rows) {
//            var id = row.findElement(By.tagName("input")).getAttribute("id");
//            var phones = row.findElements(By.tagName("td")).get(5).getText();
//            result.put(id,phones);
//        }
//        return result;
//    }

}