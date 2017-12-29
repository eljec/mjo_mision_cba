package com.mjo.misioncba.section.itinerary.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mjo.misioncba.R;
import com.mjo.misioncba.model.ItineraryDayEventPlace;

import java.util.List;

/**
 * Created by jucastillo on 28/12/17.
 */

public class MyItineraryDeyailPlaceRecyclerViewAdapter extends RecyclerView.Adapter
{
    List<ItineraryDayEventPlace> data;

    public MyItineraryDeyailPlaceRecyclerViewAdapter (List<ItineraryDayEventPlace> data)
    {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_event_detai_place, parent, false);

        return new EventDetailPlaceViewHolder (view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ((EventDetailPlaceViewHolder) holder).mTitleTextView.setText(data.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return data!= null ? data.size() : 0;
    }


    public class EventDetailPlaceViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleTextView;


        public EventDetailPlaceViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(R.id.event_detail_place_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }
}
