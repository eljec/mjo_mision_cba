package com.mjo.misioncba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailGeneratorData;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailItemList;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailListRecyclerViewAdapter;

import java.util.List;

public class LocationGroupDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_group_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.location_group_detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LocationDetailGeneratorData generator = new LocationDetailGeneratorData();
        List<LocationDetailItemList> data = generator.getData(this);

        recyclerView.setAdapter(new LocationDetailListRecyclerViewAdapter(data, this));
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
