package aplication.mjo.misioncba.com.mjomisioncbaapp.section.feedback.StepOne;


import java.util.ArrayList;
import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionFeedback;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionFeedbackQuestion;

/**
 * Created by jucastillo on 11/1/17.
 */
public class ItemFeedbackModelListGenerator {

    public List<ItemFeedbackModelList> getData(SectionFeedback feedback){

        List<ItemFeedbackModelList> data = new ArrayList<>();
        for (SectionFeedbackQuestion feedbackQuestion : feedback.getQuestions())
        {
            if(feedbackQuestion.isCloseQuestion())
            {
                ItemFeedbackModelList item = new ItemFeedbackModelList ();
                item.setText(feedbackQuestion.getText());
                item.setKeyType(feedbackQuestion.getFormKey());
                data.add(item);
            }
        }
        return data;
    }
}
