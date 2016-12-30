package com.mjo.misioncba;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.mjo.misioncba.dummy.DummyContent;
import com.mjo.misioncba.model.ItineraryProvider;
import com.mjo.misioncba.section.contact.ContactFragment;
import com.mjo.misioncba.section.itinerary.ItineraryFragment;
import com.mjo.misioncba.section.itinerary.ItineraryListViewItemModel;
import com.mjo.misioncba.section.prayer.PrayerFragment;

import static com.mjo.misioncba.model.ItineraryProviderConstants.ITINERARY_ASSET_FILE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ItineraryFragment.OnListFragmentInteractionListener {

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
            fragment = new PrayerFragment();
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
}
