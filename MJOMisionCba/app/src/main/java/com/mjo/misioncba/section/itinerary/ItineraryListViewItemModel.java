package com.mjo.misioncba.section.itinerary;

/**
 * Created by jucastillo on 28/12/16.
 */
public class ItineraryListViewItemModel {

    public static final int DAY_TYPE=0;
    public static final int EVENT_TYPE=1;

    public int type;
    public int data;
    public String text;

    public ItineraryListViewItemModel(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }
}
