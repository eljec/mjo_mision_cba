package com.mjo.misioncba.section.itinerary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjo.misioncba.ItineraryDay;
import com.mjo.misioncba.R;
import com.mjo.misioncba.section.itinerary.ItineraryFragment.OnListFragmentInteractionListener;

import com.mjo.misioncba.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyItineraryRecyclerViewAdapter extends RecyclerView.Adapter{

    private final List<ItineraryListViewItemModel> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context mContext;


    public MyItineraryRecyclerViewAdapter(List<ItineraryListViewItemModel> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case ItineraryListViewItemModel.DAY_TYPE:
               view =  LayoutInflater.from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false);
                view.setBackgroundColor(mContext.getResources().getColor(android.R.color.background_dark));

                holder = new HeaderSectionViewHolder (view);
                break;
            case ItineraryListViewItemModel.EVENT_TYPE:

                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_itinerary, parent, false);

                holder = new EventViewHolder (view);
                break;

        }

        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        ItineraryListViewItemModel modelItem = mValues.get(position);
        if (modelItem != null) {

            switch (modelItem.type) {
                case ItineraryListViewItemModel.DAY_TYPE:

                    ((HeaderSectionViewHolder) holder).mTitleTextView.setText(modelItem.text);

                    break;

                case ItineraryListViewItemModel.EVENT_TYPE:

                    EventViewHolder eventHolder = (EventViewHolder) holder;

                    eventHolder.mTitleTextView.setText(modelItem.text);
                    eventHolder.mDateTextView.setText(modelItem.date);

                    break;

            }
        }
        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    @Override
    public int getItemViewType(int position) {
        return mValues.get(position).type;
    }

    // Holder for header section

    public class HeaderSectionViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleTextView;

        public HeaderSectionViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(android.R.id.text1);
            mTitleTextView.setTextColor(mContext.getResources().getColor(android.R.color.white));
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }

    // Holder for raw

    public class EventViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleTextView;
        public final TextView mDateTextView;
        public final ImageView mEventImageView;

        public ItineraryListViewItemModel mItem;

        public EventViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(R.id.frament_itinerary_list_event_title);
            mDateTextView = (TextView) view.findViewById(R.id.frament_itinerary_list_event_date);
            mEventImageView = (ImageView) view.findViewById(R.id.frament_itinerary_list_event_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }
}
