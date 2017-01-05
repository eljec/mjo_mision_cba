package com.mjo.misioncba;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.mjo.misioncba.model.Itinerary;
import com.mjo.misioncba.model.ItineraryProvider;
import com.mjo.misioncba.model.ItineraryProviderConstants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);

        new LoadJsonFiles().execute();
    }

    private class LoadJsonFiles extends AsyncTask<Void, Void, Itinerary> {

        protected Itinerary doInBackground(Void... urls) {


            Itinerary itinerary = new ItineraryProvider(getAssets()).obtain(ItineraryProviderConstants.ITINERARY_ASSET_FILE);

            return itinerary;
        }

        protected void onPostExecute(Itinerary result) {

            // Save data on application object
            MisionCbaApplication application = ((MisionCbaApplication) getApplication());
            application.setItinerary(result);

            // Open main activity
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }
    }

    }
