package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtperfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference();
        clicks();
    }

    public void reference(){
         txtperfil = findViewById(R.id.irPerfilS);
    }

    public void clicks(){
        txtperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ir a perfil", Toast.LENGTH_SHORT).show();
                Intent irperfil = new Intent(MainActivity.this, Profile.class);
                startActivity(irperfil);
            }
        });
    }
}