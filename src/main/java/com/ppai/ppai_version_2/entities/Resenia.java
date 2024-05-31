package com.ppai.ppai_version_2.entities;

import java.util.Date;

public class Resenia {
    //Agregar atributos
    private String nombre;
    private Number puntaje;
    private Date fecha;
    private Boolean esPremium;
    private Date fechaResena;

    public Resenia(String nombre, Number puntaje, Date fecha, Boolean esPremium) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.fecha = fecha;
        this.esPremium = esPremium;
    }

    public String getNombre() {
        return this.nombre;
    }
    public Double getPuntaje() {
        return (Double) this.puntaje;
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

    public boolean sosDeFecha(Date fechaDesde, Date fechaHasta){
        if(fechaResena.after(fechaDesde) && fechaResena.before(fechaHasta)){
            return true;
        }
        return false;
    }
    
}
