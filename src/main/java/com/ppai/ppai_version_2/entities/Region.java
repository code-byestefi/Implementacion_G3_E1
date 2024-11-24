package com.ppai.ppai_version_2.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY) // Relación con la clase Region (muchos bodegas pueden tener una región)
    @JoinColumn(name = "provincia") // Columna que almacena la relación con la tabla Region
    private Provincia provincia;

    public Region(){}
    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return this.provincia;
    }
    
    
    public String obtenerPais(){
        return this.getNombre();
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
