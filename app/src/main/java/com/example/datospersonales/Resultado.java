package com.example.datospersonales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    private TextView Nombre, ApePaterno, ApeMaterno, Edad;
    public Button btnLlamar;
    private final int PHONE_CALL_CODE = 100;
    public Usuario user= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Nombre = (TextView) findViewById(R.id.Nombre);
        ApePaterno = (TextView) findViewById(R.id.ApePaterno);
        ApeMaterno = (TextView) findViewById(R.id.ApeMaterno);
        Edad = (TextView) findViewById(R.id.Edad);
        btnLlamar = (Button) findViewById(R.id.Numero);

        Bundle userIn = getIntent().getExtras();

        if (userIn != null)
        {
            user = (Usuario) userIn.getSerializable("usuario");
            Nombre.setText(user.getNombre());
            ApePaterno.setText(user.getApePaterno());
            ApeMaterno.setText(user.getApeMaterno());
            Edad.setText(user.getEdad());
            btnLlamar.setText(user.getNumero());
            Toast.makeText(this,"ok", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"No ok", Toast.LENGTH_LONG).show();
        }

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btnLlamar.getText() != null)
                {
                    if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
                    {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL_CODE);

                        //versionNueva();
                    }else
                    {
                        versionAntriores(user.getNumero());
                    }
                }
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PHONE_CALL_CODE:
                String permission= permissions[0];
                int result = grantResults[0];
                if(permission.equals(Manifest.permission.CALL_PHONE)){

                    if (result== PackageManager.PERMISSION_GRANTED){
                        String phoneNumber=user.getNumero();
                        Intent llamada= new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNumber));
                        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) return;
                        startActivity(llamada);


                    }
                    else{
                        Toast.makeText(this, "No aceptas el permiso", Toast.LENGTH_LONG).show();
                    }

                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private void versionAntriores(String num)
    {
        Intent IntentLlamada = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num));
        if (verificarPermisos(Manifest.permission.CALL_PHONE))
        {
            startActivity(IntentLlamada);
        }else
        {
            Toast.makeText(this, "Configura los permisos", Toast.LENGTH_LONG).show();
        }
    }
    private boolean verificarPermisos(String permiso)
    {
        int resultado = this.checkCallingPermission(permiso);
        return resultado == PackageManager.PERMISSION_GRANTED;
    }
}