package com.mjo.misioncba;

import android.app.Application;

import com.mjo.misioncba.model.Itinerary;
import com.mjo.misioncba.model.ItineraryProvider;

import static com.mjo.misioncba.model.ItineraryProviderConstants.ITINERARY_ASSET_FILE;

/**
 * Created by jucastillo on 28/12/16.
 */
public class MisionCbaApplication extends Application {

    private Itinerary itinerary;

    public Itinerary getItinerary() {
        return itinerary;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Load the file

        Itinerary result = new ItineraryProvider(getAssets()).obtain(ITINERARY_ASSET_FILE);
        this.itinerary = result;

    }
}
