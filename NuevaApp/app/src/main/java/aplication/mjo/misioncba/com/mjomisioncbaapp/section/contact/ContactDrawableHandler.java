package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;

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
                drawable = ContextCompat.getDrawable(ctx, R.drawable.coordinadores_tamara);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_ana_laura_fotop);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_sancho_foto);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_lautaro_foto_perfil);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_flor_rivero_foto);
                break;
            case 7:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_rosario);
                break;
            case 9:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_sabrina_foto);
                break;
            case 10:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_eli_bazan);
                break;
            case 11:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_sofi);
                break;
            case 12:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_braian);
                break;
            case 13:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_elian);
                break;
            case 14:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_lucia);
                break;
            case 15:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.coordinadores_yami);
                break;

            default:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.user_default_icon );
                break;
        }

        return drawable;
    }
}
