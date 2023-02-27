package com.bridgelabz;

public interface IAddressBook {

    int createContacts(Contacts contacts);

    void showContacts();

    void editContacts(String firstName);

    void deleteContacts(String firstName);

    void duplicateCheck(String firstName);
}