package com.mjo.misioncba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mjo.misioncba.section.contact.ContactFragment;
import com.mjo.misioncba.section.itinerary.ItineraryFragment;
import com.mjo.misioncba.section.itinerary.ItineraryListViewItemModel;
import com.mjo.misioncba.section.locations.LocationGroupFragment;
import com.mjo.misioncba.section.locations.LocationGroupItem;
import com.mjo.misioncba.section.maps.MapFragment;
import com.mjo.misioncba.section.readings.list.ReadingFragmentListFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ItineraryFragment.OnListFragmentInteractionListener, ReadingFragmentListFragment.OnReadingListFragmentInteractionListener, AdapterView.OnItemSelectedListener, LocationGroupFragment.OnLocationGroupListFragmentInteractionListener {


    public static final String KEY_PREFRENCES_FILE_NAME="mjo_mision_cba_itinerary_preferences";
    public static final String KEY_PREFRENCES_SELECTED_INDEX="itinerary_selected_index";

    private View spinnerViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Spinner

        spinnerViewContainer = findViewById(R.id.spinner_nav_container);

        Spinner spinnerDays = (Spinner)findViewById(R.id.spinner_nav);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_days_titles, R.layout.itinerary_spinner_item);

        adapter.setDropDownViewResource(R.layout.itinerary_spinner_dropdown_item);

        spinnerDays.setAdapter(adapter);
        spinnerDays.setOnItemSelectedListener(this);

        // Default fragment
        if (savedInstanceState == null) {
            // Check if we have a previous selected index
            selectItem(R.id.nav_itinerary);
            navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Check the id of the menu and replace fragment

        selectItem(id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(ItineraryListViewItemModel item) {

        // NO hacemos anda
    }

    private void selectItem(int id) {

        // Check the id of the menu and replace fragment

        Fragment fragment = null;
        // Create a new fragment and specify the planet to show based on position

        if (id == R.id.nav_itinerary) {
            spinnerViewContainer.setVisibility(View.VISIBLE);

            int indexSelected = getIndexFromPreferences();
            fragment = ItineraryFragment.newInstance(indexSelected);
        } else if (id == R.id.nav_prayer) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = ReadingFragmentListFragment.newInstance();
        } else if (id == R.id.nav_contact) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new ContactFragment();
        } else if (id == R.id.nav_location_group) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new LocationGroupFragment();
        } else if (id == R.id.nav_map) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new MapFragment();
        }

        if (fragment != null) {
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
    }

    @Override
    public void onReadingListFragmentInteraction(int position) {
        Intent intent = new Intent(this, ReadingsDatailsActivity.class);
        intent.putExtra("READING_DAY_SELECTED", position + 1);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // if index == 0 is Full Itinerary

        // Update the list view

        List<Fragment> allFragments = getSupportFragmentManager().getFragments();
        if (allFragments != null) {
            for (Fragment fragment : allFragments) {


                if(fragment instanceof  ItineraryFragment) {

                    ItineraryFragment itineraryFragment = (ItineraryFragment)fragment;
                    itineraryFragment.updateDataForDay(i);

                    // Save index
                    saveIndexOnPreferences(i);

                    break;
                }

            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onLocationGroupListFragmentInteraction(LocationGroupItem item) {

    }

    private void saveIndexOnPreferences(int index){

        SharedPreferences sharedPref = this.getSharedPreferences(KEY_PREFRENCES_FILE_NAME
                , Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(KEY_PREFRENCES_SELECTED_INDEX, index);
        editor.commit();


    }

    private int getIndexFromPreferences(){

        SharedPreferences sharedPref = this.getSharedPreferences(KEY_PREFRENCES_FILE_NAME
                , Context.MODE_PRIVATE);
        return sharedPref.getInt(KEY_PREFRENCES_SELECTED_INDEX, 0);
    }
}

