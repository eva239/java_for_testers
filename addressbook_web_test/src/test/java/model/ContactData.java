package model;

public record ContactData(String firstname, String middlename, String lastname) {
    public ContactData() {
        this ("","","");
    }


}
