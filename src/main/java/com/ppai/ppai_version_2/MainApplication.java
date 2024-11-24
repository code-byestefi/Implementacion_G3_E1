package com.ppai.ppai_version_2;

import com.ppai.ppai_version_2.controller.GestorReporte;
import com.ppai.ppai_version_2.entities.*;


import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class MainApplication {
    public static void main( String[] args ) {

        System.out.println( "Habilitamos Ventana" );

        // Obtener la sesión de Hibernate
        Session session = hibernateutil.getSession();

        try {
            // Crear una consulta HQL para obtener todos los países
            String hql = "FROM Vino";
            Query<Vino> query = session.createQuery(hql, Vino.class); // Uso de tipo genérico
            List<Vino> vinos = query.list();

            // Mostrar los países cargados
            for (Vino vino : vinos) {
                System.out.println("Vino: " + vino.getNombre());
            }
            String hql2 = "FROM Resenia";
            Query<Resenia> query2 = session.createQuery(hql2, Resenia.class); // Uso de tipo genérico
            List<Resenia> resenias = query2.list();
            // Mostrar las resenias
            for (Resenia resenia : resenias) {
                System.out.println("Reseña: " + resenia.getComentario()+" al vino " + resenia.getVino().getNombre() + " cuyo puntaje es " + resenia.getPuntaje() + " hecho en " + resenia.getFechaResena());
            }
            interfaces.PantRankingVinos pantalla = new interfaces.PantRankingVinos();
            pantalla.setVisible(true);
    
            GestorReporte gestor = new GestorReporte();
            pantalla.opcionGenerarRankingDeVinos(gestor, vinos); // empieza el flujo

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
