package aplication.mjo.misioncba.com.mjomisioncbaapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.Readings;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.detail.ReadingDetailListItemGenerator;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.detail.ReadingDetailRecyclerViewAdapter;


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

        String title = getTitleByDay(day);

        getSupportActionBar().setTitle(getString(R.string.reading_detail_title) + title);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public String getTitleByDay(int day){

        Resources res = getResources();
        String [] titles = res.getStringArray(R.array.reading_days_titles);

        return day != 0 && day <= titles.length ? titles[day -1] : "";
    }
}
