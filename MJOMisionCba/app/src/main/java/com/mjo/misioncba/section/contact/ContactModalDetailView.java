package com.mjo.misioncba.section.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.mjo.misioncba.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jucastillo on 30/12/16.
 */
public class ContactModalDetailView extends LinearLayout {

    private CircleImageView profileImageView;

    public ContactModalDetailView(Context context) {
        super(context);
        init(-1);
    }

    public ContactModalDetailView(Context context, int type) {
        super(context);
         init(type);
    }

    public ContactModalDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(-1);
    }

    public ContactModalDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(-1);
    }

    private void init(int type) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.contact_alert_detail_view, this, true);

        this.profileImageView = (CircleImageView) findViewById(R.id.profile_image);
        this.profileImageView.setImageDrawable(imageForType(type));
    }

    Drawable imageForType(int type){

        Drawable  drawable= null;

        switch (type){

            case 1:
                drawable = ContextCompat.getDrawable(getContext(),R.drawable.coordinadores_flor_foto);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(getContext(),R.drawable.coordinadores_tamara_foto);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(getContext(),R.drawable.coordinadores_ana_laura_fotop);
                break;

            default:
                drawable = ContextCompat.getDrawable(getContext(),R.drawable.mjo_logo_nuevo );
                break;
        }

            return drawable;
    }
}
