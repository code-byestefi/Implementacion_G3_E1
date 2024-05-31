package com.ppai.ppai_version_2.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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

    public boolean buscarVinosConResenia(Date fechaDesde, Date fechaHasta) {
        for (int i = 0; i < resenia.size(); i++){
            boolean tenesResenasPeriodo = resenia.get(i).sosDeFecha(fechaDesde, fechaHasta);
            boolean sosDeSommelier = resenia.get(i).sosDeSommelier();
            if(tenesResenasPeriodo && sosDeSommelier)
            {
                return true;
            }
        }
        return false;
    }

    public double calcularRanking(Date fechaDesde, Date fechaHasta){
        ArrayList<Double> puntajes = new ArrayList<>();

        for (int i = 0; i< resenia.size(); i++){
            boolean sosDePeriodo = resenia.get(i).sosDeFecha(fechaDesde, fechaHasta);
            boolean sosDeSommelier = resenia.get(i).sosDeSommelier();
            if (sosDePeriodo && sosDeSommelier){
                puntajes.add(resenia.get(i).getPuntaje());
            }
        }
        double promedio = calcularPromedio(puntajes);

        return promedio;
    }

    public double calcularPromedio(ArrayList<Double> lista) {
        if (lista == null || lista.isEmpty()) {
            return 0;  // Retornar 0 si la lista es nula o está vacía
        }
        double suma = 0;
        for (double numero : lista) {
            suma += numero;
        }
        return suma / lista.size();
    }
    
    

}
