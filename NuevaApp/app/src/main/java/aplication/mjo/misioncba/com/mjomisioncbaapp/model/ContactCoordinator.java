package aplication.mjo.misioncba.com.mjomisioncbaapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jucastillo on 29/12/17.
 */

public class ContactCoordinator implements Parcelable
{
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("type")
    @Expose
    private String  type;
    @SerializedName("name")
    @Expose
    private String  name;
    @SerializedName("phone")
    @Expose
    private String  phone;
    @SerializedName("image_link")
    @Expose
    private String  imageUrl;
    @SerializedName("info")
    @Expose
    private String  info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isGeneralCoordinatior()
    {
        return this.type.equals("general");
    }

    public boolean isGroupInternalCoordinatior()
    {
        return this.type.equals("group");
    }

    public boolean isGroupExternalCoordinatior()
    {
        return this.type.equals("group_external");
    }


    protected ContactCoordinator(Parcel in) {
        id = in.readInt();
        type = in.readString();
        name = in.readString();
        phone = in.readString();
        imageUrl = in.readString();
        info = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(imageUrl);
        dest.writeString(info);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ContactCoordinator> CREATOR = new Parcelable.Creator<ContactCoordinator>() {
        @Override
        public ContactCoordinator createFromParcel(Parcel in) {
            return new ContactCoordinator(in);
        }

        @Override
        public ContactCoordinator[] newArray(int size) {
            return new ContactCoordinator[size];
        }
    };
}
