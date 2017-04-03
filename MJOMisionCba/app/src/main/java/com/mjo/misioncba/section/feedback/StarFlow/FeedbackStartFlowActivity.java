package com.mjo.misioncba.section.feedback.StarFlow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.feedback.StepOne.FeedbackActivity;

public class FeedbackStartFlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_start_flow);

        Button btnStart = (Button) findViewById(R.id.feedback_start_flow_btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent stepOne = new Intent(getApplicationContext(), FeedbackActivity.class);
                startActivity(stepOne);
            }
        });
    }

}
