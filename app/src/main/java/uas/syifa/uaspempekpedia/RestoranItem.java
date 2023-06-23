package uas.syifa.uaspempekpedia;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class RestoranItem implements Parcelable {

    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    @SerializedName("nama_restoran")
    private String namaRestoran;

    @SerializedName("lokasi_restoran")
    private String lokasiRestoran;

    @SerializedName("telphone")
    private String telphone;

    @SerializedName("jam_operasional")
    private String jamOperational;

    @SerializedName("rating")
    private String rating;

    @SerializedName("tentang_restoran")
    private String tentangRestoran;

    @SerializedName("foto_restoran")
    private String fotoRestoran;

    protected RestoranItem(Parcel in) {
        tentangRestoran = in.readString();
        lokasiRestoran = in.readString();
        telphone = in.readString();
        jamOperational = in.readString();
        rating = in.readString();
        tentangRestoran = in.readString();
        fotoRestoran = in.readString();

    }

    public static final Creator<RestoranItem> CREATOR = new Creator<RestoranItem>() {
        @Override
        public RestoranItem createFromParcel(Parcel in) {
            return new RestoranItem(in);
        }

        @Override
        public RestoranItem[] newArray(int size) {
            return new RestoranItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(success);
        dest.writeString(message);
        dest.writeString(namaRestoran);
        dest.writeString(lokasiRestoran);
        dest.writeString(telphone);
        dest.writeString(jamOperational);
        dest.writeString(rating);
        dest.writeString(tentangRestoran);
        dest.writeString(fotoRestoran);
    }

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
