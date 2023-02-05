package com.bridgelabz;

import java.util.Scanner;

public class AddressBookIMPL implements IAddressBook {

    private static Contacts[] contactsOfPersons = new Contacts[10];
    private static Scanner sc = new Scanner(System.in);//for user input

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

    @Override
    public void editContacts(String firstName) {
        int i = findByFirstName(firstName);
        if (i != -1) {
            editContactDetails(contactsOfPersons[i]);
        }
        showContacts();
    }

    private void editContactDetails(Contacts contacts) {
        Contacts con = new Contacts();

        int exit = 1;
        do {
            System.out.println("Choose Option to Update :: " + '\n' + " 1.FirstName " + '\n' + " 2.LastName " + '\n' + " 3.Address "
                    + '\n' + " 4.City " + '\n' + " 5.State " + '\n' + " 6.Zip " + '\n'
                    + " 7.PhoneNumber " + '\n' + " 9.Email_ID ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println(" FirstName :: ");
                    contacts.setFirstName(sc.next());
                    break;
                case 2:
                    System.out.println(" LastName :: ");
                    contacts.setLastName(sc.next());
                    break;
                case 3:
                    System.out.println(" Address :: ");
                    contacts.setAddress(sc.next());
                    break;
                case 4:
                    System.out.println(" City :: ");
                    contacts.setCity(sc.next());
                    break;
                case 5:
                    System.out.println(" State :: ");
                    con.setState(sc.next());
                    break;
                case 6:
                    System.out.println(" Zip :: ");
                    contacts.setZip(sc.nextInt());
                    break;
                case 7:
                    System.out.println(" PhoneNumber :: ");
                    contacts.setPhoneNumber(sc.next());
                    break;
                case 8:
                    System.out.println(" Email_ID :: ");
                    contacts.setEmail(sc.next());
                    break;
                default:
                    System.out.println(" ****---- Invalid Input ----**** ");
            }
            System.out.println(" Press 1: If you want to update anything else " + '\n' + " Press 0: Exit to Menu ");
            exit = sc.nextByte();
        } while (exit != 0);
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

    private int findByFirstName(String firstName) {

        for (int i = 0; i < contactsOfPersons.length; i++) {
            Contacts contacts = contactsOfPersons[i];

            if (null != contacts && firstName.equalsIgnoreCase(contacts.getFirstName())) {
                return i;
            }
        }
        return -1;
    }
}
