package com.mjo.misioncba.section.feedback.StepOne;

/**
 * Created by jucastillo on 11/1/17.
 */
public class ItemFeedbackModelList {

    private String text;
    private float startValue;

    public ItemFeedbackModelList(String text, float startValue) {
        this.text = text;
        this.startValue = startValue;
    }

    public ItemFeedbackModelList() {
        this.text = null;
        this.startValue = 0;
    }

    public ItemFeedbackModelList(String text) {
        this.text = text;
        this.startValue = 0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getStartValue() {
        return startValue;
    }

    public void setStartValue(float startValue) {
        this.startValue = startValue;
    }
}
