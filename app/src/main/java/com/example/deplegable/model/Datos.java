package com.example.deplegable.model;

public class Datos {

    private String URL;

    public Datos(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() { return  URL ; }
}
