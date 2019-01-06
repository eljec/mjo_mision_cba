package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadingDayReading {

    @SerializedName("title")
    @Expose
    private GenericTextContentModel title;

    @SerializedName("subtitle")
    @Expose
    private GenericTextContentModel subtitle;

    @SerializedName("content")
    @Expose
    private GenericTextContentModel content;

    public GenericTextContentModel getTitle() {
        return title;
    }

    public void setTitle(GenericTextContentModel title) {
        this.title = title;
    }

    public GenericTextContentModel getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(GenericTextContentModel subtitle) {
        this.subtitle = subtitle;
    }

    public GenericTextContentModel getContent() {
        return content;
    }

    public void setContent(GenericTextContentModel content) {
        this.content = content;
    }
}
