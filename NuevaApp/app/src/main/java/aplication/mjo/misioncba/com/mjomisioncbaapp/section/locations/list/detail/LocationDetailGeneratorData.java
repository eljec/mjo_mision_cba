package aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.detail;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionPlaces;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionPlacesItem;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailGeneratorData {

    public List<LocationDetailItemList> getData(Context context, SectionPlaces sectionPlaces)
    {

        List<LocationDetailItemList> data = new ArrayList<>();

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
