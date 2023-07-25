package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapters.PerfilAdapter;
import com.example.myapplication.Interfaces.ApiUser;
import com.example.myapplication.Models.PerfilModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity {
    private Button btnback;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<PerfilAdapter.ViewHolder> adapter;
    private List<PerfilModel> perfilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        reference();
        clicks();
        listarPerfil();
    }

    private void clicks() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Profile.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }

    private void reference() {
        btnback = (Button) findViewById(R.id.btnback);
        recyclerView = findViewById(R.id.rcView);
    }

    private  void listarPerfil(){
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://lexa2334.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiUser apiUser = retrofit.create(ApiUser.class);
        Call<PerfilModel> call = apiUser.getProfile("2");

        call.enqueue(new Callback<PerfilModel>() {
            @Override
            public void onResponse(Call<PerfilModel> call, Response<PerfilModel> response) {
                PerfilModel perfil = new PerfilModel();
                perfil.setId(response.body().getId());
                perfil.setUsername(response.body().getUsername());
                perfil.setFirst_name(response.body().getFirst_name());
                perfil.setLast_name(response.body().getLast_name());
                perfil.setEmail(response.body().getEmail());

                perfilList = new ArrayList<>();
                perfilList.add(perfil);

                recyclerView.setLayoutManager(new LinearLayoutManager(Profile.this));
                adapter = new PerfilAdapter(perfilList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PerfilModel> call, Throwable t) {
                Toast.makeText(Profile.this, "Failed" + t, Toast.LENGTH_LONG).show();
                Log.e("onFail", "Error" + t, t);
            }
        });
    }
}