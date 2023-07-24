package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    private TextView T1, T2, T3;
    private Button btnback;
    private RecyclerView recyclerPerfil;
    private List<PerfilModel> perfilmodel;
    private  PerfilAdapter adapterPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        reference();
        clicks();
    }

    private void clicks() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Profile.this, MainActivity.class);
                startActivity(volver);
                listarPerfil();
            }
        });
    }

    private void reference() {
        T2 = findViewById(R.id.text2);
        Intent intent = getIntent();
        //String accessT = intent.getStringExtra("token");
        //T2.setText(accessT);
        T2 = (TextView) findViewById(R.id.text2);
        btnback = (Button) findViewById(R.id.btnback);
        recyclerPerfil = findViewById(R.id.rcView);

        adapterPerfil = new PerfilAdapter(this);
        recyclerPerfil.setAdapter(adapterPerfil);
        recyclerPerfil.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        recyclerPerfil.setLayoutManager(linearLayoutManager);
    }

    private  void listarPerfil(){
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://lexa2334.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiUser apiUser = retrofit.create(ApiUser.class);
        Call<List<PerfilModel>> call = apiUser.getProfile("1");

        call.enqueue(new Callback<List<PerfilModel>>() {
            @Override
            public void onResponse(Call<List<PerfilModel>> call, Response<List<PerfilModel>> response) {
                Log.e("onResponse", response.body().toString());
                Log.e("onResponse", response.message().toString());
                Log.e("onResponse", String.valueOf(response.code()));

                adapterPerfil.add((ArrayList<PerfilModel>) perfilmodel);
            }

            @Override
            public void onFailure(Call<List<PerfilModel>> call, Throwable t) {

            }
        });
    }
}