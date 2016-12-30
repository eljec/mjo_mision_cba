package com.mjo.misioncba.section.itinerary;

/**
 * Created by jucastillo on 28/12/16.
 */
public class ItineraryListViewItemModel {

    public static final int DAY_TYPE=0;
    public static final int EVENT_TYPE=1;

    public int type;
    public String date;
    public String text;
    public int imageType;

    public ItineraryListViewItemModel(int type, String text, String date, int imageType )
    {
        this.type=type;
        this.date=date;
        this.text=text;
        this.imageType = imageType;
    }
}
