package com.mjo.misioncba.section.locations.list.detail;

/**
 * Created by jucastillo on 3/1/17.
 */
public class LocationDetailItemList {

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
}
