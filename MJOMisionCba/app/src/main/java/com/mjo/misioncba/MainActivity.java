package com.mjo.misioncba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mjo.misioncba.model.ItineraryDayEvent;
import com.mjo.misioncba.model.Sections;
import com.mjo.misioncba.section.contact.ContactFragment;
import com.mjo.misioncba.section.feedback.StarFlow.FeedbackStartFlowActivity;
import com.mjo.misioncba.section.itinerary.ItineraryFragment;
import com.mjo.misioncba.section.itinerary.detail.ItineraryActivityEventDetail;
import com.mjo.misioncba.section.locations.list.LocationGroupFragment;
import com.mjo.misioncba.section.locations.list.LocationGroupItem;
import com.mjo.misioncba.section.maps.MapFragment;
import com.mjo.misioncba.section.merchandasing.MerchandisingFragment;
import com.mjo.misioncba.section.prayer.PrayerFragment;
import com.mjo.misioncba.section.readings.list.ReadingFragmentListFragment;
import com.mjo.misioncba.section.songbook.SongbookFragment;

import java.util.ArrayList;

import static com.mjo.misioncba.section.itinerary.detail.ItineraryActivityEventDetail.EVENT_DAY_ID_SELECTED;
import static com.mjo.misioncba.section.itinerary.detail.ItineraryActivityEventDetail.EVENT_ID_SELECTED;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ItineraryFragment.OnListFragmentInteractionListener, ReadingFragmentListFragment.OnReadingListFragmentInteractionListener, LocationGroupFragment.OnLocationGroupListFragmentInteractionListener {


    public static final String KEY_PREFRENCES_FILE_NAME="mjo_mision_cba_itinerary_preferences";
    public static final String KEY_PREFRENCES_SELECTED_INDEX="itinerary_selected_index";

    private View spinnerViewContainer;
    private int counterBack = 0;
    private ArrayList<Integer> visibleSections;
    private MenuItem downloadItem;


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

        addMenuItemInNavMenuDrawer();

        // Default fragment
        if (savedInstanceState == null) {
            // Check if we have a previous selected index

            if (visibleSections.size() > 0)
            {
                selectItem(visibleSections.get(0));
                navigationView.getMenu().getItem(0).setChecked(true);
            }else
            {
                 // Show modal diciendo que aun no hay secciones aun
                showNoDataAlertView();
            }

        }

    }


    private void addMenuItemInNavMenuDrawer() {
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);

        Menu menu = navView.getMenu();

        MisionCbaApplication application = ((MisionCbaApplication) getApplication());
        Sections sections = application.getSections();

        visibleSections = new ArrayList<>();

        // Check for section, and if it is available so we show it

        if(sections.hasItinerary())
        {
            menu.add(R.id.section_groups,R.id.nav_itinerary,Menu.NONE, R.string.navigation_item_itinerary).setIcon(R.mipmap.ic_event_black_24dp).setCheckable(true).setChecked(false);
            visibleSections.add(R.id.nav_itinerary);
        }

        if(sections.hasReadings())
        {
            menu.add(R.id.section_groups,R.id.nav_readings,Menu.NONE, R.string.navigation_item_reading_per_day).setIcon(R.mipmap.ic_import_contacts_black_24dp).setCheckable(true).setChecked(false);
            visibleSections.add(R.id.nav_readings);
        }

        if(sections.hasPrayers())
        {
            menu.add(R.id.section_groups,R.id.nav_prayer,Menu.NONE,R.string.navigation_item_prayer_of_missionary).setIcon(R.mipmap.ic_insert_emoticon_black_24dp).setCheckable(true).setChecked(false);
            visibleSections.add(R.id.nav_prayer);
        }

        if(sections.hasSongbook())
        {
            menu.add(R.id.section_groups,R.id.nav_songbook,Menu.NONE,R.string.navigation_item_songbook).setIcon(R.mipmap.ic_audiotrack_black_24dp).setCheckable(true).setChecked(false);;
            visibleSections.add(R.id.nav_songbook);
        }

        if(sections.hasGroups())
        {
            menu.add(R.id.section_groups,R.id.nav_groups,Menu.NONE, R.string.navigation_item_groups).setIcon(R.mipmap.ic_group_black_24dp).setCheckable(true).setChecked(false);
            visibleSections.add(R.id.nav_groups);
        }


        // Mapa barrios
        menu.add(R.id.section_groups,R.id.nav_map,Menu.NONE,R.string.navigation_item_maps).setIcon(android.R.drawable.ic_dialog_map).setCheckable(true).setChecked(false);;
        visibleSections.add(R.id.nav_map);

        if(sections.hasMerchandising())
        {
            menu.add(R.id.section_groups,R.id.nav_merchandising,Menu.NONE,R.string.navigation_item_merchandising).setIcon(R.mipmap.ic_store_black_24dp).setCheckable(true).setChecked(false);;
            visibleSections.add(R.id.nav_merchandising);
        }

        if(sections.hasFeedback())
        {
            menu.add(R.id.section_groups,R.id.nav_feedback,Menu.NONE,R.string.navigation_item_feedback).setIcon(R.mipmap.ic_star_black_24dp).setCheckable(true).setChecked(false);;
            visibleSections.add(R.id.nav_feedback);
        }

        if(sections.hasContactSection())
        {
            menu.add(R.id.section_groups,R.id.nav_contact,Menu.NONE,R.string.navigation_item_contact).setIcon(R.mipmap.ic_info_black_24dp).setCheckable(true).setChecked(false);;
            visibleSections.add(R.id.nav_contact);
        }

        navView.invalidate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        counterBack = 0;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            // Check counter for back

            counterBack ++;

            if(counterBack >= 2){
                super.onBackPressed();
            }else{
                Toast.makeText(this, "Oprimir una vez mas para salir la app",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Check the id of the menu and replace fragment

        if (id == R.id.nav_feedback){
            // Open feedback flow
            Intent intent = new Intent(this, FeedbackStartFlowActivity.class);
            startActivity(intent);
        }else {
            selectItem(id);
        }

        counterBack = 0;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return !(id == R.id.nav_feedback);
    }

    @Override
    public void onListFragmentInteraction(ItineraryDayEvent item) {
        // Click on item of itinerary list
        //openReadingDetailActivity(item.event.getDayId());
        openEventDetail(item);
    }

    private void selectItem(int id) {

        // Check the id of the menu and replace fragment

        Fragment fragment = null;
        // Create a new fragment and specify the planet to show based on position

        if (id == R.id.nav_itinerary) {
            spinnerViewContainer.setVisibility(View.VISIBLE);

            int indexSelected = getIndexFromPreferences();
            fragment = ItineraryFragment.newInstance(indexSelected);
        } else if (id == R.id.nav_readings) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = ReadingFragmentListFragment.newInstance();
        } else if (id == R.id.nav_prayer) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new PrayerFragment();
        }else if (id == R.id.nav_contact) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new ContactFragment();
        } else if (id == R.id.nav_location_group) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new LocationGroupFragment();
        } else if (id == R.id.nav_map) {
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new MapFragment();
        }else if (id == R.id.nav_songbook){
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new SongbookFragment();
        }else if (id == R.id.nav_merchandising){
            spinnerViewContainer.setVisibility(View.GONE);
            fragment = new MerchandisingFragment();
        }

        // Update download item
        updateDownloadActionVarMenu(id);

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
        openReadingDetailActivity (position + 1);
    }

    @Override
    public void onLocationGroupListFragmentInteraction(LocationGroupItem item) {

        // Open detail location maps
        Intent intent = new Intent(this, LocationGroupDetailActivity.class);
        startActivity(intent);
    }

    private int getIndexFromPreferences(){

        SharedPreferences sharedPref = this.getSharedPreferences(KEY_PREFRENCES_FILE_NAME
                , Context.MODE_PRIVATE);
        return sharedPref.getInt(KEY_PREFRENCES_SELECTED_INDEX, 0);
    }

    private void openReadingDetailActivity(int dayId){

        Intent intent = new Intent(this, ReadingsDatailsActivity.class);
        intent.putExtra("READING_DAY_SELECTED", dayId);
        startActivity(intent);
    }

    private void openEventDetail(ItineraryDayEvent event)
    {

        Intent intent = new Intent(this, ItineraryActivityEventDetail.class);
        intent.putExtra(EVENT_DAY_ID_SELECTED, event.getDayId());
        intent.putExtra(EVENT_ID_SELECTED, event.getId());

        startActivity(intent);
    }

    protected void showNoDataAlertView()
    {
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        builder.setMessage("Aun no hay data cargada sobre la mision, intentalo mas tarde. Gracias!");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                        finish();
                    }
                });

        AlertDialog alertDownload = builder.create();
        alertDownload.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        downloadItem = menu.findItem(R.id.download_content);

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        int selectedMenu = getCheckedItem (navView);

        updateDownloadActionVarMenu(selectedMenu);

        return true;
    }

    private void updateDownloadActionVarMenu(int navigationItemId)
    {
        if(downloadItem != null)
        {
            boolean showItem = false;

            if(navigationItemId == R.id.nav_songbook)
            {
                showItem = true;
            }
            downloadItem.setVisible(showItem);
        }
    }

    private int getCheckedItem(NavigationView navigationView)
    {
        Menu menu = navigationView.getMenu();

        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isChecked()) {
                return item.getItemId();
            }
        }

        return -1;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

