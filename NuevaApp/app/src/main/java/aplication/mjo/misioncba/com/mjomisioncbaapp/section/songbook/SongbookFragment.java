package aplication.mjo.misioncba.com.mjomisioncbaapp.section.songbook;


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

import java.util.ArrayList;
import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.MisionCbaApplication;
import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.DonwloadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongbookFragment extends DonwloadFragment {


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


        titleAlertMessage = "¿ Descargar el cancionero completo?";
        filenameDownload = "Cancionero-Mision-2018";
        titleNotificationDownload = filenameDownload;

        MisionCbaApplication application = ((MisionCbaApplication) getActivity().getApplication());
        url = application.getSections().getSongbook().getUrl();

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
