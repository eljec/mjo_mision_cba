package com.mjo.misioncba.section.itinerary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjo.misioncba.model.Itinerary;
import com.mjo.misioncba.model.ItineraryDay;
import com.mjo.misioncba.model.ItineraryDayEvent;
import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;

import java.util.ArrayList;
import java.util.List;

public class ItineraryFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private List<ItineraryListViewItemModel> listItem;

    public ItineraryFragment() {
    }

    @SuppressWarnings("unused")
    public static ItineraryFragment newInstance() {
        ItineraryFragment fragment = new ItineraryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the items

        modelForList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itinerary_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new MyItineraryRecyclerViewAdapter(this.listItem, getContext()));
            recyclerView.addOnItemTouchListener(
                    new RecyclerViewItemClickListener(context, new RecyclerViewItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {

                            // Callback to activity
                            ItineraryListViewItemModel item =   listItem.get(position);
                            mListener.onListFragmentInteraction(item);
                        }
                    })
            );
        }
        return view;
    }


    private void modelForList(){

        if(this.listItem == null) {

            MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
            Itinerary itinerary = appState.getItinerary();


            this.listItem = new ArrayList<ItineraryListViewItemModel>();

            for (ItineraryDay day : itinerary.getDays()) {
                // Create item for list
                ItineraryListViewItemModel itemPerDay = new ItineraryListViewItemModel(ItineraryListViewItemModel.DAY_TYPE, day.getTitle(), null, 0);
                listItem.add(itemPerDay);

                for (ItineraryDayEvent event : day.getEvents()) {
                    ItineraryListViewItemModel eventPerDay = new ItineraryListViewItemModel(ItineraryListViewItemModel.EVENT_TYPE, event.getEventTitle(), event.getEventDate(), 0);
                    listItem.add(eventPerDay);
                }
            }
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {

        void onListFragmentInteraction(ItineraryListViewItemModel item);
    }
}
