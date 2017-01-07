package com.mjo.misioncba.section.maps;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailItemList;
import com.mjo.misioncba.section.locations.list.detail.LocationDetailItemListImageFactory;
import com.mjo.misioncba.section.locations.list.zoom.LocationGroupMapZoomActivity;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MapFragment extends Fragment {

    ImageView mImageView;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mImageView = (ImageView) view.findViewById(R.id.fragment_map_image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LocationDetailItemList item = new LocationDetailItemList(LocationDetailItemListImageFactory.LOCATION_TYPE_ZONA, getString(R.string.fragment_map_title));

                Intent intent = new Intent(getActivity(), LocationGroupMapZoomActivity.class);
                intent.putExtra(LocationGroupMapZoomActivity.GROUP_MAP_MODEL_SECETED, item);
                startActivity(intent);
            }
        });

        return view;
    }

}
