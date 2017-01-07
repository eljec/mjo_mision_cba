package com.mjo.misioncba.section.songbook;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjo.misioncba.R;
import com.mjo.misioncba.section.prayer.Prayer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongbookFragment extends Fragment {


    public SongbookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_songbook, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.songbook_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, OrientationHelper.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SongbookListRecyclerViewAdapter(loadData()));

        return view;
    }


    private List<Song> loadData(){

        List<Song> data = new ArrayList<>();

        String[] tiles = getContext().getResources().getStringArray(R.array.songbook_titles);
        String[] contents = getContext().getResources().getStringArray(R.array.songbook_content);


        if(tiles.length == contents.length){

            for (int i = 0; i<  tiles.length; i++) {

                Song songItem = new Song (tiles[i], contents[i]);
                data.add(songItem);
            }
        }
        return data;
    }
}
