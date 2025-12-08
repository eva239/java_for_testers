package model;

public record ContactData(String id, String lastname, String firstname, String middlename, String photo, String address,
                          String home, String mobile, String work, String secondary) {
    public ContactData() {
        this("", "", "", "","","", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.lastname, this.firstname, this.middlename, this.photo , this.address,  this.home, this.mobile,  this.work,  this.secondary);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, lastname, this.firstname, this.middlename, this.photo, this.address, this.home,  this.mobile, this.work,  this.secondary);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, this.lastname, firstname, this.middlename, this.photo, this.address, this.home,  this.mobile, this.work,  this.secondary);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.lastname, this.firstname, middlename, this.photo, this.address, this.home,  this.mobile, this.work,  this.secondary);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.lastname, this.firstname, this.middlename, photo, this.address, this.home,  this.mobile, this.work,  this.secondary);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.lastname, this.firstname, this.middlename, this.photo, address, this.home,  this.mobile, this.work,  this.secondary);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.lastname, this.firstname, this.middlename, this.photo, this.address, home,  this.mobile, this.work,  this.secondary);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.lastname, this.firstname, this.middlename, this.photo, this.address, this.home,  mobile, this.work,  this.secondary);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.lastname, this.firstname, this.middlename, this.photo, this.address, this.home,  this.mobile, work,  this.secondary);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.lastname, this.firstname, this.middlename, this.photo, this.address, this.home,  this.mobile, this.work,  secondary);
    }
}
