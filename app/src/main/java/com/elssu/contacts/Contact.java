package com.elssu.contacts;

public class Contact {
    String firstName;
    String lastName;
    String number;
    String contactGroup;
    String fullName;
    int image;


    public Contact() {
        firstName = null;
        lastName = null;
        fullName = null;
        number = null;
        contactGroup = null;

    }

    public Contact(String firstname, String lastname, String number, String contactGroup) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.fullName = (firstName + " " + lastName);
        this.number = number;
        this.contactGroup = contactGroup;
        image = R.drawable.placeholdprofpic;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }
    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public int getImage(){
        return image;
    }
}
