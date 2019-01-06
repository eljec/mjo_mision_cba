package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SectionTask {

    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("days")
    @Expose
    private ArrayList<TaskDay> days;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<TaskDay> getDays() {
        return days;
    }

    public void setDays(ArrayList<TaskDay> days) {
        this.days = days;
    }
}
