package com.mjo.misioncba.section.readings.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mjo.misioncba.R;

public class ReadingFragmentListRecyclerViewAdapter extends RecyclerView.Adapter {

    private final String[] mValues;

    public ReadingFragmentListRecyclerViewAdapter(String[] items) {
        mValues = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_reading_list_item, parent, false);
        return new ReadingItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ReadingItemViewHolder ownHolder = (ReadingItemViewHolder) holder;
        ownHolder.mTitleView.setText(mValues[position]);
        ownHolder.mSeparatorLine.setVisibility(View.VISIBLE);

        if(position == mValues.length -1){
            // Hide the separator line
            ownHolder.mSeparatorLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    public class ReadingItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final View mSeparatorLine;
        public final TextView mTitleView;

        public ReadingItemViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.fragment_reading_list_item_title);
            mSeparatorLine = view.findViewById(R.id.fragment_reading_list_item_separator_line);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
