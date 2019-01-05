
package aplication.mjo.misioncba.com.mjomisioncbaapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ItineraryDay {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_spinner")
    @Expose
    private String titleSpinner;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("events")
    @Expose
    private ArrayList<ItineraryDayEvent> events;

    public ArrayList<ItineraryDayEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<ItineraryDayEvent> events) {
        this.events = events;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleSpinner() {
        return titleSpinner;
    }

    public void setTitleSpinner(String titleSpinner) {
        this.titleSpinner = titleSpinner;
    }
}
