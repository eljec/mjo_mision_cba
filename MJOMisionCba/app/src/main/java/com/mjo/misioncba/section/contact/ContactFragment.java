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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjo.misioncba.MainActivity;
import com.mjo.misioncba.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements ContactView.OnContactViewButtonsListener {

    private static final int REQUEST_PHONE_CALL = 1;
    private LinearLayout contactContainer;
    private LinearLayout cottoContainer;
    private TextView cottoAddressLineTextView;
    private TextView cottoPhoneTextView;
    private ImageButton cottoImageButtonMap;

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
        this.cottoAddressLineTextView = (TextView) fragmentView.findViewById(R.id.fragment_contact_cotto_address_line);
        this.cottoPhoneTextView = (TextView) fragmentView.findViewById(R.id.fragment_contact_cotto_phone);
        this.cottoImageButtonMap = (ImageButton) fragmentView.findViewById(R.id.fragment_contact_cotto_image);

        setUpView();

        return fragmentView;
    }

    private void setUpView(){

        ContactFragmentInfoGenerator infoGenerator = new ContactFragmentInfoGenerator(getContext());

        ArrayList<ContactModel> contactModels = infoGenerator.getReferentsContactModels();
        final ContactCottoModel contactCottoModel = infoGenerator.getCottoContactModel();


        // Load the contact

        for (ContactModel contact: contactModels) {

            ContactView contactView = new ContactView(getContext());
            contactView.setmListener(this);
            contactView.configureForModel(contact);

            this.contactContainer.addView(contactView);
        }

        // Cotto

        this.cottoPhoneTextView.setText("Telñefono: " + contactCottoModel.getContactCottoModelPhoneNUmber());
        this.cottoPhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialApp(contactCottoModel.getContactCottoModelPhoneNUmber());
            }
        });
        this.cottoAddressLineTextView.setText("Direccion: " + contactCottoModel.getContactCottoModelAddressStreetLine());
        this.cottoImageButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uri = contactCottoModel.getContactCottoModelUrlMaps();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCallButtonClick(String phoneNumber) {
        openDialApp(phoneNumber);
    }

    @Override
    public void onSendMsnButtonClick(String phoneNumber) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola !! Como va ?");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


    private void openDialApp(String phoneNumber){

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

}
