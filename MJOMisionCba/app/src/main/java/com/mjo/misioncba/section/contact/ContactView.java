package com.mjo.misioncba.section.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjo.misioncba.R;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactView  extends LinearLayout {


    private ImageButton buttonCall;
    private ImageButton buttonMsn;
    private TextView contactName;
    private TextView contactPhone;
    private String contactPhoneString;

    public ContactView(Context context) {
        super(context);
        init();
    }

    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContactView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void configureForModel (ContactModel model){

        this.contactName.setText(model.getContactName());
        this.contactPhone.setText(model.getContactNumber());
        this.contactPhoneString = model.getContactNumber();

    }
    private void init() {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.contact_view, this, true);

        this.contactName = (TextView)findViewById(R.id.contact_view_name);
        this.contactPhone = (TextView)findViewById(R.id.contact_view_phone);
        this.buttonCall = (ImageButton)findViewById(R.id.contact_view_button_call);
        this.buttonMsn = (ImageButton)findViewById(R.id.contact_view_button_msn);
    }
}