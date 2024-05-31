package com.ppai.ppai_version_2;

import com.ppai.ppai_version_2.controller.GestorReporte;
import com.ppai.ppai_version_2.entities.Vino;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class interfaces {
    public static class InterfazExcel {

        public void generarExcel(){

        }
    }

    public static class PantRankingVinos extends JFrame {

        private final Object lock = new Object();

        // paneles
        private JPanel primerPanel = new JPanel();
        private JPanel panelTitle = new JPanel();
        private JPanel panelBody = new JPanel();

        // botones
        private JLabel title = new JLabel("Bonvino Versión 1.0");
        private JLabel subtitle = new JLabel("Generación de reportes - Ranking's");
        private JButton btnCancelar = new JButton("Cancelar reporte");
        private JButton btnAceptar = new JButton("Aceptar");
        private JButton btnResenia = new JButton("Aceptar");
        JComboBox<String> opciones = new JComboBox<>();
        private JButton btnTipoVisualizacion = new JButton("Aceptar");
        private JButton btnConfirmar = new JButton("Confirmar");

        // fechas - campos
        private JTextField lblFechaDesde = new JTextField("01-01-2000", 20);
        private JTextField lblFechaHasta = new JTextField("01-01-2024", 20);
        private JLabel lblTextFechaDesde = new JLabel("Fecha Desde: ");
        private JLabel lblTextFechaHasta = new JLabel("Fecha Hasta: ");

        // titulos o textos
        private JLabel lblOpcResenia = new JLabel("Seleccione un Tipo de Reseña: ");
        private JLabel lblVisualizacion = new JLabel("Seleccionar Tipo de Visualización: ");
        private JLabel lblReporteGenerado = new JLabel("Reporte Generado!");

        // Métodos de Pantalla
        public void opcGenerarRankingVinos(GestorReporte gestor, ArrayList<Vino> vinos, InterfazExcel excel) {
            habilitarVentana(gestor);
            gestor.opcGenerarRankingVinos(this, vinos, excel);

        }

        public void habilitarVentana(GestorReporte gestor) {
            // configuro la ventana
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setTitle("Generación de reportes de Vinos - Ranking de Calificaciones");

            // Configuro el primer panel
            primerPanel.setLayout(new BorderLayout());
            primerPanel.setBackground(Color.black);

            // Configuro el panel del título
            panelTitle.setLayout(new GridLayout(2, 1));
            panelTitle.setBackground(Color.darkGray);

            // Configuro el título y el subtítulo
            title.setForeground(Color.white);
            subtitle.setForeground(Color.lightGray);

            // Agrego el título y el subtítulo al panel del título
            panelTitle.add(title);
            panelTitle.add(subtitle);

            // Configuro el cuerpo del panel
            panelBody.setBackground(Color.PINK);

            // agegro el cuerpo al primer panel
            primerPanel.add(panelBody, BorderLayout.CENTER);
            primerPanel.add(panelTitle, BorderLayout.NORTH);
            primerPanel.add(btnCancelar, BorderLayout.SOUTH);

            // agrego a la ventana el primer panel
            add(primerPanel);
            // Hago visible la ventana
            setVisible(true);

            // para cancelar el proceso
            btnCancelar.addActionListener(e -> {
                gestor.finCU(this);
                System.out.println("proceso cancelado");
            });
        }

        public void solicitarSeleccionFechas(GestorReporte gestor) {
            // agrego al body
            panelBody.add(lblTextFechaDesde);
            panelBody.add(lblFechaDesde);
            panelBody.add(lblTextFechaHasta);
            panelBody.add(lblFechaHasta);
            panelBody.add(btnAceptar);

            btnAceptar.addActionListener(e -> {
                Date fechaDesde = tomarFechaDesde();
                Date fechaHasta = tomarSelFechaHasta();
                boolean validate = validarPeriodo(fechaDesde, fechaHasta);

                gestor.tomarFechas(fechaDesde, fechaHasta, this);
                synchronized (lock) {
                    lock.notify();
                }
            });
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public Date tomarFechaDesde() {
            String fechaTexto = lblFechaDesde.getText();
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date fecha = formato.parse(fechaTexto);
                return fecha;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        public Date tomarSelFechaHasta() {
            String fechaTexto = lblFechaHasta.getText();
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date fecha = formato.parse(fechaTexto);
                return fecha;
            } catch (ParseException e) {
                e.printStackTrace();
                return null; //
            }
        }

        public boolean validarPeriodo(Date fechaDesde, Date fechaHasta) {
            if (fechaDesde.before(fechaHasta)) {
                System.out.println("Es correcta");
                return true;
            }
            System.out.println("No es correcta");
            return false;
        }

        public void solicitarSeleccionTipoReseña(GestorReporte gestor) {
            panelBody.removeAll();

            String[] tipoResenia = {"Premium", "No Premium"};
            opciones = new JComboBox<>(tipoResenia);

            panelBody.add(lblOpcResenia);
            panelBody.add(opciones);
            panelBody.add(btnResenia);

            btnResenia.addActionListener(e -> {
                String tipoResena = tomarSeleccionTipoResenia();
                gestor.tomarSeleccionTipoResenia(tipoResena, this);
            });
            panelBody.revalidate();
            panelBody.repaint();
        }

        private String tomarSeleccionTipoResenia() {
            String opcTipoResena = opciones.getSelectedItem().toString();
            return opcTipoResena;
        }

        public void solicitarSelecciónFormatoReporte(GestorReporte gestor) {
            // traigo tipos del gestor
            String[] tipoVisualizaciones = gestor.getTipoVisualizaciones();
            opciones = new JComboBox<>(tipoVisualizaciones);

            panelBody.add(lblVisualizacion);
            panelBody.add(opciones);
            panelBody.add(btnTipoVisualizacion);

            btnTipoVisualizacion.addActionListener(e -> {
                String tipoVisualizacion = tomarSelecciónFormatoReporte();
                gestor.tomarSelecciónFormatoReporte(tipoVisualizacion, this);
            });
            panelBody.revalidate();
            panelBody.repaint();
        }

        private String tomarSelecciónFormatoReporte() {
            return opciones.getSelectedItem().toString();
        }

        public void solicitarConfirmacion(GestorReporte gestor) {
            panelBody.add(btnConfirmar);
            tomarConfirmacion(gestor);
            panelBody.revalidate();
            panelBody.repaint();

        }
        private void tomarConfirmacion(GestorReporte gestor) {
            btnConfirmar.addActionListener(e -> {
                gestor.tomarConfirmacion(this);
                panelBody.add(lblReporteGenerado);
                panelBody.revalidate();
                panelBody.repaint();
            });
        }


    }
}
