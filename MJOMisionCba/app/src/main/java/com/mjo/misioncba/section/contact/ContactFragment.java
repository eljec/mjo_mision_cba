package com.mjo.misioncba.section.contact;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mjo.misioncba.MainActivity;
import com.mjo.misioncba.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements ContactView.OnContactViewButtonsListener {

    private static final int REQUEST_PHONE_CALL = 1;
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

        setUpView();

        return fragmentView;
    }

    private void setUpView(){

        ContactFragmentInfoGenerator infoGenerator = new ContactFragmentInfoGenerator(getContext());

        ArrayList<ContactModel> contactModels = infoGenerator.getReferentsContactModels();
        ContactCottoModel contactCottoModel = infoGenerator.getCottoContactModel();


        // Load the contact

        for (ContactModel contact: contactModels) {

            ContactView contactView = new ContactView(getContext());
            contactView.setmListener(this);
            contactView.configureForModel(contact);

            this.contactContainer.addView(contactView);
        }
    }

    @Override
    public void onCallButtonClick(String phoneNumber) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else
            {
                startActivity(intent);
            }
        }
        else
        {
            startActivity(intent);
        }
    }

    @Override
    public void onSendMsnButtonClick(String phoneNumber) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola !! Como va ?");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"));
                    startActivity(intent);
                }
                return;
            }
        }
    }
}
