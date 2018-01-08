package aplication.mjo.misioncba.com.mjomisioncbaapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionContact
{
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("cordinators")
    @Expose
    private ArrayList<ContactCoordinator> coordinators;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<ContactCoordinator> getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(ArrayList<ContactCoordinator> coordinators) {
        this.coordinators = coordinators;
    }

    public ContactCoordinator getCordinatorById(int id)
    {
        ContactCoordinator coordinatorFound = null;
        for (ContactCoordinator aux : this.coordinators)
        {
            if(aux.getId() == id){
                coordinatorFound = aux;
                break;
            }
        }

        return coordinatorFound;
    }
}
