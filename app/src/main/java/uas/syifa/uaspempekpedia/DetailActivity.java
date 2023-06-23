package uas.syifa.uaspempekpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import uas.syifa.uaspempekpedia.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private DetailActivity binding;
    private RestoranItem input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        input = getIntent().getParcelableExtra("EXTRA_DATA");

        Glide.with(binding.ivPoster)
                .load(input.getFotoRestoran())
                .into(binding.ivPoster);

        binding.tvNamaRestoran.setText(input.getNamaRestoran());
        binding.tvLokasiRestoran.setText(input.getLokasi());
        binding.tvTelphone.setText(input.getTelphone());
        binding.tvJamOperasional.setText(input.getJamOperasional());
        binding.tvRating.setText(input.getRating());
        binding.tvTentangRestoran.setText(input.getTentangRestoran());
        binding.tvFotoRestoran.setText(input.getFotoRestoran());
    }
}