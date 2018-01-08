package aplication.mjo.misioncba.com.mjomisioncbaapp.section.contact;

/**
 * Created by jucastillo on 20/12/16.
 */
public class ContactCottoModel {

    private String contactCottoModelTitle;
    private String contactCottoModelPhoneNUmber;
    private String contactCottoModelUrlMaps;
    private String contactCottoModelAddressStreetLine;


    public  ContactCottoModel(){

        this.contactCottoModelTitle = "Cottolendo Don Orione";
        this.contactCottoModelUrlMaps ="https://goo.gl/maps/RnmaKMewFDH2";
        this.contactCottoModelPhoneNUmber = "03514942111";
        this.contactCottoModelAddressStreetLine = "Av. Armada Argentina 2440, 5017 Córdoba";

    }

    public String getContactCottoModelPhoneNUmber() {
        return contactCottoModelPhoneNUmber;
    }

    public String getContactCottoModelTitle() {
        return contactCottoModelTitle;
    }

    public String getContactCottoModelUrlMaps() {
        return contactCottoModelUrlMaps;
    }

    public String getContactCottoModelAddressStreetLine() {
        return contactCottoModelAddressStreetLine;
    }
}
