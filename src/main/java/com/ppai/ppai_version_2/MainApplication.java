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
        Region region3 = new Region("Zona Noroeste", "Provincias del Noroeste");
        Region region4 = new Region("Zona Pampeana", "Provincias de la región Pampeana");
        Region region5 = new Region("Patagonia", "Provincias de la Patagonia");

        //CREACION ARRAY REGIONES
        ArrayList<Region> regiones1 = new ArrayList<>();
        ArrayList<Region> regiones2 = new ArrayList<>();
        ArrayList<Region> regiones3 = new ArrayList<>();
        ArrayList<Region> regiones4 = new ArrayList<>();
        ArrayList<Region> regiones5 = new ArrayList<>();
        regiones1.add(region1);
        regiones2.add(region2);
        regiones3.add(region3);
        regiones4.add(region4);
        regiones5.add(region5);

        //CREACION PROVINCIAS
        Provincia mendoza = new Provincia("Mendoza", regiones1);
        Provincia santaFe = new Provincia("Santa Fe", regiones2);
        Provincia salta = new Provincia("Salta", regiones3);
        Provincia buenosAires = new Provincia("Buenos Aires", regiones4);
        Provincia rioNegro = new Provincia("Río Negro", regiones5);

        //CREACION ARRAY PROVINCIAS
        ArrayList<Provincia> provincias = new ArrayList<>();
        provincias.add(mendoza);
        provincias.add(santaFe);
        provincias.add(salta);
        provincias.add(buenosAires);
        provincias.add(rioNegro);

        //CREACION DE PAISES
        Pais pais1 = new Pais("Argentina", provincias);

        //ASOCIAR PROVINCIA A REGION
        region1.setProvincia(mendoza);
        region2.setProvincia(santaFe);
        region3.setProvincia(salta);
        region4.setProvincia(buenosAires);
        region5.setProvincia(rioNegro);

        // ASOCIAR PAIS A PROVINCIA
        mendoza.setPais(pais1);
        santaFe.setPais(pais1);
        salta.setPais(pais1);
        buenosAires.setPais(pais1);
        rioNegro.setPais(pais1);

        //CREACIÓN DE BODEGAS
        Bodega bodega1 = new Bodega("Bodega Vistandes", "Bodega Vistandes", region1);
        Bodega bodega2 = new Bodega("Bodega Regional", "Bodega Santa Fe", region2);
        Bodega bodega3 = new Bodega("Bodega Cafayate", "Bodega Cafayate", region3);
        Bodega bodega4 = new Bodega("Bodega Trapiche", "Bodega Trapiche", region4);
        Bodega bodega5 = new Bodega("Bodega del Fin del Mundo", "Bodega del Fin del Mundo", region5);

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
        ArrayList<Resenia> resenasVino12 = new ArrayList<>();
        ArrayList<Resenia> resenasVino13 = new ArrayList<>();
        ArrayList<Resenia> resenasVino14 = new ArrayList<>();
        ArrayList<Resenia> resenasVino15 = new ArrayList<>();
        ArrayList<Resenia> resenasVino16 = new ArrayList<>();
        ArrayList<Resenia> resenasVino17 = new ArrayList<>();
        ArrayList<Resenia> resenasVino18 = new ArrayList<>();
        ArrayList<Resenia> resenasVino19 = new ArrayList<>();
        ArrayList<Resenia> resenasVino20 = new ArrayList<>();
        ArrayList<Resenia> resenasVino21 = new ArrayList<>();
        ArrayList<Resenia> resenasVino22 = new ArrayList<>();
        ArrayList<Resenia> resenasVino23 = new ArrayList<>();
        ArrayList<Resenia> resenasVino24 = new ArrayList<>();
        ArrayList<Resenia> resenasVino25 = new ArrayList<>();

        //CREACION DE VARIETALES
        Varietal varietal1 = new Varietal("Malbec", 80.0);
        Varietal varietal2 = new Varietal("Cabernet", 84.0);
        Varietal varietal3 = new Varietal("Torrontés", 78.0);
        Varietal varietal4 = new Varietal("Syrah", 85.0);

        //CREACION DE VINOS
        Vino vino1 = new Vino(2015, "Gran Cosecha 2015", "Notas de frutas maduras y sutiles toques de vainilla y roble.", 2500.0, bodega1, resenasVino1, varietal1);
        Vino vino2 = new Vino(2017, "Malbec de Los Andes", "Aromas complejos de frutos secos con un toque de chocolate y especias.", 3500.0, bodega1, resenasVino2, varietal2);
        Vino vino3 = new Vino(2019, "Reserva del Valle", "Intensos aromas de frutos rojos maduros y un fondo especiado.", 2000.0, bodega2, resenasVino3, varietal1);
        Vino vino4 = new Vino(2020, "Tesoro Nacional", "Notas de ciruela y cassis combinadas con un sutil toque de roble.", 1500.0, bodega1, resenasVino4, varietal1);
        Vino vino5 = new Vino(2023, "Merlot de la Tierra", "Aromas frescos de cereza y hierbas aromáticas.", 1300.0, bodega2, resenasVino5, varietal2);
        Vino vino6 = new Vino(2018, "El Dorado de La Rioja", "Rico en aromas de frutos del bosque con especias dulces.", 6000.0, bodega2, resenasVino6, varietal1);
        Vino vino7 = new Vino(2016, "San Juan Selecto", "Aromas florales y frutales con un toque de cuero y tabaco.", 3000.0, bodega1, resenasVino7, varietal2);
        Vino vino8 = new Vino(2018, "Número Ocho", "Frescos aromas de frambuesa y vainilla con un final suave.", 1500.0, bodega1, resenasVino8, varietal1);
        Vino vino9 = new Vino(2020, "Tinto del Gaucho", "Notas de mora y ciruela con un fondo especiado.", 1700.0, bodega2, resenasVino9, varietal2);
        Vino vino10 = new Vino(2018, "Selección Suprema", "Aromas profundos de frutas rojas y un toque de menta fresca.", 4000.0, bodega2, resenasVino10, varietal1);
        Vino vino11 = new Vino(2021, "Cóndor Andino", "Intensas notas de frutos negros y especias con un final prolongado.", 5500.0, bodega1, resenasVino11, varietal2);
        Vino vino12 = new Vino(2018, "Cafayate Torrontés", "Aromas frescos de durazno y cítricos.", 1200.0, bodega3, resenasVino12, varietal3);
        Vino vino13 = new Vino(2019, "Trapiche Syrah", "Notas especiadas con un final suave.", 2200.0, bodega4, resenasVino13, varietal4);
        Vino vino14 = new Vino(2020, "Patagonia Malbec", "Frutos negros y un toque de regaliz.", 2800.0, bodega5, resenasVino14, varietal1);
        Vino vino15 = new Vino(2017, "Cafayate Gran Reserva", "Complejo y elegante con notas de roble.", 3500.0, bodega3, resenasVino15, varietal2);
        Vino vino16 = new Vino(2022, "Trapiche Reserva", "Frutos rojos intensos y un final largo.", 2700.0, bodega4, resenasVino16, varietal2);
        Vino vino17 = new Vino(2021, "Río Negro Pinot Noir", "Aromas a cereza y un toque terroso.", 3200.0, bodega5, resenasVino17, varietal2);
        Vino vino18 = new Vino(2020, "Cafayate Tannat", "Intensos taninos y un final persistente.", 2900.0, bodega3, resenasVino18, varietal4);
        Vino vino19 = new Vino(2019, "Trapiche Chardonnay", "Aromas frescos de manzana y pera.", 2300.0, bodega4, resenasVino19, varietal3);
        Vino vino20 = new Vino(2022, "Río Negro Merlot", "Notas de ciruela y especias.", 2100.0, bodega5, resenasVino20, varietal2);
        Vino vino21 = new Vino(2018, "Cafayate Syrah", "Notas de mora y un toque de pimienta.", 2000.0, bodega3, resenasVino21, varietal4);
        Vino vino22 = new Vino(2019, "Trapiche Malbec", "Frutos rojos y especias dulces.", 2400.0, bodega4, resenasVino22, varietal1);
        Vino vino23 = new Vino(2020, "Río Negro Torrontés", "Aromas florales y cítricos.", 1800.0, bodega5, resenasVino23, varietal3);
        Vino vino24 = new Vino(2021, "Cafayate Reserva Malbec", "Frutos negros y taninos bien balanceados.", 2600.0, bodega3, resenasVino24, varietal1);
        Vino vino25 = new Vino(2022, "Trapiche Cabernet", "Notas de pimiento y tabaco.", 2500.0, bodega4, resenasVino25, varietal2);

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
        Resenia resena17 = new Resenia("Aromas frescos de durazno y cítricos.", true, fecha1, 8.3, vino12);
        Resenia resena18 = new Resenia("Ligero y refrescante, ideal para el verano.", true, fecha1, 8.0, vino12);
        Resenia resena19 = new Resenia("Notas especiadas y un final largo.", true, fecha1, 8.5, vino13);
        Resenia resena20 = new Resenia("Equilibrado y elegante.", true, fecha1, 7.9, vino13);
        Resenia resena21 = new Resenia("Frutos negros y un toque de regaliz.", true, fecha1, 8.7, vino14);
        Resenia resena22 = new Resenia("Complejo y con buen cuerpo.", true, fecha1, 8.5, vino14);
        Resenia resena23 = new Resenia("Elegante con notas de roble.", true, fecha1, 8.9, vino15);
        Resenia resena24 = new Resenia("Intenso y bien estructurado.", true, fecha1, 8.6, vino15);
        Resenia resena25 = new Resenia("Aromas intensos de frutos rojos.", true, fecha1, 8.4, vino16);
        Resenia resena26 = new Resenia("Buen equilibrio entre fruta y acidez.", true, fecha1, 8.1, vino16);
        Resenia resena27 = new Resenia("Notas a cereza y un toque terroso.", true, fecha1, 8.5, vino17);
        Resenia resena28 = new Resenia("Aromas frescos y un final persistente.", true, fecha1, 8.3, vino17);
        Resenia resena29 = new Resenia("Taninos intensos y final largo.", true, fecha1, 8.8, vino18);
        Resenia resena30 = new Resenia("Complejo y con buen cuerpo.", true, fecha1, 8.4, vino18);
        Resenia resena31 = new Resenia("Aromas frescos de manzana y pera.", true, fecha1, 8.2, vino19);
        Resenia resena32 = new Resenia("Ligero y refrescante.", true, fecha1, 7.9, vino19);
        Resenia resena33 = new Resenia("Notas de ciruela y especias.", true, fecha1, 8.3, vino20);
        Resenia resena34 = new Resenia("Bien equilibrado y agradable.", true, fecha1, 8.1, vino20);
        Resenia resena35 = new Resenia("Notas de mora y un toque de pimienta.", true, fecha1, 8.4, vino21);
        Resenia resena36 = new Resenia("Intenso y bien balanceado.", true, fecha1, 9.0, vino21);
        Resenia resena37 = new Resenia("Aromas intensos y un final largo.", true, fecha1, 8.8, vino22);
        Resenia resena38 = new Resenia("Taninos bien integrados.", true, fecha1, 7.6, vino22);
        Resenia resena39 = new Resenia("Notas de frutos secos y chocolate.", true, fecha1, 8.5, vino23);
        Resenia resena40 = new Resenia("Final suave y agradable.", true, fecha1, 7.9, vino23);
        Resenia resena41 = new Resenia("Aromas intensos y un final largo.", true, fecha1, 8.7, vino24);
        Resenia resena42 = new Resenia("Aromas cítricos con un toque floral.", true, fecha1, 7.8, vino24);
        Resenia resena43 = new Resenia("Notas de vainilla y especias dulces.", true, fecha1, 8.6, vino25);
        Resenia resena44 = new Resenia("Aromas especiados y un final suave.", true, fecha1, 8.4, vino25);

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
        resenasVino12.add(resena17);
        resenasVino12.add(resena18);
        resenasVino13.add(resena19);
        resenasVino13.add(resena20);
        resenasVino14.add(resena21);
        resenasVino14.add(resena22);
        resenasVino15.add(resena23);
        resenasVino15.add(resena24);
        resenasVino16.add(resena25);
        resenasVino16.add(resena26);
        resenasVino17.add(resena27);
        resenasVino17.add(resena28);
        resenasVino18.add(resena29);
        resenasVino18.add(resena30);
        resenasVino19.add(resena31);
        resenasVino19.add(resena32);
        resenasVino20.add(resena33);
        resenasVino20.add(resena34);
        resenasVino21.add(resena35);
        resenasVino21.add(resena36);
        resenasVino22.add(resena37);
        resenasVino22.add(resena38);
        resenasVino23.add(resena39);
        resenasVino23.add(resena40);
        resenasVino24.add(resena41);
        resenasVino24.add(resena42);
        resenasVino25.add(resena43);
        resenasVino25.add(resena44);

        // Crear array de vinos
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
        vinos.add(vino12);
        vinos.add(vino13);
        vinos.add(vino14);
        vinos.add(vino15);
        vinos.add(vino16);
        vinos.add(vino17);
        vinos.add(vino18);
        vinos.add(vino19);
        vinos.add(vino20);
        vinos.add(vino21);
        vinos.add(vino22);
        vinos.add(vino23);
        vinos.add(vino24);
        vinos.add(vino25);



        
        interfaces.PantRankingVinos pantalla = new interfaces.PantRankingVinos();
        pantalla.setVisible(true);

        GestorReporte gestor = new GestorReporte();
        pantalla.opcGenerarRankingVinos(gestor, vinos);





    }
}