package com.mjo.misioncba.section.contact;

import android.content.Context;

import com.mjo.misioncba.model.ContactCoordinator;
import com.mjo.misioncba.model.SectionContact;
import com.mjo.misioncba.section.contact.coordinators.CoordinatorListViewItemModel;

import java.util.ArrayList;

import static com.mjo.misioncba.section.contact.coordinators.CoordinatorListViewItemModel.CONTACT_TYPE;
import static com.mjo.misioncba.section.contact.coordinators.CoordinatorListViewItemModel.HEADER_TYPE;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactFragmentInfoGenerator {

    private Context context;

    private static final String FIREMAN_PHONE = "03514515361";
    private static final String POLICE_PHONE = "0351101";
    private static final String HOSPITAL_PHONE = "0351107";

    private SectionContact sectionGroups;

    public ContactFragmentInfoGenerator(Context context, SectionContact sectionGroups) {
        this.context = context;
        this.sectionGroups = sectionGroups;
    }

    public ArrayList<ContactCoordinator> getReferentsContactCoordinators(){

        ArrayList<ContactCoordinator> contacts = new ArrayList<>();

        for (ContactCoordinator contact: sectionGroups.getCoordinators())
        {
            if(contact.isGeneralCoordinatior())
            {
                contacts.add(contact);
            }
        }


        return contacts;
    }

    public ArrayList<ContactCoordinator> getGroupsContactCoordinators() {

        ArrayList<ContactCoordinator> animadores = new ArrayList<>();

        for (ContactCoordinator contact: sectionGroups.getCoordinators())
        {
            if(contact.isGeneralCoordinatior() == false)
            {
                animadores.add(contact);
            }
        }

        return animadores;
    }

    public ContactCottoModel getCottoContactCoordinator(){

        return new ContactCottoModel();
    }


    public ArrayList<CoordinatorListViewItemModel> getListModelCoordinators()
    {
        ArrayList<CoordinatorListViewItemModel> coordinatorListModelView = new ArrayList<>();

        // Header General
        CoordinatorListViewItemModel headerGeneral = new CoordinatorListViewItemModel(HEADER_TYPE, "Coordinadores Generales");
        coordinatorListModelView.add(headerGeneral);

        for (ContactCoordinator contact: getReferentsContactCoordinators())
        {
            CoordinatorListViewItemModel contactGeneral = new CoordinatorListViewItemModel(CONTACT_TYPE,  contact.getName(), contact);
            coordinatorListModelView.add(contactGeneral);
        }

        // Header Normal
        CoordinatorListViewItemModel headerNormal = new CoordinatorListViewItemModel(HEADER_TYPE, "Coordinadores de Grupos");
        coordinatorListModelView.add(headerNormal);

        for (ContactCoordinator contact: getGroupsContactCoordinators())
        {
            CoordinatorListViewItemModel contactNormal = new CoordinatorListViewItemModel(CONTACT_TYPE,  contact.getName(), contact);
            coordinatorListModelView.add(contactNormal);
        }

        return coordinatorListModelView;
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
