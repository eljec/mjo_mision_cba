package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 31/12/17.
 */

public class SectionPlaces
{
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("list")
    @Expose
    private ArrayList<SectionPlacesItem> list;

    public ArrayList<SectionPlacesItem> getList() {
        return list;
    }

    public void setList(ArrayList<SectionPlacesItem> list) {
        this.list = list;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getListNamePlaces()
    {
        StringBuilder listName = new StringBuilder();

        for (SectionPlacesItem place: this.list)
        {
            if(place.getName()!=null)
            {
                listName.append("-"+place.getName());
                listName.append("\n");
            }
        }

        return listName.toString();
    }
}
