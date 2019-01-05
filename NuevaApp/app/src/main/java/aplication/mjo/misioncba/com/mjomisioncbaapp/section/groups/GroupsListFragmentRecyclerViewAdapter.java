package aplication.mjo.misioncba.com.mjomisioncbaapp.section.groups;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

/**
 * Created by jucastillo on 31/12/17.
 */

public class GroupsListFragmentRecyclerViewAdapter extends RecyclerView.Adapter
{
    private final ArrayList<String> mValues;

    public GroupsListFragmentRecyclerViewAdapter(ArrayList<String> items) {
        mValues = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_groups_list_item, parent, false);
        return new GroupItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GroupItemViewHolder ownHolder = (GroupItemViewHolder) holder;
        String title = mValues.get(position);
        ownHolder.mTitleView.setText(title);
    }

    @Override
    public int getItemCount() {
        return mValues!= null ? mValues.size() : 0;
    }


    public class GroupItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;

        public GroupItemViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.fragment_group_list_item_title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
