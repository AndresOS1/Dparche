package com.example.deplegable.model;

import java.util.Date;

public class Publicaciones {

    private int foto;
    private String descripcion;
    private String ubicacion;
    private String categoria;

    public Publicaciones(int foto, String descripcion, String ubicacion, String categoria) {
        this.foto = foto;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  foto + ' ' + descripcion + ' ' + ubicacion + ' ' + categoria ;
    }
}
