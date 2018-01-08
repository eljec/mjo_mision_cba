package aplication.mjo.misioncba.com.mjomisioncbaapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionFeedback
{
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("url_form")
    @Expose
    private String  urlForm;
    @SerializedName("questions")
    @Expose
    private ArrayList<SectionFeedbackQuestion> questions;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUrlForm() {
        return urlForm;
    }

    public void setUrlForm(String urlForm) {
        this.urlForm = urlForm;
    }

    public ArrayList<SectionFeedbackQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<SectionFeedbackQuestion> questions) {
        this.questions = questions;
    }
}
