package uas.syifa.uaspempekpedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.syifa.uaspempekpedia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RestoranViewAdapter restoranViewAdapter;
    private List <Restoran> data;
    private int RestoranItem;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getAllInput();
        Log.e("MainActivity", "Main OnCreate()");

        restoranViewAdapter = new RestoranViewAdapter();
        binding.rvRestoran.setLayoutManager(new LinearLayoutManager(this));
        binding.rvRestoran.setAdapter(restoranViewAdapter);
        
        restoranViewAdapter.setOnItemClickCallback(this::dataClick);
        restoranViewAdapter.setOnItemLongClickListener(new RestoranViewAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View v, NewrestoranItem input, int position) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.setGravity(Gravity.RIGHT);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int idMenu = item.getItemId();
                        if (idMenu == R.id.action_edit) {
                            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                            intent.putExtra("EXTRA_DATA", input);
                            startActivity(intent);
                            return true;
                        } else if (idMenu == R.id.action_delete) {
                            if (input != null) {
                                String id = input.getId();
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("Konfirmasi");
                                builder.setMessage("Yakin Ingin Menghapus Restoran '" + input.getNamaRestoran() + "' ?");

                                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        deleteInput(id);
                                    }
                                });

                                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        deleteInput(id);

                                    }
                                });

                                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();

                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            } else {
                                // tampilkan pesan atau lakukan tindakan jika input null
                            }
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });

        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
    }

    private void dataClick(NewrestoranItem item ) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("EXTRA_DATA", item);
        startActivity(intent);
    }

    private void deleteInput(String id) {
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<RestoranItem> call = api.deleteRestoran(id);
        call.enqueue(new Callback<RestoranItem>() {
            @Override
            public void onResponse(Call<RestoranItem> call, Response<RestoranItem> response) {
                Log.e("MainActivity", "Get Delete Response Code: " + response.code());
                if(response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success==1){
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        getAllInput();
                    }else{
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Response " + response.code(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RestoranItem> call, Throwable t) {
                Log.e("MainActivity", "Retrofit Error : " + t.getMessage());
                Toast.makeText(MainActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllInput();
    }

    private void getAllInput() {
        Log.e("MainActivity", "Main GetAllInput()");
        binding.progressbar.setVisibility(View.VISIBLE);
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<Restoran> call = api.getRestoran();
        call.enqueue(new Callback<Restoran>() {
            @Override
            public void onResponse(Call<Restoran> call, Response<Restoran> response) {
                binding.progressbar.setVisibility(View.GONE);
                Log.e("MainActivity", "Response: " + response.code());
                if(response.code()==200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        List<RestoranItem> dataRestoran = response.body().getRestoran();

                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        restoranViewAdapter.setData(dataRestoran);

                        data = new ArrayList<>(RestoranItem);
                    }
                }
            }

            @Override
            public void onFailure(Call<Restoran> call, Throwable t) {
                binding.progressbar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(MainActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}