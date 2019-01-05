package aplication.mjo.misioncba.com.mjomisioncbaapp.section.itinerary.detail;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import aplication.mjo.misioncba.com.mjomisioncbaapp.MisionCbaApplication;
import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.ReadingsDatailsActivity;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ItineraryDay;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ItineraryDayEvent;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.ItineraryDayEventPlace;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionItinerary;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Sections;
import aplication.mjo.misioncba.com.mjomisioncbaapp.section.itinerary.RecyclerViewItemClickListener;


/**
 * Created by jucastillo on 28/12/17.
 */

public class ItineraryActivityEventDetail extends AppCompatActivity
{
    private RecyclerView list;
    private TextView scheduleView;
    private int selectedDayId;
    private int selectedEventId;
    private ItineraryDayEvent eventModel;

    private static final int REQUEST_STORAGE = 1;
    private long enqueue;
    private DownloadManager downloadManager;

    public static final String EVENT_DAY_ID_SELECTED = "EVENT_DAY_ID_SELECTED";
    public static final String EVENT_ID_SELECTED = "EVENT_ID_SELECTED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get info from intent
        if(getIntent() != null){
            Bundle args = getIntent().getExtras();
            selectedDayId = args.getInt(EVENT_DAY_ID_SELECTED, 0);
            selectedEventId = args.getInt(EVENT_ID_SELECTED, 0);

            eventModel = getSelectedEvent();

            getSupportActionBar().setTitle(eventModel.getEventTitle());

            list = (RecyclerView) findViewById(R.id.place_list);

            if(eventModel.getPlaces() != null && eventModel.getPlaces().size() > 0)
            {
                list.setLayoutManager(new LinearLayoutManager(getApplication()));
                list.setAdapter(new MyItineraryDeyailPlaceRecyclerViewAdapter(eventModel.getPlaces()));
                list.addOnItemTouchListener(
                        new RecyclerViewItemClickListener(this, new RecyclerViewItemClickListener.OnItemClickListener() {
                            @Override public void onItemClick(View view, int position) {

                                // Callback to activity
                                ItineraryDayEventPlace place =   eventModel.getPlaces().get(position);

                                if(place.getSpecificPlaceMap()!= null && place.getSpecificPlaceMap().hasLocation())
                                {
                                    // Open google map
                                    String googleMapsPackageName = "com.google.android.apps.maps";
                                    PackageManager pm = getPackageManager();
                                    boolean isInstalled = isPackageInstalled(googleMapsPackageName, pm);
                                    if(isInstalled) {

                                        String urlAddress = "http://maps.google.com/maps?q=" + place.getSpecificPlaceMap().getLatitude() + "," + place.getSpecificPlaceMap().getLongitude() + "(" + place.getPlace() + ")&iwloc=A&hl=es";
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlAddress));
                                        startActivity(intent);
                                    }else
                                    {
                                        Toast.makeText(getApplicationContext(),"Necesitas tener instalado Google Maps para ver el punto en el mapa", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        })
                );
            }else
            {
                findViewById(R.id.place_container).setVisibility(View.GONE);
            }

            scheduleView = (TextView) findViewById(R.id.schedule_view);
            scheduleView.setText("Horario: " + eventModel.getEventDate());

            // Lecturas
            // Check if reading is online
            View readingContainer = findViewById(R.id.reading_container);
            MisionCbaApplication application = ((MisionCbaApplication) getApplication());
            Sections sections = application.getSections();

            if(sections.hasReadings() && eventModel.getEventImageType() == 2) // MISA
            {
                Button redaing = (Button) findViewById(R.id.event_detail_reading);
                redaing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(), ReadingsDatailsActivity.class);
                        intent.putExtra("READING_DAY_SELECTED", selectedDayId);
                        startActivity(intent);
                    }
                });

            }else
            {
                readingContainer.setVisibility(View.GONE);
            }

            // Download

            View downloadContainer = findViewById(R.id.download_container);

            if(eventModel.getUrl()!= null)
            {
                Button downloadButton = (Button) findViewById(R.id.event_detail_download_content);
                downloadButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        downloadFileFromUrl();

                    }
                });
            }else
            {
                downloadContainer.setVisibility(View.GONE);
            }

        }else
        {
            finish();
        }
    }

    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private ItineraryDayEvent getSelectedEvent()
    {
        MisionCbaApplication appState = ((MisionCbaApplication) getApplication());
        SectionItinerary itinerary = appState.getSections().getItinerary();

        ItineraryDayEvent eventSelectedModel = null;

        for (ItineraryDay day: itinerary.getDays())
        {
           if(day.getId() == selectedDayId)
           {
               for (ItineraryDayEvent event : day.getEvents())
               {
                  if(event.getId() == selectedEventId)
                  {
                      eventSelectedModel = event;
                      break;
                  }
               }
           }
        }

        return eventSelectedModel;
    }

    // Download logic

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_STORAGE) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                downloadFile();
            } else  {
                Toast.makeText(getApplication(), "Necesitamos que nos des permisos para descargar contenido desde la app :)", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected void downloadFileFromUrl()
    {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.M) {
            requestStoragePermission();
        } else {
            downloadFile();
        }
    }

    private void requestStoragePermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_STORAGE);
        } else {
            Log.i("Main", "Storage permissions have already been granted. Download the file");
            downloadFile();
        }
    }

    private void downloadFile() {
        downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(eventModel.getUrl().getLink()));

        //Setting title of request
        String title = "Formacion";
        request.setTitle(title);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        String name = eventModel.getEventTitle().replace(" ","-") + "." +  eventModel.getUrl().getExtension();

        //Save file to destination folder
        request.setDestinationInExternalPublicDir("/Downloads", name);
        enqueue = downloadManager.enqueue(request);
    }
}
