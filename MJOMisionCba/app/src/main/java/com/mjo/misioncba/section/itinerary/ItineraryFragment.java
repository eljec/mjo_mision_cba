package com.mjo.misioncba.section.itinerary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjo.misioncba.Itinerary;
import com.mjo.misioncba.ItineraryDay;
import com.mjo.misioncba.ItineraryDayEvent;
import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.dummy.DummyContent;
import com.mjo.misioncba.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItineraryFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItineraryFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItineraryFragment newInstance(int columnCount) {
        ItineraryFragment fragment = new ItineraryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itinerary_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItineraryRecyclerViewAdapter(modelForList(), mListener));
        }
        return view;
    }


    private List<ItineraryListViewItemModel> modelForList(){

        MisionCbaApplication appState = ((MisionCbaApplication)getActivity().getApplication());
        Itinerary itinerary = appState.getItinerary();


        List<ItineraryListViewItemModel> listItem = new ArrayList<ItineraryListViewItemModel>();

        for (ItineraryDay day: itinerary.getDays())
        {
            // Create item for list
            ItineraryListViewItemModel itemPerDay = new ItineraryListViewItemModel(ItineraryListViewItemModel.DAY_TYPE, "Dia",0);
            listItem.add(itemPerDay);

            for (ItineraryDayEvent event: day.getEvents())
            {
                ItineraryListViewItemModel eventPerDay = new ItineraryListViewItemModel(ItineraryListViewItemModel.EVENT_TYPE, event.getEventTitle(),0);
                listItem.add(eventPerDay);
            }
        }

        return listItem;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ItineraryListViewItemModel item);
    }
}
