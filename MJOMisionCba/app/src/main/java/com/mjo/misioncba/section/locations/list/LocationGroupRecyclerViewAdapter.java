package com.mjo.misioncba.section.locations.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mjo.misioncba.R;
import java.util.List;


public class LocationGroupRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<LocationGroupItem> mValues;
    private final LocationGroupFragment.OnLocationGroupListFragmentInteractionListener mListener;
    private Context mContext;

    public LocationGroupRecyclerViewAdapter(List<LocationGroupItem> items, LocationGroupFragment.OnLocationGroupListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case LocationGroupItem.HEADER_TYPE:
                view =  LayoutInflater.from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false);

                holder = new HeaderSectionViewHolder (view);
                break;
            case LocationGroupItem.LOCATION_TYPE:

                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.location_group_item_list, parent, false);

                holder = new LocationViewHolder (view);
                break;

        }

        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        LocationGroupItem modelItem = mValues.get(position);
        if (modelItem != null) {

            switch (modelItem.getType()) {
                case LocationGroupItem.HEADER_TYPE:

                    ((HeaderSectionViewHolder) holder).mContentTextView.setText(modelItem.getContent());

                    break;

                case LocationGroupItem.LOCATION_TYPE:

                    LocationViewHolder locationHolder = (LocationViewHolder) holder;
                    // Update data
                    locationHolder.mContentTextView.setText(modelItem.getContent());
                    locationHolder.mSeparatorLine.setVisibility(View.VISIBLE);

                    if(position == mValues.size() -1){
                        locationHolder.mSeparatorLine.setVisibility(View.GONE);
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
        return mValues.get(position).getType();
    }

    // Holder for header section

    public class HeaderSectionViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentTextView;

        public HeaderSectionViewHolder(View view) {
            super(view);
            mView = view;
            mContentTextView = (TextView) view.findViewById(android.R.id.text1);
            mContentTextView.setTextColor(mContext.getResources().getColor(android.R.color.holo_blue_dark));
        }
    }


    public class LocationViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentTextView;
        public  final  View mSeparatorLine;


        public LocationViewHolder(View view) {
            super(view);
            mView = view;
            mContentTextView = (TextView) view.findViewById(R.id.location_group_item_label);
            mContentTextView.setTextColor(mContext.getResources().getColor(android.R.color.black));
            mSeparatorLine = view.findViewById(R.id.location_group_item_separator_line);
        }
    }
}
