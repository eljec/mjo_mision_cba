package com.mjo.misioncba.model;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jucastillo on 1/1/18.
 */

public class ReadingJsonProvider
{
    private final AssetManager assetManager;

    public ReadingJsonProvider(@NonNull AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public ReadingJsonModel obtain(@NonNull String assetFileName) {
        return parseItinerary(createInputStream(assetFileName));
    }

    private InputStream createInputStream(@NonNull String assetFileName) {
        try {
            return assetManager.open(assetFileName);
        } catch (IOException e) {
            throw new IllegalStateException("There is not asset with the name: " + assetFileName, e);
        }
    }

    private ReadingJsonModel parseItinerary(@NonNull InputStream inputStream) {
        try {
            return new ObjectMapper().readValue(inputStream, ReadingJsonModel.class);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot create an instance of ReadingJsonModel from asset resource.", e);
        }
    }
}
