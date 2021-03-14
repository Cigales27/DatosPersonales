package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre, ApePaterno, ApeMaterno, Numero,Edad;
    private Button btnRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistro = (Button) findViewById(R.id.btnRegistrar);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nombre = (EditText) findViewById(R.id.txtNombre);
                ApePaterno = (EditText) findViewById(R.id.txtxApePaterno);
                ApeMaterno = (EditText) findViewById(R.id.txtxApeMaterno);
                Numero = (EditText) findViewById(R.id.txtxNumero);
                Edad = (EditText) findViewById(R.id.txtEdad);
                String nombre = Nombre.getText().toString();
                String numero = Numero.getText().toString();
                if(nombre!="" && numero!=null)
                {
                    Usuario usuario = new Usuario();
                    usuario.setNombre(Nombre.getText().toString());
                    usuario.setApePaterno(ApePaterno.getText().toString());
                    usuario.setApeMaterno(ApeMaterno.getText().toString());
                    usuario.setNumero(Numero.getText().toString());
                    usuario.setEdad(Edad.getText().toString());
                    Intent resultado = new Intent(view.getContext(), Resultado.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("usuario", usuario);
                    resultado.putExtras(bundle);

                    startActivity(resultado);
                }else {
                    Toast.makeText(MainActivity.this, "Ingresa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}