package com.mjo.misioncba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mjo.misioncba.model.SectionPlaces;
import com.mjo.misioncba.section.itinerary.RecyclerViewItemClickListener;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailGeneratorData;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailItemList;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailListRecyclerViewAdapter;
import com.mjo.misioncba.section.locations.list.zoom.LocationGroupMapZoomActivity;

import java.util.List;

public class LocationGroupDetailActivity extends AppCompatActivity  {

    private  List<LocationDetailItemList> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_group_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mapa de Barrios");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.location_group_detail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MisionCbaApplication appState = ((MisionCbaApplication) getApplication());
        SectionPlaces sectionPlaces = appState.getSections().getPlaces();

        LocationDetailGeneratorData generator = new LocationDetailGeneratorData();
        data = generator.getData(this, sectionPlaces);

        recyclerView.setAdapter(new LocationDetailListRecyclerViewAdapter(data, this));

        recyclerView.addOnItemTouchListener(
                new RecyclerViewItemClickListener(this, new RecyclerViewItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        LocationDetailItemList item = data.get(position);

                        Intent intent = new Intent(getApplicationContext(), LocationGroupMapZoomActivity.class);
                        intent.putExtra(LocationGroupMapZoomActivity.GROUP_MAP_MODEL_SECETED, item);
                        startActivity(intent);
                    }
                })
        );
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
