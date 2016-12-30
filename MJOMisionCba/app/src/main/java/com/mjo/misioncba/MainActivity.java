package com.mjo.misioncba;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mjo.misioncba.section.contact.ContactFragment;
import com.mjo.misioncba.section.cotto.CottoDetailActivity;
import com.mjo.misioncba.section.itinerary.ItineraryFragment;
import com.mjo.misioncba.section.itinerary.ItineraryListViewItemModel;
import com.mjo.misioncba.section.prayer.PrayerFragment;
import com.mjo.misioncba.section.readings.ReadingFragmentListFragment;
import com.mjo.misioncba.section.readings.ReadingsItemLIst;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ItineraryFragment.OnListFragmentInteractionListener, ReadingFragmentListFragment.OnReadingListFragmentInteractionListener {

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

        // Default fragment
        if (savedInstanceState == null) {
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
            fragment = ItineraryFragment.newInstance();
        } else if (id == R.id.nav_prayer) {
            fragment = ReadingFragmentListFragment.newInstance();
        } else if (id == R.id.nav_contact) {
            fragment = new ContactFragment();
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
        startActivity(intent);
    }
}
