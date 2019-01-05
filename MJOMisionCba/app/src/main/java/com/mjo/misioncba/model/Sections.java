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
    @SerializedName("contact")
    @Expose
    private SectionContact contact;
    @SerializedName("feedback")
    @Expose
    private SectionFeedback feedback;
    @SerializedName("groups")
    @Expose
    private SectionGroups groups;
    @SerializedName("reading")
    @Expose
    private SectionReadings reading;
    @SerializedName("merchandising")
    @Expose
    private SectionMerchandising merchandising;
    @SerializedName("itinerary")
    @Expose
    private SectionItinerary itinerary;
    @SerializedName("places")
    @Expose
    private SectionPlaces places;

    @SerializedName("messages")
    @Expose
    private SectionMessage messages;



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

    public SectionContact getContact() {
        return contact;
    }

    public void setContact(SectionContact contact) {
        this.contact = contact;
    }

    public SectionFeedback getFeedback() {
        return feedback;
    }

    public void setFeedback(SectionFeedback feedback) {
        this.feedback = feedback;
    }

    public SectionGroups getGroups() {
        return groups;
    }

    public void setGroups(SectionGroups groups) {
        this.groups = groups;
    }

    public SectionReadings getReading() {
        return reading;
    }

    public void setReading(SectionReadings reading) {
        this.reading = reading;
    }

    public SectionMerchandising getMerchandising() {
        return merchandising;
    }

    public void setMerchandising(SectionMerchandising merchandising) {
        this.merchandising = merchandising;
    }

    public SectionItinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(SectionItinerary itinerary) {
        this.itinerary = itinerary;
    }

    public SectionPlaces getPlaces() {
        return places;
    }

    public void setPlaces(SectionPlaces places) {
        this.places = places;
    }

    public SectionMessage getMessages() {
        return messages;
    }

    public void setMessages(SectionMessage messages) {
        this.messages = messages;
    }

    // Available helpers

    public boolean hasItinerary()
    {
        return this.itinerary!=null && this.itinerary.isActive();
    }

    public boolean hasReadings()
    {
        return this.reading!= null && this.reading.isActive();
    }

    public boolean hasMerchandising() {
        return this.merchandising!= null && this.merchandising.isActive();
    }

    public boolean hasContactSection()
    {
        return this.contact != null && this.contact.isActive();
    }

    public boolean hasGroups()
    {
        return this.groups!=null && this.groups.isActive();
    }

    public boolean hasFeedback()
    {
        return this.feedback != null && this.feedback.isActive();
    }

    public boolean hasPrayers()
    {
        return this.prayers != null && this.prayers.isActive();
    }

    public boolean hasSongbook()
    {
        return this.songbook != null && this.songbook.isActive();
    }

    public boolean hasPlaces()
{
    return this.places != null && this.places.isActive();
}

    public boolean hasMessage()
    {
        return this.messages != null && this.messages.isActive();
    }
}
