package com.ppai.ppai_version_2.entities;

import java.util.Date;

public class Resenia {
    private String comentario;
    private Boolean esPremium;
    private Date fechaResena;
    private double puntaje;
    private Vino vino;

    public Resenia(String comentario, Boolean esPremium, Date fechaResena, double puntaje, Vino vino) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
        this.vino = vino;
    }

    public Double getPuntaje() {
        return (Double) this.puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setEsPremium(Boolean esPremium) {
        this.esPremium = esPremium;
    }

    public Date getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(Date fechaResena) {
        this.fechaResena = fechaResena;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
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
