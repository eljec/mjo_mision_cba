package aplication.mjo.misioncba.com.mjomisioncbaapp.section.groups.detail;

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

public class GroupDetailMembersListRecyclerViewAdapter extends RecyclerView.Adapter
{
    private final ArrayList<String> mValues;

    public GroupDetailMembersListRecyclerViewAdapter(ArrayList<String> items) {
        mValues = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_groups_members_list_item, parent, false);
        return new GroupMemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        GroupMemberViewHolder ownHolder = (GroupMemberViewHolder) holder;
        String title = mValues.get(position);
        ownHolder.mTitleView.setText(title);
    }

    @Override
    public int getItemCount() {
        return mValues!= null ? mValues.size() : 0;
    }

    public class GroupMemberViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;

        public GroupMemberViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.group_detail_member_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
