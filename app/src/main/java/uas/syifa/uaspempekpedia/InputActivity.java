package uas.syifa.uaspempekpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.syifa.uaspempekpedia.databinding.ActivityInputBinding;

public class InputActivity extends AppCompatActivity {

    private ActivityInputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama_restoran = binding.etNamaRestoran.getText().toString();
                String lokasi_restoran = binding.etLokasiRestoran.getText().toString();
                String telphone = binding.etTelphone.getText().toString();
                String jam_operasional = binding.etJamOperational.getText().toString();
                String rating = binding.etRating.getText().toString();
                String tentang_restoran = binding.etTentangRestoran.getText().toString();
                String foto_restoran = binding.etFotoRestoran.getText().toString();

                boolean bolehInputNamaRestoran = Util.inputError(nama_restoran,binding.etNamaRestoran, "nama_restoran");
                boolean bolehInputLokasiRestoran = Util.inputError(lokasi_restoran,binding.etLokasiRestoran, "lokasi_restorab");
                boolean bolehInputTelphone = Util.inputError(telphone,binding.etTelphone, "telphone");
                boolean bolehInputJamOperasional = Util.inputError(jam_operasional,binding.etJamOperational, "jam_operasional");
                boolean bolehInputRating = Util.inputError(rating,binding.etRating, "rating");
                boolean bolehInputTentangRestoran = Util.inputError(tentang_restoran,binding.etTentangRestoran, "tentang_restoran");
                boolean bolehInputFotoRestoran = Util.inputError(foto_restoran,binding.etFotoRestoran, "foto_restoran");

                if (bolehInputNamaRestoran && bolehInputLokasiRestoran && bolehInputTelphone && bolehInputJamOperasional && bolehInputRating &&
                        bolehInputTentangRestoran && bolehInputFotoRestoran) {
                    saveRestoranToAPI(nama_restoran, lokasi_restoran, telphone, jam_operasional, rating, tentang_restoran, foto_restoran);
                }
            }
        });
    }

    private void saveRestoranToAPI(String namaRestoran, String lokasiRestoran, String telphone, String jamOperasional, String rating, String tentangRestoran, String fotoRestoran ) {
        binding.progressbar.setVisibility(View.VISIBLE);
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<RestoranItem> call = api.addRestoran(namaRestoran, lokasiRestoran, telphone, jamOperasional, rating, tentangRestoran, fotoRestoran);
        call.enqueue(new Callback<RestoranItem>() {
            @Override
            public void onResponse(Call<RestoranItem> call, Response<RestoranItem> response) {
                binding.progressbar.setVisibility(View.VISIBLE);
                if (response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1){
                        Toast.makeText(InputActivity.this,message, Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(InputActivity.this,message, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else {
                    Toast.makeText(InputActivity.this,"Response" + response.code(), Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

            @Override
            public void onFailure(Call<RestoranItem> call, Throwable t) {
                binding.progressbar.setVisibility(View.VISIBLE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(InputActivity.this, "Retrofit Error : " + t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}