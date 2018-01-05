package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 5/1/18.
 */

public class SectionMessage
{
    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("info")
    @Expose
    private SectionMessageItem message;

    public SectionMessage() {
    }

    public SectionMessageItem getMessage() {
        return message;
    }

    public void setMessage(SectionMessageItem message) {
        this.message = message;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
