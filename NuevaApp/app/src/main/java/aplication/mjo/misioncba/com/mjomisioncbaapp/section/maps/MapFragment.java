package aplication.mjo.misioncba.com.mjomisioncbaapp.section.maps;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import aplication.mjo.misioncba.com.mjomisioncbaapp.LocationGroupDetailActivity;
import aplication.mjo.misioncba.com.mjomisioncbaapp.MisionCbaApplication;
import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Places.SectionPlaces;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.detail.LocationDetailItemList;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.detail.LocationDetailItemListImageFactory;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.zoom.LocationGroupMapZoomActivity;

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

        TextView contentLabel = (TextView) view.findViewById(R.id.fragment_map_label);
        contentLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Open map list
                Intent intent = new Intent(getActivity(), LocationGroupDetailActivity.class);
                startActivity(intent);
            }
        });
        contentLabel.setText(generateDataDescriptionLabel());

        return view;
    }


    private String generateDataDescriptionLabel()
    {
        MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
        SectionPlaces sectionPlaces = appState.getSections().getPlaces();

        return getString(R.string.fragment_map_description) + sectionPlaces.getListNamePlaces();
    }

}
