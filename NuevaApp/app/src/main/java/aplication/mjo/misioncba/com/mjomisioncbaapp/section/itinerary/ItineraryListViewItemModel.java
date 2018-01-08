package aplication.mjo.misioncba.com.mjomisioncbaapp.section.itinerary;


import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ItineraryDayEvent;

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
