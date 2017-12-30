package com.mjo.misioncba;

import android.app.Application;

import com.mjo.misioncba.model.SectionItinerary;
import com.mjo.misioncba.model.Sections;

/**
 * Created by jucastillo on 28/12/16.
 */
public class MisionCbaApplication extends Application {

    private SectionItinerary sectionItinerary;

    private Sections sections;

    public SectionItinerary getSectionItinerary() {
        return sectionItinerary;
    }

    public void setSectionItinerary(SectionItinerary sectionItinerary) {
        this.sectionItinerary = sectionItinerary;
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
