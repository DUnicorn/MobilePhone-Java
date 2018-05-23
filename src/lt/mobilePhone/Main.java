package lt.mobilePhone;

import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static MobilePhone mobilePhone = new MobilePhone("86 547 8742");

	public static void main(String[] args) {

		boolean quit = false;
		startPhone();
		printInstructions();

		while (!quit) {
			System.out.println("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 0:
				System.out.println("\nShutting down..");
				quit = true;
				break;
			case 1:
				mobilePhone.printContacts();
				break;
			case 2:
				addContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printInstructions();
				break;
			}
		}

	}

	private static void addContact() {
		System.out.println("Enter contact name: ");
		String name = sc.nextLine();
		System.out.println("Enter phone number: ");
		String phone = sc.nextLine();
		Contact newContact = Contact.createContact(name, phone);
		if (mobilePhone.addContact(newContact)) {
			System.out.println("New contact added: " + name + ", phone: " + phone);
		} else {
			System.out.println("Can not add, " + name + "already on file");
		}
	}

	private static void updateContact() {
		System.out.println("Enter existing contact: ");
		String name = sc.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if (existingContact == null) {
			System.out.println("Contact not found");
			return;
		}

		System.out.println("Enter new contact name: ");
		String newName = sc.nextLine();
		System.out.println("Enter new contact number: ");
		String newNumber = sc.nextLine();
		Contact newContact = Contact.createContact(newName, newNumber);
		if (mobilePhone.updateContact(existingContact, newContact)) {
			System.out.println("Record was updated.");
		} else {
			System.out.println("Error updating record.");
		}
		;
	}

	private static void removeContact() {
		System.out.println("Enter existing contact: ");
		String name = sc.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if (existingContact == null) {
			System.out.println("Contact not found.");
			return;
		}
		if (mobilePhone.removeContact(existingContact)) {
			System.out.println("Successufully deleted!");
		} else {
			System.out.println("Error deleting contact.");
		}
	}

	private static void queryContact() {
		System.out.println("Enter existing contact: ");
		String name = sc.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if (existingContact == null) {
			System.out.println("Contact not found.");
			return;
		}
		System.out.println("Name: " + existingContact.getName() + ". Phone number is " + existingContact.getNumber());
	}

	private static void startPhone() {
		System.out.println("Starting phone...");
	}

	private static void printInstructions() {
		System.out.println("\nPress: \n ");
		System.out.println("\t 0 - to shutdown\n" +
		       "\t 1 - to print contacts\n" +
				"\t 2 - to add a new contact\n."+ 
		        "\t 3 - to update contact\n" +
				"\t 4 - to remove contact\n"+
		        "\t 5 - query if an existing contact exists\n" + 
				"\t 6 - to print menu");
		System.out.println("Choose your action: ");
	}
}
