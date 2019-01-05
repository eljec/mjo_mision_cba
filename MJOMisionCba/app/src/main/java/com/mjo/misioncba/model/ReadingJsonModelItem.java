package com.mjo.misioncba.model;

/**
 * Created by jucastillo on 1/1/18.
 */

public class ReadingJsonModelItem
{
    private String title;
    private String subtitle;
    private String content;

    public ReadingJsonModelItem() {
    }

    public ReadingJsonModelItem(String title, String subtitle, String content) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEmpty()
    {
        return this.title.isEmpty() && this.subtitle.isEmpty() && this.content.isEmpty();
    }
}
