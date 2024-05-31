package com.ppai.ppai_version_2.entities;
public class Provincia {
    //Agregar atributos
    private String nombre;
    private Pais pais;

    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Pais getPais() {
        return this.pais;
    }
}
