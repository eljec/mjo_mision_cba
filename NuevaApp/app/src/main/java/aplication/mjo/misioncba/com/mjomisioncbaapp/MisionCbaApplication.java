package aplication.mjo.misioncba.com.mjomisioncbaapp;

import android.app.Application;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Sections;


/**
 * Created by jucastillo on 28/12/16.
 */
public class MisionCbaApplication extends Application {

    private Sections sections;

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
