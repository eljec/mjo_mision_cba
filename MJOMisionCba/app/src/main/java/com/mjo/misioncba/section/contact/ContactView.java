package com.mjo.misioncba.section.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjo.misioncba.R;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactView  extends LinearLayout {

    private TextView contactName;
    private String contactPhoneString;
    ContactModel contactModel;

    private OnContactViewButtonsListener mListener;

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

    public void setmListener(OnContactViewButtonsListener mListener) {
        this.mListener = mListener;
    }

    public void configureForModel (ContactModel model){

        this.contactModel = model;
        this.contactName.setText(model.getContactName());
        this.contactPhoneString = model.getContactNumber();

    }
    private void init() {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.contact_view, this, true);

        this.contactName = (TextView)findViewById(R.id.contact_view_name);

        this.contactName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mListener != null){
                    mListener.onClickView(contactModel);
                }
            }
        });
    }



    public interface OnContactViewButtonsListener {

        void onClickView(ContactModel contactModel);
    }
}
