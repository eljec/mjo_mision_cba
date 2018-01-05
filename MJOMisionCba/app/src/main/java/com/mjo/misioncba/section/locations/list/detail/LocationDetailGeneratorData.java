package com.mjo.misioncba.section.locations.list.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.mjo.misioncba.model.SectionPlaces;
import com.mjo.misioncba.model.SectionPlacesItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailGeneratorData {

    public List<LocationDetailItemList> getData(Context context, SectionPlaces sectionPlaces)
    {

        List<LocationDetailItemList> data = new ArrayList<>();

        /*Resources res = context.getResources();
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
        }*/

        for (SectionPlacesItem place: sectionPlaces.getList())
        {

            // Get drawable for id
            Drawable image = LocationDetailItemListImageFactory.getImageForType(place.getId(), context);

            if(place.hasUrl() || image != null)
            {
                LocationDetailItemList item = new LocationDetailItemList();
                item.setImageType(place.getId());
                item.setNeighborhoodName(place.getName());
                item.setUrl(place.getImageUrl());

                data.add(item);
            }

        }
        return data;
    }
}
