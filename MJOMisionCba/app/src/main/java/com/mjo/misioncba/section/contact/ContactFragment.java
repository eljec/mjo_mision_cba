package com.mjo.misioncba.section.contact;


import android.Manifest;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjo.misioncba.ContactDetailActivity;
import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.model.ContactCoordinator;
import com.mjo.misioncba.section.cotto.CottoDetailActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements ContactView.OnContactViewButtonsListener {

    public static final int REQUEST_PHONE_CALL = 1;

    private LinearLayout contactContainer;
    private LinearLayout cottoContainer;
    private TextView cottoAddressLineTextView;
    private TextView cottoPhoneTextView;
    private ImageButton cottoImageButtonMap;
    private TextView cottoSectionLabel;

    private Button firemanButton;
    private Button policeButton;
    private Button hospitalButton;
    private LinearLayout aniamdoresContainer;
    private TextView misionWeb;

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
        this.aniamdoresContainer = (LinearLayout) fragmentView.findViewById(R.id.fragment_contact_animadores_container_view);

        this.cottoAddressLineTextView = (TextView) fragmentView.findViewById(R.id.fragment_contact_cotto_address_line);
        this.cottoPhoneTextView = (TextView) fragmentView.findViewById(R.id.fragment_contact_cotto_phone);
        this.cottoImageButtonMap = (ImageButton) fragmentView.findViewById(R.id.fragment_contact_cotto_image);
        this.firemanButton = (Button) fragmentView.findViewById(R.id.fragment_contact_cotto_button_fireman);
        this.hospitalButton = (Button) fragmentView.findViewById(R.id.fragment_contact_cotto_button_hospital);
        this.policeButton = (Button) fragmentView.findViewById(R.id.fragment_contact_cotto_button_police);

        this.cottoSectionLabel = (TextView) fragmentView.findViewById(R.id.fragment_contact_cotto_section_label);

        this.misionWeb = (TextView) fragmentView.findViewById(R.id.fragment_contact_mision_web_content_label);

        setUpView();

        return fragmentView;
    }

    private void setUpView(){

        // Open browser
        this.misionWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://donorione.org.ar/web/index.php/miradoras/5639-sembrando-esperanza-en-cordoba";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        MisionCbaApplication application = ((MisionCbaApplication) getActivity().getApplication());

        final ContactFragmentInfoGenerator infoGenerator = new ContactFragmentInfoGenerator(getContext(),application.getSections().getContact());

        ArrayList<ContactCoordinator> generalCoordinators = infoGenerator.getReferentsContactCoordinators();
        ArrayList<ContactCoordinator> groupCoordinators = infoGenerator.getGroupsContactCoordinators();

        final ContactCottoModel contactCottoModel = infoGenerator.getCottoContactCoordinator();


        // Coordinadores generales

        for (ContactCoordinator contact: generalCoordinators) {

            ContactView contactView = new ContactView(getContext());
            contactView.setListener(this);
            contactView.configureForModel(contact);

            this.contactContainer.addView(contactView);
        }

        // Coordinadores de grupos

        for (ContactCoordinator contact: groupCoordinators) {

            ContactView contactView = new ContactView(getContext());
            contactView.setListener(this);
            contactView.configureForModel(contact);

            this.aniamdoresContainer.addView(contactView);
        }

        // Cotto

        this.cottoPhoneTextView.setText("Tel: " + contactCottoModel.getContactCottoModelPhoneNUmber());
        this.cottoSectionLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open cotto detail
                Intent intent = new Intent(getContext(), CottoDetailActivity.class);
                startActivity(intent);
            }
        });
        this.cottoPhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialApp(contactCottoModel.getContactCottoModelPhoneNUmber());
            }
        });
        this.cottoAddressLineTextView.setText(contactCottoModel.getContactCottoModelAddressStreetLine());
        this.cottoImageButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uri = contactCottoModel.getContactCottoModelUrlMaps();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });

        // Setup help buttons

        this.policeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialApp(infoGenerator.getPolicePhoe());
            }
        });

        this.hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialApp(infoGenerator.getHospitalPhone());
            }
        });

        this.firemanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialApp(infoGenerator.getFiremanPhone());
            }
        });
    }

    @Override
    public void onClickView(ContactCoordinator contactModel) {
        // Open detail contact view

        Intent contactDetail = new Intent(getActivity(), ContactDetailActivity.class);
        contactDetail.putExtra("CONTACT_DETAIL_CONTACT_MODEL", contactModel);
        startActivity(contactDetail);
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
