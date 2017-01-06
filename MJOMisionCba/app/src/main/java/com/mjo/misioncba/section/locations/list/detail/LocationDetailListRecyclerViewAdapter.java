package com.mjo.misioncba.section.locations.list.detail;

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

import java.util.List;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailListRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<LocationDetailItemList> mValues;
    private Context mContext;

    public LocationDetailListRecyclerViewAdapter(List<LocationDetailItemList> items, Context context) {
        mValues = items;
        mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_group_detail_item_list, parent, false);
        return new LocationDetailItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        LocationDetailItemList model = mValues.get(position);

        LocationDetailItemViewHolder ownHolder = (LocationDetailItemViewHolder) holder;
        ownHolder.mTitleView.setText(model.getNeighborhoodName());
        ownHolder.mImage.setImageDrawable(LocationDetailItemListImageFactory.getImageForType(model.getImageType(), mContext));
        ownHolder.mSeparatorLine.setVisibility(View.VISIBLE);

        if(position == mValues.size() -1){
            // Hide the separator line
            ownHolder.mSeparatorLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class LocationDetailItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final View mSeparatorLine;
        public final TextView mTitleView;
        public final ImageView mImage;

        public LocationDetailItemViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.location_group_detail_item_list_title);
            mSeparatorLine = view.findViewById(R.id.location_group_detail_item_list_separator_line);
            mImage = (ImageView) view.findViewById(R.id.location_group_detail_item_list_image);
        }
    }
}
