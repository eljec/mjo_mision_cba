package com.mjo.misioncba.section.readings.detail;

import android.content.Context;

import com.mjo.misioncba.model.ReadingJsonModel;
import com.mjo.misioncba.model.ReadingJsonProvider;
import com.mjo.misioncba.section.readings.Readings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jucastillo on 30/12/16.
 */
public class ReadingDetailListItemGenerator {

    private Context context;

    public ReadingDetailListItemGenerator(Context context) {
        this.context = context;
    }

    private ReadingJsonModel loadReadingJsonModelForDay(int day)
    {
        ReadingJsonModel model = null;

       String READING_ASSET_FILE = "reading_day_" + day+ ".json";

        ReadingJsonProvider provider = new ReadingJsonProvider(context.getAssets());
        model = provider.obtain(READING_ASSET_FILE);

       return model;
    }

    public List<Readings> getReadingForDay(int day){

        List<Readings> readingForDay = new ArrayList<Readings>();
        ReadingJsonModel jsonModel = loadReadingJsonModelForDay(day);

        if(day > 0 && day <= 9 && jsonModel!=null)
        {
            // Create  view model

            if(jsonModel.getFirstReading().isEmpty() == false) {
                Readings reading = new Readings(jsonModel.getFirstReading().getTitle(), jsonModel.getFirstReading().getSubtitle(), jsonModel.getFirstReading().getContent());
                readingForDay.add(reading);
            }

            if(jsonModel.getPsalm().isEmpty() == false) {
                Readings readingPsalm = new Readings(jsonModel.getPsalm().getTitle(), jsonModel.getPsalm().getSubtitle(), jsonModel.getPsalm().getFullContent());
                readingForDay.add(readingPsalm);
            }

            if(jsonModel.getSecondReading().isEmpty() == false) {
                Readings readingSecond = new Readings(jsonModel.getSecondReading().getTitle(), jsonModel.getSecondReading().getSubtitle(), jsonModel.getSecondReading().getContent());
                readingForDay.add(readingSecond);
            }
            if(jsonModel.getGospelReading().isEmpty() == false) {
                Readings readingGospel = new Readings(jsonModel.getGospelReading().getTitle(), jsonModel.getGospelReading().getSubtitle(), jsonModel.getGospelReading().getContent());
                readingForDay.add(readingGospel);
            }
        }

        return readingForDay;
    }
}
