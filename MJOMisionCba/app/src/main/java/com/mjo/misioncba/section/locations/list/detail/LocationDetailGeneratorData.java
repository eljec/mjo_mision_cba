package com.mjo.misioncba.section.locations.list.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.mjo.misioncba.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailGeneratorData {

    public List<LocationDetailItemList> getData(Context context){

        List<LocationDetailItemList> data = new ArrayList<>();

        Resources res = context.getResources();
        int[] imagesTypes = res.getIntArray(R.array.location_detail_image_types);
        String[] titles = res.getStringArray(R.array.location_detail_title);

        for (int i = 0; i < imagesTypes.length; i++) {

            String title = titles[i];
            int imageType = imagesTypes[i];

            Drawable image = LocationDetailItemListImageFactory.getImageForType(imageType, context);

            if(image != null){

                LocationDetailItemList item = new LocationDetailItemList (imageType, title);
                data.add(item);
            }
        }
        return data;
    }
}
