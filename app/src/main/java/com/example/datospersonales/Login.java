package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Nombre;
    private Button btnLog;
    private Usuarios usuarios = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLog = (Button) findViewById(R.id.btnLogin);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nombre = (EditText) findViewById(R.id.txtLogNombre);
                String nombre = Nombre.getText().toString();

                Bundle userIn = getIntent().getExtras();

                if (userIn != null)
                {
                    usuarios = (Usuarios) userIn.getSerializable("usuarios");
                    usuarios.listaUsuarios.get(0);

                    //

                }else
                {
                    //
                }

            }
        });

    }
}