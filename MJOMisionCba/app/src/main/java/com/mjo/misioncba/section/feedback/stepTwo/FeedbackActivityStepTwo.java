package com.mjo.misioncba.section.feedback.stepTwo;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mjo.misioncba.R;

public class FeedbackActivityStepTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_activity_step_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }
}
