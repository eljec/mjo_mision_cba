package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ReadingDay {

    @SerializedName("dayTitle")
    @Expose
    private String dayTitle;
    @SerializedName("dayId")
    @Expose
    private int dayId;
    @SerializedName("readings")
    @Expose
    private ArrayList<ReadingDayReading> readings;

    public String getDayTitle() {
        return dayTitle;
    }

    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public ArrayList<ReadingDayReading> getReadings() {
        return readings;
    }

    public void setReadings(ArrayList<ReadingDayReading> readings) {
        this.readings = readings;
    }
}
