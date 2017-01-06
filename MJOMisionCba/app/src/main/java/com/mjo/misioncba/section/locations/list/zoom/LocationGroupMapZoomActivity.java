package com.mjo.misioncba.section.locations.list.zoom;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailItemList;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailItemListImageFactory;

import uk.co.senab.photoview.PhotoViewAttacher;

public class LocationGroupMapZoomActivity extends AppCompatActivity {

    static public final String GROUP_MAP_MODEL_SECETED = "GROUP_MAP_MODEL_SECETED";

    ImageView mImageView;
    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_group_map_zoom);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView = (ImageView) findViewById(R.id.location_group_map_zoom_image);

        // Set image map
        LocationDetailItemList model = null;

        if(getIntent().getExtras() != null){

            model = getIntent().getExtras().getParcelable(GROUP_MAP_MODEL_SECETED);
            Drawable drwb = LocationDetailItemListImageFactory.getImageForType(model.getImageType(), this);

            mImageView.setImageDrawable(drwb);
            mAttacher = new PhotoViewAttacher(mImageView);

            getSupportActionBar().setTitle(model.getNeighborhoodName());
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
