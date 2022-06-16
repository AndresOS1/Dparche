package com.example.deplegable.model;

import java.util.Date;

public class Publicaciones {

    private String imagen;
    private String opinion;
    private Date Fecha;
    private Double Ubicacion;
    private String NombreLugar;

    public Publicaciones() {
    }

    public Publicaciones(String imagen, String opinion, Date fecha, Double ubicacion, String nombreLugar) {
        this.imagen = imagen;
        this.opinion = opinion;
        Fecha = fecha;
        Ubicacion = ubicacion;
        NombreLugar = nombreLugar;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Double getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(Double ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getNombreLugar() {
        return NombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        NombreLugar = nombreLugar;
    }

    @Override
    public String toString() {
        return  imagen + ' ' + opinion + ' ' + Fecha + ' ' + Ubicacion + ' ' + NombreLugar;
    }
}
