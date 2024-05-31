package com.ppai.ppai_version_2.entities;
public class Varietal {
    //Agregar atributos
    private String nombre;
    private String descripcion;
    private double porcentajeComposicion;

    public Varietal(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Varietal(String descripcion, String nombre, double porcentajeComposicion) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public Varietal(String descripcion, double porcentajeComposicion) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public Varietal(String nombre) {
        this.nombre=nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setPorcentajeComposicion(double porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }
}
