package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.GenericTextContentModel;

public class TaskDay {

    @SerializedName("dayTitle")
    @Expose
    private String dayTitle;
    @SerializedName("dayId")
    @Expose
    private int dayId;
    @SerializedName("tasks")
    @Expose
    private GenericTextContentModel task;

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

    public GenericTextContentModel getTask() {
        return task;
    }

    public void setTask(GenericTextContentModel task) {
        this.task = task;
    }
}
