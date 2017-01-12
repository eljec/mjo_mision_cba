package com.mjo.misioncba.section.feedback.stepTwo;

import android.Manifest;
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

public class FeedbackActivityStepTwo extends AppCompatActivity implements PostDataTask.OnPostTaskListener {

    public static final int REQUEST_FEEDBACK_INFO = 12;

    private View loadingContainer;
    private Button submitButton;
    private EditText textArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_activity_step_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ya casi terminas..");


        // Get the date of the previous activity

        this.loadingContainer = findViewById(R.id.progressbar_container);
        this.submitButton = (Button) findViewById(R.id.feedback_submit_btn);
        this.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Make request to form
                loadingContainer.setVisibility(View.VISIBLE);
                checkPermissions();
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

                    PostDataTask postDataTask = new PostDataTask(this);
                    postDataTask.execute("EXC", "Mejorar la app");

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
                PostDataTask postDataTask = new PostDataTask(this);
                postDataTask.execute("EXC", "Mejorar la app");
            }
        }
        else
        {
            PostDataTask postDataTask = new PostDataTask(this);
            postDataTask.execute("EXC", "Mejorar la app");
        }
    }

    @Override
    public void onPostTaskSuccess() {
        loadingContainer.setVisibility(View.GONE);
        // Ver si voy a otra pantalla
        Toast.makeText(this,"Gracias por darnos tu opinion",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPostTaskError() {
        loadingContainer.setVisibility(View.GONE);
        Toast.makeText(this,"Ocurrio un error, intenta mas tarde",Toast.LENGTH_LONG).show();
    }
}
