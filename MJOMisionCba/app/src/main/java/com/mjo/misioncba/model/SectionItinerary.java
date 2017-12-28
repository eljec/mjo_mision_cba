package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 20/12/16.
 */
public class SectionItinerary {

    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("days")
    @Expose
    private ArrayList<ItineraryDay> days;

    public ArrayList<ItineraryDay> getDays() {
        return days;
    }

    public void setDays(ArrayList<ItineraryDay> days) {
        this.days = days;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
