package com.mjo.misioncba.section.merchandasing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjo.misioncba.R;

/**
 * Created by jucastillo on 24/12/17.
 */

public class MerchandisingFragment extends Fragment
{
    public MerchandisingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_merchandising, container, false);


        return view;
    }
}
