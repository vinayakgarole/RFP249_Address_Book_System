package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int i = 0;
        System.out.println("Welcome to Address Book System Program");
        IAddressBook addressBook = new AddressBookIMPL();

        do {
            System.out.println("1 Press create contact");
            System.out.println("2 Press show all contacts");
            System.out.println("3 Press Edit Contact");
            System.out.println("4 Press Delete Contact");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Create contact");
                    Contacts contacts = getContacts();
                    int index = addressBook.createContacts(contacts);
                    System.out.println("Contact id = " + index);
                    break;
                case 2:
                    addressBook.showContacts();
                    break;
                case 3:
                    System.out.println("Enter First Name: ");
                    String firstName = sc.next();
                    addressBook.editContacts(firstName);
                    break;
                case 4:
                    System.out.println("Enter the first name of details you want to delete");
                    String firstName1 = sc.next();
                    addressBook.deleteContacts(firstName1);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.println("Do you want to continue press 1.....");
            i = sc.nextInt();
        } while (i == 1);
    }

    private static Contacts getContacts() {
        Contacts contacts = new Contacts();
        System.out.println("Enter First Name: ");
        String firstName = sc.next();
        contacts.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        String lastName = sc.next();
        contacts.setLastName(lastName);

        System.out.println("Enter Address: ");
        String address = sc.next();
        contacts.setAddress(address);

        System.out.println("Enter City: ");
        String city = sc.next();
        contacts.setCity(city);

        System.out.println("Enter State: ");
        String state = sc.next();
        contacts.setState(state);

        System.out.println("Enter Zip: ");
        int zip = sc.nextInt();
        contacts.setZip(zip);

        System.out.println("Enter Phone Number: ");
        String phoneNumber = sc.next();
        contacts.setPhoneNumber(phoneNumber);

        System.out.println("Enter Email: ");
        String email = sc.next();
        contacts.setEmail(email);
        return contacts;
    }
}
