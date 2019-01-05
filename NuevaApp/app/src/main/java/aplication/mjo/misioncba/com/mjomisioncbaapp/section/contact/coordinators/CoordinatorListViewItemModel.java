package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.coordinators;


import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ContactCoordinator;

/**
 * Created by jucastillo on 4/1/18.
 */

public class CoordinatorListViewItemModel
{
    public static final int HEADER_TYPE=0;
    public static final int CONTACT_TYPE=1;

    public int type;
    public String text;
    public ContactCoordinator contact;


    public CoordinatorListViewItemModel (int type, String text, ContactCoordinator contact){

        this.type=type;
        this.text=text;
        this.contact = contact;
    }

    public CoordinatorListViewItemModel (int type, String text){

        this.type=type;
        this.text=text;
        this.contact = null;
    }
}
