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
                drawable = ContextCompat.getDrawable(ctx, R.drawable.coordinadores_luciano);
                break;
            default:
                drawable = ContextCompat.getDrawable(ctx,R.drawable.user_default_icon_2);
                break;
        }

        return drawable;
    }
}
