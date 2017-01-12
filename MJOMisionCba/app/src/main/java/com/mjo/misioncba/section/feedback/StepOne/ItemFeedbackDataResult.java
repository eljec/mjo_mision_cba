package com.mjo.misioncba.section.feedback.StepOne;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jucastillo on 11/1/17.
 */

public class ItemFeedbackDataResult implements Parcelable {

    private float value;
    private String key;

    public ItemFeedbackDataResult(float value, String key) {
        this.value = value;
        this.key = key;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    protected ItemFeedbackDataResult(Parcel in) {
        value = in.readFloat();
        key = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(value);
        dest.writeString(key);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ItemFeedbackDataResult> CREATOR = new Parcelable.Creator<ItemFeedbackDataResult>() {
        @Override
        public ItemFeedbackDataResult createFromParcel(Parcel in) {
            return new ItemFeedbackDataResult(in);
        }

        @Override
        public ItemFeedbackDataResult[] newArray(int size) {
            return new ItemFeedbackDataResult[size];
        }
    };
}
