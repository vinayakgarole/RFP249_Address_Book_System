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
}
