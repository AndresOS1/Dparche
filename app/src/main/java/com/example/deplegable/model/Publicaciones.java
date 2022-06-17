package com.example.deplegable.model;

import java.util.Date;

public class Publicaciones {

    private String imagen;
    private String opinion;
    private Date Fecha;
    private Double Ubicacion;

    public Publicaciones() {
    }

    public Publicaciones(String imagen, String opinion, Date fecha, Double ubicacion) {
        this.imagen = imagen;
        this.opinion = opinion;
        Fecha = fecha;
        Ubicacion = ubicacion;
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


    @Override
    public String toString() {
        return  imagen + ' ' + opinion + ' ' + Fecha + ' ' + Ubicacion ;
    }
}
