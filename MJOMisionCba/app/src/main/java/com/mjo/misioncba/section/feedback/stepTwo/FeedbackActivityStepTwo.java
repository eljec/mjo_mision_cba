package com.mjo.misioncba.section.feedback.stepTwo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mjo.misioncba.R;

public class FeedbackActivityStepTwo extends AppCompatActivity {

    public static final int REQUEST_FEEDBACK_INFO = 12;

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


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_FEEDBACK_INFO: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    PostDataTask postDataTask = new PostDataTask();
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
            }
            else
            {
                PostDataTask postDataTask = new PostDataTask();
                postDataTask.execute("EXC", "Mejorar la app");
            }
        }
        else
        {
            PostDataTask postDataTask = new PostDataTask();
            postDataTask.execute("EXC", "Mejorar la app");
        }
    }
}
