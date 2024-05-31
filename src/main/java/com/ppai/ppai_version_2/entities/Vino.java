package com.ppai.ppai_version_2.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Vino {
    //Agregar atributos
    private String nombre;
    private String descripcion;
    private Varietal varietal;
    private Bodega bodega;
    private Double precio;
    private List<Resenia> resenia;

    public Vino(String nombre, String descripcion, Varietal varietal, Bodega bodega, Double precio, List<Resenia> resenia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.varietal = varietal;
        this.bodega = bodega;
        this.precio = precio;
        this.resenia = resenia;
    }

    public Bodega getBodega() {
        return this.bodega;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public String getNombre() {
        return this.nombre;
    }
    public Double getPrecio() {
        return this.precio;
    }
    public List<Resenia> getResenia() {
        return this.resenia;
    }
    public Varietal getVarietal() {
        return this.varietal;
    }

    // mirar diagrama de secuencia
    public boolean buscarVinosConResenia(Date fechaDesde, Date fechaHasta, String tipoResenia) {
    
        for (Resenia resenia : this.resenia) {
            if (!resenia.getFecha().before(fechaDesde) && 
                !resenia.getFecha().after(fechaHasta) &&  
                resenia.getEsPremium() && tipoResenia.equals("Es premium")) {
                return true; // El vino tiene al menos una reseña que cumple los criterios
            }

        }
        return false; // El vino no tiene reseñas que cumplan los criterios
    }
    
    

}
