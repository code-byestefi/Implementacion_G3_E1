package com.ppai.ppai_version_2.controller;

import com.ppai.ppai_version_2.entities.Region;
import com.ppai.ppai_version_2.entities.Resenia;
import com.ppai.ppai_version_2.entities.Vino;
import com.ppai.ppai_version_2.interfaces;

import java.util.concurrent.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GestorReporte {

    Date fechaDesde;
    Date fechaHasta;
    String[] tipoVisualizaciones = {"PDF", "Consola", "Excel"}; // tipos de formatos
    String[] tipoResenia = {"Premium", "No Premium"};
    private String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;
    List<List<Object>> vinosEnElArray = new ArrayList<>();
    private boolean confirmacion;
    private Vino[] vinosConResenia;
    List<List<Object>> list10MejoresVinos = new ArrayList<>();
    private ArrayList<Vino> vinos;

    public void generarRankingDeVinos(interfaces.PantRankingVinos pantalla, ArrayList<Vino> vinos){
        this.vinos = vinos; // guardamos la instancia de vinos
        pantalla.solicitarSeleccionFechas(this); // solicitamos las fechas
    }

    public void tomarFechas(Date fechaDesde, Date fechaHasta, interfaces.PantRankingVinos pantalla) {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);

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

        // Ejecutar búsqueda de vinos con reseñas y ordenarlos
        buscarVinosConResenia(this.vinos, pantalla);
        ordenarVinosPorRanking();

        // Generar el Excel con los datos ordenados
        interfaces.InterfazExcel excel = new interfaces.InterfazExcel(); // instancia
        pantalla.mostrarGeneracionExitosa();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
            pantalla.dispose();
        }, 1, TimeUnit.SECONDS);

        excel.generarExcel(this.list10MejoresVinos); // se genera el excel. Se usa la interfaz
        executorService.shutdown();
    }

    public void buscarVinosConResenia(List<Vino> vinos, interfaces.PantRankingVinos pantalla) {
        vinosEnElArray.clear();
        for (Vino vino : vinos) {
            Boolean tieneResenaValidas = vino.buscarVinosConResenia(this.fechaDesde, this.fechaHasta);

            if (tieneResenaValidas) {
                String nombre = vino.getNombre(); // solicitamos el nombre
                double promedio = vino.calcularRanking(this.fechaDesde, this.fechaHasta); // calculamos Ranking

                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(vino);

                this.vinosEnElArray.add(datosVinoSeleccionado);
            }
        }
    }

    public void ordenarVinosPorRanking() {
        Collections.sort(this.vinosEnElArray, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> lista1, List<Object> lista2) {
                Double valor1 = (Double) lista1.get(0);
                Double valor2 = (Double) lista2.get(0);
                return valor2.compareTo(valor1); // Ordena de mayor a menor
            }
        });
        buscarDatosMejoresVinos(this.vinosEnElArray.subList(0, Math.min(this.vinosEnElArray.size(), 10)));
    }


    private void buscarDatosMejoresVinos(List<List<Object>> list10MejoresVinos) {
        this.list10MejoresVinos = new ArrayList<>();

        for (List<Object> datosVino : list10MejoresVinos) {
            double promedio = (double) datosVino.get(0);
            String nombre = (String) datosVino.get(1);
            Vino vino = (Vino) datosVino.get(2);

            double precio = vino.getPrecio();
            ArrayList<String> infoBodega = vino.getDatosBodega();
            System.out.println("Info traida de Bodega para el vino " + nombre + ": " + infoBodega);

            ArrayList<Object> datosVinoCompletos = new ArrayList<>();
            datosVinoCompletos.add(promedio);
            datosVinoCompletos.add(nombre);
            datosVinoCompletos.add(precio);
            datosVinoCompletos.addAll(infoBodega);

            this.list10MejoresVinos.add(datosVinoCompletos);
        }
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

    public String[] getTipoResenia() {
        return tipoResenia;
    }

    public void setTipoResenia(String[] tipoResenia) {
        this.tipoResenia = tipoResenia;
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