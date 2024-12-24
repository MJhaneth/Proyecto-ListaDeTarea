package INTERFAZ;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Sistema_Agenda.Estado;
import Sistema_Agenda.Prioridad;
import Sistema_Agenda.Tarea;
import java.io.File;
import javax.swing.JFrame;       
import javax.swing.SwingUtilities;  
import javax.swing.table.TableModel; 

/**
 * La clase DesignarTarea permite asignar tareas a los usuarios. 
 * Se utiliza para gestionar la asignación de tareas, la carga de usuarios desde archivos 
 * y el almacenamiento de las tareas en archivos correspondientes a cada usuario.
 * Esta clase extiende de JFrame, por lo que se trata de una ventana de la interfaz gráfica 
 * de usuario (GUI) que contiene una tabla para mostrar los usuarios y un JComboBox para seleccionar 
 * el usuario al que se le asignará una tarea.
 * 
 */
public class DesignarTarea extends javax.swing.JFrame {
    private JTable tablaUsuarios;  
    private JComboBox<String> cmbUsuarios;  
    private DefaultTableModel modeloTabla;  
    private Prioridad prioridad;  // Prioridad de la tarea (no definido en este fragmento)
    private Estado estado;  // Estado de la tarea (no definido en este fragmento)
    private Menu menu; 
    private static int siguienteId = 0;
    
    /**
     * Método estático para obtener el siguiente ID de tarea.
     * 
     * @return El siguiente ID único para una tarea.
     */
    public static int Idsiguiente() {
        return siguienteId++;
    }

