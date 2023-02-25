package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookIMPL implements IAddressBook {

    private static ArrayList<Contacts> contactsOfPersons = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);//for user input

    @Override
    public int createContacts(Contacts contacts) {
        contactsOfPersons.add(contacts);
        System.out.println(contacts.toString());
        return contactsOfPersons.indexOf(contacts);
    }

    private int getIndexForNextEmptyLocation() {

        for (int i = 0; i < contactsOfPersons.size(); i++) {

            if (null == contactsOfPersons.get(i)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void showContacts() {
        System.out.println("Showing All Contacts Details.....");

        for (int i = 0; i < contactsOfPersons.size(); i++) {
            showContactsDetails(contactsOfPersons.get(i));
        }
    }

    @Override
    public void editContacts(String firstName) {
        int i = findByFirstName(firstName);
        if (i != -1) {
            editContactDetails(contactsOfPersons.get(i));
        }
        showContacts();
    }

    public void deleteContacts(String firstName) {
        int i = findByFirstName(firstName);

        if (i != -1) {
            contactsOfPersons.set(i, null);
        } else {
            System.out.println("Name not found");
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

        for (int i = 0; i < contactsOfPersons.size(); i++) {
            Contacts contacts = contactsOfPersons.get(i);

            if (null != contacts && firstName.equalsIgnoreCase(contacts.getFirstName())) {
                return i;
            }
        }
        return -1;
    }
}