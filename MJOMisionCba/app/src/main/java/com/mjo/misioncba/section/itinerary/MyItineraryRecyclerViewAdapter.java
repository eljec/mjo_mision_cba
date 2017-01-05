package com.mjo.misioncba.section.itinerary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mjo.misioncba.R;
import com.mjo.misioncba.model.ItineraryDayEventPlace;

import java.util.List;

public class MyItineraryRecyclerViewAdapter extends RecyclerView.Adapter{

    private final List<ItineraryListViewItemModel> mValues;
    private Context mContext;


    public MyItineraryRecyclerViewAdapter(List<ItineraryListViewItemModel> items, Context context) {
        mValues = items;
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
                    eventHolder.mDateTextView.setText(modelItem.event.getEventDate());
                    eventHolder.mTitleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    eventHolder.mContainerMassIndicators.setVisibility(View.GONE);
                    // Info de misas

                    if(modelItem.event.getPlaces() != null && modelItem.event.getPlaces().size() > 0){
                        String placesString = generatePlacesStringByPlaces(modelItem.event.getPlaces());

                        if(placesString != null){

                            eventHolder.mMassLabel.setText(placesString);
                            eventHolder.mContainerMassIndicators.setVisibility(View.VISIBLE);
                        }
                    }
                    // Solo para tipos Misa muestra la flecha

                    if(modelItem.event.getEventImageType() == 2) {
                        eventHolder.mTitleTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_trending_flat_black_24dp, 0);
                    }

                    break;

            }
        }
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
        public final View mContainerMassIndicators;
        public final  TextView mMassLabel;


        public EventViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(R.id.frament_itinerary_list_event_title);
            mDateTextView = (TextView) view.findViewById(R.id.frament_itinerary_list_event_date);
            mEventImageView = (ImageView) view.findViewById(R.id.frament_itinerary_list_event_image);
            mContainerMassIndicators = view.findViewById(R.id.frament_itinerary_list_mass_containers);
            mMassLabel = (TextView) view.findViewById(R.id.frament_itinerary_list_mass_label);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }


    private String generatePlacesStringByPlaces(List<ItineraryDayEventPlace> places){

        StringBuilder placesString = new StringBuilder();

        for (ItineraryDayEventPlace place: places) {

            String line = null;

            if( isNotEmpty(place.getPlace()) ){
                line = "+ " + place.getPlace();
                if (isNotEmpty(place.getPriest())){
                    line = line + ", Padre " + place.getPriest() + "\n";
                }else{
                    line = line + "\n";
                }
                placesString.append(line);
            }
        }

        return placesString.toString();
    }


    private boolean isNotEmpty(String value){

        return  value != null && value.length() > 0;

    }
}
