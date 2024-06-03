package com.ppai.ppai_version_2;

import com.ppai.ppai_version_2.controller.GestorReporte;
import com.ppai.ppai_version_2.entities.Vino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.UtilDateModel;

public class interfaces {
    public static class InterfazExcel {

        public void generarExcel(List<List<Object>> datosVinos){

            Workbook workbook = new XSSFWorkbook();


            Sheet sheet = workbook.createSheet("excel-sheet");
            for (int i = 0; i < 9; i++) {
                sheet.setColumnWidth(i, 5000);
            }

            Row row0 = sheet.createRow(0);

            row0.createCell(0).setCellValue("Posición");
            row0.createCell(1).setCellValue("Nombre");
            row0.createCell(2).setCellValue("Calificación General");
            row0.createCell(3).setCellValue("Calificación Sommelier");
            row0.createCell(4).setCellValue("Precio Sugerido");
            row0.createCell(5).setCellValue("Bodega");
            row0.createCell(6).setCellValue("Región");
            row0.createCell(7).setCellValue("País");
            row0.createCell(8).setCellValue("Provincia");


            for (int i = 0; i < datosVinos.size(); i++) {
                List<Object> vino = datosVinos.get(i);

                Row row1 = sheet.createRow(i+1);

                row1.createCell(0).setCellValue(i+1);
                row1.createCell(1).setCellValue(vino.get(1).toString());
                row1.createCell(2).setCellValue(7);
                row1.createCell(3).setCellValue(vino.get(0).toString());
                row1.createCell(4).setCellValue(vino.get(2).toString());
                row1.createCell(5).setCellValue(vino.get(3).toString());
                row1.createCell(6).setCellValue(vino.get(4).toString());
                row1.createCell(7).setCellValue(vino.get(5).toString());
                row1.createCell(8).setCellValue(vino.get(6).toString());
            }


            try {
                FileOutputStream out = new FileOutputStream(
                        new File("10-ranking-Vinos.xlsx"));
                workbook.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        private JDatePickerImpl datePickerDesde;
        private JDatePickerImpl datePickerHasta;
        private JLabel lblTextFechaDesde = new JLabel("Fecha Desde: ");
        private JLabel lblTextFechaHasta = new JLabel("Fecha Hasta: ");

        // titulos o textos
        private JLabel lblOpcResenia = new JLabel("Seleccione un Tipo de Reseña: ");
        private JLabel lblVisualizacion = new JLabel("Seleccionar Tipo de Visualización: ");
        private JLabel lblGeneracionExitosa = new JLabel("Reporte Generado exitosamente!");

        // Métodos de Pantalla
        public void opcionGenerarRankingDeVinos(GestorReporte gestor, ArrayList<Vino> vinos) {
            JFrame frame = new JFrame("Generación de reportes de Vinos - Ranking de Calificaciones");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            JPanel mainPanel = new JPanel(new CardLayout());
            frame.add(mainPanel);
            frame.setLocation(0,0);

            // Crear la primera pantalla con la imagen de fondo y el botón
            JPanel screen1 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Cargar la imagen desde el archivo (asegúrate de tener la imagen en la ruta correcta)
                    ImageIcon image = new ImageIcon("src/main/java/com/ppai/ppai_version_2/Imagen/Captura de pantalla 2024-05-30 224701.png");
                    // Dibujar la imagen en el panel
                    g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), null);
                }
            };

            screen1.setLayout(new GridBagLayout());


            // Añadir el botón para cambiar a la segunda pantalla
            JButton toScreen2Button = new JButton("Generar Ranking de vinos");
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(50, 0, 0, 0); // Ajustar el relleno (top, left, bottom, right)
            screen1.add(toScreen2Button, gbc);

