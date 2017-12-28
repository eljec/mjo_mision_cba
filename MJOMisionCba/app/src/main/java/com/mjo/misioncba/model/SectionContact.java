package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionContact
{
    @SerializedName("active")
    @Expose
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
