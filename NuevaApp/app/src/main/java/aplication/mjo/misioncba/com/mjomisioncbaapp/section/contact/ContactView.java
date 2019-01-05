package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ContactCoordinator;


/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactView  extends LinearLayout {

    private TextView contactName;
    private String contactPhoneString;
    ContactCoordinator contactModel;

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

    public void setListener(OnContactViewButtonsListener mListener) {
        this.mListener = mListener;
    }

    public void configureForModel (ContactCoordinator model){

        this.contactModel = model;
        this.contactName.setText(model.getName());
        this.contactPhoneString = model.getPhone();

    }
    private void init() {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.contact_view, this, true);

        this.contactName = (TextView)findViewById(R.id.contact_view_name);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mListener != null){
                    mListener.onClickView(contactModel);
                }
            }
        });
    }



    public interface OnContactViewButtonsListener {

        void onClickView(ContactCoordinator contactModel);
    }
}
