package com.mjo.misioncba.section.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.Server.DataSourceDelegate;
import com.mjo.misioncba.Server.SectionMessageDataSource;
import com.mjo.misioncba.SplashActivity;
import com.mjo.misioncba.model.SectionMessage;

/**
 * Created by jucastillo on 5/1/18.
 */

public class MessageFragment extends Fragment implements DataSourceDelegate
{

    private TextView title;
    private TextView info;
    private Button reload;

    private View loading;
    private  View dataContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);

        loading = view.findViewById(R.id.fragment_message_loading);
        dataContainer = view.findViewById(R.id.fragment_message_data);

        title = (TextView) view.findViewById(R.id.fragment_message_title);
        info = (TextView) view.findViewById(R.id.fragment_message_info);
        reload = (Button) view.findViewById(R.id.fragment_message_reload);

        MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
        SectionMessage sectionMsg = appState.getSections().getMessages();


        setUpView(sectionMsg);

        // Load new data from server

        SectionMessageDataSource dataSource = new SectionMessageDataSource(this);

        loading.setVisibility(View.VISIBLE);
        dataContainer.setVisibility(View.GONE);

        dataSource.loadData();

        return view;
    }

    @Override
    public void loadSuccess(Object result)
    {
       // Update data onn section and refresh view
        SectionMessage sectionMsg = (SectionMessage) result;
        setUpView(sectionMsg);

        loading.setVisibility(View.GONE);
        dataContainer.setVisibility(View.VISIBLE);

        // Update data on aplication
        MisionCbaApplication appState = ((MisionCbaApplication) getActivity().getApplication());
        appState.getSections().setMessages(sectionMsg);
    }

    @Override
    public void loadFail(Object error)
    {
        loading.setVisibility(View.GONE);
        dataContainer.setVisibility(View.VISIBLE);

        // Toast
        Toast.makeText(getContext(), "Error al traer datos, intentalo mas tarde", Toast.LENGTH_LONG).show();
    }

    private void setUpView (SectionMessage sectionMsg)
    {
        title.setText(sectionMsg.getMessage().getTitle());

        info.setText(sectionMsg.getMessage().getContent());

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

    }
}
