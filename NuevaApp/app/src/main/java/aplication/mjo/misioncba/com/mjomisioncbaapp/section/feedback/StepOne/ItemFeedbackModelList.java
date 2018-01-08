package aplication.mjo.misioncba.com.mjomisioncbaapp.section.feedback.StepOne;

/**
 * Created by jucastillo on 11/1/17.
 */
public class ItemFeedbackModelList {

    private String text;
    private float startValue;
    private String keyType;

    public ItemFeedbackModelList(String text, float startValue, String keyType) {
        this.text = text;
        this.startValue = startValue;
        this.keyType = keyType;
    }

    public ItemFeedbackModelList() {
        this.text = null;
        this.startValue = 0;
    }

    public ItemFeedbackModelList(String text) {
        this.text = text;
        this.startValue = 0;
        this.keyType = null;
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

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
}
