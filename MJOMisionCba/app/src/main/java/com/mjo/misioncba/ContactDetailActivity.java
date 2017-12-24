package com.mjo.misioncba;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mjo.misioncba.section.contact.ContactFragment;
import com.mjo.misioncba.section.contact.ContactModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactDetailActivity extends AppCompatActivity {

    private CircleImageView profileImageView;
    private Button callBtn;
    private Button msnBtn;
    private ContactModel contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.profileImageView = (CircleImageView) findViewById(R.id.contact_detail_profile_image);
        this.callBtn = (Button) findViewById(R.id.contact_detail_call_button);
        this.msnBtn = (Button) findViewById(R.id.contact_detail_msn_button);

        int type = -1;

        if(getIntent().getExtras() != null){
            contact = getIntent().getExtras().getParcelable("CONTACT_DETAIL_CONTACT_MODEL");
            type = contact.getType();
        }

        this.msnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMessengerMenu(contact.getContactNumber());
            }
        });

        this.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialApp(contact.getContactNumber());
            }
        });

        getSupportActionBar().setTitle(contact.getContactName());

        // Load the image
        Drawable drawable = imageForType (type);

        if(drawable != null){
            this.profileImageView.setImageDrawable(drawable);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    Drawable imageForType(int type){

        Drawable  drawable= null;

        switch (type){

            case 1:
                drawable = ContextCompat.getDrawable(this,R.drawable.coordinadores_flor_foto);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(this,R.drawable.coordinadores_tamara_foto);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(this,R.drawable.coordinadores_ana_laura_fotop);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(this,R.drawable.coordinadores_lautaro_foto_perfil);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(this,R.drawable.coordinadores_sabrina_foto);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(this,R.drawable.coordinadores_cachi_foto);
                break;

            default:
                drawable = ContextCompat.getDrawable(this,R.drawable.mjo_logo_nuevo );
                break;
        }

        return drawable;
    }

    private void openDialApp(String phoneNumber){

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, ContactFragment.REQUEST_PHONE_CALL);
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

    private void openMessengerMenu(String phoneNumber){

        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
        sendIntent.putExtra("sms_body", "Hola !! Como va ?");
        startActivity(sendIntent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ContactFragment.REQUEST_PHONE_CALL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    openDialApp(contact.getContactNumber());

                } else {

                    // Toast

                    Toast toast = Toast.makeText(getApplicationContext(), "Necesitamos tu permiso para ejecutar esta accion", Toast.LENGTH_LONG);
                    toast.show();
                }
                return;
            }
        }
    }
}
