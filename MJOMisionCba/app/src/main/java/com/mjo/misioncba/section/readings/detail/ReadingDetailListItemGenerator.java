package com.mjo.misioncba.section.readings.detail;

import android.content.Context;
import android.content.res.Resources;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.readings.Readings;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by jucastillo on 30/12/16.
 */
public class ReadingDetailListItemGenerator {

    private static final String KEY_FOR_HEADER_FIRST_READING= "firs_reading_text";
    private static final String KEY_FOR_HEADER_SECOND_READING= "second_reading_text";
    private static final String KEY_FOR_HEADER_PSALMS_READING= "psalms_reading_text";
    private static final String KEY_FOR_HEADER_GOSPEL_READING= "gospel_reading_text";

    private static final String KEY_FOR_FIRST_READING= "firs_reading_text_";
    private static final String KEY_FOR_SECOND_READING= "second_reading_text_";
    private static final String KEY_FOR_PSALMS_READING= "psalms_reading_text_";
    private static final String KEY_FOR_GOSPEL_READING= "gospel_reading_text_";


    private static final String KEY_FOR_FIRST_SUBTITLE_READING= "firs_reading_subtitle_text_";
    private static final String KEY_FOR_SECOND_SUBTITLE_READING= "second_reading_subtitle_text_";
    private static final String KEY_FOR_PSALMS_SUBTITLE_READING= "psalms_reading_subtitle_text_";
    private static final String KEY_FOR_GOSPEL_SUBTITLE_READING= "gospel_reading_subtitle_text_";

    private Context context;

    private String [] mTitles;
    private String [] mSubtitles;
    private String [] mContent;

    public ReadingDetailListItemGenerator(Context context) {
        this.context = context;
    }

    public List<Readings> getReadingForDay(int day){

        List<Readings> readingForDay = new ArrayList<Readings>();

        if(day > 0 && day <= 8){

            loadArraysByDay(day);

            if(mSubtitles.length == mTitles.length && mTitles.length == mContent.length){

                for (int i = 0; i < mTitles.length; i++) {

                    String title = mTitles[i];
                    String subtitle = mSubtitles [i];
                    String content = mContent[i];

                    Readings reading = new Readings(title, subtitle, content);

                    readingForDay.add(reading);
                }
            }

        }
        return readingForDay;
    }

    private void loadArraysByDay(int day){

        int titlesResId,  subtitlesResId,  contentResId;

        switch (day){

            case 1 :
                titlesResId = R.array.readings_for_day_1_title;
                subtitlesResId = R.array.readings_for_day_1_subtitle;
                contentResId = R.array.readings_for_day_1_content;

                break;

            default:
                titlesResId = -1;
                subtitlesResId = -1;
                contentResId = -1;
                break;

        }

        loadArraysByIdRes(titlesResId, subtitlesResId,contentResId);

    }

    private void loadArraysByIdRes(int titlesResId, int subtitlesResId, int contentResId){


        if(titlesResId > 0 && subtitlesResId > 0 && contentResId> 0) {
            mTitles = context.getResources().getStringArray(titlesResId);
            mSubtitles = context.getResources().getStringArray(subtitlesResId);
            mContent = context.getResources().getStringArray(contentResId);
        }else{

            mTitles = new String[0];
            mSubtitles = new String[0];
            mContent = new String[0];

        }
    }
}
