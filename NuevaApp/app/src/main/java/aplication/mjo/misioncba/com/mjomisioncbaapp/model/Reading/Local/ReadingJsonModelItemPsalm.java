package aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.Local;

import java.util.ArrayList;

/**
 * Created by jucastillo on 2/1/18.
 */

public class ReadingJsonModelItemPsalm
{
    private String title;
    private String subtitle;
    private ArrayList<String> content;

    public ReadingJsonModelItemPsalm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ArrayList<String> getContent()
    {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    public String getFullContent()
    {
        StringBuilder content = new StringBuilder();

        for (String psalm: this.content) {
            content.append(psalm);
            content.append("\n");
            content.append("\n");
        }
        return content.toString();
    }

    public boolean isEmpty()
    {
        return this.title.isEmpty() && this.subtitle.isEmpty() && this.content.isEmpty();
    }
}
