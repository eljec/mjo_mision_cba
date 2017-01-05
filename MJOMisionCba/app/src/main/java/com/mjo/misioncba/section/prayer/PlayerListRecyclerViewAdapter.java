package com.mjo.misioncba.section.prayer;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mjo.misioncba.R;

import java.util.List;

/**
 * Created by jucastillo on 5/1/17.
 */
public class PlayerListRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<Prayer> mValues;
    private final Context ctx;

    public PlayerListRecyclerViewAdapter(List<Prayer> mValues, Context ctx) {
        this.mValues = mValues;
        this.ctx = ctx;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        return new PrayerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        PrayerItemViewHolder ownHolder = (PrayerItemViewHolder) holder;
        Prayer item = mValues.get(position);

        ownHolder.mTitleLabel.setText(item.getTitle());
        ownHolder.mSubtitleLabel.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class PrayerItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleLabel;
        public final TextView mSubtitleLabel;

        public PrayerItemViewHolder(View view) {
            super(view);
            mView = view;
            mTitleLabel = (TextView) view.findViewById(android.R.id.text1);
            mTitleLabel.setTextSize(20);
            mTitleLabel.setTypeface(Typeface.DEFAULT_BOLD);


            mSubtitleLabel = (TextView) view.findViewById(android.R.id.text2);
            mSubtitleLabel.setTextSize(18);
            mSubtitleLabel.setTextColor(ContextCompat.getColor(ctx, android.R.color.darker_gray));
            mSubtitleLabel.setLineSpacing(0, 1.5f);
        }

    }
}
