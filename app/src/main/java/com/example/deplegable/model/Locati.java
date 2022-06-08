package com.example.deplegable.model;

public class Locati {

    private Double Latitud;
    private Double Longitud;

    public Locati() {
    }

    public Locati(Double latitud, Double longitud) {
        Latitud = latitud;
        Longitud = longitud;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }

    @Override
    public String toString() {
        return Latitud + " " + Longitud;
    }
}
