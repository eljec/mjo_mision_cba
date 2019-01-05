package aplication.mjo.misioncba.com.mjomisioncbaapp.section.feedback.StepOne;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

/**
 * Created by jucastillo on 11/1/17.
 */
public class FeedbackStepOneListRecyclerViewAdapter extends RecyclerView.Adapter implements  RatingBar.OnRatingBarChangeListener {

    private final List<ItemFeedbackModelList> mValues;
    private Map<String, Float> mSelectedValues = new HashMap<String, Float>();
    private OnFeedbackListStartChangeListener mlistener;

    public FeedbackStepOneListRecyclerViewAdapter(List<ItemFeedbackModelList> items, OnFeedbackListStartChangeListener listener) {
        mValues = items;
        mlistener = listener;
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

        float selectedRating = 0.f;

        if(mSelectedValues.containsKey(model.getKeyType())){
            selectedRating = mSelectedValues.get(model.getKeyType());
        }

        ownHolder. mRatingBar.setOnRatingBarChangeListener(this);
        ownHolder.mRatingBar.setTag(model.getKeyType());
        ownHolder.mRatingBar.setRating(selectedRating);
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

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

        // Si la key  esta en mapa actualizo el valor
        // Si la key no esta en el mapa, me fijo si el rating es cero, Si es cero no lo agrego. Agrego solo cosas distintas de cero

        String keyType = (String)ratingBar.getTag();

        boolean isInMap = mSelectedValues.containsKey(keyType);

        if (isInMap || rating > 0){

            if(rating > 0){
                mSelectedValues.put(keyType, rating);
                // Call listener to know if we have to show fab button
                mlistener.onFeedbackListStartChange(mSelectedValues);
            }else{
                // saco la key del mapa
                mSelectedValues.remove(keyType);
                mlistener.onFeedbackListStartChange(mSelectedValues);
            }
        }
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

    public Map<String, Float>  getUpdatedData(){

        return mSelectedValues;
    }


    public interface OnFeedbackListStartChangeListener {

        void onFeedbackListStartChange(Map<String, Float> selectedValues);
    }
}
