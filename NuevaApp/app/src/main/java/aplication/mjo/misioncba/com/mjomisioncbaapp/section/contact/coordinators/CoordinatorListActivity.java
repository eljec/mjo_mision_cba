package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.coordinators;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import aplication.mjo.misioncba.com.mjomisioncbaapp.ContactDetailActivity;
import aplication.mjo.misioncba.com.mjomisioncbaapp.MisionCbaApplication;
import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact.ContactFragmentInfoGenerator;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.itinerary.RecyclerViewItemClickListener;

/**
 * Created by jucastillo on 4/1/18.
 */

public class CoordinatorListActivity extends AppCompatActivity
{
    private RecyclerView list;
    private ArrayList<CoordinatorListViewItemModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Coordinadores");

        // List
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MisionCbaApplication application = ((MisionCbaApplication) getApplication());
        ContactFragmentInfoGenerator generator = new ContactFragmentInfoGenerator(getApplicationContext(), application.getSections().getContact());

        data = generator.getListModelCoordinators();
        list.setAdapter(new CoordinatorListRecyclerViewAdapter(data, getApplicationContext()));
        list.addOnItemTouchListener(
                new RecyclerViewItemClickListener(getApplicationContext(), new RecyclerViewItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position)
                    {
                        // Open contact detail

                        CoordinatorListViewItemModel model = data.get(position);

                        Intent contactDetail = new Intent(getApplicationContext(), ContactDetailActivity.class);
                        contactDetail.putExtra("CONTACT_DETAIL_CONTACT_MODEL", model.contact);
                        startActivity(contactDetail);
                    }
                })
        );
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
