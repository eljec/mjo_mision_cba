package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Itinerary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.PlaceMap;

/**
 * Created by jucastillo on 5/1/17.
 */
public class ItineraryDayEventPlace {

    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("priest")
    @Expose
    private String priest;
    @SerializedName("specificPlace")
    @Expose
    private String specificPlace;
    @SerializedName("specificPlaceMap")
    @Expose
    private PlaceMap specificPlaceMap;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPriest() {
        return priest;
    }

    public void setPriest(String priest) {
        this.priest = priest;
    }

    public String getSpecificPlace() {
        return specificPlace;
    }

    public void setSpecificPlace(String specificPlace) {
        this.specificPlace = specificPlace;
    }

    public PlaceMap getSpecificPlaceMap() {
        return specificPlaceMap;
    }

    public void setSpecificPlaceMap(PlaceMap specificPlaceMap) {
        this.specificPlaceMap = specificPlaceMap;
    }
}
