package aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

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

        // Check if we have url, in that case we use it

        if(model.getUrl()!=null && model.getUrl().isEmpty() == false)
        {
            // Uso Picasso
            Picasso.with(mContext)
                    .load(model.getUrl())
                    .placeholder(R.drawable.loading_bg)
                    .error(R.drawable.loading_bg)
                    .into(ownHolder.mImage);
        }else
        {
            ownHolder.mImage.setImageDrawable(LocationDetailItemListImageFactory.getImageForType(model.getImageType(), mContext));
        }

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
