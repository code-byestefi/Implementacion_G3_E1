package com.ppai.ppai_version_2.entities;

import java.util.ArrayList;

public class Provincia {
    //Agregar atributos
    private String nombre;
    private Pais pais;
    private ArrayList<Region> region;

    public Provincia(String nombre, Pais pais, ArrayList<Region> regionVitivinicolas) {
        this.nombre = nombre;
        this.pais = pais;
        this.region = regionVitivinicolas;
    }

    public Provincia(String nombre, ArrayList<Region> region) {
        this.nombre = nombre;
        this.region = region;
    }

    public ArrayList<Region> getRegion() {
        return region;
    }

    public void setRegion(ArrayList<Region> region) {
        this.region = region;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String obtenerPais(){
        return this.pais.getNombre();
    }
}
