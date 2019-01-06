package aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.list;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aplication.mjo.misioncba.com.mjomisioncbaapp.MisionCbaApplication;
import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.ReadingDay;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.SectionReadings;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Sections;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.itinerary.RecyclerViewItemClickListener;

public class ReadingFragmentListFragment extends Fragment {

    private OnReadingListFragmentInteractionListener mListener;
    private ArrayList<String > readingDayTitles;
    private SectionReadings section;

    public ReadingFragmentListFragment() {
    }


    public static ReadingFragmentListFragment newInstance() {
        ReadingFragmentListFragment fragment = new ReadingFragmentListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getActivity().getResources();

        MisionCbaApplication application = ((MisionCbaApplication) getActivity().getApplication());
        Sections sections = application.getSections();
        section = sections.getReading();

        this.readingDayTitles = section.getArrayTitleNames();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new ReadingFragmentListRecyclerViewAdapter(this.readingDayTitles));
            recyclerView.addOnItemTouchListener(
                    new RecyclerViewItemClickListener(context, new RecyclerViewItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {

                            ReadingDay day = section.getReadingModelForPosition(position);
                            mListener.onReadingListFragmentInteraction(day.getDayId());
                        }
                    })
            );
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnReadingListFragmentInteractionListener) {
            mListener = (OnReadingListFragmentInteractionListener) context;
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

    public interface OnReadingListFragmentInteractionListener {
        void onReadingListFragmentInteraction( int position);
    }
}
