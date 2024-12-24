package INTERFAZ;

import Sistema_Agenda.Estado;
import Sistema_Agenda.Prioridad;
import Sistema_Agenda.Tarea;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/**
 * La clase CrearTarea es una ventana (JFrame) que permite crear una nueva tarea en el sistema de agenda.
 * Esta clase interactúa con los objetos de la clase Menu y utiliza botones de opción (JRadioButton) 
 * para seleccionar la prioridad y el estado de la tarea.
 * Además, gestiona la creación de una nueva tarea con sus respectivos parámetros y las opciones 
 * de prioridad y estado.
 */
public class CrearTarea extends javax.swing.JFrame {

    // Atributos que definen la prioridad y el estado de la tarea
    Prioridad prioridad = null;
    Estado estado = null;

    // Referencia al menú principal
    Menu menu;

    // Definición de los grupos de botones de opción (ButtonGroup)
    // Estos ButtonGroup gestionan los botones de selección para prioridad y estado
    ButtonGroup GrupoPrioridad;
    ButtonGroup GrupoEstado;

    /**
     * Constructor de la clase CrearTarea.
     * Este constructor inicializa los componentes gráficos y los grupos de botones de opción 
     * para la prioridad y el estado de la tarea.
     * 
     * @param menu Una instancia del menú principal que se pasa al constructor.
     */
    public CrearTarea(Menu menu) {
        this.menu = menu;
        initComponents();  // Inicializa los componentes gráficos de la ventana
        GrupoPrioridad = new ButtonGroup();  // Inicializa el grupo de botones de prioridad
        GrupoPrioridad.add(btnAlta);         // Agrega los botones de prioridad al grupo
        GrupoPrioridad.add(btnBaja);
        GrupoPrioridad.add(btnMedia);

        GrupoEstado = new ButtonGroup();    // Inicializa el grupo de botones de estado
        GrupoEstado.add(btnPorHacer);       // Agrega los botones de estado al grupo
        GrupoEstado.add(btnEnProgreso);
        GrupoEstado.add(btnCompletada);
        
        // Hace visible el panel de creación de tarea
        this.panelCrear.setVisible(true);
        
        // Centra la ventana en la pantalla
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
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
        txtEstado = new javax.swing.JLabel();
        btnPorHacer = new javax.swing.JRadioButton();
        btnEnProgreso = new javax.swing.JRadioButton();
        btnCompletada = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtNom1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNom4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNom2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNom3 = new javax.swing.JTextField();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear Tarea");
        setBounds(new java.awt.Rectangle(0, 0, 500, 600));
        setPreferredSize(new java.awt.Dimension(360, 564));

        panelCrear.setBackground(new java.awt.Color(255, 255, 204));
        panelCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelCrear.setPreferredSize(new java.awt.Dimension(336, 500));

        txtNuevaTarea.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        txtNuevaTarea.setText("CREAR TAREA");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.setText("Tarea:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDescripcion.setText("Descripción : ");

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        txtPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrioridad.setText("Prioridad:");

        btnBaja.setBackground(new java.awt.Color(148, 239, 251));
        btnBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBaja.setText("Baja");
        btnBaja.setOpaque(true);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnMedia.setBackground(new java.awt.Color(255, 192, 0));
        btnMedia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMedia.setText("Media");
        btnMedia.setOpaque(true);
        btnMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediaActionPerformed(evt);
            }
        });

        btnAlta.setBackground(new java.awt.Color(255, 102, 102));
        btnAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlta.setText("Alta");
        btnAlta.setOpaque(true);
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        txtEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtEstado.setText("Estado:");

        btnPorHacer.setBackground(new java.awt.Color(255, 217, 102));
        btnPorHacer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPorHacer.setText("Por Hacer");
        btnPorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorHacerActionPerformed(evt);
            }
        });

        btnEnProgreso.setBackground(new java.awt.Color(170, 237, 99));
        btnEnProgreso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnProgreso.setText("En Progreso");
        btnEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnProgresoActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Fecha Inicio:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Hora Inicio:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Fecha fin:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Hora Fin:");

        javax.swing.GroupLayout panelCrearLayout = new javax.swing.GroupLayout(panelCrear);
        panelCrear.setLayout(panelCrearLayout);
        panelCrearLayout.setHorizontalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnCancelar))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnPorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(67, 67, 67))
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(214, 214, 214)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCompletada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNom1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNom4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNom3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNom2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCrearLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(157, Short.MAX_VALUE)))
        );
        panelCrearLayout.setVerticalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNuevaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtPrioridad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaja)
                    .addComponent(btnMedia)
                    .addComponent(btnAlta))
                .addGap(33, 33, 33)
                .addComponent(txtEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPorHacer)
                    .addComponent(btnEnProgreso)
                    .addComponent(btnCompletada))
                .addGap(44, 44, 44)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(16, 16, 16))
            .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCrearLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(txtNombre)
                    .addGap(35, 35, 35)
                    .addComponent(txtDescripcion)
                    .addContainerGap(388, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        // Este método se ejecuta cuando se selecciona la opción "Alta" en los botones de prioridad
        // Establece la prioridad de la tarea como "Alta" (true, false, false)
        prioridad = new Prioridad(true, false, false);
        System.out.println("PRIORIDAD ALTA");
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediaActionPerformed
        // Este método se ejecuta cuando se selecciona la opción "Media" en los botones de prioridad
        // Establece la prioridad de la tarea como "Media" (false, true, false)
        prioridad = new Prioridad(false, true, false);  
        System.out.println("PRIORIDAD MEDIA");
    }//GEN-LAST:event_btnMediaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
       // Este método se ejecuta cuando se selecciona la opción "Baja" en los botones de prioridad
        // Establece la prioridad de la tarea como "Baja" (false, false, true)
        prioridad = new Prioridad(false, false, true);
        System.out.println("PRIORIDAD BAJA");
    }//GEN-LAST:event_btnBajaActionPerformed

    /**
     * Método que obtiene los datos de una columna específica de una tabla (TableModel).
     * 
     * @param model El modelo de la tabla.
     * @param columnIndex El índice de la columna de la cual obtener los datos.
     * @return Una lista con los datos de la columna seleccionada.
     */
    public List<String> getColumnData(TableModel model, int columnIndex) {
        List<String> columnData = new ArrayList<>();
        for (int row = 0; row < model.getRowCount(); row++) {
            columnData.add((String) model.getValueAt(row, columnIndex));
        }
        return columnData;
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        // Este método se ejecuta cuando se presiona el botón "Cancelar".
        // Obtiene los datos de la columna 0 de la tabla de tareas y los imprime.
        List<String> columnData = getColumnData(this.menu.getTabla().getModel(), 0);
        System.out.println(columnData);
        
        // Cierra la ventana de creación de tarea y actualiza el menú principal
       
        JFrame contenedorFrame = (JFrame) SwingUtilities.getWindowAncestor(this.panelCrear);
        contenedorFrame.dispose();
        menu.refreshMenu(menu);
        this.repaint();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método que calcula el siguiente ID disponible para la tarea.
     * 
     * @return El siguiente ID disponible para una nueva tarea.
     */
    private int Idsiguiente() {
        List<String> Id = getColumnData(this.menu.getTabla().getModel(), 0);
        if (Id.isEmpty()) {
            return 1;
        } else {

            String id = Id.get(Id.size() - 1);
            int res = Integer.parseInt(id) + 1;
            return res;
        }
    }

    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Este método se ejecuta cuando se presiona el botón "Guardar".
        // Obtiene los valores de los campos de la tarea y guarda la tarea en un archivo de texto.

        // Obtener los valores de los campos (nombre de la tarea, descripción, fechas, horas)
        String nombreTarea = this.txtNom1.getText().trim();
        String descripcionTarea = this.txtDesc.getText().trim();
        String fechaInicio = this.txtNom.getText().trim();
        String horaInicio = this.txtNom4.getText().trim();
        String fechaFin = this.txtNom2.getText().trim();
        String horaFin = this.txtNom3.getText().trim();

        // Crear la tarea con los valores obtenidos
        Tarea t1 = new Tarea(Idsiguiente(), menu.getUsuario(), nombreTarea, descripcionTarea, prioridad, estado);
        guardarTarea("src/usuarios/" + menu.getUsuario() + ".txt", t1.getAtributos());

        // Establecer valores por defecto si algún campo de fecha o hora está vacío
        if (fechaInicio.isEmpty()) {
            fechaInicio = obtenerFechaActual();  // Obtener fecha actual
        }
        if (horaInicio.isEmpty()) {
            horaInicio = obtenerHoraActual();  // Obtener hora actual
        }
        if (fechaFin.isEmpty()) {
            fechaFin = obtenerFechaActual();  // Obtener fecha actual
        }
        if (horaFin.isEmpty()) {
            horaFin = obtenerHoraActual();  // Obtener hora actual
        }

        // Crear la tarea con los valores obtenidos
        Tarea t2 = new Tarea(Idsiguiente(), menu.getUsuario(), nombreTarea, descripcionTarea, prioridad, estado);

        // Crear la ruta del archivo para el usuario
        String rutaCarpeta = "C:\\Users\\Lenovo\\Downloads\\ListaTarea\\ListaTarea\\src\\date\\" + menu.getUsuario();
        File carpeta = new File(rutaCarpeta);

        // Verificar si la carpeta del usuario existe, si no, crearla
        if (!carpeta.exists()) {
            carpeta.mkdirs();  // Crear la carpeta si no existe
        }

        // Ruta completa al archivo de tareas del usuario
        String rutaArchivo = rutaCarpeta + "\\tareas.txt";
        File archivo = new File(rutaArchivo);

        // Verificar si el archivo de tareas ya existe. Si no existe, crearlo.
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();  // Crear el archivo si no existe
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }

        // Crear el contenido a guardar, incluyendo el ID, usuario, nombre de la tarea, fechas y horas
        String contenido = t1.getId() + "," + menu.getUsuario() + "," + t1.getNombre() + "," + fechaInicio + "," + horaInicio + "," + fechaFin + "," + horaFin;

        // Guardar la tarea en el archivo del usuario
        guardarTarea(rutaArchivo, contenido);

        // Cierra la ventana de creación de tarea y actualiza el menú principal
        JFrame contenedorFrame = (JFrame) SwingUtilities.getWindowAncestor(this.panelCrear);
        contenedorFrame.dispose();
        menu.dispose();
        menu = new Menu(menu.getUsuario());
        menu.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void btnPorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorHacerActionPerformed
        // Este método se ejecuta cuando se selecciona la opción "Por Hacer" en los botones de estado
        // Establece el estado de la tarea como "Por Hacer" (false, false, true)
        estado = new Estado(false, false, true);
        System.out.println("ESTADO POR HACER");
    }//GEN-LAST:event_btnPorHacerActionPerformed

    private void btnEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnProgresoActionPerformed
        // Este método se ejecuta cuando se selecciona la opción "En Progreso" en los botones de estado
        // Establece el estado de la tarea como "En Progreso" (false, true, false)
        estado = new Estado(false, true, false);
        System.out.println("ESTADO EN PROGRESO");
    }//GEN-LAST:event_btnEnProgresoActionPerformed

    private void btnCompletadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletadaActionPerformed
        // Este método se ejecuta cuando se selecciona la opción "Completada" en los botones de estado
        // Establece el estado de la tarea como "Completada" (true, false, false)
        estado = new Estado(true, false, false);
        System.out.println("ESTADO COMPLETADA");
    }//GEN-LAST:event_btnCompletadaActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // Este método se ejecuta cuando se hace clic en el botón "Cancelar".
        // Cierra la ventana de creación de tarea
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

     /**
     * Método que obtiene la fecha actual en formato "yyyy-MM-dd".
     * 
     * @return La fecha actual en formato "yyyy-MM-dd".
     */
    private String obtenerFechaActual() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(new Date());  // Devuelve la fecha actual en formato "yyyy-MM-dd"
}

 /**
     * Método que obtiene la hora actual en formato "HH:mm".
     * 
     * @return La hora actual en formato "HH:mm".
     */
    private String obtenerHoraActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(new Date());  // Devuelve la hora actual en formato "HH:mm"
    }
    
    /**
     * Método estático que guarda una tarea en un archivo de texto.
     * 
     * @param rutaRelativaArchivo La ruta relativa del archivo donde se guardará la tarea.
     * @param contenido El contenido a guardar en el archivo.
     */
    public static void guardarTarea(String rutaRelativaArchivo, String contenido) {
        BufferedWriter bufferEscritor = null;
        try {
            // Convertir la ruta relativa a una ruta absoluta
            String rutaAbsolutaArchivo = Paths.get(rutaRelativaArchivo).toAbsolutePath().toString();

            // Crear FileWriter en modo append (añadir contenido al final del archivo)
            FileWriter escritorArchivo = new FileWriter(rutaAbsolutaArchivo, true);
            bufferEscritor = new BufferedWriter(escritorArchivo);

            // Escribir el contenido en el archivo
            bufferEscritor.write(contenido);
            bufferEscritor.newLine(); // Añadir una nueva línea al final del contenido

            System.out.println("El archivo ha sido escrito exitosamente.");
        } catch (IOException e) {
            // Manejar la excepción si ocurre un error durante la escritura del archivo
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        } finally {
            // Cerrar BufferedWriter en el bloque finally
            if (bufferEscritor != null) {
                try {
                    bufferEscritor.close();
                } catch (IOException e) {
                    System.err.println("Ocurrió un error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }

    public JPanel getPAnel() {
        return this.panelCrear;
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
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelCrear;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNom1;
    private javax.swing.JTextField txtNom2;
    private javax.swing.JTextField txtNom3;
    private javax.swing.JTextField txtNom4;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNuevaTarea;
    private javax.swing.JLabel txtPrioridad;
    // End of variables declaration//GEN-END:variables
}
