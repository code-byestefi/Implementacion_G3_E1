package com.ppai.ppai_version_2.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EstrategiaRS implements IEstrategia{
    private String nombre;
    List<List<Object>> vinosEnElArray = new ArrayList<>();
    public EstrategiaRS(String nombre){
        this.nombre = nombre;
    }

    @Override
    public  List<List<Object>> buscarVinosConResenia(java.util.Date fechaDesde, java.util.Date fechaHasta, List<Vino> vinos) {
        for(Vino vino : vinos){
            if(vino.tenesResenas()){
                List<Resenia> resenias = vino.getResenas();
                ArrayList<Double> puntajes = new ArrayList<>();
                for(Resenia resenia: resenias){
                    System.out.println(resenia.sosDeFecha(fechaDesde, fechaHasta));
                    System.out.println(resenia.sosDeSommelier());
                    boolean tenesResenasPeriodo = resenia.sosDeFecha(fechaDesde, fechaHasta);
                    boolean sosDeSommelier = resenia.sosDeSommelier();
                    if (tenesResenasPeriodo && sosDeSommelier) {
                        puntajes.add(resenia.getPuntaje());
                       
                    }
                }
                String nombre = vino.getNombre(); // solicitamos el nombre
                System.out.println(vino.getNombre());
                Double promedio = vino.calcularCalificacionPromedio(puntajes);
                System.out.println(promedio);
                ArrayList<Object> datosVinoSeleccionado = new ArrayList<>();
                datosVinoSeleccionado.add(promedio);
                datosVinoSeleccionado.add(nombre);
                datosVinoSeleccionado.add(vino);
                this.vinosEnElArray.add(datosVinoSeleccionado);
            }
        }
        return this.vinosEnElArray;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}

