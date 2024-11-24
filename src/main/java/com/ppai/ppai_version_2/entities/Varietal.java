package com.ppai.ppai_version_2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "varietal") // Nombre de la tabla en la base de datos
public class Varietal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID
    @Column(name = "id") // Columna de ID
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "porcentaje_composicion")
    private double porcentajeComposicion;

    public Varietal(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    public Varietal(){}
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
        this.nombre = nombre;
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
