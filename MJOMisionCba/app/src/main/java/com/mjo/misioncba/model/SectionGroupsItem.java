package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionGroupsItem
{
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String  name;
    @SerializedName("map")
    @Expose
    private String  map;
    @SerializedName("cordinator")
    @Expose
    private SectionGroupsItemCoordinator cordinator;
    @SerializedName("food")
    @Expose
    private SectionGroupsItemFood food;
    @SerializedName("members")
    @Expose
    private ArrayList<String> members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public SectionGroupsItemCoordinator getCordinator() {
        return cordinator;
    }

    public void setCordinator(SectionGroupsItemCoordinator cordinator) {
        this.cordinator = cordinator;
    }

    public SectionGroupsItemFood getFood() {
        return food;
    }

    public void setFood(SectionGroupsItemFood food) {
        this.food = food;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
}