    /**
     * Método estático para guardar el contenido de una tarea en un archivo.
     * 
     * @param archivo La ruta del archivo donde se guardará la tarea.
     * @param contenido El contenido de la tarea que se guardará.
     */
    public static void guardarTarea(String archivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(contenido);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la tarea en " + archivo + ": " + e.getMessage());
        }
    }

    /**
     * Guarda una tarea específica en un archivo dentro del directorio de usuarios.
     * Si el directorio no existe, se crea automáticamente.
     * 
     * @param tarea La tarea que se desea guardar en el archivo correspondiente al usuario.
     */
    private void guardarTareaEnArchivo(Tarea tarea) {
        File directorioUsuarios = new File("src/usuarios");
        if (!directorioUsuarios.exists()) {
            if (!directorioUsuarios.mkdirs()) {
                System.out.println("No se pudo crear el directorio 'src/usuarios'. No se guardará la tarea.");
                return;
            }
        }

        String archivo = "src/usuarios/" + tarea.getUsuario() + ".txt";
        String contenido = tarea.toString();
        guardarTarea(archivo, contenido);
    }
    
    /**
     * Constructor de la clase DesignarTarea.
     * Inicializa los componentes gráficos de la interfaz y carga los usuarios en el ComboBox.
     */
    public DesignarTarea() {
        initComponents();  // Método generado por el editor de formularios, inicializa los componentes gráficos
        cmbUsuarios = new JComboBox<>();  // Inicializa el JComboBox
        cargarUsuarios();  // Carga los usuarios desde los archivos en el directorio 'src/usuarios'
        panelCrear.add(cmbUsuarios);  // Agrega el ComboBox al panel de la ventana
        cmbUsuarios.setBounds(15, 180, 100, 30);  // Establece las posiciones del ComboBox en la ventana
    }

    /**
     * Carga los nombres de usuario desde los archivos de texto en el directorio 'src/usuarios'.
     * Los archivos deben tener extensión .txt, y el nombre del archivo es usado como nombre de usuario.
     * Los nombres de usuario se agregan al ComboBox {@link #cmbUsuarios}.
     */
    private void cargarUsuarios() {
        File directorioUsuarios = new File("src/usuarios");
        if (!directorioUsuarios.exists()) {
            if (directorioUsuarios.mkdirs()) {
                System.out.println("Directorio 'src/usuarios' creado correctamente.");
            } else {
                System.out.println("No se pudo crear el directorio 'src/usuarios'.");
                return;  // Salir si no se puede crear el directorio
            }
        }

        if (directorioUsuarios.isDirectory()) {
            File[] archivos = directorioUsuarios.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                        String nombreUsuario = archivo.getName().replace(".txt", "");
                        cmbUsuarios.addItem(nombreUsuario);  // Agregar el nombre de usuario al ComboBox
                    }
                }
            } else {
                System.out.println("No se encontraron archivos en el directorio 'src/usuarios'.");
            }
        } else {
            System.out.println("'src/usuarios' no es un directorio válido.");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCrear = new javax.swing.JPanel();
        txtNuevaTarea = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtDesc = new javax.swing.JTextField();
        txtPrioridad = new javax.swing.JLabel();
        btnBaja = new javax.swing.JRadioButton();
        txtNom = new javax.swing.JTextField();
        btnMedia = new javax.swing.JRadioButton();
        btnAlta = new javax.swing.JRadioButton();
        btnCompletada = new javax.swing.JRadioButton();
        txtEstado = new javax.swing.JLabel();
        btnEnProgreso = new javax.swing.JRadioButton();
        btnPorHacer = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCrear.setBackground(new java.awt.Color(255, 255, 204));
        panelCrear.setPreferredSize(new java.awt.Dimension(336, 500));

        txtNuevaTarea.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        txtNuevaTarea.setText("Designar Tarea");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.setText("Tarea :");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDescripcion.setText("Descripción : ");

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrioridad.setText("Prioridad");

        btnBaja.setBackground(new java.awt.Color(148, 239, 251));
        btnBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnMedia.setBackground(new java.awt.Color(255, 192, 0));
        btnMedia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMedia.setText("Media");
        btnMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediaActionPerformed(evt);
            }
        });

        btnAlta.setBackground(new java.awt.Color(255, 102, 102));
        btnAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnCompletada.setBackground(new java.awt.Color(3, 194, 91));
        btnCompletada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCompletada.setText("Completada");
        btnCompletada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletadaActionPerformed(evt);
            }
        });

        txtEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtEstado.setText("Estado:");

        btnEnProgreso.setBackground(new java.awt.Color(170, 237, 99));
        btnEnProgreso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnProgreso.setText("En Progreso");
        btnEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnProgresoActionPerformed(evt);
            }
        });

        btnPorHacer.setBackground(new java.awt.Color(255, 153, 0));
        btnPorHacer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPorHacer.setText("Por Hacer");

        javax.swing.GroupLayout panelCrearLayout = new javax.swing.GroupLayout(panelCrear);
        panelCrear.setLayout(panelCrearLayout);
        panelCrearLayout.setHorizontalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(67, 67, 67))
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrearLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelCrearLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                                .addComponent(btnPorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCompletada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCrearLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(340, Short.MAX_VALUE)))
        );
        panelCrearLayout.setVerticalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(txtEstado)
                .addGap(18, 18, 18)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaja)
                    .addComponent(btnMedia)
                    .addComponent(btnAlta))
                .addGap(28, 28, 28)
                .addComponent(txtPrioridad)
                .addGap(18, 18, 18)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnProgreso)
                    .addComponent(btnCompletada)
                    .addComponent(btnPorHacer))
                .addGap(126, 126, 126)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(16, 16, 16))
            .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCrearLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNombre)
                    .addGap(35, 35, 35)
                    .addComponent(txtDescripcion)
                    .addContainerGap(388, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
 * Este método es el manejador del evento de acción (por ejemplo, al hacer clic en un botón) 
 * que guarda una nueva tarea en el sistema.
 * 
 * @param evt El evento de acción que activó el método (por ejemplo, un clic en un botón).
 */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                                                                                 // Extraemos el valor de cada campo y eliminamos cualquier prefijo
    // Extraemos el valor de cada campo y eliminamos cualquier prefijo
    String nombreTarea = txtNom.getText().trim();
    nombreTarea = limpiarPrefijo(nombreTarea);

    String descripcion = txtDesc.getText().trim();
    descripcion = limpiarPrefijo(descripcion);

    String prioridad = "";
    if (btnAlta.isSelected()) {
        prioridad = "Alta";
    } else if (btnMedia.isSelected()) {
        prioridad = "Media";
    } else if (btnBaja.isSelected()) {
        prioridad = "Baja";
    }

    String estado = "";
    if (btnPorHacer.isSelected()) {
        estado = "Por Hacer";
    } else if (btnEnProgreso.isSelected()) {
        estado = "En Progreso";
    } else if (btnCompletada.isSelected()) {
        estado = "Completada";
    }

    // Procesamos el nombre de usuario de la misma manera
    String usuarioSeleccionado = (String) cmbUsuarios.getSelectedItem();
    if (usuarioSeleccionado != null) {
        usuarioSeleccionado = limpiarPrefijo(usuarioSeleccionado);
    }

    // Validamos si todos los campos están completos
    if (nombreTarea.isEmpty() || descripcion.isEmpty() || prioridad.isEmpty() || estado.isEmpty() || usuarioSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de guardar la tarea.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Creamos la nueva tarea con los valores ya procesados
    Tarea nuevaTarea = new Tarea(
        Idsiguiente() + "",        // Aquí solo tomamos el ID como es
        nombreTarea,               // Solo el nombre de la tarea
        estado,                    // Solo el estado limpio
        descripcion,               // Solo la descripción limpia
        usuarioSeleccionado,       // Solo el nombre del usuario
        prioridad,                 // Solo la prioridad limpia
        ""                         // Campo vacío (no especificado)
    );

    // Guardamos la tarea en el archivo
    guardarTareaEnArchivo(nuevaTarea);
    // Mostramos un mensaje de éxito con el nombre del usuario
    JOptionPane.showMessageDialog(this, "Tarea guardada con éxito para " + usuarioSeleccionado);
    this.dispose();
}
 /**
     * Limpia cualquier prefijo del valor de un campo. Si el valor contiene un símbolo 
     * de igual (=), se extrae el valor que sigue después del igual.
     * 
     * @param valor El valor a limpiar.
     * @return El valor limpio sin el prefijo.
     */
    // Método auxiliar para limpiar prefijos de los campos
    private String limpiarPrefijo(String valor) {
        if (valor.contains("=")) {
            // Extraemos solo el valor después del "="
            return valor.split("=")[1].trim();
        }
        return valor; // Si no contiene "=", devolvemos el valor tal cual
    
    }//GEN-LAST:event_btnGuardarActionPerformed

   
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Este método es el manejador del evento de acción cuando se selecciona la opción de prioridad "Baja".

     * @param evt El evento de acción que activó el método (por ejemplo, un clic en el botón "Baja").
     */
    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // Configura la prioridad como Baja
        prioridad = new Prioridad(false, false, true);
        System.out.println("PRIORIDAD BAJA");
    }//GEN-LAST:event_btnBajaActionPerformed

    /**
    * Este método es el manejador del evento de acción cuando se selecciona la opción de prioridad "Media".

    * @param evt El evento de acción que activó el método (por ejemplo, un clic en el botón "Media").
    */
    private void btnMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediaActionPerformed
        // Configura la prioridad como Media
        prioridad = new Prioridad(false, true, false);        // TODO add your handling code here:
        System.out.println("PRIORIDAD MEDIA");
    }//GEN-LAST:event_btnMediaActionPerformed

    
    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        // Configura la prioridad como Alta
        prioridad = new Prioridad(true, false, false);
        System.out.println("PRIORIDAD ALTA");
    }//GEN-LAST:event_btnAltaActionPerformed

    
    /**
     * Método que configura el estado como Completada.
     * 
     * @param evt El evento de acción que ocurrió.
     */
    private void btnCompletadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletadaActionPerformed
        // Configura el estado como Completada
        estado = new Estado(true, false, false);
        System.out.println("ESTADO COMPLETADA");
    }//GEN-LAST:event_btnCompletadaActionPerformed

    private void btnEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnProgresoActionPerformed
        // Configura el estado como Por Hacer
        estado = new Estado(false, true, false);
        System.out.println("ESTADO EN PROGRESO");
    }//GEN-LAST:event_btnEnProgresoActionPerformed
/**
     * Método principal que inicializa y muestra la interfaz gráfica de la aplicación.
     * 
     * @param args Los argumentos de línea de comandos.
     */
    public static void main(String args[]) {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesignarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesignarTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAlta;
    private javax.swing.JRadioButton btnBaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnCompletada;
    private javax.swing.JRadioButton btnEnProgreso;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JRadioButton btnMedia;
    private javax.swing.JRadioButton btnPorHacer;
    private javax.swing.JPanel panelCrear;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtNom;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNuevaTarea;
    private javax.swing.JLabel txtPrioridad;
    // End of variables declaration//GEN-END:variables
}
