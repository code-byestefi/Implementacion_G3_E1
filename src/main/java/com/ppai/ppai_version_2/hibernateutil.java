package com.ppai.ppai_version_2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateutil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Cargar la configuración de Hibernate (hibernate.cfg.xml)
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(com.ppai.ppai_version_2.entities.Vino.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Pais.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Provincia.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Bodega.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Vino.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Varietal.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Resenia.class)
                                                .addAnnotatedClass(com.ppai.ppai_version_2.entities.Region.class)
                                                .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to create sessionFactory object." + e);
        }
    }

    // Obtener la sesión de Hibernate
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Cerrar la sesión
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Cerrar el SessionFactory al finalizar la aplicación
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
