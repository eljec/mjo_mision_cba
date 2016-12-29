package com.mjo.misioncba;

import java.util.ArrayList;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ItineraryDay {

    private String title;
    private ArrayList<ItineraryDayEvent> events;

    public ArrayList<ItineraryDayEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<ItineraryDayEvent> events) {
        this.events = events;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
