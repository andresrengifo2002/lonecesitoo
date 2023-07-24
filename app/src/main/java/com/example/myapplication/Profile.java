package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
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
        T2 = findViewById(R.id.text2);
        Intent intent = getIntent();
        //String accessT = intent.getStringExtra("token");
        //T2.setText(accessT);
        T2 = (TextView) findViewById(R.id.text2);
        btnback = (Button) findViewById(R.id.btnback);
        recyclerPerfil = findViewById(R.id.rcView);

        adapterPerfil = new PerfilAdapter(perfilmodel, this);
        recyclerPerfil.setAdapter(adapterPerfil);
        recyclerPerfil.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        recyclerPerfil.setLayoutManager(linearLayoutManager);

        Toast.makeText(this, "Reference complete!", Toast.LENGTH_SHORT).show();
    }

    private  void listarPerfil(){
        Toast.makeText(this, "Get profile", Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://lexa2334.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiUser apiUser = retrofit.create(ApiUser.class);
        Call<PerfilModel> call = apiUser.getProfile("1");

        call.enqueue(new Callback<PerfilModel>() {
            @Override
            public void onResponse(Call<PerfilModel> call, Response<PerfilModel> response) {
                Log.i("onResponse", response.body().toString());
                Log.i("onResponse", response.message().toString());
                Log.i("onResponse", String.valueOf(response.code()));

                Toast.makeText(Profile.this, "respuesta: " + response.body().toString(), Toast.LENGTH_SHORT).show();

                recyclerPerfil.setAdapter(new PerfilAdapter(perfilmodel, this));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Profile.this, RecyclerView.VERTICAL, true);
            }

            @Override
            public void onFailure(Call<PerfilModel> call, Throwable t) {
                Toast.makeText(Profile.this, "Failed" + t, Toast.LENGTH_LONG).show();
                Log.e("onFail", "Error" + t, t);
            }
        });
    }
}