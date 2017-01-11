package com.mjo.misioncba.section.feedback.StepOne;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.mjo.misioncba.R;

import java.util.List;

/**
 * Created by jucastillo on 11/1/17.
 */
public class FeedbackStepOneListRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<ItemFeedbackModelList> mValues;
    private Context mContext;

    public FeedbackStepOneListRecyclerViewAdapter(List<ItemFeedbackModelList> items, Context context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feedback_section_item, parent, false);
        return new FeedbackItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ItemFeedbackModelList model = mValues.get(position);

        FeedbackItemViewHolder ownHolder = (FeedbackItemViewHolder) holder;
        ownHolder.mTitleView.setText(model.getText());
        ownHolder.mRatingBar.setRating(model.getStartValue());
        ownHolder.mSeparatorLine.setVisibility(View.VISIBLE);

        if(position == mValues.size() -1){
            // Hide the separator line
            ownHolder.mSeparatorLine.setVisibility(View.GONE);
        }

        ownHolder.mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser)
            {
                model.setText(String.valueOf(rating));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class FeedbackItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final View mSeparatorLine;
        public final TextView mTitleView;
        public final RatingBar mRatingBar;

        public FeedbackItemViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.feedback_item_list_label);
            mSeparatorLine = view.findViewById(R.id.feedback_item_list_separator_line);
            mRatingBar = (RatingBar) view.findViewById(R.id.feedback_item_ratingbar);
        }
    }

    public List<ItemFeedbackModelList> getUpdatedData(){

        return mValues;
    }
}
