package com.mjo.misioncba.section.contact;

import android.content.Context;
import android.content.res.Resources;

import com.mjo.misioncba.R;

import java.util.ArrayList;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactFragmentInfoGenerator {

    private Context context;

    private static final String FIREMAN_PHONE = "03514515361";
    private static final String POLICE_PHONE = "0351101";
    private static final String HOSPITAL_PHONE = "0351107";

    public ContactFragmentInfoGenerator(Context context) {
        this.context = context;
    }

    public ArrayList<ContactModel> getReferentsContactModels(){

        ArrayList<ContactModel> contacts = new ArrayList<>();

        // Load the array of resources and create de classes

        Resources res = this.context.getResources();
        String[] referentsName = res.getStringArray(R.array.referents_name);
        String[] referentsPhoneNumber = res.getStringArray(R.array.referents_phone_number);


        for (int i = 0; i < referentsName.length; i++) {
            String name = referentsName[i];
            String phoneNUmber = referentsPhoneNumber[i];

            ContactModel contact = new ContactModel(name, phoneNUmber);

            contacts.add(contact);
        }
        return contacts;
    }

    public ContactCottoModel getCottoContactModel(){

        return new ContactCottoModel();
    }

    public String getPolicePhoe(){

        return POLICE_PHONE;
    }

    public  String getHospitalPhone(){

        return  HOSPITAL_PHONE;
    }

    public  String getFiremanPhone(){
        return FIREMAN_PHONE;
    }
}
