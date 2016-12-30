package com.mjo.misioncba.model;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ItineraryDayEvent {

    private String eventTitle;
    private String eventDate;
    private int eventImageType;


    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventImageType() {
        return eventImageType;
    }

    public void setEventImageType(int eventImageType) {
        this.eventImageType = eventImageType;
    }
}
