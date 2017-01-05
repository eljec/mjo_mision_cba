package com.mjo.misioncba.model;

import java.util.List;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ItineraryDayEvent {

    private String eventTitle;
    private String eventDate;
    private int eventImageType;
    private  int dayId;
    private List<ItineraryDayEventPlace> places;


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

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public List<ItineraryDayEventPlace> getPlaces() {
        return places;
    }

    public void setPlaces(List<ItineraryDayEventPlace> places) {
        this.places = places;
    }
}
