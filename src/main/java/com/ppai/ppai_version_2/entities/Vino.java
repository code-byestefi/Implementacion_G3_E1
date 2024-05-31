package com.ppai.ppai_version_2.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vino {
    private int anio;
    private String nombre;
    private String notaCataBodega;
    private double precio;
    private Bodega bodega;
    private ArrayList<Resenia> resenas;
    private Varietal varietal;


    //METODOS

    //Constructor
    public Vino(int anio, String nombre, String notaCataBodega, double precio,Bodega bodega, ArrayList<Resenia> resenas, Varietal varietal) {
        this.anio = anio;
        this.nombre = nombre;
        this.notaCataBodega = notaCataBodega;
        this.precio = precio;
        this.bodega = bodega;
        this.resenas = resenas;
        this.varietal = varietal;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaCataBodega() {
        return notaCataBodega;
    }

    public void setNotaCataBodega(String notaCataBodega) {
        this.notaCataBodega = notaCataBodega;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Resenia> getResenas() {
        return resenas;
    }

    public void setResenas(ArrayList<Resenia> resenas) {
        this.resenas = resenas;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Varietal getVarietal() {
        return varietal;
    }

    public void setVarietal(Varietal varietal) {
        this.varietal = varietal;
    }

    public boolean buscarVinosConResenia(Date fechaDesde, Date fechaHasta) {
        for (int i = 0; i < resenas.size(); i++){
            boolean tenesResenasPeriodo = resenas.get(i).sosDeFecha(fechaDesde, fechaHasta);
            boolean sosDeSommelier = resenas.get(i).sosDeSommelier();
            if(tenesResenasPeriodo && sosDeSommelier)
            {
                return true;
            }
        }
        return false;
    }

    public double calcularRanking(Date fechaDesde, Date fechaHasta){
        ArrayList<Double> puntajes = new ArrayList<>();

        for (int i = 0; i< resenas.size(); i++){
            boolean sosDePeriodo = resenas.get(i).sosDeFecha(fechaDesde, fechaHasta);
            boolean sosDeSommelier = resenas.get(i).sosDeSommelier();
            if (sosDePeriodo && sosDeSommelier){
                puntajes.add(resenas.get(i).getPuntaje());
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