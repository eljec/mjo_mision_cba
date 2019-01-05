package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadingDayReading {

    @SerializedName("title")
    @Expose
    private ReadingTextContentModel title;

    @SerializedName("subtitle")
    @Expose
    private ReadingTextContentModel subtitle;

    @SerializedName("content")
    @Expose
    private ReadingTextContentModel content;

    public ReadingTextContentModel getTitle() {
        return title;
    }

    public void setTitle(ReadingTextContentModel title) {
        this.title = title;
    }

    public ReadingTextContentModel getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(ReadingTextContentModel subtitle) {
        this.subtitle = subtitle;
    }

    public ReadingTextContentModel getContent() {
        return content;
    }

    public void setContent(ReadingTextContentModel content) {
        this.content = content;
    }
}
