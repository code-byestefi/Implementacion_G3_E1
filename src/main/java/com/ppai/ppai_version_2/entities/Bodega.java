package com.ppai.ppai_version_2.entities;

public class Bodega {
    //Agregar atributos
    private String nombre;
    private Region region;
    private String periodoActualizacion;
    private String coordenadasUbicacion;
    private String descripcion;
    private String historia;

    public Bodega(String coordenadasUbicacion, String descripcion, String historia, String nombre, String periodoActualizacion, Region region) {
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
        this.region = region;
    }

    public Bodega(String descripcion, String nombre, Region region) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.region = region;
    }

    public String getCoordenadasUbicacion() {
        return coordenadasUbicacion;
    }

    public void setCoordenadasUbicacion(String coordenadasUbicacion) {
        this.coordenadasUbicacion = coordenadasUbicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodoActualizacion() {
        return periodoActualizacion;
    }

    public void setPeriodoActualizacion(String periodoActualizacion) {
        this.periodoActualizacion = periodoActualizacion;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
