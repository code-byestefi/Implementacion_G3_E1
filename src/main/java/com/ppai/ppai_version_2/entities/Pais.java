package com.ppai.ppai_version_2.entities;

import java.util.ArrayList;

public class Pais {

    private String nombre;
    private ArrayList<Provincia> provincias;

    public Pais(String nombre, ArrayList<Provincia> provincias) {
        this.nombre = nombre;
        this.provincias = provincias;
    }
    public Pais(String name) {
        this.nombre = name;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Provincia> getProvincias() {
        return provincias;
    }
    public void setProvincias(ArrayList<Provincia> provincias) {
        this.provincias = provincias;
    }

}
