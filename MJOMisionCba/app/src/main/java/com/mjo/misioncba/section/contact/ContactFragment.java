package com.mjo.misioncba.section.contact;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mjo.misioncba.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    private LinearLayout contactContainer;
    private LinearLayout cottoContainer;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView =  inflater.inflate(R.layout.fragment_contact, container, false);

        this.contactContainer = (LinearLayout) fragmentView.findViewById(R.id.fragment_contact_referents_container_view);
        this.cottoContainer = (LinearLayout) fragmentView.findViewById(R.id.fragment_contact_cotto_container_view);

        return fragmentView;
    }

    private void setUpView(){

        ContactFragmentInfoGenerator infoGenerator = new ContactFragmentInfoGenerator(getContext());

        ArrayList<ContactModel> contactModels = infoGenerator.getReferentsContactModels();
        ContactCottoModel contactCottoModel = infoGenerator.getCottoContactModel();



    }

}
