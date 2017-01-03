package com.mjo.misioncba.section.locations;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mjo.misioncba.R;


import java.util.List;

public class LocationGroupFragment extends Fragment {

    private OnLocationGroupListFragmentInteractionListener mListener;

    public LocationGroupFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_group_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));


            LocationGroupDataGenerator generator = new LocationGroupDataGenerator();
            List<LocationGroupItem> data = generator.getData(getContext());

            recyclerView.setAdapter(new LocationGroupRecyclerViewAdapter(data, mListener, getContext()));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLocationGroupListFragmentInteractionListener) {
            mListener = (OnLocationGroupListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLocationGroupListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnLocationGroupListFragmentInteractionListener {
        void onLocationGroupListFragmentInteraction(LocationGroupItem item);
    }
}
