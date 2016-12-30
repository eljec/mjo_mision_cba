package com.mjo.misioncba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mjo.misioncba.R;

public class ReadingsDatailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readings_datails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
