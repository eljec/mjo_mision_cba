package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionReadings
{
    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("days")
    @Expose
    private ArrayList<ReadingDay> days;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<ReadingDay> getDays() {
        return days;
    }

    public void setDays(ArrayList<ReadingDay> days) {
        this.days = days;
    }

    public ReadingDay getReadingModelForDay(int dayId) {

        ReadingDay reading = null;

        if(days != null) {
            for (ReadingDay readingDay: days) {
                if(readingDay.getDayId() == dayId){
                    reading = readingDay;
                    break;
                }
            }
        }
        return reading;
    }
}
