package com.mjo.misioncba.section.itinerary;

import com.mjo.misioncba.model.ItineraryDayEvent;
import com.mjo.misioncba.model.ItineraryDayEventPlace;

import java.util.List;

/**
 * Created by jucastillo on 28/12/16.
 */
public class ItineraryListViewItemModel {

    public static final int DAY_TYPE=0;
    public static final int EVENT_TYPE=1;

    public int type;
    public String text;
    public ItineraryDayEvent event;


    public ItineraryListViewItemModel (int type, String text, ItineraryDayEvent event){

        this.type=type;
        this.text=text;
        this.event = event;
    }

    public ItineraryListViewItemModel (int type, String text){

        this.type=type;
        this.text=text;
        this.event = null;
    }
}
