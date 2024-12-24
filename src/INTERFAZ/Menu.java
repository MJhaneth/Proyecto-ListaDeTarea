
package INTERFAZ;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter; 
import javax.swing.RowFilter;
/**
 * La clase Menu gestiona la interfaz gráfica y las funcionalidades principales
 * del menú de la aplicación. Permite al usuario visualizar y gestionar tareas,
 * con columnas para información como el ID, usuario, tarea, descripción,
 * prioridad, estado, acción y fecha. Además, incluye funcionalidades
 * de personalización de la tabla, filtrado de datos y manejo de eventos
 * relacionados con las tareas.
 * 
 */
public class Menu extends javax.swing.JFrame {
   

    String[] columnas = {"ID", "USUARIO", "TAREA", "DESCRIPCIÓN", "PRIORIDAD", "ESTADO", "ACCIÓN", "FECHA"}; // Crear una instancia de DefaultTableModel 
    DefaultTableModel modelo;
    private String usuario;

    /**
    * Constructor de la clase Menu.
    
    * @param usuario El nombre de usuario que ha iniciado sesión.
    */
    public Menu(String usuario) {
        this.usuario = usuario;
        modelo = new DefaultTableModel(columnas, 0); // Crear el JTable y asignar el modelo 
        initComponents();
        this.userLabel.setText("Usuario: " + usuario);
        initTable();
        botonEliminar();
        setHeaderStyle();
    }
    // Método para personalizar la cabecera
    private void setHeaderStyle() {
        JTableHeader header = Tabla.getTableHeader(); // Obtén el encabezado de la tabla
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                comp.setBackground(new Color(102, 204, 255)); // Color de fondo de la cabecera
                comp.setForeground(Color.BLACK); // Color del texto de la cabecera
                comp.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y tamaño de texto
                setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
                return comp;
            }
         });
        
        // Establecer el renderizado para la columna PRIORIDAD
        Tabla.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Cambiar el color del fondo según el valor de la columna
                if (value != null) {
                    if (value.toString().equalsIgnoreCase("Alta")) {
                        comp.setBackground(new Color(255, 102, 102)); 
                    } else if (value.toString().equalsIgnoreCase("Media")) {
                        comp.setBackground(new Color(255, 192, 0)); 
                    } else if (value.toString().equalsIgnoreCase("Baja")) {
                        comp.setBackground(new Color(148, 239, 251)); 
                        comp.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño de texto
                        setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
                    }
                }
                return comp;
            }
            
            
        });
        
         // Establecer el renderizado para la columna ESTADO
        Tabla.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Cambiar el color del fondo según el estado
                if (value != null) {
                    if (value.toString().equalsIgnoreCase("Completada")) {
                        comp.setBackground (new Color(3, 194, 91)); 
                    } else if (value.toString().equalsIgnoreCase("En Progreso")) {
                        comp.setBackground (new Color(170, 237, 99)); 
                    
                    } else if (value.toString().equalsIgnoreCase("Por Hacer")) {
                        comp.setBackground (new Color(255, 217, 102)); 
                    }
                    comp.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño de texto
                    setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
                }
                return comp;
            }
        });
       
    }
    
    private void initTable() {
        
     Tabla.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        Tabla.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), Tabla, this.usuario));
        //  Tabla.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        cargarTareas();
        cargarFechas();
    }

    private Icon getIconURL(String url, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource(url)).getImage().getScaledInstance(w, h, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        FiltrarEstado = new javax.swing.JComboBox<>();
        userLabel = new javax.swing.JLabel();
        eliminarButton = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        ListaTarea = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();
        CrearTarea = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        botonCrearTarea = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FiltrarPrioridad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 0));
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        Tabla.setBackground(new java.awt.Color(255, 255, 204));
        Tabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Tabla.setModel(modelo);
        Tabla.setRowHeight(35);
        Tabla.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TablaComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        txtBuscar.setForeground(new java.awt.Color(153, 153, 153));

        FiltrarEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FiltrarEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Por Hacer", "En Progreso", "Completada" }));
        FiltrarEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrarEstadoItemStateChanged(evt);
            }
        });
        FiltrarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarEstadoActionPerformed(evt);
            }
        });

        userLabel.setText("user");

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        ListaTarea.setName("ListaTarea"); // NOI18N
        ListaTarea.setOpaque(false);
        ListaTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaTareaMousePressed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista.png"))); // NOI18N

        txt4.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        txt4.setForeground(new java.awt.Color(255, 255, 255));
        txt4.setText("Lista de Tareas");
        txt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ListaTareaLayout = new javax.swing.GroupLayout(ListaTarea);
        ListaTarea.setLayout(ListaTareaLayout);
        ListaTareaLayout.setHorizontalGroup(
            ListaTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaTareaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        ListaTareaLayout.setVerticalGroup(
            ListaTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListaTareaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CrearTarea.setName("CrearTarea"); // NOI18N
        CrearTarea.setOpaque(false);
        CrearTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CrearTareaMousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pestana.png"))); // NOI18N

        botonCrearTarea.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        botonCrearTarea.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearTarea.setText("Crear Tarea");
        botonCrearTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCrearTareaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CrearTareaLayout = new javax.swing.GroupLayout(CrearTarea);
        CrearTarea.setLayout(CrearTareaLayout);
        CrearTareaLayout.setHorizontalGroup(
            CrearTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearTareaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(botonCrearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        CrearTareaLayout.setVerticalGroup(
            CrearTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearTareaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCrearTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial-de-pedidos.png"))); // NOI18N

        txt3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setText("Historial");
        txt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ListaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(ListaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pestana.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Estado:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Prioridad:");

        FiltrarPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FiltrarPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Baja", "Media", "Alta" }));
        FiltrarPrioridad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrarPrioridadItemStateChanged(evt);
            }
        });
        FiltrarPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarPrioridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jToggleButton1)
                        .addGap(29, 29, 29)
                        .addComponent(eliminarButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FiltrarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FiltrarPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(FiltrarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(FiltrarPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarButton)
                    .addComponent(jToggleButton1))
                .addGap(10, 10, 10))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refreshMenu(Menu menu){
     menu.dispose();
    menu = new Menu(menu.getUsuario());
    }
    private void TablaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TablaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaComponentAdded

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        // TODO add your handling code here:
        this.dispose();
        new Loggin();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt3MouseClicked
       

    }//GEN-LAST:event_txt3MouseClicked

    private void CrearTareaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearTareaMousePressed
       
    }//GEN-LAST:event_CrearTareaMousePressed

    //crear taream label 
    private void botonCrearTareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCrearTareaMouseClicked

        new CrearTarea(this).setVisible(true);

        System.out.println("crear tarea");
        System.out.println("ventana lanzada");
    }//GEN-LAST:event_botonCrearTareaMouseClicked

    private void ListaTareaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaTareaMousePressed
      
    }//GEN-LAST:event_ListaTareaMousePressed

    private void txt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt4MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_txt4MouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // boton de buscar
        // Obtener el texto escrito en el campo txtBuscar
    String textoBusqueda = txtBuscar.getText().trim();

    // Verificar si el campo no está vacío
    if (!textoBusqueda.isEmpty()) {
        // Filtrar las tareas que contienen el texto escrito en alguna columna (por ejemplo, en el nombre o descripción)
        List<String[]> tareasFiltradas = buscarTareas(textoBusqueda);

        // Limpiar la tabla antes de agregar las tareas filtradas
        DefaultTableModel modelo = (DefaultTableModel) this.Tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        // Agregar las tareas filtradas a la tabla
        for (String[] tarea : tareasFiltradas) {
            modelo.addRow(tarea);
            cargarFechas();
        }
    } else {
        // Si el campo de búsqueda está vacío, se muestran todas las tareas (cargarTareas se encarga de mostrar todas)
        cargarTareas();
        cargarFechas();
    }

    }//GEN-LAST:event_btnBuscarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new CrearTarea(this).setVisible(true);

        System.out.println("crear tarea");
        System.out.println("ventana lanzada");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void FiltrarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarEstadoActionPerformed
        
    }//GEN-LAST:event_FiltrarEstadoActionPerformed

    private void FiltrarPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarPrioridadActionPerformed
     
    }//GEN-LAST:event_FiltrarPrioridadActionPerformed

    private void FiltrarEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrarEstadoItemStateChanged
        String query = FiltrarEstado.getSelectedItem().toString();
        
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelo);
        Tabla.setRowSorter(tr);
        
        if(query != ""){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            Tabla.setRowSorter(tr);
        }
        
    }//GEN-LAST:event_FiltrarEstadoItemStateChanged

    private void FiltrarPrioridadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrarPrioridadItemStateChanged
        String query = FiltrarPrioridad.getSelectedItem().toString();
        
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelo);
        Tabla.setRowSorter(tr);
        
        if(query != ""){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            Tabla.setRowSorter(tr);
        }
    }//GEN-LAST:event_FiltrarPrioridadItemStateChanged


