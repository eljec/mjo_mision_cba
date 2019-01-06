package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Itinerary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.UrlFIle;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ItineraryDayEvent {

    @SerializedName("eventTitle")
    @Expose
    private String eventTitle;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;
    @SerializedName("eventImageType")
    @Expose
    private int eventImageType;
    @SerializedName("dayId")
    @Expose
    private  int dayId;
    @SerializedName("url_file")
    @Expose
    private UrlFIle url;
    @SerializedName("places")
    @Expose
    private List<ItineraryDayEventPlace> places;
    private  int id;
    @SerializedName("id")


    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventImageType() {
        return eventImageType;
    }

    public void setEventImageType(int eventImageType) {
        this.eventImageType = eventImageType;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public List<ItineraryDayEventPlace> getPlaces() {
        return places;
    }

    public void setPlaces(List<ItineraryDayEventPlace> places) {
        this.places = places;
    }

    public UrlFIle getUrl() {
        return url;
    }

    public void setUrl(UrlFIle url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
