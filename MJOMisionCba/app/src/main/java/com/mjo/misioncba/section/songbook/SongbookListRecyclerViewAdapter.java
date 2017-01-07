package com.mjo.misioncba.section.songbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mjo.misioncba.R;

import java.util.List;

/**
 * Created by jucastillo on 7/1/17.
 */
public class SongbookListRecyclerViewAdapter  extends RecyclerView.Adapter {

    private final List<Song> mValues;

    public SongbookListRecyclerViewAdapter(List<Song> mValues) {
        this.mValues = mValues;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prayer_list_item, parent, false);
        return new PrayerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        PrayerItemViewHolder ownHolder = (PrayerItemViewHolder) holder;
        Song item = mValues.get(position);

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
            mTitleLabel = (TextView) view.findViewById(R.id.prayer_list_item_title);
            mSubtitleLabel = (TextView) view.findViewById(R.id.prayer_list_item_subtitle);

        }

    }
}
