package com.ppai.ppai_version_2.controller;

import com.ppai.ppai_version_2.entities.Vino;
import com.ppai.ppai_version_2.interfaces;

import java.util.ArrayList;
import java.util.Date;

public class GestorReporte {

    Date fechaDesde;
    Date fechaHasta;
    String[] tipoVisualizaciones = {"PDF", "Consola", "Excel"};
    private String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;
    private boolean confirmacion;

    public void opcGenerarRankingVinos(interfaces.PantRankingVinos pantalla, ArrayList<Vino> vinos, interfaces.InterfazExcel excel){
        pantalla.solicitarSeleccionFechas(this);

    }

    public void tomarFechas(Date fechaDesde, Date fechaHasta, interfaces.PantRankingVinos pantalla) {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);

        //Llamada a la pantalla para que muestre los tipos de reseñas
        if (fechaDesde != null && fechaHasta != null){
            pantalla.solicitarSeleccionTipoReseña(this);

        }
    }

    public void tomarSeleccionTipoResenia(String tipoResena, interfaces.PantRankingVinos pantalla) {

        setTipoResenaSeleccionado(tipoResena);

        if(tipoResenaSeleccionado != null){
            pantalla.solicitarSelecciónFormatoReporte(this);
        }
    }


    public void tomarSelecciónFormatoReporte(String tipoVisualizacion, interfaces.PantRankingVinos pantalla) {
        setTipoVisualizacionSeleccionado(tipoVisualizacion);

        if (tipoVisualizacionSeleccionado != null){
            pantalla.solicitarConfirmacion(this);

        }
    }

    public void tomarConfirmacion(interfaces.PantRankingVinos pantalla) {
        setConfirmacion(true);
    }
    
    public void finCU(interfaces.PantRankingVinos pantalla) {
        pantalla.dispose();
    }


    public Date getFechaDesde() {
        return fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


    public void setTipoResenaSeleccionado(String tipoResenaSeleccionado) {
        this.tipoResenaSeleccionado = tipoResenaSeleccionado;
    }

    public String[] getTipoVisualizaciones() {
        return tipoVisualizaciones;
    }

    public void setTipoVisualizacionSeleccionado(String tipoVisualizacionSeleccionado) {
        this.tipoVisualizacionSeleccionado = tipoVisualizacionSeleccionado;
    }


    private void setConfirmacion(boolean confirmacion) {
        this.confirmacion = confirmacion;
    }


}