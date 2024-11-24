package com.ppai.ppai_version_2.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vino") // Nombre de la tabla en la base de datos
public class Vino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "anio")
    private int anio;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nota_cata_bodega")
    private String notaCataBodega;

    @Column(name = "precio")
    private double precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bodega",nullable = true) // Nombre de la columna de clave foránea
    private Bodega bodega;

    @OneToMany(mappedBy = "vino", cascade = CascadeType.ALL)
    private List<Resenia> resenas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "varietal") // Nombre de la columna de clave foránea
    private Varietal varietal;
    public Vino(){}
    // Constructor
    public Vino(int anio, String nombre, String notaCataBodega, double precio, Bodega bodega, List<Resenia> resenas, Varietal varietal) {
        this.anio = anio;
        this.nombre = nombre;
        this.notaCataBodega = notaCataBodega;
        this.precio = precio;
        this.bodega = bodega;
        this.resenas = resenas;
        this.varietal = varietal;
    }

    // Getters y Setters
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

    public List<Resenia> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resenia> resenas) {
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

    public boolean tenesResenas(){
        if(this.resenas.size()== 0){
            return false;
        } else { return true;}
    }

    public double calcularCalificacionPromedio(ArrayList<Double> lista) {
        if (lista == null || lista.isEmpty()) {
            return 0; // Retornar 0 si la lista es nula o está vacía
        }
        double suma = 0;
        for (double numero : lista) {
            suma += numero;
        }
        return suma / lista.size();
    }

    public List<String> getDatosBodega() {
        List<String> lista = new ArrayList<>();
        String nombreBodega = bodega.getNombre();
        List<String> regionYPais = bodega.getPaisRegion();

        lista.add(nombreBodega);
        lista.addAll(regionYPais);

        return lista;
    }
}
