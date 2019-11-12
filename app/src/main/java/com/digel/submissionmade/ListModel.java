package com.digel.submissionmade;

import android.os.Parcel;
import android.os.Parcelable;

public class ListModel implements Parcelable {

    private String movie_name;
    private String genre;
    private String rilis;
    private String desc;
    private int photo;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }


    public String getMovieName() {
        return movie_name;
    }

    public void setMovieName(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public ListModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movie_name);
        dest.writeString(this.genre);
        dest.writeString(this.rilis);
        dest.writeString(this.desc);
        dest.writeInt(this.photo);
    }

    protected ListModel(Parcel in) {
        this.movie_name = in.readString();
        this.genre = in.readString();
        this.rilis = in.readString();
        this.desc = in.readString();
        this.photo = in.readInt();
    }

    public static final Creator<ListModel> CREATOR = new Creator<ListModel>() {
        @Override
        public ListModel createFromParcel(Parcel source) {
            return new ListModel(source);
        }

        @Override
        public ListModel[] newArray(int size) {
            return new ListModel[size];
        }
    };
}
