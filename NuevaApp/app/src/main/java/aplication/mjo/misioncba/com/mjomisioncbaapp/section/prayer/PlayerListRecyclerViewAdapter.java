package aplication.mjo.misioncba.com.mjomisioncbaapp.section.prayer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

/**
 * Created by jucastillo on 5/1/17.
 */
public class PlayerListRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<Prayer> mValues;

    public PlayerListRecyclerViewAdapter(List<Prayer> mValues) {
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
            mTitleLabel = (TextView) view.findViewById(R.id.prayer_list_item_title);
            mSubtitleLabel = (TextView) view.findViewById(R.id.prayer_list_item_subtitle);

        }

    }
}