            toScreen2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    habilitarPantalla(gestor); // habilitamos pantalla
                }
            });

            mainPanel.add(screen1, "Screen1");

            frame.setVisible(true);
            gestor.generarRankingDeVinos(this, vinos); // opcGenerarRankingVinos()
        }

        public void habilitarPantalla(GestorReporte gestor) {
            // configuro la ventana
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocation(0,0);
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
            panelBody.setBackground(Color.decode("#4a1b1b"));

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
            // Configuración del date picker
            UtilDateModel modelDesde = new UtilDateModel();
            Properties pDesde = new Properties();
            pDesde.put("text.today", "Today");
            pDesde.put("text.month", "Month");
            pDesde.put("text.year", "Year");
            JDatePanelImpl datePanelDesde = new JDatePanelImpl(modelDesde, pDesde);
            datePickerDesde = new JDatePickerImpl(datePanelDesde, new DateLabelFormatter());

            UtilDateModel modelHasta = new UtilDateModel();
            Properties pHasta = new Properties();
            pHasta.put("text.today", "Today");
            pHasta.put("text.month", "Month");
            pHasta.put("text.year", "Year");
            JDatePanelImpl datePanelHasta = new JDatePanelImpl(modelHasta, pHasta);
            datePickerHasta = new JDatePickerImpl(datePanelHasta, new DateLabelFormatter());

            datePickerDesde.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date selectedDate = (Date) datePickerDesde.getModel().getValue();
                    System.out.println("Fecha Desde seleccionada: " + selectedDate);
                    try {
                        datePickerDesde.getJFormattedTextField().setText(new DateLabelFormatter().valueToString(selectedDate));
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            datePickerHasta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date selectedDate = (Date) datePickerHasta.getModel().getValue();
                    System.out.println("Fecha Hasta seleccionada: " + selectedDate);
                    try {
                        datePickerHasta.getJFormattedTextField().setText(new DateLabelFormatter().valueToString(selectedDate));
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            // agrego al body
            panelBody.add(lblTextFechaDesde);
            lblTextFechaDesde.setForeground(Color.WHITE); // Establecer color de texto blanco
            panelBody.add(datePickerDesde);
            panelBody.add(lblTextFechaHasta);
            lblTextFechaHasta.setForeground(Color.WHITE); // Establecer color de texto blanco
            panelBody.add(datePickerHasta);
            panelBody.add(btnAceptar);

            btnAceptar.addActionListener(e -> {
                Date fechaDesde = tomarFechaDesde(); // tomamos fechaDesde
                Date fechaHasta = tomarFechaHasta(); // tomamos fechaHasta

                gestor.tomarFechas(fechaDesde, fechaHasta, this); // tomamos fechas al gestor

                boolean validate = validarPeriodo(fechaDesde, fechaHasta); // validamos periodo

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
            return (Date) datePickerDesde.getModel().getValue();
        }

        public Date tomarFechaHasta() {
            return (Date) datePickerHasta.getModel().getValue();
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

            String[] tipoResenia = gestor.getTipoResenia(); // buscarTipoResenia()

            //String[] tipoResenia = {"Premium", "No Premium"};

            opciones = new JComboBox<>(tipoResenia);

            panelBody.add(lblOpcResenia);
            lblOpcResenia.setForeground(Color.WHITE);
            panelBody.add(opciones);
            panelBody.add(btnResenia);

            btnResenia.addActionListener(e -> {
                String tipoResena = tomarSeleccionTipoResenia(); // tomas la seleccion
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
            panelBody.removeAll();
            // traigo tipos del gestor
            String[] tipoVisualizaciones = gestor.getTipoVisualizaciones(); // buscarFormatoReporte();

            opciones = new JComboBox<>(tipoVisualizaciones);

            panelBody.add(lblVisualizacion);
            lblVisualizacion.setForeground(Color.WHITE);
            panelBody.add(opciones);
            panelBody.add(btnTipoVisualizacion);

            btnTipoVisualizacion.addActionListener(e -> {
                String tipoVisualizacion = tomarSelecciónFormatoReporte(); // tomar las seleccion
                gestor.tomarSelecciónFormatoReporte(tipoVisualizacion, this); // pasar al gestor
            });
            panelBody.revalidate();
            panelBody.repaint();
        }

        private String tomarSelecciónFormatoReporte() {
            return opciones.getSelectedItem().toString(); // se toma la seleccion
        }

        public void solicitarConfirmacion(GestorReporte gestor) {
            panelBody.add(btnConfirmar);
            tomarConfirmacion(gestor); // se toma confirmación
            panelBody.revalidate();
            panelBody.repaint();

        }
        private void tomarConfirmacion(GestorReporte gestor) {
            JOptionPane pane = new JOptionPane("¿Estás seguro de que deseas generar el reporte?", JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = pane.createDialog(panelBody, "Confirmar Generación de Reporte");
            dialog.setVisible(true);
            gestor.tomarConfirmacion(this);
        }

        public void mostrarGeneracionExitosa() {
            JOptionPane.showMessageDialog(panelBody, "Generación exitosa", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            setLocation(0,0);
        }

    }

}
