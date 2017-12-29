package com.mjo.misioncba.section.readings.list;

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

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.itinerary.RecyclerViewItemClickListener;

public class ReadingFragmentListFragment extends Fragment {

    private OnReadingListFragmentInteractionListener mListener;
    private String[] readingDayTitles;

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
        this.readingDayTitles = res.getStringArray(R.array.reading_days_titles);
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
                            mListener.onReadingListFragmentInteraction(position);
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
