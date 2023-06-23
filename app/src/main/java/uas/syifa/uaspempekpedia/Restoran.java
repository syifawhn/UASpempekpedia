package uas.syifa.uaspempekpedia;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restoran {
    @SerializedName("restoran")
    private List<RestoranItem> restoran;

    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    private String id;
    private String nama_restoran;
    private String lokasi;
    private String telphone;
    private String jam_operational;
    private String rating;
    private String tentang_restoran;
    private String link_foto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_restoran() {
        return nama_restoran;
    }

    public void setNama_restoran(String nama_restoran) {
        this.nama_restoran = nama_restoran;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getJam_operational() {
        return jam_operational;
    }

    public void setJam_operational(String jam_operational) {
        this.jam_operational = jam_operational;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTentang_restoran() {
        return tentang_restoran;
    }

    public void setTentang_restoran(String tentang_restoran) {
        this.tentang_restoran = tentang_restoran;
    }

    public String getLink_foto() {
        return link_foto;
    }

    public void setLink_foto(String link_foto) {
        this.link_foto = link_foto;
    }

    public int getSuccess() {
        return 0;
    }

    public String getMessage() {
        return message;

    }

    public List<RestoranItem> getRestoran() {
        return restoran;
    }
}
