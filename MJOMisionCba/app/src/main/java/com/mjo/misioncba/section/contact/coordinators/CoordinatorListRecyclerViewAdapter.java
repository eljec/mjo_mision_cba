package com.mjo.misioncba.section.contact.coordinators;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mjo.misioncba.R;

import java.util.List;

/**
 * Created by jucastillo on 4/1/18.
 */

public class CoordinatorListRecyclerViewAdapter extends RecyclerView.Adapter
{
    private final List<CoordinatorListViewItemModel> mValues;
    private Context mContext;

    public CoordinatorListRecyclerViewAdapter(List<CoordinatorListViewItemModel> items, Context context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case CoordinatorListViewItemModel.HEADER_TYPE:
                view =  LayoutInflater.from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false);
                view.setBackgroundColor(mContext.getResources().getColor(android.R.color.background_dark));

                holder = new HeaderContactSectionViewHolder (view);
                break;
            case CoordinatorListViewItemModel.CONTACT_TYPE:

                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.contact_view, parent, false);

                holder = new ContactViewHolder (view);
                break;

        }

        return holder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        CoordinatorListViewItemModel modelItem = mValues.get(position);
        if (modelItem != null) {

            switch (modelItem.type) {
                case CoordinatorListViewItemModel.HEADER_TYPE:
                    ((HeaderContactSectionViewHolder) holder).mTitleTextView.setText(modelItem.text);
                    break;

                case CoordinatorListViewItemModel.CONTACT_TYPE:
                    ContactViewHolder eventHolder = (ContactViewHolder) holder;
                    eventHolder.mTitleTextView.setText(modelItem.text);

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
        return mValues.get(position).type;
    }

    // Holder for header section

    public class HeaderContactSectionViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleTextView;

        public HeaderContactSectionViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(android.R.id.text1);
            mTitleTextView.setTextColor(mContext.getResources().getColor(android.R.color.white));
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleTextView;


        public ContactViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(R.id.contact_view_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }

}
