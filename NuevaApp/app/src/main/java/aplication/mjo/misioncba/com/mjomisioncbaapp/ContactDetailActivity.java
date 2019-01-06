package aplication.mjo.misioncba.com.mjomisioncbaapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ContactCoordinator;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.ContactDrawableHandler;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.ContactFragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class ContactDetailActivity extends AppCompatActivity {

    private CircleImageView profileImageView;
    private Button callBtn;
    private Button msnBtn;
    TextView infoLabel;
    private ContactCoordinator contact;

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
            type = contact.getId();
        }

        if(contact.getPhone() != null && contact.getPhone().isEmpty() == false)
        {
            this.msnBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openMessengerMenu(contact.getPhone());
                }
            });

            this.callBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialApp(contact.getPhone());
                }
            });
        }else
        {
            findViewById(R.id.contact_detail_communication_container).setVisibility(View.GONE);
        }

        getSupportActionBar().setTitle(contact.getName());

        // Load the image
        if(contact.getImageUrl()!= null)
        {
            // Uso Picasso
            Picasso.with(this)
                    .load(contact.getImageUrl())
                    .placeholder(R.drawable.user_default_icon_2)
                    .error(R.drawable.user_default_icon_2)
                    .into(this.profileImageView);
        }else
        {
            // First check for image from server
            Drawable drawable = ContactDrawableHandler.imageForType(type, this);

            if(drawable != null){
                this.profileImageView.setImageDrawable(drawable);
            }
        }

        infoLabel = (TextView) findViewById(R.id.contact_detail_info);
        infoLabel.setText(contact.getInfo());
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
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

                    openDialApp(contact.getPhone());

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
