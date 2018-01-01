package com.mjo.misioncba.section.feedback.stepTwo;

import com.mjo.misioncba.model.SectionFeedback;
import com.mjo.misioncba.model.SectionFeedbackQuestion;
import com.mjo.misioncba.section.feedback.StepOne.ItemFeedbackDataResult;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by jucastillo on 12/1/17.
 */
public class FeedbackActivityStepTwoUrlGenerator {

    public String generatePostBody (ArrayList<ItemFeedbackDataResult> resultStepOne, String suggestionText, SectionFeedback sectionFeedback)
    {

        StringBuilder postBody = new StringBuilder();

        for (ItemFeedbackDataResult item : resultStepOne) {

                String formId = item.getKey();
                String value = stringValueForRating(item.getValue());

                postBody.append(formId);
                postBody.append("=");
                postBody.append(value);
                postBody.append("&");
        }

        try {
            String keySuggestionInput = getSuggestionQuestion(sectionFeedback).getFormKey();
            postBody.append(keySuggestionInput);
            postBody.append("=");
            postBody.append( URLEncoder.encode(suggestionText,"UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            postBody = new StringBuilder();
        }

        return postBody.toString();
    }

    private SectionFeedbackQuestion getSuggestionQuestion(SectionFeedback feedback)
    {
        SectionFeedbackQuestion suggestionQuestion = null;

        for (SectionFeedbackQuestion feedbackQuestion : feedback.getQuestions())
        {
            if(feedbackQuestion.isOpenQuestion())
            {
                suggestionQuestion = feedbackQuestion;
                break;
            }
        }

        return suggestionQuestion;
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
