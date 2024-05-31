package com.ppai.ppai_version_2.controller;

import com.ppai.ppai_version_2.entities.Region;
import com.ppai.ppai_version_2.entities.Resenia;
import com.ppai.ppai_version_2.entities.Vino;
import com.ppai.ppai_version_2.interfaces;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class GestorReporte {

    Date fechaDesde;
    Date fechaHasta;
    String[] tipoVisualizaciones = {"PDF", "Consola", "Excel"};
    private String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;
    List<List<Object>> vinosEnElArray = new ArrayList<>();
    private boolean confirmacion;
    private Vino[] vinosConResenia;
    List<List<Object>> list10MejoresVinos = new ArrayList<>();

    public void opcGenerarRankingVinos(interfaces.PantRankingVinos pantalla, ArrayList<Vino> vinos, interfaces.InterfazExcel excel){
        pantalla.solicitarSeleccionFechas(this);
        if(fechaDesde != null && fechaHasta != null) {
            buscarVinosConResenia(vinos, pantalla);
        }
        ordenarVinosPorRanking();
        excel.generarExcel(this.list10MejoresVinos);
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
        pantalla.mostrarGeneracionExitosa();

    }

    public void buscarVinosConResenia(ArrayList<Vino> vinos, interfaces.PantRankingVinos pantalla) {
        ArrayList<Object> vinosEnBusqueda = new ArrayList<>();
        ArrayList<String> infoBodegas = new ArrayList<>();
        for (int i = 0; i < vinos.size(); i++) {
            Boolean tieneResenaValidas = vinos.get(i).buscarVinosConResenia(this.fechaDesde, this.fechaHasta);

            if (tieneResenaValidas) {
                String nombre = vinos.get(i).getNombre();
                Double precio = vinos.get(i).getPrecio();
                ArrayList<String> infoBodega = vinos.get(i).getDatosBodega();

                System.out.println("infoBodega para el vino " + nombre + ": " + infoBodega);

                double promedio = vinos.get(i).calcularRanking(this.fechaDesde, this.fechaHasta);

                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(precio);
                datosVinoSeleccionado.addAll(infoBodega);
                this.vinosEnElArray.add(datosVinoSeleccionado);
            }
        }
    }

    public void ordenarVinosPorRanking(){
        Collections.sort(this.vinosEnElArray, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> lista1, List<Object> lista2) {
                // Convertir el primer elemento de cada sublista a Double para comparar
                Double valor1 = (Double) lista1.get(0);
                Double valor2 = (Double) lista2.get(0);
                // Comparar los valores
                return valor2.compareTo(valor1); // Ordena de mayor a menor
            }

        });
        buscarDatosMejoresVinos( this.vinosEnElArray.subList(0, Math.min(this.vinosEnElArray.size(), 10)));
    }

    private void buscarDatosMejoresVinos(List<List<Object>> list10MejoresVinos) {
        this.list10MejoresVinos = list10MejoresVinos;

    };

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


    public List<List<Object>> getList10MejoresVinos() {
        return list10MejoresVinos;
    }


}