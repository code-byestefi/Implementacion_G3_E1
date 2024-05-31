package com.ppai.ppai_version_2;

import com.ppai.ppai_version_2.controller.GestorReporte;
import com.ppai.ppai_version_2.entities.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainApplication {
    public static void main( String[] args ) {

        System.out.println( "Habilitamos Ventana" );

        //Datos
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY,1);
        Date fecha1 = calendar.getTime();

        calendar.set(2024, Calendar.JANUARY,1);
        Date fecha2 = calendar.getTime();


        //CREACION DE REGIONES
        Region region1 = new Region("Zona De Cuyo", "Provincias de cuyo");
        Region region2 = new Region("Zona Litoral", "Provincias de litoral");

        //CREACION ARRAY REGIONES
        ArrayList<Region> regiones1 = new ArrayList<>();
        ArrayList<Region> regiones2 = new ArrayList<>();
        regiones2.add(region2);
        regiones1.add(region1);


        //CRACIÓN PROVINCIAS
        Provincia mendoza = new Provincia("Mendoza", regiones1);
        Provincia santaFe = new Provincia("Santa Fe", regiones2);

        //CREACION ARRAY PROVINCIAS
        ArrayList<Provincia> provincias = new ArrayList<>();
        provincias.add(mendoza);
        provincias.add(santaFe);

        //CREACION DE PAISES
        Pais pais1 = new Pais("Argentina", provincias);

        //ASOCIAR PROVINCIA A REGION
        region1.setProvincia(mendoza);
        region2.setProvincia(santaFe);

        // ASOCIAR PAIS A PROVINCIA
        mendoza.setPais(pais1);
        santaFe.setPais(pais1);


        //CREACIÓN DE BODEGAS
        Bodega bodega1 = new Bodega( "Bodega Vistandes", "Bodega Vistandes", region1);
        Bodega bodega2 = new Bodega( "Bodega Regional", "Bodega Santa Fe", region2);

        // LISTA RESENAS PARA VINOS
        ArrayList<Resenia> resenasVino1 = new ArrayList<>();
        ArrayList<Resenia> resenasVino2 = new ArrayList<>();
        ArrayList<Resenia> resenasVino3 = new ArrayList<>();
        ArrayList<Resenia> resenasVino4 = new ArrayList<>();
        ArrayList<Resenia> resenasVino5 = new ArrayList<>();
        ArrayList<Resenia> resenasVino6 = new ArrayList<>();
        ArrayList<Resenia> resenasVino7 = new ArrayList<>();
        ArrayList<Resenia> resenasVino8 = new ArrayList<>();
        ArrayList<Resenia> resenasVino9 = new ArrayList<>();
        ArrayList<Resenia> resenasVino10 = new ArrayList<>();
        ArrayList<Resenia> resenasVino11 = new ArrayList<>();

        //CREACION DE VARIETALES
        Varietal varietal1 = new Varietal("Malbec", 80.0);
        Varietal varietal2 = new Varietal("Cabernet", 84.0);

        Vino vino1 = new Vino(2015, "Gran Cosecha 2015", "Notas de frutas maduras y sutiles toques de vainilla y roble.", 2500.0, bodega1, resenasVino1, varietal1);
        Vino vino2 = new Vino(2017, "Malbec de Los Andes", "Aromas complejos de frutos secos con un toque de chocolate y especias.", 3500.0, bodega1, resenasVino2, varietal2);
        Vino vino3 = new Vino(2019, "Reserva del Valle", "Intensos aromas de frutos rojos maduros y un fondo especiado.", 2000.0, bodega2, resenasVino3, varietal1);
        Vino vino4 = new Vino(2020, "Tesoro Nacional", "Notas de ciruela y cassis combinadas con un sutil toque de roble.", 1500.0, bodega1, resenasVino4, varietal1);
        Vino vino5 = new Vino(2023, "Merlot de la Tierra", "Aromas frescos de cereza y hierbas aromáticas.", 1300.0, bodega2, resenasVino5, varietal2);
        Vino vino6 = new Vino(2018, "El Dorado de La Rioja", "Rico en aromas de frutos del bosque con especias dulces.", 6000.0, bodega2, resenasVino6, varietal1);
        Vino vino7 = new Vino(2020, "San Juan Selecto", "Aromas florales y frutales con un toque de cuero y tabaco.", 3000.0, bodega1, resenasVino7, varietal2);
        Vino vino8 = new Vino(2020, "Número Ocho", "Frescos aromas de frambuesa y vainilla con un final suave.", 1500.0, bodega1, resenasVino8, varietal1);
        Vino vino9 = new Vino(2020, "Tinto del Gaucho", "Notas de mora y ciruela con un fondo especiado.", 1700.0, bodega2, resenasVino9, varietal2);
        Vino vino10 = new Vino(2018, "Selección Suprema", "Aromas profundos de frutas rojas y un toque de menta fresca.", 4000.0, bodega2, resenasVino10, varietal1);
        Vino vino11 = new Vino(2021, "Cóndor Andino", "Intensas notas de frutos negros y especias con un final prolongado.", 5500.0, bodega1, resenasVino11, varietal2);

        //RESEÑAS
        Resenia resena1 = new Resenia("Una sinfonía de sabores complejos con un final suave.", true, fecha1, 8.2, vino1);
        Resenia resena2 = new Resenia("Un toque de frutos rojos y un cuerpo aterciopelado.", true, fecha1, 7.5, vino1);
        Resenia resena3 = new Resenia("Aromas florales pero carece de profundidad.", false, fecha1, 5.8, vino1); // NO PREMIUM
        Resenia resena4 = new Resenia("Equilibrio perfecto entre dulzura y acidez.", true, fecha1, 7.9, vino2);
        Resenia resena5 = new Resenia("Persistente en boca, pero algo corto en aroma.", false, fecha1, 6.4, vino2); // NO PREMIUM
        Resenia resena6 = new Resenia("Notas de vainilla y caramelo con un final largo.", true, fecha1, 9.3, vino3);
        Resenia resena7 = new Resenia("Cuerpo robusto y taninos bien integrados.", true, fecha1, 8.7, vino3);
        Resenia resena8 = new Resenia("Fresco y afrutado, perfecto para una tarde de verano.", true, fecha1, 8.9, vino4);
        Resenia resena9 = new Resenia("Rico en especias y con una estructura firme.", true, fecha1, 9.0, vino5);
        Resenia resena10 = new Resenia("Delicadamente floral con una textura sedosa.", true, fecha1, 8.8, vino6);
        Resenia resena11 = new Resenia("Aromas intensos de cereza y un toque de chocolate.", true, fecha1, 7.4, vino7);
        Resenia resena12 = new Resenia("Equilibrio entre fruta y madera, muy bien logrado.", true, fecha1, 7.8, vino8);
        Resenia resena13 = new Resenia("Elegante y sofisticado, con un toque de mineralidad.", true, fecha1, 9.1, vino9);
        Resenia resena14 = new Resenia("Ligero y refrescante, aunque un poco simple.", true, fecha1, 6.0, vino10);
        Resenia resena15 = new Resenia("Taninos suaves y un final persistente.", true, fecha1, 7.2, vino11);
        Resenia resena16 = new Resenia("Aromas a frutas maduras, pero algo desequilibrado.", true, fecha2, 6.5, vino11);

        //AÑADIR RESEÑAS A VINOS
        resenasVino1.add(resena1);
        resenasVino1.add(resena2);
        resenasVino1.add(resena3);
        resenasVino2.add(resena4);
        resenasVino2.add(resena5);
        resenasVino3.add(resena6);
        resenasVino3.add(resena7);
        resenasVino4.add(resena8);
        resenasVino5.add(resena9);
        resenasVino6.add(resena10);
        resenasVino7.add(resena11);
        resenasVino8.add(resena12);
        resenasVino9.add(resena13);
        resenasVino10.add(resena14);
        resenasVino11.add(resena15);
        resenasVino11.add(resena16);

        //CREAR ARRAY VINOS
        ArrayList<Vino> vinos = new ArrayList<>();
        vinos.add(vino1);
        vinos.add(vino2);
        vinos.add(vino3);
        vinos.add(vino4);
        vinos.add(vino5);
        vinos.add(vino6);
        vinos.add(vino7);
        vinos.add(vino8);
        vinos.add(vino9);
        vinos.add(vino10);
        vinos.add(vino11);


        interfaces.InterfazExcel excel = new interfaces.InterfazExcel();
        interfaces.PantRankingVinos pantalla = new interfaces.PantRankingVinos();
        pantalla.setVisible(true);

        GestorReporte gestor = new GestorReporte();
        pantalla.opcGenerarRankingVinos(gestor, vinos, excel);





    }
}