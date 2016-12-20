package com.mjo.misioncba.section.contact;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactModel {

    private String contactName;
    private  String contactNumber;

    public ContactModel(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
