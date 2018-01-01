package com.mjo.misioncba.section.groups.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjo.misioncba.ContactDetailActivity;
import com.mjo.misioncba.MisionCbaApplication;
import com.mjo.misioncba.R;
import com.mjo.misioncba.model.ContactCoordinator;
import com.mjo.misioncba.model.SectionGroups;
import com.mjo.misioncba.model.SectionGroupsItem;
import com.mjo.misioncba.section.contact.ContactView;

/**
 * Created by jucastillo on 31/12/17.
 */

public class GroupDetailActivity extends AppCompatActivity implements  ContactView.OnContactViewButtonsListener
{
    public static final String GROUP_ID_SELECTED = "GROUP_ID_SELECTED";
    private SectionGroupsItem groupSelected;
    private LinearLayout coordinatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(getIntent() != null) {
            Bundle args = getIntent().getExtras();
            int groupIdSelected = args.getInt(GROUP_ID_SELECTED, 0);

            MisionCbaApplication appState = ((MisionCbaApplication) getApplication());
            SectionGroups sectionGroups = appState.getSections().getGroups();

            groupSelected = sectionGroups.getGroupById(groupIdSelected);

            // Title
            getSupportActionBar().setTitle(groupSelected.getName());

            // Members
            if(groupSelected.hasMembers())
            {
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.group_member_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(this) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }});
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(new GroupDetailMembersListRecyclerViewAdapter(groupSelected.getMembers()));

            }else
            {
                findViewById(R.id.members_container).setVisibility(View.GONE);
            }

            // Coordinadores
            if(groupSelected.hasCoordinators())
            {
                coordinatorView = (LinearLayout)findViewById(R.id.group_coordinator_container_view);

                for (ContactCoordinator contact: groupSelected.getCoordinator()) {

                    ContactView contactView = new ContactView(this);
                    contactView.setListener(this);
                    contactView.configureForModel(contact);

                    coordinatorView.addView(contactView);
                }
            }else
            {
                findViewById(R.id.group_coordinator_container).setVisibility(View.GONE);
            }

            // Food
            if(groupSelected.hasFood())
            {
              TextView foodLabel = (TextView) findViewById(R.id.group_food_label);
              foodLabel.setText(groupSelected.getFood().getText());
            }else
            {
                findViewById(R.id.group_food_container).setVisibility(View.GONE);
            }

        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClickView(ContactCoordinator contactModel)
    {
        // Open detail contact view
        Intent contactDetail = new Intent(this, ContactDetailActivity.class);
        contactDetail.putExtra("CONTACT_DETAIL_CONTACT_MODEL", contactModel);
        startActivity(contactDetail);
    }
}
