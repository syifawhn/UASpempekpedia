package uas.syifa.uaspempekpedia;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class NewrestoranItem implements Parcelable {
	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;


	@SerializedName("link_foto")
	private String linkFoto;

	@SerializedName("jam_operasional")
	private String jamOperasional;

	@SerializedName("rating_restoran")
	private String ratingRestoran;

	@SerializedName("__v")
	private int v;

	@SerializedName("nama_restoran")
	private String namaRestoran;

	@SerializedName("tentang_restoran")
	private String tentangRestoran;

	@SerializedName("_id")
	private String id;

	@SerializedName("lokasi_restoran")
	private String lokasiRestoran;

	protected NewrestoranItem(Parcel in) {
		linkFoto = in.readString();
		jamOperasional = in.readString();
		ratingRestoran = in.readString();
		v = in.readInt();
		namaRestoran = in.readString();
		tentangRestoran = in.readString();
		id = in.readString();
		lokasiRestoran = in.readString();
	}

	public static final Creator<NewrestoranItem> CREATOR = new Creator<NewrestoranItem>() {
		@Override
		public NewrestoranItem createFromParcel(Parcel in) {
			return new NewrestoranItem(in);
		}

		@Override
		public NewrestoranItem[] newArray(int size) {
			return new NewrestoranItem[size];
		}
	};

	public void setLinkFoto(String linkFoto){
		this.linkFoto = linkFoto;
	}

	public String getLinkFoto(){
		return linkFoto;
	}

	public void setJamOperasional(String jamOperasional){
		this.jamOperasional = jamOperasional;
	}

	public String getJamOperasional(){
		return jamOperasional;
	}

	public void setRatingRestoran(String ratingRestoran){
		this.ratingRestoran = ratingRestoran;
	}

	public String getRatingRestoran(){
		return ratingRestoran;
	}

	public void setV(int v){
		this.v = v;
	}

	public int getV(){
		return v;
	}

	public void setNamaRestoran(String namaRestoran){
		this.namaRestoran = namaRestoran;
	}

	public String getNamaRestoran(){
		return namaRestoran;
	}

	public void setTentangRestoran(String tentangRestoran){
		this.tentangRestoran = tentangRestoran;
	}

	public String getTentangRestoran(){
		return tentangRestoran;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLokasiRestoran(String lokasiRestoran){
		this.lokasiRestoran = lokasiRestoran;
	}

	public String getLokasiRestoran(){
		return lokasiRestoran;
	}
	public int getSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeString(linkFoto);
		dest.writeString(jamOperasional);
		dest.writeString(ratingRestoran);
		dest.writeInt(v);
		dest.writeString(namaRestoran);
		dest.writeString(tentangRestoran);
		dest.writeString(id);
		dest.writeString(lokasiRestoran);
	}
}