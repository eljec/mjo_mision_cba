package aplication.mjo.misioncba.com.mjomisioncbaapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 27/12/17.
 */

public class UrlFIle
{
    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("link")
    @Expose
    private String link;

    public UrlFIle(String extension, String link) {
        this.extension = extension;
        this.link = link;
    }

    public UrlFIle()
    {

    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
