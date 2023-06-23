package uas.syifa.uaspempekpedia;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @GET("get")
    Call<Restoran> getRestoran();

    @FormUrlEncoded
    @POST("add")
    Call<RestoranItem>
    addRestoran(
            @Field("nama_restoran") String namaRestoran,
            @Field("lokasi_restoran") String lokasiRestoran,
            @Field("telphone") Integer telphone,
            @Field("jam_operasional") String jamOperasional,
            @Field("rating") String rating,
            @Field("tentang_restoran") String tentangRestoran,
            @Field("foto_restoran") String fotoRestoran
    );

    @FormUrlEncoded
    @PUT("update/{id}")
    Call<RestoranItem>
    updateRestoran(
            @Path("id") String id,
            @Field("nama_restoran") String namaRestoran,
            @Field("lokasi_restoran") String lokasiRestoran,
            @Field("telphone") Integer telphone,
            @Field("jam_operasional") String jamOperasional,
            @Field("rating") String rating,
            @Field("tentang_restoran") String tentangRestoran,
            @Field("foto_restoran") String fotoRestoran
    );

    @DELETE("delete/{id}")
    Call<RestoranItem>
    deleteRestoran(
            @Path("id") String id
    );
}
