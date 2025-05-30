package com.victor.examen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente, btnSiguiente2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente2 = findViewById(R.id.btnSiguiente1);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irSiguiente = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(irSiguiente);
            }
        });


        btnSiguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irSiguiente = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(irSiguiente);
            }
        });
    }
}