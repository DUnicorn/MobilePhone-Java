package lt.mobilePhone;

import java.util.ArrayList;

public class MobilePhone {

	private ArrayList<Contact> myContacts;
	private String myNumber;

	public MobilePhone(String myNumber) {
		super();
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();// creating new List
	}

	public boolean addContact(Contact contact) {
		if (findContact(contact.getName()) >= 0) {
			System.out.println("contact is already on file");
			return false;
		}

		myContacts.add(contact);
		return true;
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact);
		if (foundPosition < 0) {
			System.out.println(oldContact.getName() + ", was not found.");
			return false;
		}else if (findContact(newContact.getName()) != -1){
			System.out.println("Contact with name " + newContact.getName() +
					           " already exists. Update was not successuful.");
			return false;
		}
		this.myContacts.set(foundPosition, newContact);
		System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
		return true;
	}

	public boolean removeContact(Contact contact) {
		int foundPosition = findContact(contact);
		if (foundPosition < 0) {
			System.out.println(contact.getName() + ", was not found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		System.out.println(contact.getName() + ", was deleted");
		return true;

	}

	public String queryContact(Contact contact) {
		if (findContact(contact) > 0) {
			return contact.getName();
		}
		return null;
	}

	// position number based on the name
	public Contact queryContact(String name) {
		int position = findContact(name);
		if (position >= 0) {
			return this.myContacts.get(position);
		}
		return null;

	}

	public void printContacts() {
		System.out.println("Contact List");
		for (int i = 0; i < this.myContacts.size(); i++) {
			System.out.println(
					(i + 1) + " ." + this.myContacts.get(i).getName() + " --> " + this.myContacts.get(i).getNumber());

		}
	}

	// showing position int the array
	private int findContact(Contact contact) {
		return this.myContacts.indexOf(contact);
	}

	private int findContact(String contactName) {
		for (int i = 0; i < this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if (contact.getName().equals(contactName)) {
				return i;
			}
		}
		// if was not found
		return -1;
	}

}
