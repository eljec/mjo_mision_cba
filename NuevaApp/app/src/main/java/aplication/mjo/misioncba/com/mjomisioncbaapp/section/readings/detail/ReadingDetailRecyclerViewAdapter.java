package aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.Readings;


/**
 * Created by jucastillo on 1/1/17.
 */
public class ReadingDetailRecyclerViewAdapter extends RecyclerView.Adapter {


    private final List<Readings> mReadings;

    public ReadingDetailRecyclerViewAdapter(List<Readings> readings) {
        mReadings = readings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reading_view, parent, false);

        return new ReadingDeatilItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ReadingDeatilItemViewHolder ownHolder = (ReadingDeatilItemViewHolder) holder;
        Readings currentReading = mReadings.get(position);

        ownHolder.titleLabel.setText(currentReading.getReadingTitle());
        ownHolder.subtitleLabel.setText(currentReading.getReadingSubtitle());
        ownHolder.contentLabel.setText(currentReading.getReadingText());

    }

    @Override
    public int getItemCount() {

        return mReadings.size();
    }


    public class ReadingDeatilItemViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView titleLabel;
        public final TextView subtitleLabel;
        public final TextView contentLabel;


        public ReadingDeatilItemViewHolder(View view) {
            super(view);
            mView = view;
            titleLabel = (TextView)view.findViewById(R.id.reading_view_title);
            subtitleLabel = (TextView)view.findViewById(R.id.reading_view_subtitle);
            contentLabel = (TextView)view.findViewById(R.id.reading_view_content);
        }
    }
}
