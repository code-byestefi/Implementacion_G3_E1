package com.ppai.ppai_version_2.controller;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ppai.ppai_version_2.entities.Bodega;
import com.ppai.ppai_version_2.entities.EstrategiaRS;
import com.ppai.ppai_version_2.entities.IEstrategia;
import com.ppai.ppai_version_2.entities.Pais;
import com.ppai.ppai_version_2.entities.Provincia;
import com.ppai.ppai_version_2.entities.Region;
import com.ppai.ppai_version_2.entities.Resenia;
import com.ppai.ppai_version_2.entities.Varietal;
import com.ppai.ppai_version_2.entities.Vino;

import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

import com.ppai.ppai_version_2.hibernateutil;
import com.ppai.ppai_version_2.interfaces;

import java.util.concurrent.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GestorReporte {
    IEstrategia estrategia;
    Date fechaDesde;
    Date fechaHasta;
    String[] tipoVisualizaciones = {"PDF", "Pantalla", "Excel"}; // tipos de formatos
    String[] tipoResenia = {"Reseña Normal", "Reseña de Sommelier","Reseña de Amigos"};
    private String tipoResenaSeleccionado;
    String tipoVisualizacionSeleccionado;
    List<List<Object>> vinosEnElArray = new ArrayList<>();
    private boolean confirmacion;
    private Vino[] vinosConResenia;
    List<List<Object>> list10MejoresVinos = new ArrayList<>();
    private List<Vino> vinos;

    public void generarRankingDeVinos(interfaces.PantRankingVinos pantalla, List<Vino> vinos){
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
        IEstrategia estrategia = crearEstrategia();
        this.estrategia = estrategia;
        


        if(tipoResenaSeleccionado != null){
            pantalla.solicitarSelecciónFormatoReporte(this);
        }
    }
    public IEstrategia crearEstrategia() {
            EstrategiaRS estrategia = new EstrategiaRS(tipoResenaSeleccionado);
            return estrategia;
            
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

        if(tipoVisualizacionSeleccionado == "Excel"){
            // Generar el Excel con los datos ordenados
        interfaces.InterfazExcel excel = new interfaces.InterfazExcel(); // instancia
        excel.generarExcel(this.list10MejoresVinos); // se genera el excel. Se usa la interfaz
        }
        if(tipoVisualizacionSeleccionado == "PDF"){
            //Generar PDF con los datos ordenados
        interfaces.InterfazPDF pdf = new interfaces.InterfazPDF();
        pdf.generarPDF(this.list10MejoresVinos);
        }
        
        // se generar el mensaje de reporte exitoso
        pantalla.mostrarGeneracionExitosa();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
            pantalla.dispose();
        }, 1, TimeUnit.SECONDS);

        executorService.shutdown();
    }

    public void buscarVinosConResenia(List<Vino> vinos, interfaces.PantRankingVinos pantalla) {
        vinosEnElArray.clear();
        this.vinosEnElArray = this.estrategia.buscarVinosConResenia(this.fechaDesde, this.fechaHasta, vinos);
    }

    public void ordenarVinosPorRanking() {
        // Ordenamos la lista por el promedio de los puntajes
        Collections.sort(this.vinosEnElArray, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> lista1, List<Object> lista2) {
                Double valor1 = (Double) lista1.get(0);
                Double valor2 = (Double) lista2.get(0);
                return valor2.compareTo(valor1); // Ordena de mayor a menor
            }
        });
    
        // Extraemos los primeros 10 vinos (o menos si no hay suficientes)
        List<List<Object>> mejoresVinos = this.vinosEnElArray.subList(0, Math.min(this.vinosEnElArray.size(), 10));
    
        // Verificación: Imprimimos el tamaño de la sublista
        System.out.println("Número de vinos en la sublista: " + mejoresVinos.size());
    
        // Imprimimos los primeros 10 vinos ordenados
        System.out.println("Primeros 10 vinos ordenados por ranking:");
        for (List<Object> vinoDatos : mejoresVinos) {
            String nombre = (String) vinoDatos.get(1); // Nombre del vino
            Double promedio = (Double) vinoDatos.get(0); // Promedio de calificación
            // Imprime cada vino
            System.out.println("Nombre: " + nombre + ", Calificación Promedio: " + promedio);
        }
    
        // Llamamos al método que maneja los mejores vinos
        buscarDatosMejoresVinos(mejoresVinos);
    }
    
    


    private void buscarDatosMejoresVinos(List<List<Object>> list10MejoresVinos) {
    this.list10MejoresVinos = new ArrayList<>();
    Session session = hibernateutil.getSession();
    try {
        
        // Consultas HQL para obtener las listas
        List<Vino> vinos = session.createQuery("FROM Vino", Vino.class).list();
        List<Resenia> resenias = session.createQuery("FROM Resenia", Resenia.class).list();
        List<Bodega> bodegas = session.createQuery("FROM Bodega", Bodega.class).list();
        List<Pais> paises = session.createQuery("FROM Pais", Pais.class).list();
        List<Provincia> provincias = session.createQuery("FROM Provincia", Provincia.class).list();
        List<Varietal> varietales = session.createQuery("FROM Varietal", Varietal.class).list();
        List<Region> regiones = session.createQuery("FROM Region", Region.class).list();

        // Inicializar colecciones perezosas (como 'resenas') antes de cerrar la sesión
        
        // Inicialización y comprobación de nulos
        for (Pais p : paises){
            Hibernate.initialize(p.getNombre());
            System.out.println(p.getNombre());
        }
        for (Region r : regiones) {
            Hibernate.initialize(r.getProvincia());
            Hibernate.initialize(r.getNombre());
            System.out.println(r.getNombre());
        }
        for (Provincia p : provincias) {
            Hibernate.initialize(p.obtenerPais());
            Hibernate.initialize(p.getNombre());
            System.out.println(p.getNombre());
        }
        
        for (Bodega b: bodegas){
            System.out.println(b.getNombre());
            Hibernate.initialize(b.getRegion());
            Hibernate.initialize(b.getPaisRegion());
        }
        for (Vino vino : vinos) {
            Hibernate.initialize(vino.getResenas());
            Hibernate.initialize(vino.getBodega());

        }
        for (Varietal v : varietales){
            System.out.println(v.getNombre());
            Hibernate.initialize(v.getNombre());
        }

        // Procesar los datos de los mejores vinos
        for (List<Object> datosVino : list10MejoresVinos) {
            double promedio = (double) datosVino.get(0);
            String nombre = (String) datosVino.get(1);
            Vino vino = (Vino) datosVino.get(2);

            double precio = vino.getPrecio();
            List<String> infoBodega = vino.getDatosBodega();
            System.out.println("Info traida de Bodega para el vino " + nombre + ": " + infoBodega);

            // Crear una lista con los datos completos
            List<Object> datosVinoCompletos = new ArrayList<>();
            datosVinoCompletos.add(promedio);
            datosVinoCompletos.add(nombre);
            datosVinoCompletos.add(precio);
            datosVinoCompletos.addAll(infoBodega);

            this.list10MejoresVinos.add(datosVinoCompletos);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Cerrar la sesión
        hibernateutil.closeSession(session);
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