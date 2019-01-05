package aplication.mjo.misioncba.com.mjomisioncbaapp.section.songbook;

/**
 * Created by jucastillo on 7/1/17.
 */
public class Song {

    private String title;
    private  String content;

    public Song(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
