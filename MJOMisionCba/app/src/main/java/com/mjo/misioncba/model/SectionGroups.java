package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionGroups
{
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("list")
    @Expose
    ArrayList<SectionGroupsItem> list;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<SectionGroupsItem> getList() {
        return list;
    }

    public void setList(ArrayList<SectionGroupsItem> list) {
        this.list = list;
    }

    public SectionGroupsItem getGroupByPosition(int position)
    {
        return this.list.get(position);
    }
}
