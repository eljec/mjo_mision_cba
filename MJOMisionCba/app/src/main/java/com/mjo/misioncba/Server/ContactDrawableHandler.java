package com.mjo.misioncba.Server;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.mjo.misioncba.R;

/**
 * Created by jucastillo on 29/12/17.
 */

public class ContactDrawableHandler
{
    static public Drawable imageForType(int type, Context ctx)
    {

        Drawable  drawable= null;

        switch (type){

            case 1:
                drawable = ContextCompat.getDrawable(ctx, R.drawable.coordinadores_flor_foto);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_tamara_foto);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_ana_laura_fotop);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_lautaro_foto_perfil);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_sabrina_foto);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_cachi_foto);
                break;

            default:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.mjo_logo_nuevo );
                break;
        }

        return drawable;
    }
}
