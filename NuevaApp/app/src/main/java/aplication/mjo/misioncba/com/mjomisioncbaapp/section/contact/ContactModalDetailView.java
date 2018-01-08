package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ContactCoordinator;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jucastillo on 30/12/16.
 */
public class ContactModalDetailView extends LinearLayout {

    private CircleImageView profileImageView;

    public ContactModalDetailView(Context context) {
        super(context);
        init(null);
    }

    public ContactModalDetailView(Context context, ContactCoordinator contactCoordinator) {
        super(context);
         init(contactCoordinator);
    }

    public ContactModalDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(null);
    }

    public ContactModalDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(null);
    }

    private void init(ContactCoordinator contactCoordinator) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.contact_alert_detail_view, this, true);

        this.profileImageView = (CircleImageView) findViewById(R.id.profile_image);

        // Load the image
        if(contactCoordinator.getImageUrl()!= null)
        {
            // Uso Picasso
            Picasso.with(getContext())
                    .load(contactCoordinator.getImageUrl())
                    .placeholder(R.drawable.mjo_logo_nuevo)
                    .error(R.drawable.mjo_logo_nuevo)
                    .into(this.profileImageView);
        }else
        {
            // First check for image from server
            Drawable drawable = ContactDrawableHandler.imageForType(contactCoordinator.getId(), getContext());

            if(drawable != null){
                this.profileImageView.setImageDrawable(drawable);
            }
        }
    }
}
