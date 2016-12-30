package com.mjo.misioncba.section.contact;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactModel {

    private String contactName;
    private  String contactNumber;
    private int type;

    public ContactModel(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.type = -1;
    }

    public ContactModel(String contactName, String contactNumber, int type) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.type = type;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
