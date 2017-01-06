package com.mjo.misioncba.section.contact;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactModel implements Parcelable {

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

    protected ContactModel(Parcel in) {
        contactName = in.readString();
        contactNumber = in.readString();
        type = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contactName);
        dest.writeString(contactNumber);
        dest.writeInt(type);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ContactModel> CREATOR = new Parcelable.Creator<ContactModel>() {
        @Override
        public ContactModel createFromParcel(Parcel in) {
            return new ContactModel(in);
        }

        @Override
        public ContactModel[] newArray(int size) {
            return new ContactModel[size];
        }
    };
}
