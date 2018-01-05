package com.mjo.misioncba.section.locations.list.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.mjo.misioncba.R;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailItemListImageFactory {


    static public final int LOCATION_TYPE_ZONA = 99;

    static public Drawable getImageForType(int type, Context context){

        Drawable image = null;

        switch (type){

            case LocationDetailItemList.LOCATION_TYPE_LOS_CEDROS:
                image = ContextCompat.getDrawable(context, R.drawable.map_los_cedros );
                break;

            case LocationDetailItemList.LOCATION_TYPE_AMPLIACION_CABILDO:
                image = ContextCompat.getDrawable(context, R.drawable.map_ampliacion_cabildo );
                break;

            case LocationDetailItemList.LOCATION_TYPE_CABILDO_ANEXO:
                break;

            case LocationDetailItemList.LOCATION_TYPE_HOGAR_CLASE_MEDIA:
                break;

            case LocationDetailItemList.LOCATION_TYPE_PARQUE_UNIVERSIDAD:
                image = ContextCompat.getDrawable(context, R.drawable.map_parque_universidad );
                break;

            case LocationDetailItemList.LOCATION_TYPE_CABILDO:
                image = ContextCompat.getDrawable(context, R.drawable.map_cabildo );
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
