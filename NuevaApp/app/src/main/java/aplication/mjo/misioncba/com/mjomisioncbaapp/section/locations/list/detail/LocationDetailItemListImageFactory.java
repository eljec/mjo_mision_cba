package aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;


/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailItemListImageFactory {


    static public final int LOCATION_TYPE_ZONA = 99;

    static public Drawable getImageForType(int type, Context context){

        Drawable image = null;

        switch (type){

            case LocationDetailItemList.LOCATION_TYPE_SACHI:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_sachi );
                break;

            case LocationDetailItemList.LOCATION_TYPE_CARRARA_NORTE:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_carrara_norte );
                break;

            case LocationDetailItemList.LOCATION_TYPE_CARRARA_SUR:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_carrara_sur );
                break;

            case LocationDetailItemList.LOCATION_TYPE_COLINA_LOS_PINOS:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_colina_los_pinos );
                break;

            case LocationDetailItemList.LOCATION_TYPE_ASENTAMIENTO_RANAULT:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_asentamiento_renault );
                break;

            case LOCATION_TYPE_ZONA:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_barrios_mision );
                break;

            default:
                break;

        }

        return image;
    }
}
