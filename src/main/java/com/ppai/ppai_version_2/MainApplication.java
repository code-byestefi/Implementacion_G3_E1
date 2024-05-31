package com.ppai.ppai_version_2;

import com.ppai.ppai_version_2.controller.GestorReporte;
import com.ppai.ppai_version_2.entities.*;

import java.util.ArrayList;
import java.util.Date;

public class MainApplication {
    public static void main( String[] args ) {

        // Datos de la simulación
        Pais pais1 = new Pais("Argentina");

        Provincia provincia1 = new Provincia("Mendoza", pais1);

        // Creo regiones
        Region region1 = new Region("Cuyo", "Zona de Este", provincia1);

        // Crear bodegas
        Bodega bodega1 = new Bodega("Bodega Los Toneles", region1);
        Bodega bodega2 = new Bodega("Bodega Vistandes", region1);
        Bodega bodega3 = new Bodega("Bodega Salentein", region1);

        // Crear varietales
        Varietal varietal1 = new Varietal("Cabernet Sauvignon");
        Varietal varietal2 = new Varietal("Malbec");
        Varietal varietal3 = new Varietal("Merlot");
        Varietal varietal4 = new Varietal("Pinot Noir");


        // Crear reseñas
        ArrayList<Resenia> resenas1 = new ArrayList<>();
        resenas1.add(new Resenia("Excelente sabor y cuerpo.", 5, new Date(), false));
        resenas1.add(new Resenia("Aromas frutales intensos.", 4, new Date(), true));
        resenas1.add(new Resenia("Perfecto equilibrio de acidez.", 4, new Date(), true));

        ArrayList<Resenia> resenas2 = new ArrayList<>();
        resenas2.add(new Resenia("Notas de frutas rojas y especias.", 5, new Date(), false));
        resenas2.add(new Resenia("Notas de frutas cafe1", 8, new Date(), true));


        // Crear vinos (pasando las listas de reseñas)
        Vino vino1 = new Vino("Gran Reserva", "Un vino excepcional", varietal1, bodega1, 150.0, resenas1);
        Vino vino2 = new Vino("Malbec Premium", "Un vino con carácter", varietal2, bodega2, 120.0, resenas1);
        Vino vino3 = new Vino("Merlot Especial", "Suavidad y elegancia", varietal3, bodega1, 130.0, resenas1);
        Vino vino4 = new Vino("Pinot Noir Elegante", "Complejo y sofisticado", varietal4, bodega3, 160.0, resenas2);
        Vino vino5 = new Vino("Reserva Exclusiva", "Intenso y persistente", varietal2, bodega2, 195.0, resenas1);
        Vino vino6 = new Vino("Cosecha Tardía", "Dulce y aromático", varietal3, bodega3, 110.0, resenas2);
        Vino vino7 = new Vino("Edición Limitada", "Elegante y complejo", varietal1, bodega1, 220.0, resenas1);
        Vino vino8 = new Vino("Selección Especial", "Equilibrado y afrutado", varietal4, bodega2, 145.0, resenas2);
        Vino vino9 = new Vino("Roble Añejo", "Notas tostadas y vainilla", varietal2, bodega3, 170.0, resenas1);
        Vino vino10 = new Vino("Clásico Malbec", "Expresión auténtica del terruño", varietal2, bodega1, 95.0, resenas2);
        Vino vino11 = new Vino("Cabernet Franc Joven", "Fresco y vibrante", varietal1, bodega2, 80.0, resenas1);
        Vino vino12 = new Vino("Merlot Reserva", "Complejo y estructurado", varietal3, bodega3, 135.0, resenas2);
        Vino vino13 = new Vino("Pinot Grigio", "Ligero y refrescante", varietal4, bodega1, 75.0, resenas1);
        Vino vino14 = new Vino("Syrah Reserva", "Especiado y potente", varietal2, bodega2, 165.0, resenas2);
        Vino vino15 = new Vino("Chardonnay", "Notas cítricas y tropicales", varietal1, bodega3, 105.0, resenas1);


        // Agregar los vinos a una lista
        ArrayList<Vino> vino = new ArrayList<>();
        vino.add(vino1);
        vino.add(vino2);
        vino.add(vino3);
        vino.add(vino4);
        vino.add(vino5);
        vino.add(vino6);
        vino.add(vino7);
        vino.add(vino8);
        vino.add(vino9);
        vino.add(vino10);
        vino.add(vino11);
        vino.add(vino12);
        vino.add(vino13);
        vino.add(vino14);
        vino.add(vino15);


        interfaces.PantRankingVinos pantalla = new interfaces.PantRankingVinos();
        pantalla.setVisible(true);

        interfaces.InterfazExcel excel = new interfaces.InterfazExcel();
        GestorReporte gestor = new GestorReporte();
        pantalla.opcGenerarRankingVinos(gestor, vino, excel);





    }
}