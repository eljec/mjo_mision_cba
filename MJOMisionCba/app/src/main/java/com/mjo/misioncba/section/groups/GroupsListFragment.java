package com.mjo.misioncba.section.groups;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.model.SectionGroups;
import com.mjo.misioncba.model.SectionGroupsItem;
import com.mjo.misioncba.section.itinerary.RecyclerViewItemClickListener;

import java.util.ArrayList;

/**
 * Created by jucastillo on 24/12/17.
 */

public class GroupsListFragment extends Fragment
{
    private OnGroupsListFragmentInteractionListener mListener;
    SectionGroups sectionGroups;
    private ArrayList<String> groupsTitles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.groupsTitles = getGroupsTitles();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groups_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new GroupsListFragmentRecyclerViewAdapter(this.groupsTitles));
            recyclerView.addOnItemTouchListener(
                    new RecyclerViewItemClickListener(context, new RecyclerViewItemClickListener.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position)
                        {
                            mListener.onGroupsListFragmentInteraction(sectionGroups.getGroupByPosition(position));
                        }
                    })
            );
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGroupsListFragmentInteractionListener) {
            mListener = (OnGroupsListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnGroupsListFragmentInteractionListener
    {
        void onGroupsListFragmentInteraction( SectionGroupsItem groupsItem);
    }

    private ArrayList<String> getGroupsTitles()
    {
        MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
        sectionGroups = appState.getSections().getGroups();

        ArrayList<String> titles =new ArrayList<>();

        for (SectionGroupsItem group: sectionGroups.getList())
        {
           titles.add(group.getName());
        }

        return titles;
    }
}
