package com.example.myapplication.Models;

import java.io.Serializable;

public class PerfilList implements Serializable {
    private String nombre_usuario;
    private String correo;

    public PerfilList(String nombre_usuario, String correo) {
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
