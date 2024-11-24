package com.ppai.ppai_version_2.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resenia") // Nombre de la tabla en la base de datos
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID
    @Column(name = "id") // Columna de ID
    private Long id;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "es_premium")
    private Boolean esPremium;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_resena")
    private Date fechaResena;

    @Column(name = "puntaje")
    private double puntaje;

    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con la clase Vino
    @JoinColumn(name = "vino_id") // Define la columna de la clave foránea
    private Vino vino;

    public Resenia(String comentario, Boolean esPremium, Date fechaResena, double puntaje, Vino vino) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
        this.vino = vino;
    }
    public Resenia(){
        
    }
    public double getPuntaje() {
        return this.puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getEsPremium() {
        return esPremium;
    }

    public void setEsPremium(Boolean esPremium) {
        this.esPremium = esPremium;
    }

    public Date getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(Date fechaResena) {
        this.fechaResena = fechaResena;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }

    public Boolean sosDeSommelier() {
        return this.esPremium; 
    }

    public boolean sosDeFecha(Date fechaDesde, Date fechaHasta) {
        return fechaResena.after(fechaDesde) && fechaResena.before(fechaHasta);
    }
}
