package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 24/12/17.
 */

public class SectionPrayers
{
    @SerializedName("url_file")
    @Expose
    private UrlFIle url;

    @SerializedName("active")
    @Expose
    private boolean active;

    public SectionPrayers() {
    }

    public SectionPrayers(UrlFIle url, boolean active)
    {
        this.url = url;
        this.active = active;
    }

    public UrlFIle getUrl() {
        return url;
    }

    public void setUrl(UrlFIle url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
