package model;

public record ContactData(String id, String lastname, String firstname, String middlename) {
    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.lastname, this.firstname, this.middlename);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, lastname, this.firstname, this.middlename);
    }


    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, this.lastname, firstname, this.middlename);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.lastname, this.firstname, middlename);
    }

}
