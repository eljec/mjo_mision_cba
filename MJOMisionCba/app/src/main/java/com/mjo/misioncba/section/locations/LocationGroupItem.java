package com.mjo.misioncba.section.locations;

/**
 * Created by jucastillo on 2/1/17.
 */
public class LocationGroupItem {

    public static final int HEADER_TYPE=0;
    public static final int LOCATION_TYPE=1;

    private int type;
    private  String content;

    public LocationGroupItem(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
