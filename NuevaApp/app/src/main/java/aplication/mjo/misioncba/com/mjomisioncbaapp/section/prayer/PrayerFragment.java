package aplication.mjo.misioncba.com.mjomisioncbaapp.section.prayer;


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

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrayerFragment extends Fragment {


    public PrayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prayer_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.player_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, OrientationHelper.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new PlayerListRecyclerViewAdapter(loadData()));

        return view;
    }


    private List<Prayer> loadData(){

        List<Prayer> data = new ArrayList<>();

        String[] tiles = getContext().getResources().getStringArray(R.array.prayer_titles);
        String[] contents = getContext().getResources().getStringArray(R.array.prayer_content);


        if(tiles.length == contents.length){

            for (int i = 0; i<  tiles.length; i++) {

                Prayer pryer = new Prayer (tiles[i], contents[i]);
                data.add(pryer);
            }
        }
        return data;
    }

}
