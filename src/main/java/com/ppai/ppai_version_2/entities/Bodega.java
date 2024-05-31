package com.ppai.ppai_version_2.entities;

public class Bodega {
    //Agregar atributos
    private String nombre;
    private Region region;

    public Bodega(String nombre, Region region) {
        this.nombre = nombre;
        this.region = region;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Region getRegion() {
        return this.region;
    }

}
