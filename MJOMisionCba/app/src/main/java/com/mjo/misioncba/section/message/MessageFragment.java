package com.mjo.misioncba.section.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.SplashActivity;
import com.mjo.misioncba.model.SectionMessage;

/**
 * Created by jucastillo on 5/1/18.
 */

public class MessageFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);

        MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
        SectionMessage sectionMsg = appState.getSections().getMessages();

        TextView title = (TextView) view.findViewById(R.id.fragment_message_title);
        title.setText(sectionMsg.getMessage().getTitle());

        TextView info = (TextView) view.findViewById(R.id.fragment_message_info);
        info.setText(sectionMsg.getMessage().getContent());

        Button reload = (Button) view.findViewById(R.id.fragment_message_reload);

        if(sectionMsg.getMessage().isShowBtn())
        {

            reload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getContext(), SplashActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(intent);

                    getActivity().finish();
                }
            });

        }else{
            reload.setVisibility(View.GONE);
        }

        return view;
    }
}
