package com.mjo.misioncba.model;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjo.misioncba.Itinerary;

import java.io.IOException;
import java.io.InputStream;

/**
 * Provides an itinerary from the asset folder.
 * <p>
 * Created by mbel on 12/28/16.
 */
public class ItineraryProvider {

    private final AssetManager assetManager;
    private final String assetFileName;

    public ItineraryProvider(@NonNull AssetManager assetManager, @NonNull String assetFileName) {
        this.assetManager = assetManager;
        this.assetFileName = assetFileName;
    }

    public Itinerary obtain() {
        String jsonTextFromAssets = obtainJsonString(createInputStream());
        return parseItinerary(jsonTextFromAssets);
    }

    private InputStream createInputStream() {
        try {
            return assetManager.open(assetFileName);
        } catch (IOException e) {
            throw new IllegalStateException("There is not asset with the name: " + assetFileName, e);
        }
    }

    private String obtainJsonString(@NonNull InputStream inputStream) {
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            return new String(buffer);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot process asset file.", e);
        }
    }

    private Itinerary parseItinerary(@NonNull String jsonText) {
        try {
            return new ObjectMapper().readValue(jsonText, Itinerary.class);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot create an instance of Itinerary from asset resource. Invalid json: " + jsonText, e);
        }
    }
}
