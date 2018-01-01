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
    @SerializedName("coordinator")
    @Expose
    private ArrayList<ContactCoordinator> coordinator;
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

    public ArrayList<ContactCoordinator> getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(ArrayList<ContactCoordinator> coordinator) {
        this.coordinator = coordinator;
    }

    public boolean hasCoordinators() {
        return this.coordinator != null && this.coordinator.size() > 0;
    }

    public boolean hasFood()
    {
        return  this.food!=null && this.food.getText()!=null;
    }

    public boolean hasMembers() {
        return this.members!= null && this.members.size() >0;
    }
}
