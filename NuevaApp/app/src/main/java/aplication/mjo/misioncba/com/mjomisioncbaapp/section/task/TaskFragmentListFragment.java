package aplication.mjo.misioncba.com.mjomisioncbaapp.section.task;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aplication.mjo.misioncba.com.mjomisioncbaapp.MisionCbaApplication;
import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Sections;

public class TaskFragmentListFragment extends Fragment {


    public static TaskFragmentListFragment newInstance() {
        TaskFragmentListFragment fragment = new TaskFragmentListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        MisionCbaApplication application = ((MisionCbaApplication) getActivity().getApplication());
        Sections sections = application.getSections();


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_task_list_view);
        Context context = recyclerView.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        TaskRecyclerViewAdapter adapter = new TaskRecyclerViewAdapter(sections.getTasks());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
