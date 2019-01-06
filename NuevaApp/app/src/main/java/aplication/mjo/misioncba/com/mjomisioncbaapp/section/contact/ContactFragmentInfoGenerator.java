package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact;

import android.content.Context;

import java.util.ArrayList;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ContactCoordinator;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionContact;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.coordinators.CoordinatorListViewItemModel;

import static aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.coordinators.CoordinatorListViewItemModel.CONTACT_TYPE;
import static aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.coordinators.CoordinatorListViewItemModel.HEADER_TYPE;


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

        if(sectionGroups !=  null) {
            for (ContactCoordinator contact : sectionGroups.getCoordinators()) {
                if (contact.isGeneralCoordinatior()) {
                    contacts.add(contact);
                }
            }
        }


        return contacts;
    }

    public ArrayList<ContactCoordinator> getGroupsContactCoordinators() {

        ArrayList<ContactCoordinator> animadores = new ArrayList<>();

        if(sectionGroups != null) {
            for (ContactCoordinator contact : sectionGroups.getCoordinators()) {
                if (contact.isGeneralCoordinatior() == false) {
                    animadores.add(contact);
                }
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
        ArrayList<ContactCoordinator> groupsRefContactCoordinators =  getReferentsContactCoordinators();

        if(groupsRefContactCoordinators.isEmpty() == false){
            CoordinatorListViewItemModel headerGeneral = new CoordinatorListViewItemModel(HEADER_TYPE, "Generales");
            coordinatorListModelView.add(headerGeneral);

            for (ContactCoordinator contact: groupsRefContactCoordinators)
            {
                CoordinatorListViewItemModel contactGeneral = new CoordinatorListViewItemModel(CONTACT_TYPE,  contact.getName(), contact);
                coordinatorListModelView.add(contactGeneral);
            }
        }


        // Header Normal
        ArrayList<ContactCoordinator> groupsContactCoordinators =  getGroupsContactCoordinators();

        if(groupsContactCoordinators.isEmpty() == false){
            CoordinatorListViewItemModel headerNormal = new CoordinatorListViewItemModel(HEADER_TYPE, "Grupales");
            coordinatorListModelView.add(headerNormal);

            for (ContactCoordinator contact: groupsContactCoordinators)
            {
                CoordinatorListViewItemModel contactNormal = new CoordinatorListViewItemModel(CONTACT_TYPE,  contact.getName(), contact);
                coordinatorListModelView.add(contactNormal);
            }
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
