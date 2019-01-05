package aplication.mjo.misioncba.com.mjomisioncbaapp.section.readings.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

/**
 * Created by jucastillo on 30/12/16.
 */
public class ReadingView extends LinearLayout {


    private TextView titleLabel;
    private TextView subtitleLabel;
    private TextView contentLabel;

    public ReadingView(Context context) {
        super(context);
    }

    public ReadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.reading_view, this, true);

        this.titleLabel = (TextView)findViewById(R.id.reading_view_title);
        this.titleLabel = (TextView)findViewById(R.id.reading_view_subtitle);
        this.titleLabel = (TextView)findViewById(R.id.reading_view_content);

    }
}
