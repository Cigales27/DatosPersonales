package com.example.datospersonales;

import java.io.Serializable;

public class Usuario implements Serializable {
    public String Nombre;
    public String ApePaterno;
    public String ApeMaterno;
    public String Numero;
    public String Edad;

    public Usuario() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String apePaterno) {
        ApePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        ApeMaterno = apeMaterno;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
