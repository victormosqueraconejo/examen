package com.victor.examen;

import android.content.DialogInterface;
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

public class MainActivity2 extends AppCompatActivity {


    RadioGroup rgNivelTexto;
    RadioButton rbAlto, rbMedio, rbBajo;
    CheckBox chBateria, chRendimiento, chDiseno, chPantalla;
    Button btnVerResultado;

    int valorTotal = 0;
    int nivelSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        rgNivelTexto = findViewById(R.id.rgNivelTexto);
        rbAlto = findViewById(R.id.rbAlto);
        rbMedio = findViewById(R.id.rbMedio);
        rbBajo = findViewById(R.id.rbBajo);
        chBateria = findViewById(R.id.chBateria);
        chRendimiento = findViewById(R.id.chRendimiento);
        chDiseno = findViewById(R.id.chDiseno);
        chPantalla = findViewById(R.id.chPantalla);
        btnVerResultado = findViewById(R.id.btnVerResultado);



        chBateria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    valorTotal += 2;
                }
                if (!isChecked) {
                    valorTotal -= 2;
                }
            }
        });

        chRendimiento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    valorTotal += 3;
                }
                if (!isChecked) {
                    valorTotal -= 3;
                }
            }
        });
        chDiseno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    valorTotal += 1;
                }
                if (!isChecked) {
                    valorTotal -= 1;
                }
            }
        });
        chPantalla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    valorTotal += 2;
                }
                if (!isChecked) {
                    valorTotal -= 2;
                }
            }
        });

        rgNivelTexto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,  int checkedId) {
                nivelSeleccionado = checkedId;
            }
        });

        btnVerResultado.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder modal = new AlertDialog.Builder(MainActivity2.this);
            @Override
            public void onClick(View v) {
                if (nivelSeleccionado == R.id.rbBajo) {
                    modal.setMessage("Gracias por tu honestidad. Seguiremos mejorando.   \nResultado: " + valorTotal);
                }
                else if (nivelSeleccionado  == R.id.rbAlto && !chBateria.isChecked() && !chRendimiento.isChecked() && !chDiseno.isChecked() && !chPantalla.isChecked()) {
                    modal.setMessage("Selecciona al menos una razon que ejustifique tu alta satisfaccion:");
                }
//              Variante para enviar un mensaje cuando todas estan vacias
//              else if (!chBateria.isChecked() && !chRendimiento.isChecked() && !chDiseno.isChecked() && !chPantalla.isChecked()) {
//                  modal.setMessage("Selecciona al menos una razon que ejustifique tu alta satisfaccion:");
//              }
                else {
                    modal.setTitle("Resultado:");
                    if (valorTotal <= 2) {
                        modal.setMessage("Parece que no estas satifecho. \nRespuesta: "  + valorTotal);
                    } else if (valorTotal > 3 && valorTotal <= 5 ) {
                        modal.setMessage("Tu experiencia en medianamente buena. \nRespuesta: "  + valorTotal);
                    } else if (valorTotal > 5) {
                        modal.setMessage("Nos alegra saber que estas muy satisfecho. \nRespuesta: "  + valorTotal);
                    }
                }
                modal.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                modal.show();
            }
        }
        );

    }


}