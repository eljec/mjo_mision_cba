package com.mjo.misioncba.section.feedback.stepTwo;

import android.content.Context;
import android.content.res.Resources;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.feedback.StepOne.ItemFeedbackDataResult;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jucastillo on 12/1/17.
 */
public class FeedbackActivityStepTwoUrlGenerator {

    private Map<String, String> mapKeyFormId = new HashMap<String, String>();

    public FeedbackActivityStepTwoUrlGenerator(Context ctx) {

        Resources res = ctx.getResources();
        String[] feedbackItemsFormId = res.getStringArray(R.array.feedback_item_form_id);
        String[] feedbackItemsKeys = res.getStringArray(R.array.feedback_item_list_key);

        for (int i = 0; i < feedbackItemsKeys.length; i++) {

            String formId = feedbackItemsFormId[i];
            String key = feedbackItemsKeys[i];

            mapKeyFormId.put(key, formId);
        }
    }

    public String generatePostBody (ArrayList<ItemFeedbackDataResult> resultStepOne, String suggestionText){

        StringBuilder postBody = new StringBuilder();

        for (ItemFeedbackDataResult item : resultStepOne) {

            if(mapKeyFormId.containsKey(item.getKey())){

                String formId = mapKeyFormId.get(item.getKey());
                String value = stringValueForRating(item.getValue());

                postBody.append(formId);
                postBody.append("=");
                postBody.append(value);
                postBody.append("&");
            }
        }

        try {
            postBody.append("entry.692504424");
            postBody.append("=");
            postBody.append( URLEncoder.encode(suggestionText,"UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            postBody = new StringBuilder();
        }

        return postBody.toString();
    }

    private String stringValueForRating(float rating){

        String value = "";

        if(rating == 5){
            value = "EXC";
        }else if(rating == 4){
            value = "MB";
        } else if(rating == 3){
            value = "B";
        } else if(rating == 2){
            value = "R";
        }else if(rating == 1){
            value = "M";
        }

        return value;
    }
}
