package IGU;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Reporte extends javax.swing.JFrame {

    
    public Reporte() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aclaracion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnVolver = new javax.swing.JToggleButton();
        titulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aclaracion.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        aclaracion.setText("Aca se descargaran todos los cambios por usted en un txt.");

        jButton1.setText("Descargar .txt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        titulo1.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        titulo1.setText("Reporte");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(aclaracion)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Opciones opc = new Opciones();
        opc.setVisible(true);
        this.dispose(); //para cerrar la pantalla actual y seguir con la otra.
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Crear un JFileChooser para que el usuario elija dónde guardar el archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como...");
        
        // Establecer el archivo predeterminado como "reporte.txt"
        fileChooser.setSelectedFile(new File("reporte.txt"));
        
        // Mostrar el diálogo de guardar archivo
        int userSelection = fileChooser.showSaveDialog(this);
        
        // Si el usuario selecciona guardar, procedemos a generar el archivo
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivoAguardar = fileChooser.getSelectedFile();
            
            // Generar el reporte en el archivo seleccionado
            try {
                generarReporteDesdeCSV("datosClientes.csv", archivoAguardar.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Reporte guardado exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

     private void generarReporteDesdeCSV(String rutaCSV, String rutaReporte) throws IOException {
         BufferedReader lectorCSV = null;
        BufferedWriter escritorReporte = null;
        HashMap<String, ArrayList<String>> reportePorDiagnostico = new HashMap<>();

        try {
            // Abrir el archivo CSV
            lectorCSV = new BufferedReader(new FileReader(rutaCSV));

            // Saltar la primera línea (asumiendo que son encabezados)
            String linea = lectorCSV.readLine();
            
            // Leer el CSV y agrupar por diagnóstico
            while ((linea = lectorCSV.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 6) {  // aseguramos que tenga al menos las columnas necesarias
                    String nombre = datos[0];
                    String rut = datos[1];
                    String direccion = datos[2];
                    String telefono = datos[3];
                    String correo = datos[4];
                    String diagnostico = datos[5];

                    String clienteInfo = String.format("    - %s, %s, %s, %s, %s", nombre, rut, direccion, telefono, correo);

                    // Agrupar por diagnóstico
                    reportePorDiagnostico.putIfAbsent(diagnostico, new ArrayList<>());
                    reportePorDiagnostico.get(diagnostico).add(clienteInfo);
                }
            }

            // Crear el archivo de reporte
            escritorReporte = new BufferedWriter(new FileWriter(rutaReporte));
            escritorReporte.write("REPORTE DE CLIENTES\n");
            escritorReporte.write("--------------------\n");

            // Escribir los datos agrupados por diagnóstico
            for (String diagnostico : reportePorDiagnostico.keySet()) {
                escritorReporte.write("\nDiagnostico: " + diagnostico + "\n");
                for (String cliente : reportePorDiagnostico.get(diagnostico)) {
                    escritorReporte.write(cliente + "\n");
                }
                escritorReporte.write("-------------\n");
            }

        } finally {
            // Cerrar los archivos
            if (lectorCSV != null) lectorCSV.close();
            if (escritorReporte != null) escritorReporte.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aclaracion;
    private javax.swing.JToggleButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
