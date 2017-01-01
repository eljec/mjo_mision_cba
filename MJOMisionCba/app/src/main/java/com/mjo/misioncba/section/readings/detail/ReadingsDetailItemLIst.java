package com.mjo.misioncba.section.readings.detail;

import com.mjo.misioncba.section.readings.Readings;

/**
 * Created by jucastillo on 30/12/16.
 */
public class ReadingsDetailItemLIst {

    public static final int READINBG_ITEM_LIST_TYPE_HEADER=0;
    public static final int READINBG_ITEM_LIST_TYPE_CONTENT=1;


    private int readingItemListType;
    private Readings readingModel;

    public ReadingsDetailItemLIst(int readingItemListType) {
        this.readingItemListType = readingItemListType;
    }

    public ReadingsDetailItemLIst(int readingItemListType, Readings readingModel) {
        this.readingItemListType = readingItemListType;
        this.readingModel = readingModel;
    }

    public int getReadingItemListType() {
        return readingItemListType;
    }

    public void setReadingItemListType(int readingItemListType) {
        this.readingItemListType = readingItemListType;
    }

    public Readings getReadingModel() {
        return readingModel;
    }

    public void setReadingModel(Readings readingModel) {
        this.readingModel = readingModel;
    }
}
