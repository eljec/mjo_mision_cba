package com.mjo.misioncba;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mjo.misioncba.section.contact.ContactModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactDetailActivity extends AppCompatActivity {

    private CircleImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        this.profileImageView = (CircleImageView) findViewById(R.id.profile_image);

        ContactModel contact = null;
        int type = -1;

        if(getIntent().getExtras() != null){
            contact = getIntent().getExtras().getParcelable("CONTACT_DETAIL_CONTACT_MODEL");
            type = contact.getType();
        }

        getSupportActionBar().setTitle(contact.getContactName());

        // Load the image
        Drawable drawable;

        switch (type){

            case 1:
                drawable = ContextCompat.getDrawable(this,R.drawable.flor_foto_perfil );
                break;
            case 2:
                drawable = ContextCompat.getDrawable(this,R.drawable.tamara_foto_perfil );
                break;
            case 3:
                drawable = ContextCompat.getDrawable(this,R.drawable.ana_laura_foto_perfil );
                break;

            default:
                drawable = ContextCompat.getDrawable(this,R.drawable.mjo_logo_nuevo );
                break;
        }

        if(drawable != null){
            this.profileImageView.setImageDrawable(drawable);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
