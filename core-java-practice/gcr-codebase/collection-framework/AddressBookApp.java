import java.util.*;

// Simple Contact class
class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

// Main AddressBookApp class
public class AddressBookApp {
    private ArrayList<Contact> contacts;
    private HashMap<String, Contact> contactByName;
    private HashSet<String> phoneNumbers;

    public AddressBookApp() {
        contacts = new ArrayList<Contact>();
        contactByName = new HashMap<String, Contact>();
        phoneNumbers = new HashSet<String>();
    }

    public void addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number not allowed: " + phone);
            return;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        contactByName.put(name.toLowerCase(), contact);
        phoneNumbers.add(phone);
        System.out.println("Contact added: " + name);
    }

    public void searchContact(String name) {
        Contact contact = contactByName.get(name.toLowerCase());
        if (contact != null) {
            System.out.println(contact.name + " | " + contact.phone + " | " + contact.email);
        } else {
            System.out.println("Contact not found");
        }
    }

    public void deleteContact(String name) {
        Contact contact = contactByName.remove(name.toLowerCase());
        if (contact != null) {
            contacts.remove(contact);
            phoneNumbers.remove(contact.phone);
            System.out.println("Contact deleted: " + contact.name);
        } else {
            System.out.println("Contact not found");
        }
    }

    public void displaySortedContacts() {
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact first, Contact second) {
                return first.name.compareToIgnoreCase(second.name);
            }
        });

        System.out.println("Sorted contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact.name + " | " + contact.phone + " | " + contact.email);
        }
    }

    public static void main(String[] args) {
        AddressBookApp book = new AddressBookApp();

        book.addContact("Ravi", "9876543210", "ravi@mail.com");
        book.addContact("Anita", "9123456780", "anita@mail.com");
        book.addContact("Karan", "9988776655", "karan@mail.com");
        book.addContact("Mina", "9876543210", "mina@mail.com");

        book.searchContact("Anita");
        book.deleteContact("Karan");
        book.displaySortedContacts();
    }
}