public List<String[]> filtrarTareas(String prioridad, String estado) {
    // boton de filtro
    List<String[]> tareasFiltradas = new ArrayList<>();
    List<String[]> todasLasTareas = leerArchivo("src/usuarios/" + usuario + ".txt");

    for (String[] tarea : todasLasTareas) {
        String prioridadTarea = tarea[4]; // La prioridad está en la columna 4
        String estadoTarea = tarea[5]; // El estado está en la columna 5

        // Verificar si la tarea coincide con los filtros
        if ((prioridad.equals("") || prioridadTarea.equals(prioridad)) &&
            (estado.equals("") || estadoTarea.equals(estado))) {
            tareasFiltradas.add(tarea);
        }
    }

    return tareasFiltradas;
}

public List<String[]> buscarTareas(String textoBusqueda) {
    // boton de buscador
    List<String[]> tareasFiltradas = new ArrayList<>();
    List<String[]> todasLasTareas = leerArchivo("src/usuarios/" + usuario + ".txt");

    for (String[] tarea : todasLasTareas) {
        // Buscar el texto en las columnas (por ejemplo, en el nombre y la descripción)
        String nombreTarea = tarea[2]; // Nombre de la tarea (columna 1)
        String descripcionTarea = tarea[3]; // Descripción de la tarea (columna 3)

        // Verificar si el texto de búsqueda está contenido en el nombre o descripción de la tarea
        if (nombreTarea.toLowerCase().contains(textoBusqueda.toLowerCase()) ||
            descripcionTarea.toLowerCase().contains(textoBusqueda.toLowerCase())) {
            tareasFiltradas.add(tarea);
        }
    }

    return tareasFiltradas;
}
    public void cargarTareas() {
        agregarDatos((DefaultTableModel) this.Tabla.getModel());
    }

    // Método para agregar datos al modelo de la tabla
    //cambie el static
    public void agregarDatos(DefaultTableModel modelo) {
        // Datos de ejemplo

        List<String[]> datos2 = new ArrayList<>();
        datos2 = leerArchivo("src/usuarios/" + usuario + ".txt");
        // Agregar cada fila al modelo de la tabla
        for (Object[] fila : datos2) {
            modelo.addRow(fila);
        }
    }

    public static List<String[]> leerArchivo(String rutaRelativaArchivo) {
        List<String[]> lineas = new ArrayList<>();
        BufferedReader br = null;

        try {
            // Convertir la ruta relativa a una ruta absoluta
            String rutaAbsolutaArchivo = Paths.get(rutaRelativaArchivo).toAbsolutePath().toString();

            // Crear BufferedReader para leer el archivo
            br = new BufferedReader(new FileReader(rutaAbsolutaArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                // Separar la línea por comas y agregarla a la lista
                String[] datos = linea.split(",");
                lineas.add(datos);
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        } finally {
            // Cerrar BufferedReader en el bloque finally
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Ocurrió un error al cerrar el archivo: " + e.getMessage());
                }
            }
        }

        return lineas;
    }

    private void botonEliminar() {

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = Tabla.getSelectedRow();
                System.out.println(selectedRow);
                if (selectedRow != -1) {
                    String dato = (String) Tabla.getValueAt(selectedRow, 0);
                    modelo.removeRow(selectedRow);
                    Eliminar2("src/usuarios/" + usuario + ".txt", selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
                }
            }
        });
    }

    public static List<String> getColumnData(TableModel model, int columnIndex) {
        List<String> columnData = new ArrayList<>();
        for (int row = 0; row < model.getRowCount(); row++) {
            columnData.add((String) model.getValueAt(row, columnIndex));
        }
        return columnData;
    }
    
    private void cargarFechas() {
    // Ruta del archivo que contiene FechaFin y HoraFin
    String filePathWithFechas = "C:\\Users\\Lenovo\\Downloads\\ListaTarea\\ListaTarea\\src\\date\\" + this.usuario + "\\tareas.txt";

    // Verificar si el archivo de fechas existe antes de intentar cargarlo
    File file = new File(filePathWithFechas);
    if (!file.exists()) {
        // Si el archivo no existe, salimos del método y no intentamos cargar las fechas
        System.out.println("El archivo de fechas no existe para el usuario: " + this.usuario);
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(filePathWithFechas))) {
        String line;

        // Procesar cada línea del archivo de fechas
        while ((line = reader.readLine()) != null) {
            // Dividir la línea en los detalles de la tarea (ID, Usuario, Nombre, FechaInicio, HoraInicio, FechaFin, HoraFin)
            String[] taskDetails = line.split(",");

            // Verificar si la línea tiene el número esperado de columnas (7 columnas)
            if (taskDetails.length == 7) {
                String taskId = taskDetails[0].trim();        // ID de la tarea
                String fechaFin = taskDetails[5].trim();      // FechaFin desde el archivo
                String horaFin = taskDetails[6].trim();       // HoraFin desde el archivo

                // Si FechaFin o HoraFin están vacíos, continuar con la siguiente tarea
                if (fechaFin.isEmpty() || horaFin.isEmpty()) continue;

                // Concatenar la fecha y la hora en un solo string para mostrar en la columna "Fecha"
                String fechaHoraFin = fechaFin + " " + horaFin;  // Ejemplo: 2024-12-19 16:43

                // Iterar sobre las filas de la tabla para encontrar las tareas que coincidan solo por ID
                for (int i = 0; i < Tabla.getRowCount(); i++) {
                    String tableId = Tabla.getValueAt(i, 0).toString();    // ID en la tabla

                    // Comparar solo el ID de la tarea de la tabla con el del archivo de fechas
                    if (taskId.equals(tableId)) {
                        // Si hay coincidencia, actualizar la columna "Fecha" (índice 6) con la Fecha y Hora concatenadas
                        Tabla.setValueAt(fechaHoraFin, i, 7);  // La columna "Fecha" tiene el índice 6
                    }
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de fechas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public static void Eliminar2(String filePath, int lineNumber) {
        File inputFile = new File(filePath);
        File tempFile = new File("src/usuarios/temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            int currentLineNumber = 0; // Se inicia el contador desde 0

            while ((currentLine = reader.readLine()) != null) {
                // Saltar la línea que queremos eliminar
                if (currentLineNumber != lineNumber) {
                    writer.write(currentLine);
                    writer.newLine();
                }
                currentLineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
        }

        // Eliminar el archivo original y renombrar el archivo temporal
        if (inputFile.delete()) {
            System.out.println("Archivo original eliminado");
            if (tempFile.renameTo(inputFile)) {
                System.out.println("Archivo temporal renombrado a original");
            } else {
                System.out.println("No se pudo renombrar el archivo temporal a original");
            }
        } else {
            System.out.println("No se pudo eliminar el archivo original");
        }
    }

    public JTable getTabla() {
        return this.Tabla;
    }

    public String getUsuario() {
        return usuario;
    }

    public JPanel getPanel() {
        return this.jPanel1;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CrearTarea;
    private javax.swing.JComboBox<String> FiltrarEstado;
    private javax.swing.JComboBox<String> FiltrarPrioridad;
    private javax.swing.JPanel ListaTarea;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel botonCrearTarea;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JToggleButton eliminarButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

}
