package com.mjo.misioncba.section.feedback.StepOne;

import android.content.Context;
import android.content.res.Resources;

import com.mjo.misioncba.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jucastillo on 11/1/17.
 */
public class ItemFeedbackModelListGenerator {

    public List<ItemFeedbackModelList> getData(Context ctx){


        List<ItemFeedbackModelList> data = new ArrayList<>();

        Resources res = ctx.getResources();
        String[] feedbackItemsTitles = res.getStringArray(R.array.feedback_item_list_title);
        String[] feedbackItemsKeys = res.getStringArray(R.array.feedback_item_list_key);

        for (int i = 0; i < feedbackItemsTitles.length; i++) {

            String title = feedbackItemsTitles[i];
            String key = feedbackItemsKeys[i];

            if(title != null){
                ItemFeedbackModelList item = new ItemFeedbackModelList (title);
                item.setKeyType(key);
                data.add(item);
            }
        }
        return data;
    }
}