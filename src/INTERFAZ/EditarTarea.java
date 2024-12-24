
package INTERFAZ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.*;

public class EditarTarea extends javax.swing.JFrame {
    private Tarea tarea;
    
/**
 * Constructor que recibe un objeto Tarea para cargar los datos en los campos de texto de la interfaz.
 *
 * @param tarea El objeto Tarea que contiene los datos de la tarea a editar.
 */
public EditarTarea(Tarea tarea) {
    initComponents();  // Inicializa los componentes gráficos
    this.tarea = tarea;  // Asigna la tarea a la instancia
    cargarDatos();  // Carga los datos de la tarea en los campos de texto
    leerTareas();  // Lee las tareas desde el archivo
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar1 = new javax.swing.JTextField();
        txtBuscar2 = new javax.swing.JTextField();
        txtBuscar3 = new javax.swing.JTextField();
        txtBuscar4 = new javax.swing.JTextField();
        txtBuscar5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        txtBuscar1.setForeground(new java.awt.Color(153, 153, 153));

        txtBuscar2.setForeground(new java.awt.Color(153, 153, 153));

        txtBuscar3.setForeground(new java.awt.Color(153, 153, 153));

        txtBuscar4.setForeground(new java.awt.Color(153, 153, 153));

        txtBuscar5.setForeground(new java.awt.Color(153, 153, 153));

        jLabel4.setText("Nombre de la tarea");

        jLabel1.setText("Estado");

        jLabel5.setText("Descripcion");

        jLabel2.setText("Usuario");

        jLabel6.setText("Prioridad");

        jLabel3.setText("Notas");

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Actualizar tarea");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtBuscar.setForeground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Editar Tarea");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                            .addComponent(jButton1)
                            .addGap(98, 98, 98))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBuscar4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(123, 123, 123)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1)))))
                                .addComponent(jLabel5)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel6))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
 * Este método lee las tareas almacenadas en un archivo y las carga en la aplicación.
 
 * @throws IOException Si ocurre un error al leer el archivo de tareas.
 */
    private void leerTareas() {
    // Ubicación del archivo tareas.txt
    String filePath = "C:\\Users\\Lenovo\\Downloads\\ListaTarea\\ListaTarea\\src\\usuarios\\" + tarea.getUsuario() + ".txt";
    File archivo = new File(filePath);
    List<String> tareas = new ArrayList<>();

    try {
        // Leer el archivo línea por línea
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            tareas.add(linea); // Agregar cada línea a la lista, incluyendo las vacías
        }
        br.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
}
    private void cargarDatos() {
        txtBuscar1.setText(tarea.getNombre());      // Task Name
        txtBuscar2.setText(tarea.getEstado());      // Task State
        txtBuscar3.setText(tarea.getUsuario()); // Task Description
        txtBuscar4.setText(tarea.getPrioridad());     // Task User
        txtBuscar5.setText(tarea.getNotas());   // Task Priority
        txtBuscar.setText(tarea.getDescripcion());        // Task Notes (if any)
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
String nombre = txtBuscar1.getText();      // Nombre de la tarea
    String estado = txtBuscar4.getText();      // Estado de la tarea
    String descripcion = txtBuscar.getText(); // Descripción de la tarea
    String usuario = txtBuscar3.getText();     // Usuario de la tarea
    String prioridad = txtBuscar2.getText();   // Prioridad de la tarea
        // Notas adicionales

    // Establecer los valores en el objeto tarea
    tarea.setUsuario(estado );
    
    tarea.setNombre(usuario);
    tarea.setDescripcion(descripcion);
    
    tarea.setPrioridad(prioridad);
    tarea.setEstado(nombre );
    
    
    
    // Ubicación del archivo tareas.txt
    String filePath = "C:\\Users\\Lenovo\\Downloads\\ListaTarea\\ListaTarea\\src\\usuarios\\" + usuario + ".txt";
    File archivo = new File(filePath);
    List<String> tareas = new ArrayList<>();

    try {
    // Leer el archivo línea por línea
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8));
    String linea;
    while ((linea = br.readLine()) != null) {
        tareas.add(linea); // Agregar cada línea a la lista, incluyendo las vacías
    }
    br.close();

    // Buscar la tarea por el ID y actualizarla
    boolean tareaEncontrada = false;

    for (int i = 0; i < tareas.size(); i++) {
        String tareaLine = tareas.get(i);
        System.out.println("Línea leída: [" + tareaLine + "]");  // Imprime la línea leída
        String[] partes = tareaLine.split(",");

        if (partes.length >= 6) {
            System.out.println("ID en el archivo: [" + partes[0].trim() + "]");  // Imprime el ID de la línea
            System.out.println("ID a buscar: [" + tarea.getId().trim() + "]");  // Verifica el ID que estás buscando
            
            if (partes[0].trim().equals(tarea.getId().trim())) {  // Asegúrate de comparar el ID sin espacios extra
                tareaEncontrada = true;
                // Actualizar la tarea en la lista
                String nuevaTarea = tarea.getId() + "," + tarea.getNombre() + "," + tarea.getEstado() + "," + tarea.getDescripcion() + "," + tarea.getUsuario() + "," + tarea.getPrioridad() + "," + tarea.getNotas();
                tareas.set(i, nuevaTarea);
                break; // Terminamos el ciclo después de encontrar la tarea
            }
        }
    }

    if (!tareaEncontrada) {
        System.out.println("No se encontró la tarea con el ID: " + tarea.getId());
    }

    // Sobrescribir el archivo con las tareas actualizadas
    BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false)); // 'false' para sobrescribir
    for (String tareaStr : tareas) {
        bw.write(tareaStr);
        bw.newLine(); // Escribir cada tarea en una nueva línea
    }
    bw.close();

} catch (IOException e) {
    e.printStackTrace(); // Manejo de excepciones
}
    this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
   this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtBuscar3;
    private javax.swing.JTextField txtBuscar4;
    private javax.swing.JTextField txtBuscar5;
    // End of variables declaration//GEN-END:variables
}
