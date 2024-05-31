package com.ppai.ppai_version_2.entities;

import java.util.Date;

public class Resenia {
    //Agregar atributos
    private String nombre;
    private Number puntaje;
    private Date fecha;
    private Boolean esPremium;

    public Resenia(String nombre, Number puntaje, Date fecha, Boolean esPremium) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.fecha = fecha;
        this.esPremium = esPremium;
    }

    public String getNombre() {
        return this.nombre;
    }
    public Number getPuntaje() {
        return this.puntaje;
    }
    public Date getFecha() {
        return this.fecha;
    }
    public Boolean getEsPremium() {
        return this.esPremium;
    }
    public Boolean sosDeSommelier() {
        return this.esPremium; 
    }
    
}
