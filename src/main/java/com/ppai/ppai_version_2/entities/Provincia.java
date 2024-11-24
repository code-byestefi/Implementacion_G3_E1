package com.ppai.ppai_version_2.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provincia") // Nombre de la tabla en la base de datos
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID
    @Column(name = "id") // Columna de ID
    private Long id;

    @Column(name = "nombre", nullable = false) // Nombre de la provincia
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY) // Relación con la clase Pais (una provincia pertenece a un solo país)
    @JoinColumn(name = "pais") // Columna que almacena la relación con la tabla Pais
    private Pais pais;

    @OneToMany
    private List<Region> regiones;

    public Provincia(String nombre, Pais pais, List<Region> regiones) {
        this.nombre = nombre;
        this.pais = pais;
        this.regiones = regiones;
    }
    public Provincia(){}
    public Provincia(String nombre, List<Region> regiones) {
        this.nombre = nombre;
        this.regiones = regiones;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Region>  getRegion() {
        return this.regiones;
    }

    public void setRegion(List<Region> regiones) {
        this.regiones = regiones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String obtenerPais() {
        return this.pais.getNombre();
    }
}
