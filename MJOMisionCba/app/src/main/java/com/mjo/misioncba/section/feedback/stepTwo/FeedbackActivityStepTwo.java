package com.mjo.misioncba.section.feedback.stepTwo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.feedback.StepOne.FeedbackActivity;
import com.mjo.misioncba.section.feedback.StepOne.ItemFeedbackDataResult;
import com.mjo.misioncba.section.feedback.congrats.FeedbackCongratsActivity;

import java.util.ArrayList;

public class FeedbackActivityStepTwo extends AppCompatActivity implements PostDataTask.OnPostTaskListener {

    public static final int REQUEST_FEEDBACK_INFO = 12;

    private View loadingContainer;
    private Button submitButton;
    private EditText textArea;
    private ArrayList<ItemFeedbackDataResult> resultStepOne;
    private FeedbackActivityStepTwoUrlGenerator generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_activity_step_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ya casi terminas..");

        // Get the date of the previous activity
        if(getIntent().getExtras() != null){
            resultStepOne = getIntent().getExtras().getParcelableArrayList(FeedbackActivity.FEEDBACK_LIST_RESULTS);
        }

        this.generator = new FeedbackActivityStepTwoUrlGenerator(this);

        this.loadingContainer = findViewById(R.id.progressbar_container);
        this.submitButton = (Button) findViewById(R.id.feedback_submit_btn);
        this.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check text
                if(textArea.getText() == null || textArea.getText().length() == 0){
                    // Show error
                    Toast.makeText(getApplicationContext(), "Por favor pon alguna sugerencia :-)", Toast.LENGTH_SHORT).show();
                }else{
                    // Make request to form
                    loadingContainer.setVisibility(View.VISIBLE);
                    //checkPermissions();

                    Intent congrats = new Intent(getApplicationContext(), FeedbackCongratsActivity.class);
                    startActivity(congrats);
                }

            }
        });


        textArea = (EditText) findViewById(R.id.feedback_textarea);
        textArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_FEEDBACK_INFO: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    startPostDataTask();

                } else {

                    // Toast
                    Toast toast = Toast.makeText(getApplicationContext(), "Necesitamos tu permiso para ejecutar esta accion", Toast.LENGTH_LONG);
                    toast.show();
                }
                return;
            }
        }
    }


    private void checkPermissions(){

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, REQUEST_FEEDBACK_INFO);
                loadingContainer.setVisibility(View.GONE);
            }
            else
            {
                startPostDataTask();
            }
        }
        else
        {
            startPostDataTask();
        }
    }

    @Override
    public void onPostTaskSuccess() {
        loadingContainer.setVisibility(View.GONE);
        // Ver si voy a otra pantalla
        Intent congrats = new Intent(this, FeedbackCongratsActivity.class);
        startActivity(congrats);
    }

    @Override
    public void onPostTaskError() {
        loadingContainer.setVisibility(View.GONE);
        Toast.makeText(this,"Ocurrio un error, intenta mas tarde",Toast.LENGTH_LONG).show();
    }

    private void startPostDataTask(){

        PostDataTask postDataTask = new PostDataTask(this);

        String body = this.generator.generatePostBody(resultStepOne, textArea.getText().toString());
        postDataTask.execute(body);
    }
}
