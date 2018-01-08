package aplication.mjo.misioncba.com.mjomisioncbaapp.section.prayer;

/**
 * Created by jucastillo on 5/1/17.
 */
public class Prayer {

    private String title;
    private  String content;

    public Prayer(String title, String content) {
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
