package uas.syifa.uaspempekpedia;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataRestoran implements Parcelable {

	@SerializedName("success")
	private int success;

	@SerializedName("newrestoran")
	private List<NewrestoranItem> newrestoran;

	@SerializedName("message")
	private String message;

	protected DataRestoran(Parcel in) {
		success = in.readInt();
		message = in.readString();
	}

	public static final Creator<DataRestoran> CREATOR = new Creator<DataRestoran>() {
		@Override
		public DataRestoran createFromParcel(Parcel in) {
			return new DataRestoran(in);
		}

		@Override
		public DataRestoran[] newArray(int size) {
			return new DataRestoran[size];
		}
	};

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setNewrestoran(List<NewrestoranItem> newrestoran){
		this.newrestoran = newrestoran;
	}

	public List<NewrestoranItem> getNewrestoran(){
		return newrestoran;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeInt(success);
		dest.writeString(message);
	}
}