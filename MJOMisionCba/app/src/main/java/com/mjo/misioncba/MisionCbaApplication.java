package com.mjo.misioncba;

import android.app.Application;

import com.mjo.misioncba.model.Itinerary;
import com.mjo.misioncba.model.Sections;

/**
 * Created by jucastillo on 28/12/16.
 */
public class MisionCbaApplication extends Application {

    private Itinerary itinerary;

    private Sections sections;

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
