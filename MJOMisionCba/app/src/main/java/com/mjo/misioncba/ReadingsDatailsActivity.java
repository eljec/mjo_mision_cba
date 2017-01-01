package com.mjo.misioncba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.mjo.misioncba.section.readings.Readings;
import com.mjo.misioncba.section.readings.detail.ReadingDetailRecyclerViewAdapter;
import com.mjo.misioncba.section.readings.detail.ReadingDetailListItemGenerator;

import java.util.List;

public class ReadingsDatailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readings_datails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        int day = 0;
        // Load the reading by day

        if(getIntent().getExtras() != null){

             day = getIntent().getExtras().getInt("READING_DAY_SELECTED");
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.reading_detail_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ReadingDetailListItemGenerator generator = new ReadingDetailListItemGenerator(getApplicationContext());
        List<Readings> data = generator.getReadingForDay(day);

        recyclerView.setAdapter(new ReadingDetailRecyclerViewAdapter(data));
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
