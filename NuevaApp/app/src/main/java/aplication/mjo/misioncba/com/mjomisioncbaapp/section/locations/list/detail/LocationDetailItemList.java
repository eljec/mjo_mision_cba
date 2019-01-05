package aplication.mjo.misioncba.com.mjomisioncbaapp.section.locations.list.detail;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailItemList implements Parcelable {

    static public final int LOCATION_TYPE_SACHI = 1;
    static public final int LOCATION_TYPE_CARRARA_SUR = 2;
    static public final int LOCATION_TYPE_CARRARA_NORTE = 3;
    static public final int LOCATION_TYPE_COLINA_LOS_PINOS = 4;
    static public final int LOCATION_TYPE_ASENTAMIENTO_RANAULT = 5;

    private int imageType;
    private String neighborhoodName;
    private String url;

    public LocationDetailItemList ()
    {

    }

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

    public String getUrl() {
        return url;
    }

    public void setImageType(int imageType) {
        this.imageType = imageType;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected LocationDetailItemList(Parcel in) {
        imageType = in.readInt();
        neighborhoodName = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageType);
        dest.writeString(neighborhoodName);
        dest.writeString(url);
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