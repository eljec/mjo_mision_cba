package com.mjo.misioncba.section.locations.list.detail;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailItemList implements Parcelable {

    static public final int LOCATION_TYPE_SANTA_ISABLE_TERCERA = 0;
    static public final int LOCATION_TYPE_VICOR = 1;
    static public final int LOCATION_TYPE_VICOR_ANEXO = 2;
    static public final int LOCATION_TYPE_VICOR_AMPLIACION = 3;
    static public final int LOCATION_TYPE_HEROES_DE_MALVINAS = 4;
    static public final int LOCATION_TYPE_KAIROS = 5;
    static public final int LOCATION_TYPE_SANTA_ISABLE_ANEXO = 6;
    static public final int LOCATION_TYPE_SAN_LUIS_DE_FRANCIA = 7;
    static public final int LOCATION_TYPE_PARQUE_FUTURA = 8;
    static public final int LOCATION_TYPE_LA_ESPERANZA = 9;

    private int imageType;
    private String neighborhoodName;

    public LocationDetailItemList(int imageType, String neighborhoodName) {
        this.imageType = imageType;
        this.neighborhoodName = neighborhoodName;
    }

    public int getImageType() {
        return imageType;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    protected LocationDetailItemList(Parcel in) {
        imageType = in.readInt();
        neighborhoodName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageType);
        dest.writeString(neighborhoodName);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LocationDetailItemList> CREATOR = new Parcelable.Creator<LocationDetailItemList>() {
        @Override
        public LocationDetailItemList createFromParcel(Parcel in) {
            return new LocationDetailItemList(in);
        }

        @Override
        public LocationDetailItemList[] newArray(int size) {
            return new LocationDetailItemList[size];
        }
    };
}