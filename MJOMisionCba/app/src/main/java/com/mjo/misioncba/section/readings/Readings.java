package com.mjo.misioncba.section.readings;

/**
 * Created by jucastillo on 30/12/16.
 */

public class Readings {


    public static final int READINBG_TYPE_FIRST=0;
    public static final int READINBG_TYPE_SECOND=1;
    public static final int READINBG_TYPE_PSALMS=2;
    public static final int READINBG_TYPE_GOSPEL=3;


    private int readingType;
    private String readingTitle;
    private String readingSubtitle;
    private String readingText;

    public Readings(int readingType, String readingTitle, String readingSubitle, String readingText) {
        this.readingType = readingType;
        this.readingTitle = readingTitle;
        this.readingSubtitle = readingSubitle;
        this.readingText = readingText;
    }

    public Readings(String readingTitle, String readingSubtitle, String readingText) {
        this.readingTitle = readingTitle;
        this.readingSubtitle = readingSubtitle;
        this.readingText = readingText;
        this.readingType = -1;
    }

    public int getReadingType() {
        return readingType;
    }

    public void setReadingType(int readingType) {
        this.readingType = readingType;
    }

    public String getReadingTitle() {
        return readingTitle;
    }

    public void setReadingTitle(String readingTitle) {
        this.readingTitle = readingTitle;
    }

    public String getReadingText() {
        return readingText;
    }

    public void setReadingText(String readingText) {
        this.readingText = readingText;
    }

    public String getReadingSubtitle() {
        return readingSubtitle;
    }

    public void setReadingSubtitle(String readingSubtitle) {
        this.readingSubtitle = readingSubtitle;
    }
}
