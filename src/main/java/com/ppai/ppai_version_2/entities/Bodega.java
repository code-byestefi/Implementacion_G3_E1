package com.ppai.ppai_version_2.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bodega") // Nombre de la tabla en la base de datos
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID
    @Column(name = "id") // Nombre de la columna de ID
    private Long id;

    @Column(name = "nombre") // Nombre de la columna en la base de datos
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY) // Relación con la clase Region (muchos bodegas pueden tener una región)
    @JoinColumn(name = "region") // Columna que almacena la relación con la tabla Region
    private Region region;

    @Column(name = "descripcion")
    private String descripcion;

    public Bodega(String coordenadasUbicacion, String descripcion, String historia, String nombre, String periodoActualizacion, Region region) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.region = region;
    }

    public Bodega(String descripcion, String nombre, Region region) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.region = region;
    }
    public Bodega(){}
    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Region getRegion() {
        return region;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<String> getPaisRegion() {
        ArrayList<String> regionYPais = new ArrayList<>();
        String region = this.region.getNombre();
        String pais = this.region.getProvincia().getPais().getNombre();

        regionYPais.add(region);
        regionYPais.add(pais);

        return regionYPais;
    }
}
