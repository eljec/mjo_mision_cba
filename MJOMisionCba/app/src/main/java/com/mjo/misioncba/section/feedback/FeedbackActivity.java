package com.mjo.misioncba.section.feedback;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.contact.ContactFragment;
import com.mjo.misioncba.section.feedback.stepTwo.FeedbackActivityStepTwo;

public class FeedbackActivity extends AppCompatActivity {

    public static final int REQUEST_FEEDBACK_INFO = 12;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                /*Intent stepTwo = new Intent(getApplicationContext(), FeedbackActivityStepTwo.class);

                Bundle bndlanimation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim1,R.anim.anim2).toBundle();
                startActivity(stepTwo, bndlanimation);*/

                checkPermissions();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
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
