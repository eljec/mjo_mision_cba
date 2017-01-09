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

            case LocationDetailItemList.LOCATION_TYPE_SANTA_ISABLE_TERCERA:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_santa_isabel_tercera );
                break;

            case LocationDetailItemList.LOCATION_TYPE_VICOR:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_vicor );
                break;

            case LocationDetailItemList.LOCATION_TYPE_VICOR_ANEXO:
                break;

            case LocationDetailItemList.LOCATION_TYPE_VICOR_AMPLIACION:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_amp_vicor );
                break;

            case LocationDetailItemList.LOCATION_TYPE_HEROES_DE_MALVINAS:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_h_de_malvinas );
                break;

            case LocationDetailItemList.LOCATION_TYPE_KAIROS:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_kairos );
                break;

            case LocationDetailItemList.LOCATION_TYPE_SANTA_ISABLE_ANEXO:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_santa_isable_anexo );
                break;

            case LocationDetailItemList.LOCATION_TYPE_SAN_LUIS_DE_FRANCIA:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_san_luis_de_francia );
                break;

            case LocationDetailItemList.LOCATION_TYPE_PARQUE_FUTURA:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_parque_futura );
                break;

            case LocationDetailItemList.LOCATION_TYPE_LA_ESPERANZA:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_esperanza );
                break;

            case LOCATION_TYPE_ZONA:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_barrios_mision );
                break;

            default:
                image = ContextCompat.getDrawable(context, R.drawable.mapa_amp_vicor );
                break;

        }

        return image;
    }
}
