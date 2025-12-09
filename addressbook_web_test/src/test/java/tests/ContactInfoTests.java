package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {
 //   @Test
//    void testPhones() {
//        var contacts = app.hbm().getContactList();
//        if (app.contacts().getCount() == 0) {
//            app.contacts().createContact(new ContactData("", "lastname", "firstname", "middlename", "", "", "", "", "", ""));
//        }
//        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
//                    Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
//                            .filter(s -> s != null && !"".equals(s))
//                            .collect(Collectors.joining("\n"))
//
//        ));
//        var phones = app.contacts().getPhones();
//        Assertions.assertEquals(expected, phones);
//    }

    @Test
    void testOneContactPhones() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "lastname", "firstname", "middlename", "", "", "", "", "", "", "", "", ""));
        }
        var expected = Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);
    }
    @Test
    void testAddress() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var address = app.contacts().getAddress(contact);
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "lastname", "firstname", "middlename", "", "", "", "", "", "", "", "", ""));
        }
        var expected = contact.address();
        Assertions.assertEquals(expected, address);
    }

    @Test
    void testEmails() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var emails = app.contacts().getEmails(contact);
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "lastname", "firstname", "middlename", "", "", "", "", "", "", "", "", ""));
        }
        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, emails);
    }
}
