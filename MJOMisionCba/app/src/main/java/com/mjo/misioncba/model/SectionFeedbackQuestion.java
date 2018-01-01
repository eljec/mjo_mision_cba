package com.mjo.misioncba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionFeedbackQuestion
{
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("form_key")
    @Expose
    private String formKey;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCloseQuestion() {

        return this.type != null && this.type.isEmpty()== false && this.type.equals("close");
    }

    public boolean isOpenQuestion() {

        return this.type != null && this.type.isEmpty()== false && this.type.equals("open");
    }
}
