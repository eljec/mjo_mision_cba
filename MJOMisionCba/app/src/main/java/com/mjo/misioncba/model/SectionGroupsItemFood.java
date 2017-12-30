package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionGroupsItemFood
{
    @SerializedName("text")
    @Expose
    private String  text;
    @SerializedName("gps_latitud")
    @Expose
    private long gpsLatitud;
    @SerializedName("gps_longitud")
    @Expose
    private long gpsLongitud;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getGpsLatitud() {
        return gpsLatitud;
    }

    public void setGpsLatitud(long gpsLatitud) {
        this.gpsLatitud = gpsLatitud;
    }

    public long getGpsLongitud() {
        return gpsLongitud;
    }

    public void setGpsLongitud(long gpsLongitud) {
        this.gpsLongitud = gpsLongitud;
    }
}
