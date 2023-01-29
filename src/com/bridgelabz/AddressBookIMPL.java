package com.bridgelabz;

public class AddressBookIMPL implements IAddressBook {

    private static Contacts[] contactsOfPersons = new Contacts[10];

    @Override
    public int createContacts(Contacts contacts) {
        System.out.println(contacts);
        int index = getIndexForNextEmptyLocation();
        System.out.println("index = " + index);
        contactsOfPersons[index] = contacts;
        return index;
    }

    private int getIndexForNextEmptyLocation() {

        for (int i = 0; i < contactsOfPersons.length; i++) {

            if (null == contactsOfPersons[i]) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void showContacts() {
        System.out.println("Showing All Contacts Details.....");

        for (int i = 0; i < contactsOfPersons.length; i++) {
            showContactsDetails(contactsOfPersons[i]);
        }
    }

    public void showContactsDetails(Contacts contacts) {

        if (contacts != null) {
            System.out.println("firstName = " + contacts.getFirstName());
            System.out.println("lastName = " + contacts.getLastName());
            System.out.println("Address = " + contacts.getAddress());
            System.out.println("Email = " + contacts.getEmail());
            System.out.println("Zip = " + contacts.getZip());
            System.out.println("State = " + contacts.getState());
            System.out.println("City = " + contacts.getCity());
            System.out.println("phoneNumber = " + contacts.getPhoneNumber());
        }
    }
}
