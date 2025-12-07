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
        if (contacts.size() == 0) {
            var contact = new ContactData()
                    .withFirstname(CommonFunctions.randomString(10))
                    .withLastname(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            app.contacts().createContact(contact);
            contacts = app.hbm().getContactList();
        }
        if (groups.size() == 0) {
            app.hbm().createGroup(new GroupData("", CommonFunctions.randomString(10), CommonFunctions.randomString(10), CommonFunctions.randomString(10)));
            groups = app.hbm().getGroupList();
            var oldRelated = app.hbm().getContactInGroup(groups.get(0));
            app.contacts().addContactInGroup(contacts.get(0), (groups.get(0)));
            var newRelated = app.hbm().getContactInGroup(groups.get(0));
            Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
        }
        if (groups.size() > 0) {
            for (GroupData group : groups) {
                var contactsInGroup = app.hbm().getContactInGroup(group);
                for (ContactData contact : contacts) {
                    if (!contactsInGroup.contains(contact)) {
                        var oldRelated = app.hbm().getContactInGroup(group);
                        app.contacts().addContactInGroup(contact, group);
                        var newRelated = app.hbm().getContactInGroup(group);
                        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
                        break;
                    }
                }
            }

        }
        app.hbm().createGroup(new GroupData("", CommonFunctions.randomString(10), CommonFunctions.randomString(10), CommonFunctions.randomString(10)));
        groups = app.hbm().getGroupList();
        var oldRelated = app.hbm().getContactInGroup(groups.get(0));
        app.contacts().addContactInGroup(contacts.get(0), (groups.get(0)));
        var newRelated = app.hbm().getContactInGroup(groups.get(0));
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }
}