package com.mjo.misioncba.model;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Provides an itinerary from the asset folder.
 * <p>
 * Created by mbel on 12/28/16.
 */
public class ItineraryProvider {

    private final AssetManager assetManager;

    public ItineraryProvider(@NonNull AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public SectionItinerary obtain(@NonNull String assetFileName) {
        return parseItinerary(createInputStream(assetFileName));
    }

    private InputStream createInputStream(@NonNull String assetFileName) {
        try {
            return assetManager.open(assetFileName);
        } catch (IOException e) {
            throw new IllegalStateException("There is not asset with the name: " + assetFileName, e);
        }
    }

    private SectionItinerary parseItinerary(@NonNull InputStream inputStream) {
        try {
            return new ObjectMapper().readValue(inputStream, SectionItinerary.class);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot create an instance of SectionItinerary from asset resource.", e);
        }
    }
}
