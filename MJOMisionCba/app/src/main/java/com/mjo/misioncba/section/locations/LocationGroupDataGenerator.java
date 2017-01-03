package com.mjo.misioncba.section.locations;

import android.content.Context;

import com.mjo.misioncba.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jucastillo on 2/1/17.
 */
public class LocationGroupDataGenerator {

    public List<LocationGroupItem> getData(Context context){

        List<LocationGroupItem> data = new ArrayList<LocationGroupItem>();

        if(context != null){

           String[]  titles = context.getResources().getStringArray(R.array.location_group_section_title);
           String[]  contents = context.getResources().getStringArray(R.array.location_group_section_content);

            for (int i = 0; i < titles.length; i++) {
                String title = titles[i];
                data.add(new LocationGroupItem(LocationGroupItem.HEADER_TYPE, title));
                String content = contents[i];
                data.add(new LocationGroupItem(LocationGroupItem.LOCATION_TYPE, content));
            }

        }
        return  data;
    }
}
