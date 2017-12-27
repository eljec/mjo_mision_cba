package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 24/12/17.
 */

public class Sections
{
    @SerializedName("prayers")
    @Expose
    private SectionPrayers prayers;
    @SerializedName("songbook")
    @Expose
    private SectionSongbook songbook;


    public SectionPrayers getPrayers() {
        return prayers;
    }

    public void setPrayers(SectionPrayers prayers) {
        this.prayers = prayers;
    }

    public SectionSongbook getSongbook() {
        return songbook;
    }

    public void setSongbook(SectionSongbook songbook) {
        this.songbook = songbook;
    }

    // Available helpers

    public boolean hasItinerary()
    {
        return false;
    }

    public boolean hasReadings()
    {
        return false;
    }

    public boolean hasMerchandising()
    {
        return false;
    }

    public boolean hasContactSection()
    {
        return false;
    }

    public boolean hasGroups()
    {
        return false;
    }

    public boolean hasFeedback()
    {
        return true;
    }

    public boolean hasPrayers()
    {
        return this.prayers != null && this.prayers.isActive();
    }

    public boolean hasSongbook()
    {
        return this.songbook != null && this.songbook.isActive();
    }
}
