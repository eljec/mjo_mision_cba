package com.mjo.misioncba.section.itinerary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.model.ItineraryDay;
import com.mjo.misioncba.model.ItineraryDayEvent;
import com.mjo.misioncba.model.SectionItinerary;

import java.util.ArrayList;
import java.util.List;

import static com.mjo.misioncba.MainActivity.KEY_PREFRENCES_FILE_NAME;
import static com.mjo.misioncba.MainActivity.KEY_PREFRENCES_SELECTED_INDEX;

public class ItineraryFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public static final String FRAGMENT_ITINERARY_SELECTED_INDEX="fragment_selected_index";

    private OnListFragmentInteractionListener mListener;
    private List<ItineraryListViewItemModel> listItem;
    private  RecyclerView list;
    private SectionItinerary sectionItineraryRawData;

    public ItineraryFragment() {
    }

    @SuppressWarnings("unused")
    public static ItineraryFragment newInstance(int selectedIndex) {
        ItineraryFragment fragment = new ItineraryFragment();

        Bundle args = new Bundle();
        args.putInt(FRAGMENT_ITINERARY_SELECTED_INDEX, selectedIndex);
        fragment.setArguments(args);

        return fragment;
    }


    public void updateDataForDay(int day){

        modelForList(day);
        list.setAdapter(new MyItineraryRecyclerViewAdapter(this.listItem, getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load full itinerary

        int indexSelected = 0;

        if(getArguments() != null){
            Bundle args = getArguments();
            indexSelected = args.getInt(FRAGMENT_ITINERARY_SELECTED_INDEX, 0);
        }

        modelForList(indexSelected);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itinerary_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            list = (RecyclerView) view;
            list.setLayoutManager(new LinearLayoutManager(context));

            list.setAdapter(new MyItineraryRecyclerViewAdapter(this.listItem, getContext()));
            list.addOnItemTouchListener(
                    new RecyclerViewItemClickListener(context, new RecyclerViewItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {

                            // Callback to activity
                            ItineraryListViewItemModel item =   listItem.get(position);

                            // 2 == Misa
                            /*if(item.event.getEventImageType() == 2) {
                                mListener.onListFragmentInteraction(item);
                            }else if (item.event.getDayId() == 3 && item.event.getEventImageType() == 5){

                                // Formacion del padre Santiago
                                Intent intent = new Intent(getActivity(), ImageZoomActivity.class);
                                startActivity(intent);
                            }*/

                            mListener.onListFragmentInteraction(item.event);


                        }
                    })
            );
        }


        Spinner spinnerDays = (Spinner) getActivity().findViewById(R.id.spinner_nav);

        String [] listItems = getDataForSpinner();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getActivity(), R.layout.itinerary_spinner_item, listItems);
        adapter.setDropDownViewResource(R.layout.itinerary_spinner_dropdown_item);
        spinnerDays.setAdapter(adapter);
        spinnerDays.setOnItemSelectedListener(this);

        return view;
    }

    private  String [] getDataForSpinner()
    {
        ArrayList<String> list = new ArrayList<>();

        if(this.sectionItineraryRawData != null)
        {
            for (ItineraryDay itineraryDay : this.sectionItineraryRawData.getDays()) {
                list.add(itineraryDay.getTitleSpinner());
            }
        }

        return list.toArray(new String [list.size()]);
    }

    private void modelForList(int day){

        // Obtengo data original
        if(this.sectionItineraryRawData == null) {
            MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
            this.sectionItineraryRawData = appState.getSections().getItinerary();

            //if(this.sectionItineraryRawData == null){
                // Load teh file again
                //this.sectionItineraryRawData = new ItineraryProvider(getActivity().getAssets()).obtain(ItineraryProviderConstants.ITINERARY_ASSET_FILE);
            //}
        }

       SectionItinerary sectionItinerary = null;

        if(day == 0){
            // Show full sectionItinerary
            sectionItinerary = this.sectionItineraryRawData;
        }
        else{
            sectionItinerary = itineraryByDay (day);
        }
            this.listItem = new ArrayList<ItineraryListViewItemModel>();

            for (ItineraryDay itineraryDay : sectionItinerary.getDays()) {
                // Create item for list
                ItineraryListViewItemModel itemPerDay = new ItineraryListViewItemModel(ItineraryListViewItemModel.DAY_TYPE, itineraryDay.getTitle());
                listItem.add(itemPerDay);

                for (ItineraryDayEvent event : itineraryDay.getEvents()) {
                    ItineraryListViewItemModel eventPerDay = new ItineraryListViewItemModel(ItineraryListViewItemModel.EVENT_TYPE, event.getEventTitle(), event);
                    listItem.add(eventPerDay);
                }
            }

    }

    private SectionItinerary itineraryByDay(int day){

        SectionItinerary sectionItineraryByDay = new SectionItinerary();

        for (ItineraryDay itineraryDay : this.sectionItineraryRawData.getDays()) {

            if(itineraryDay.getId() == day){

                ArrayList<ItineraryDay> arrayDays =  new ArrayList<ItineraryDay>();
                arrayDays.add(itineraryDay);

                sectionItineraryByDay.setDays(arrayDays);
                break;
            }
        }

        return sectionItineraryByDay;
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        // if index == 0 is Full SectionItinerary
        // Update the list view
        updateDataForDay(i);

        // Save index
        saveIndexOnPreferences(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void saveIndexOnPreferences(int index){

        SharedPreferences sharedPref = getActivity().getSharedPreferences(KEY_PREFRENCES_FILE_NAME
                , Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(KEY_PREFRENCES_SELECTED_INDEX, index);
        editor.commit();
    }

    public interface OnListFragmentInteractionListener {

        void onListFragmentInteraction(ItineraryDayEvent item);
    }


}
