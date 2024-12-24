package INTERFAZ;

import static INTERFAZ.Menu.leerArchivo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * La clase MenuAdmin gestiona la interfaz gráfica del menú principal para el 
 * administrador de la aplicación. En este menú, el administrador puede
 * visualizar y administrar las tareas, ver información relacionada con las 
 * fechas y personalizar la vista de la tabla de tareas.
 * 
 */
public class MenuAdmin extends javax.swing.JFrame {

    String admin;
    private List<String> usuarios;

        /**
     * Constructor de la clase MenuAdmin.
     * 
     * Este constructor inicializa la interfaz gráfica para el menú del administrador, 
     * establece el nombre del administrador, carga las tareas y fechas asociadas, 
     * y personaliza la cabecera de la tabla de tareas.
     * 
     * @param admin El nombre del administrador que ha iniciado sesión.
     */
    public MenuAdmin(String admin) {
        this.admin = admin;
        initComponents();
        this.adminField.setText("Admin: " + admin);
        cargarTareas();
        cargarFechas();
        setHeaderStyle();
    }
    
    // Método para personalizar la cabecera
    private void setHeaderStyle() {
        JTableHeader header = Tabla1.getTableHeader(); // Obtén el encabezado de la tabla
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
        Tabla1.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
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
        Tabla1.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        VentanaAdmi = new javax.swing.JPanel();
        adminField = new javax.swing.JLabel();
        txtBuscar2 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        eliminarButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FiltrarEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        FiltrarPrioridad = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        VentanaAdmi.setBackground(new java.awt.Color(153, 204, 255));
        VentanaAdmi.setPreferredSize(new java.awt.Dimension(1044, 600));

        adminField.setText("admin");

        txtBuscar2.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        Tabla1.setBackground(new java.awt.Color(204, 255, 204));
        Tabla1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "ID", "USUARIO", "TAREA", "DESCRIPCIÓN", "PRIORIDAD", "ESTADO", "ACCIÓN", "FECHA FIN"
            }
        ));
        Tabla1.setRowHeight(35);
        jScrollPane1.setViewportView(Tabla1);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(236, 341));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seguro.png"))); // NOI18N

        txt2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Lista de Usuarios");

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(204, 255, 255));
        jButton2.setText("Designar Tarea");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lista-de-verificacion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 222, Short.MAX_VALUE))))
        );

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Usuarios Activos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Estado:");

        FiltrarEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FiltrarEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Por Hacer", "En Progreso", "Completada" }));
        FiltrarEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrarEstadoItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Prioridad:");

        FiltrarPrioridad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FiltrarPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Baja", "Media", "Alta" }));
        FiltrarPrioridad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltrarPrioridadItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout VentanaAdmiLayout = new javax.swing.GroupLayout(VentanaAdmi);
        VentanaAdmi.setLayout(VentanaAdmiLayout);
        VentanaAdmiLayout.setHorizontalGroup(
            VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaAdmiLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaAdmiLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jToggleButton1)
                        .addGap(175, 175, 175)
                        .addComponent(eliminarButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(VentanaAdmiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VentanaAdmiLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FiltrarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FiltrarPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(VentanaAdmiLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                            .addGroup(VentanaAdmiLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );
        VentanaAdmiLayout.setVerticalGroup(
            VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaAdmiLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaAdmiLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(VentanaAdmiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(FiltrarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(FiltrarPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VentanaAdmiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(eliminarButton))
                .addGap(18, 18, 18))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        getContentPane().add(VentanaAdmi, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        // TODO add your handling code here:
        this.dispose();
        new Loggin();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Crear una instancia de la ventana DesignarTarea
        DesignarTarea designarTarea = new DesignarTarea();
        // Hacer visible la nueva ventana
        designarTarea.setVisible(true);
        // Opcional: Cerrar la ventana actual si quieres que no se pueda interactuar con ambas
        // this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void FiltrarEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrarEstadoItemStateChanged
        
       String query = FiltrarEstado.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelo);
        Tabla1.setRowSorter(tr);
        
        if(query != ""){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            Tabla1.setRowSorter(tr);
        }
    }//GEN-LAST:event_FiltrarEstadoItemStateChanged

    private void FiltrarPrioridadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltrarPrioridadItemStateChanged
        String query = FiltrarPrioridad.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelo);
        Tabla1.setRowSorter(tr);
        
        if(query != ""){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            Tabla1.setRowSorter(tr);
        }
    }//GEN-LAST:event_FiltrarPrioridadItemStateChanged

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        // boton de buscar
        // Obtener el texto escrito en el campo txtBuscar
    String textoBusqueda = txtBuscar2.getText().trim();

    // Verificar si el campo no está vacío
    if (!textoBusqueda.isEmpty()) {
        // Filtrar las tareas que contienen el texto escrito en alguna columna (por ejemplo, en el nombre o descripción)
        List<String[]> tareasFiltradas = buscarTareas(textoBusqueda);

        // Limpiar la tabla antes de agregar las tareas filtradas
        DefaultTableModel modelo = (DefaultTableModel) this.Tabla1.getModel();
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

    public List<String[]> buscarTareas(String textoBusqueda) {
    // Lista para almacenar las tareas que coinciden con la búsqueda
    List<String[]> tareasFiltradas = new ArrayList<>();
    
    // Ruta del directorio que contiene los archivos de los usuarios
    String directorioUsuarios = "src/usuarios/";

    // Obtener los archivos en el directorio de usuarios
    File dir = new File(directorioUsuarios);
    File[] archivos = dir.listFiles((d, nombre) -> nombre.endsWith(".txt")); // Filtra solo archivos .txt

    if (archivos != null) {
        // Recorrer todos los archivos de los usuarios
        for (File archivo : archivos) {
            List<String[]> todasLasTareas = leerArchivo(archivo.getPath()); // Leer el archivo de tareas de cada usuario

            // Recorrer las tareas del archivo
            for (String[] tarea : todasLasTareas) {
                // Buscar el texto en las columnas (por ejemplo, en el nombre y la descripción)
                String nombreTarea = tarea[2]; // Nombre de la tarea (columna 2)
                String descripcionTarea = tarea[3]; // Descripción de la tarea (columna 3)

                // Verificar si el texto de búsqueda está contenido en el nombre o descripción de la tarea
                if (nombreTarea.toLowerCase().contains(textoBusqueda.toLowerCase()) ||
                    descripcionTarea.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                    tareasFiltradas.add(tarea);
                }
            }
        }
    }

    return tareasFiltradas;
}
    //devuelve una lista de admins
public List<String[]> filtrarTareas(String prioridad, String estado) {
    // Lista para almacenar las tareas filtradas
    List<String[]> tareasFiltradas = new ArrayList<>();
    
    // Ruta del directorio que contiene los archivos de los usuarios
    String directorioUsuarios = "src/usuarios/";

    // Obtener los archivos en el directorio de usuarios
    File dir = new File(directorioUsuarios);
    File[] archivos = dir.listFiles((d, nombre) -> nombre.endsWith(".txt")); // Filtra solo archivos .txt

    if (archivos != null) {
        // Recorrer todos los archivos de los usuarios
        for (File archivo : archivos) {
            List<String[]> todasLasTareas = leerArchivo(archivo.getPath()); // Leer el archivo de tareas de cada usuario

            // Recorrer las tareas del archivo
            for (String[] tarea : todasLasTareas) {
                // Verificar que la tarea tiene al menos 6 columnas (o la cantidad mínima necesaria)
                if (tarea.length >= 6) {
                    String prioridadTarea = tarea[4]; // La prioridad está en la columna 4 (índice 4)
                    String estadoTarea = tarea[5]; // El estado está en la columna 5 (índice 5)

                    // Verificar si la tarea coincide con los filtros
                    if ((prioridad.equals("") || prioridadTarea.equals(prioridad)) &&
                        (estado.equals("") || estadoTarea.equals(estado))) {
                        tareasFiltradas.add(tarea);
                    }
                } else {
                    // Si la tarea tiene menos de 6 columnas, intentar manejarlo adecuadamente
                    System.out.println("Tarea con formato incompleto (menos de 6 columnas): " + Arrays.toString(tarea));
                    // Podrías decidir si agregar estas tareas incompletas a la lista de tareas filtradas o no
                }
            }
        }
    }

    return tareasFiltradas;
}
    
    //devuelve una lista de admins
    public void cargarTareas() {
        usuarios = new ArrayList<>();
        usuarios = listaUsuarios("src/data/users.txt");
        System.out.println(usuarios.size());
        for(String fila: usuarios){
            
        agregarDatos((DefaultTableModel) this.Tabla1.getModel(), fila);
        }
      //    agregarDatos((DefaultTableModel) this.Tabla.getModel(), "lucas");
    }

    // Método para agregar datos al modelo de la tabla
    public void agregarDatos(DefaultTableModel modelo, String user) {
        // Datos de ejemplo

        List<String[]> datos2 = new ArrayList<>();
        datos2 = leerArchivo("src/usuarios/" + user + ".txt");
        // Agregar cada fila al modelo de la tabla
        for (Object[] fila : datos2) {
            modelo.addRow(fila);
        }
    }

    public List<String[]> leerArchivo(String rutaRelativaArchivo) {
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
    
    private void cargarFechas() {
    // Ruta principal donde se encuentran las carpetas de los usuarios
    String baseDirectory = "C:\\Users\\Lenovo\\Downloads\\ListaTarea\\ListaTarea\\src\\date";

    // Crear un objeto File que represente el directorio base
    File baseDir = new File(baseDirectory);

    // Verificar si el directorio existe
    if (!baseDir.exists() || !baseDir.isDirectory()) {
        System.out.println("El directorio base no existe o no es un directorio válido.");
        return;
    }

    // Obtener todas las carpetas dentro del directorio base
    File[] userDirs = baseDir.listFiles(File::isDirectory);

    // Verificar si existen carpetas de usuarios
    if (userDirs == null || userDirs.length == 0) {
        System.out.println("No se encontraron carpetas de usuarios.");
        return;
    }

    // Iterar sobre cada carpeta de usuario
    for (File userDir : userDirs) {
        // Ruta del archivo de fechas para cada usuario
        String filePathWithFechas = userDir.getPath() + "\\tareas.txt";

        // Verificar si el archivo de fechas existe
        File file = new File(filePathWithFechas);
        if (!file.exists()) {
            System.out.println("El archivo de fechas no existe para el usuario: " + userDir.getName());
            continue; // Continuar con el siguiente usuario si el archivo no existe
        }

        // Leer el archivo de fechas
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
                    for (int i = 0; i < Tabla1.getRowCount(); i++) {
                        String tableId = Tabla1.getValueAt(i, 0).toString();    // ID en la tabla

                        // Comparar solo el ID de la tarea de la tabla con el del archivo de fechas
                        if (taskId.equals(tableId)) {
                            // Si hay coincidencia, actualizar la columna "Fecha" (índice 6) con la Fecha y Hora concatenadas
                            Tabla1.setValueAt(fechaHoraFin, i, 7);  // La columna "Fecha" tiene el índice 6
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de fechas para el usuario " 
                    + userDir.getName() + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private List<String> listaUsuarios(String rutaRelativaArchivo) {
        List<String> lineas = new ArrayList<>();
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
                lineas.add(datos[0]);
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
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> FiltrarEstado;
    private javax.swing.JComboBox<String> FiltrarPrioridad;
    private javax.swing.JTable Tabla1;
    private javax.swing.JPanel VentanaAdmi;
    private javax.swing.JLabel adminField;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JToggleButton eliminarButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel txt2;
    private javax.swing.JTextField txtBuscar2;
    // End of variables declaration//GEN-END:variables
}
