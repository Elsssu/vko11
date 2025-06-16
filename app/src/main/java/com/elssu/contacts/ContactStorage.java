package com.elssu.contacts;

import java.util.ArrayList;

public class ContactStorage {
    private ArrayList<Contact> contacts = new ArrayList<>();

    private static ContactStorage storage = null;

    private ContactStorage() {
    }

    public static ContactStorage getInstance() {
        if(storage == null) {
            storage = new ContactStorage();
        }
        return storage;
    }
    public ArrayList<Contact> getContacts(){
        return contacts;
    }
    public void removeContact(String id) {
        int i = 0;
        for (Contact r : contacts) {
            if (r.getFullName().equals(id)) {
                break;
            }
            i++;
        }
        contacts.remove(i);
    }

    public void addContact( Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int id) {
        contacts.remove(id);
    }
}
