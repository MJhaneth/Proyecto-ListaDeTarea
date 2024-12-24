
package INTERFAZ;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;  // Asegúrate de importar la lista de java.util
import java.util.ArrayList;

/**
 * ButtonEditor2 es una clase que extiende DefaultCellEditor y permite la
 * edición de celdas en una tabla (JTable) mediante la incorporación de
 * botones. Cada celda puede tener botones para Editar, Eliminar y Agregar
 * notas.
 */
public class ButtonEditor2 extends DefaultCellEditor {
    private JPanel panel;
    private JButton editButton;
    private JButton deleteButton;
    private JButton addButton;
    private String label;
    private boolean isPushed;
    private JTable table;
    
    /**
     * Constructor de ButtonEditor2.
     *
     * @param checkBox      JCheckBox utilizado para inicializar el editor.
     * @param table         JTable al que pertenece este editor.
     */
    public ButtonEditor2(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;

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

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        return panel; // Devuelve el panel con los botones
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }

    // Método para obtener todos los archivos de tareas
    private List<File> getAllTaskFiles() {
        String basePath = "src/usuarios/"; // Cambiar la ruta si es necesario
        File folder = new File(basePath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        return files != null ? Arrays.asList(files) : new ArrayList<>();
    }

    // Método para cargar todos los datos de la tabla desde los archivos de tareas
    private void cargarDatosTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Eliminar filas actuales

        List<File> taskFiles = getAllTaskFiles();
        for (File file : taskFiles) {
            List<String> tareas = readTareasFromFile(file);
            for (String tareaLine : tareas) {
                String[] partes = tareaLine.split(",");
                model.addRow(partes);
            }
        }
    }

    // Leer las tareas de un archivo específico
    private List<String> readTareasFromFile(File file) {
        List<String> tareas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    tareas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tareas;
    }

    // Actualizar el archivo de tareas
    private void actualizarArchivo() {
        List<File> taskFiles = getAllTaskFiles();
        for (File file : taskFiles) {
            List<String> tareas = readTareasFromFile(file);
            writeTareasToFile(file, tareas);
        }
    }

    // Escribir las tareas en el archivo
    private void writeTareasToFile(File file, List<String> tareas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String tareaStr : tareas) {
                bw.write(tareaStr);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Eliminar tarea por ID de todos los archivos
    private void eliminarTareaPorID(String idTarea) {
        List<File> taskFiles = getAllTaskFiles();
        for (File file : taskFiles) {
            List<String> tareas = readTareasFromFile(file);
            List<String> updatedTareas = new ArrayList<>();
            for (String tarea : tareas) {
                if (!tarea.startsWith(idTarea + ",")) {
                    updatedTareas.add(tarea);
                }
            }
            writeTareasToFile(file, updatedTareas);
        }
        JOptionPane.showMessageDialog(null, "Tarea eliminada.");
    }

    // Obtener las notas de una tarea por ID de todos los archivos
    private String getNotasFromId(String idTarea) {
        List<File> taskFiles = getAllTaskFiles();
        for (File file : taskFiles) {
            List<String> tareas = readTareasFromFile(file);
            for (String tareaLine : tareas) {
                String[] partes = tareaLine.split(",");
                if (partes[0].equals(idTarea)) {
                    return partes.length > 6 ? partes[6] : "sin notas";
                }
            }
        }
        return "sin notas";
    }

    // Actualizar las notas en todos los archivos
    private void updateNotasInFile(String idTarea, String nuevasNotas) {
        List<File> taskFiles = getAllTaskFiles();
        for (File file : taskFiles) {
            List<String> tareas = readTareasFromFile(file);
            List<String> updatedTareas = new ArrayList<>();
            for (String tarea : tareas) {
                String[] partes = tarea.split(",");
                if (partes[0].equals(idTarea)) {
                    if (partes.length < 7) {
                        updatedTareas.add(tarea + "," + nuevasNotas);
                    } else {
                        partes[6] = nuevasNotas;
                        updatedTareas.add(String.join(",", partes));
                    }
                } else {
                    updatedTareas.add(tarea);
                }
            }
            writeTareasToFile(file, updatedTareas);
        }
    }
}
