
package INTERFAZ;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;  
import java.util.ArrayList;

/**
 * ButtonEditor es una clase que extiende DefaultCellEditor y permite la
 * edición de celdas en una tabla (JTable) mediante la incorporación de
 * botones. Cada celda puede tener botones para Editar, Eliminar y Agregar
 * notas.
 */
public class ButtonEditor extends DefaultCellEditor {
    private JPanel panel;
    private JButton editButton;
    private JButton deleteButton;
    private JButton addButton;
    private String label;
    private boolean isPushed;
    private JTable table;
    private String usuarioActual;

    /**
    * Constructor de ButtonEditor.
    *
    * @param checkBox      JCheckBox utilizado para inicializar el editor.
    * @param table         JTable al que pertenece este editor.
    * @param usuarioActual Nombre del usuario actual.
    */
    public ButtonEditor(JCheckBox checkBox, JTable table, String usuarioActual) {
        super(checkBox);
        this.table = table;
        this.usuarioActual = usuarioActual;

        // Crear un panel con un layout en grid para los botones
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 5, 5));  // 1 fila, 3 columnas

        // Crear los botones
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");
        addButton = new JButton("Agregar");

        // Agregar listeners a los botones
        editButton.addActionListener(e -> {
        isPushed = true;
        actualizarArchivo();
        fireEditingStopped(); // Detener la edición

        // Actualizar el archivo txt antes de mostrar la ventana de edición
        actualizarArchivo();
        // Obtener los valores de la fila seleccionada
        int row = table.getSelectedRow();
        String id = (table.getValueAt(row, 0) != null) ? table.getValueAt(row, 0).toString() : "";
        String nombre = (table.getValueAt(row, 2) != null) ? table.getValueAt(row, 2).toString() : "";
        String estado = (table.getValueAt(row, 5) != null) ? table.getValueAt(row, 5).toString() : "";
        String descripcion = (table.getValueAt(row, 3) != null) ? table.getValueAt(row, 3).toString() : "";
        String usuario = (table.getValueAt(row, 1) != null) ? table.getValueAt(row, 1).toString() : "";
        String prioridad = (table.getValueAt(row, 4) != null) ? table.getValueAt(row, 4).toString() : "";
        String notas = (table.getValueAt(row, 6) != null) ? table.getValueAt(row, 6).toString() : ""; // Default placeholder if no value is available


        // Crear una tarea con los datos obtenidos
        Tarea tarea = new Tarea(id, nombre, estado, descripcion, usuario, prioridad, notas);



        // Mostrar la ventana de edición con los datos de la tarea
        new EditarTarea(tarea) {
            @Override
            public void dispose() {
                super.dispose();
                // Actualizar el archivo después de editar

                cargarDatosTabla(table); // Recargar los datos de la tabla después de editar
            }
        }.setVisible(true);
    });

        deleteButton.addActionListener(e -> {
        isPushed = true;
        fireEditingStopped(); // Detener la edición

        // Obtener el ID de la tarea de la fila seleccionada
        int row = table.getSelectedRow();
        String idTarea = (table.getValueAt(row, 0) != null) ? table.getValueAt(row, 0).toString() : "";

        if (!idTarea.isEmpty()) {
            // Confirmar eliminación
            int confirmation = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar esta tarea?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                // Eliminar la tarea por ID
                eliminarTareaPorID(idTarea);
                cargarDatosTabla(table); // Recargar la tabla después de eliminar
                cargarFechas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una tarea para eliminar.");
        }
    });

      addButton.addActionListener(e -> {
          isPushed = true;
          fireEditingStopped();

          // Obtener la fila seleccionada
          int row = table.getSelectedRow();
          String idTarea = (table.getValueAt(row, 0) != null) ? table.getValueAt(row, 0).toString() : "";

          // Obtener las notas de la tarea correspondiente a ese ID
          String notas = getNotasFromId(idTarea); // Obtener notas de la tarea con el ID seleccionado

          // Si la tarea no tiene notas (es decir, tiene "sin notas" o es vacía)
          if (notas == null || notas.trim().isEmpty() || "sin notas".equals(notas)) {
              // Crear una ventana de diálogo para que el usuario ingrese nuevas notas
              String nuevasNotas = JOptionPane.showInputDialog(table, "Agregar notas:", "sin notas");

              // Si el usuario ha ingresado nuevas notas
              if (nuevasNotas != null && !nuevasNotas.trim().isEmpty()) {
                  // Actualizar las notas en el archivo
                  updateNotasInFile(idTarea, nuevasNotas);
              }
          } else {
              // Si la tarea ya tiene notas, permitir que el usuario las edite
              String nuevasNotas = JOptionPane.showInputDialog(table, "Editar notas:", notas);

              // Si el usuario ha ingresado nuevas notas
              if (nuevasNotas != null && !nuevasNotas.trim().isEmpty()) {
                  // Actualizar las notas en el archivo
                  updateNotasInFile(idTarea, nuevasNotas);
              }
          }

          // Recargar los datos de la tabla después de actualizar las notas
          cargarDatosTabla(table);  // Actualizar la tabla con los cambios
      });


          // Agregar los botones al panel
          panel.add(editButton);
          panel.add(deleteButton);
          panel.add(addButton);
      }


      /**
       * Configura el componente de la celda con los botones.
       */
      @Override
      public Component getTableCellEditorComponent(JTable table, Object value,
                                                   boolean isSelected, int row, int column) {
          label = (value == null) ? "" : value.toString();
          return panel; // Devuelve el panel con los botones
      }

      /**
     * Devuelve el valor de la celda editada.
     */
    @Override
    public Object getCellEditorValue() {
        return label;
    }

    // Obtener la ruta del archivo del usuario por su nombre (nombre de archivo)
    private String getFilePathForUser(String usuario) {
        String basePath = "src/usuarios/";
        return basePath + usuario + ".txt";
    }
 private void updateNotasInFile(String idTarea, String nuevasNotas) {
    String filePath ="src/usuarios/" + usuarioActual + ".txt";
    File archivo = new File(filePath);
    List<String> tareas = new ArrayList<>();

    try {
        // Leer el archivo línea por línea
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                tareas.add(linea); // Agregar cada línea a la lista
            }
        }
        br.close();

        // Buscar la tarea correspondiente al ID y agregar/actualizar las notas
        boolean tareaEncontrada = false;
        for (int i = 0; i < tareas.size(); i++) {
            String tareaLine = tareas.get(i);
            String[] partes = tareaLine.split(",");

            // Si encontramos el ID, actualizamos las notas
            if (partes.length >= 6 && partes[0].equals(idTarea)) {
                // Si no existe el campo de notas (menos de 7 columnas)
                if (partes.length < 7) {
                    // Agregar la columna de notas
                    tareas.set(i, String.join(",", partes) + ","+nuevasNotas);  // Si no existe el campo notas, agregarlo
                } else {
                    // Si el campo de notas ya existe, solo lo actualizamos
                    partes[6] = nuevasNotas;  // Modificamos las notas en la séptima columna
                    tareas.set(i, String.join(",", partes));  // Reemplazamos la tarea con las nuevas notas
                }
                tareaEncontrada = true;
                break;
            }
        }

        // Si no se encuentra la tarea, significa que la tarea no existe y podemos agregarla
        if (!tareaEncontrada) {
            // Aquí es necesario agregar la nueva tarea al archivo (si la tarea no se encuentra)
            // Suponiendo que si no está, se crea una nueva línea en el archivo
            String nuevaTarea = idTarea + ",w,pttt,dedes,MEDIA,Por hacer," + nuevasNotas;  // Agregar la nueva tarea con las notas
            tareas.add(nuevaTarea);
        }

        // Escribir las tareas actualizadas de nuevo al archivo
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false));
        for (String tareaStr : tareas) {
            bw.write(tareaStr);
            bw.newLine();
        }
        bw.close();

        JOptionPane.showMessageDialog(null, "Notas actualizadas con éxito.");
    } catch (IOException e) {
        e.printStackTrace();  // Manejar excepciones
    }
}

    // Cargar los datos de la tabla usando el archivo del usuario
  

    private void cargarDatosTabla(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Eliminar filas actuales

    String filePath = "src/usuarios/" + usuarioActual + ".txt";
    File archivo = new File(filePath);
    List<String> tareas = new ArrayList<>();

    try {
        // Leer el archivo línea por línea
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                tareas.add(linea); // Añadir cada línea a la lista
            }
        }
        br.close();

        // Añadir cada tarea al modelo de la tabla
        for (String tareaLine : tareas) {
            String[] partes = tareaLine.split(",");
            // Asegúrate de que la cantidad de columnas es correcta según tu modelo
            model.addRow(partes);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    // Método para actualizar el archivo
private void actualizarArchivo() {
    String filePath = "src/usuarios/" + usuarioActual + ".txt";
    File archivo = new File(filePath);
    List<String> tareas = new ArrayList<>();

    try {
        // Leer el archivo línea por línea
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                tareas.add(linea); // Agregar cada línea a la lista
            }
        }
        br.close();

        // Escribir las tareas actualizadas al archivo
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (String tareaStr : tareas) {
            bw.write(tareaStr);
            bw.newLine();
        }
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    // Obtener la tarea por ID
private Tarea obtenerTareaPorID(String idTarea) {
    actualizarArchivo();
    String filePath = "src/usuarios/" + usuarioActual + ".txt";
    File archivo = new File(filePath);

    if (archivo.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].equals(idTarea)) {
                    // Si la tarea existe, retornamos el objeto Tarea
                    String id = partes[0];
                    String nombre = (partes.length > 1) ? partes[1] : "";
                    String estado = (partes.length > 2) ? partes[2] : "";
                    String descripcion = (partes.length > 3) ? partes[3] : "";
                    String usuario = (partes.length > 4) ? partes[4] : "";
                    String prioridad = (partes.length > 5) ? partes[5] : "";
                    String notas = (partes.length > 6) ? partes[6] : "Sin notas";
                    return new Tarea(id, nombre, estado, descripcion, usuario, prioridad, notas);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return null;  // Si no se encuentra la tarea
}
private String getNotasFromId(String idTarea) {
    String filePath = "src/usuarios/"+ usuarioActual + ".txt";
    File archivo = new File(filePath);
    List<String> tareas = new ArrayList<>();
    String notas = "";

    try {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                tareas.add(linea); // Añadir cada línea a la lista
            }
        }
        br.close();

        // Buscar la tarea correspondiente al ID
        for (String tareaLine : tareas) {
            String[] partes = tareaLine.split(",");
            if (partes.length >= 7 && partes[0].equals(idTarea)) {
                notas = partes[6];  // Suponemos que las notas están en la séptima columna
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();  // Manejar excepciones
    }

    return notas;
}

   private void eliminarTareaPorID(String idTarea) {
    // Primero, eliminamos la tarea en el archivo del usuario actual
    String filePathUsuario = "src/usuarios/" + usuarioActual + ".txt";
    File archivoUsuario = new File(filePathUsuario);

    if (archivoUsuario.exists()) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoUsuario));
            List<String> lineasUsuario = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty() && !linea.startsWith(idTarea + ",")) {
                    lineasUsuario.add(linea); // Solo agregar líneas que no sean de la tarea a eliminar
                }
            }
            br.close();

            // Reenumeramos las tareas restantes (si es necesario)
            for (int i = 0; i < lineasUsuario.size(); i++) {
                String tarea = lineasUsuario.get(i);
                String[] partes = tarea.split(",");
                if (partes.length > 0) {
                    partes[0] = String.valueOf(i + 1);  // Asignamos un nuevo ID secuencial
                    lineasUsuario.set(i, String.join(",", partes)); // Actualizamos la tarea con el nuevo ID
                }
            }

            // Escribimos las tareas actualizadas de vuelta al archivo del usuario
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuario));
            for (String tarea : lineasUsuario) {
                bw.write(tarea);
                bw.newLine();
            }
            bw.close();

            // Ahora eliminamos la tarea en el archivo adicional
            String filePathTareas = "\\src\\date\\" + usuarioActual + "\\tareas.txt";
            File archivoTareas = new File(filePathTareas);

            if (archivoTareas.exists()) {
                BufferedReader brTareas = new BufferedReader(new FileReader(archivoTareas));
                List<String> lineasTareas = new ArrayList<>();
                while ((linea = brTareas.readLine()) != null) {
                    if (!linea.trim().isEmpty() && !linea.startsWith(idTarea + ",")) {
                        lineasTareas.add(linea); // Solo agregar líneas que no sean de la tarea a eliminar
                    }
                }
                brTareas.close();

                // Reenumeramos las tareas restantes en el archivo adicional
                for (int i = 0; i < lineasTareas.size(); i++) {
                    String tarea = lineasTareas.get(i);
                    String[] partes = tarea.split(",");
                    if (partes.length > 0) {
                        partes[0] = String.valueOf(i + 1);  // Asignamos un nuevo ID secuencial
                        lineasTareas.set(i, String.join(",", partes)); // Actualizamos la tarea con el nuevo ID
                    }
                }

                // Escribimos las tareas actualizadas de vuelta al archivo adicional
                BufferedWriter bwTareas = new BufferedWriter(new FileWriter(archivoTareas));
                for (String tarea : lineasTareas) {
                    bwTareas.write(tarea);
                    bwTareas.newLine();
                }
                bwTareas.close();
            }

            JOptionPane.showMessageDialog(null, "Tarea eliminada y actualizada en ambos archivos.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
private void cargarFechas() {
    // Ruta del archivo que contiene FechaFin y HoraFin
    String filePathWithFechas = "\\src\\date\\" + this.usuarioActual + "\\tareas.txt";

    // Verificar si el archivo de fechas existe antes de intentar cargarlo
    File file = new File(filePathWithFechas);
    if (!file.exists()) {
        // Si el archivo no existe, salimos del método y no intentamos cargar las fechas
        System.out.println("El archivo de fechas no existe para el usuario: " + this.usuarioActual);
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
                for (int i = 0; i < table.getRowCount(); i++) {
                    String tableId = table.getValueAt(i, 0).toString();    // ID en la tabla

                    // Comparar solo el ID de la tarea de la tabla con el del archivo de fechas
                    if (taskId.equals(tableId)) {
                        // Si hay coincidencia, actualizar la columna "Fecha" (índice 6) con la Fecha y Hora concatenadas
                        table.setValueAt(fechaHoraFin, i, 7);  // La columna "Fecha" tiene el índice 6
                    }
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al leer el archivo de fechas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    // Actualizar las notas de la tarea por ID
    private void actualizarNotasPorID(String idTarea, String nuevasNotas) {
        String filePath = "src/usuarios/" + usuarioActual + ".txt";
        File archivo = new File(filePath);

        if (archivo.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                List<String> lineas = new ArrayList<>();
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length > 6 && partes[0].equals(idTarea)) {
                        partes[6] = nuevasNotas;  // Actualizamos las notas
                        lineas.add(String.join(",", partes));  // Reemplazamos la tarea
                    } else {
                        lineas.add(linea);  // Mantener la tarea sin cambios
                    }
                }
                br.close();

                // Escribir las líneas actualizadas al archivo
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                for (String tarea : lineas) {
                    bw.write(tarea);
                    bw.newLine();
                }
                bw.close();
                JOptionPane.showMessageDialog(null, "Notas actualizadas con éxito.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para asignar el usuario actual
    public void setUsuarioActual(String usuario) {
        this.usuarioActual = usuario;
    }
}


