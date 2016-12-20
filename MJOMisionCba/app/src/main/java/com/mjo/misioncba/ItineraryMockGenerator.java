package com.mjo.misioncba;

import java.util.ArrayList;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ItineraryMockGenerator {

    public Itinerary getMockItinerary(){

        Itinerary mock = new Itinerary();


        // Day 1

        ItineraryDay dayOne = new ItineraryDay();

        // Events

        ItineraryDayEvent eventOne = new ItineraryDayEvent();

        eventOne.setEventTitle("Desayuno");
        eventOne.setEventDate("12:30");

        ArrayList<ItineraryDayEvent> events = new ArrayList<ItineraryDayEvent> ();
        events.add(eventOne);

        dayOne.setEvents(events);


        ArrayList<ItineraryDay> days = new ArrayList<ItineraryDay> ();
        days.add(dayOne);

        mock.setDays(days);

        return mock;
    }
}
