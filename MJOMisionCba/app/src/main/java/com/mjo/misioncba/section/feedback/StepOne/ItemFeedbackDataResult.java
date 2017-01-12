package com.mjo.misioncba.section.feedback.StepOne;

/**
 * Created by jucastillo on 11/1/17.
 */
public class ItemFeedbackDataResult {

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
}
