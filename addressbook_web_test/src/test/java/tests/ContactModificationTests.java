package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "lastname", "firstname", "middlename", "", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withLastname("lastname modified").withFirstname("firstname modified");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canAddContactInGroup() {
        var contacts = app.hbm().getContactList();
        var groups = app.hbm().getGroupList();
        if (groups.size() == 0) {
            var contact = new ContactData()
                    .withFirstname(CommonFunctions.randomString(10))
                    .withLastname(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            app.contacts().createContact(contact);
            if (app.hbm().getGroupCount() == 0) {
                app.hbm().createGroup(new GroupData("", CommonFunctions.randomString(10), CommonFunctions.randomString(10), CommonFunctions.randomString(10)));
            }
            var group = app.hbm().getGroupList().get(0);
            var oldRelated = app.hbm().getContactInGroup(group);
            contact = app.hbm().getContactList().get(0);
            app.contacts().addContactInGroup(contact, group);
            var newRelated = app.hbm().getContactInGroup(group);
            Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
        }
        else if (groups.size() > 0) {
            var group = app.hbm().getGroupList().get(0);
            var contactsInGroup = app.hbm().getContactInGroup(group);
            Comparator<ContactData> compareById = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            contacts.sort(compareById);
            contactsInGroup.sort(compareById);
            if (contacts.equals(contactsInGroup)) {
                if (app.hbm().getGroupCount() == 0) {
                    app.hbm().createGroup(new GroupData("", CommonFunctions.randomString(10), CommonFunctions.randomString(10), CommonFunctions.randomString(10)));
                }
                var groupNew = app.hbm().getGroupList().get(0);
                var contact = new ContactData()
                        .withFirstname(CommonFunctions.randomString(10))
                        .withLastname(CommonFunctions.randomString(10))
                        .withPhoto(randomFile("src/test/resources/images"));
                app.contacts().createContact(contact);
                contacts = app.hbm().getContactList();
                var maxId = contacts.get(contacts.size() - 1).id();
                var oldRelated = app.hbm().getContactInGroup(groupNew);
                app.contacts().addContactInGroup(contact.withId(maxId), groupNew);
                var newRelated = app.hbm().getContactInGroup(groupNew);
                Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
            } else {
                for (var i = 0; i < contacts.size(); i++) {
                    if (i >= contactsInGroup.size() && (!(contacts.get(i).equals(contactsInGroup.get(i))))) {
                        var oldRelated = app.hbm().getContactInGroup(groups.get(0));
                        app.contacts().addContactInGroup(contacts.get(i), (groups.get(0)));
                        var newRelated = app.hbm().getContactInGroup(groups.get(0));
                        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
                        break;
                    }
                }
            }
        }
    }

}