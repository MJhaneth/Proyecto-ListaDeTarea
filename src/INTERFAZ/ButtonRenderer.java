package INTERFAZ;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * La clase ButtonRenderer implementa un renderizador personalizado para celdas de una tabla (JTable).
 * Su objetivo es mostrar un conjunto de botones con íconos dentro de una celda de la tabla.
 * Los botones están diseñados para ser interactivos y tener un diseño circular.
 */
public class ButtonRenderer implements TableCellRenderer {

    /**
     * Panel principal que contendrá los botones dentro de la celda.
     */
    private JPanel panel;

    /**
     * Constructor de la clase ButtonRenderer.
     * Configura el panel principal con un diseño de cuadrícula (GridLayout) y un fondo blanco.
     */
    public ButtonRenderer() {
        // Crear el panel y configurar el layout con GridLayout para asegurar la distribución correcta de los botones
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 5, 5)); // GridLayout con 1 fila y 3 columnas
        panel.setBackground(Color.WHITE); // De forma predeterminada, el panel tendrá color blanco
    }

    /**
     * Método sobrescrito para personalizar el renderizado de celdas.
     * Agrega un conjunto de botones al panel según la celda que se está renderizando.
     *
     * @param table      La tabla que contiene la celda.
     * @param value      El valor de la celda.
     * @param isSelected Verdadero si la celda está seleccionada.
     * @param hasFocus   Verdadero si la celda tiene el foco.
     * @param row        Fila de la celda.
     * @param column     Columna de la celda.
     * @return Un componente que representa la celda renderizada.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        panel.removeAll(); // Limpiar el panel antes de agregar los botones

        // Crear los botones sin texto, solo con íconos
        JButton editButton = createCustomButton("/Imagenes/boligrafo.png");
        JButton deleteButton = createCustomButton("/Imagenes/borrar.png");
        JButton addButton = createCustomButton("/Imagenes/bloc-de-notas.png");
        
        // Agregar los botones al panel
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(addButton);

        // Establecer el color de fondo del panel de acuerdo al estado de la celda
        Color backgroundColor = isSelected ? table.getSelectionBackground() : table.getBackground();
        panel.setBackground(backgroundColor);

        // Redibujar el panel para asegurarse de que se muestre correctamente
        panel.revalidate();
        panel.repaint();

        return panel;
    }

    /**
     * Crea un botón personalizado con un ícono especificado.
     *
     * @param imagePath La ruta relativa al recurso de la imagen que se usará como ícono.
     * @return Un botón personalizado con el ícono y un diseño circular.
     */
    private JButton createCustomButton(String imagePath) {
        JButton button = new JButton();
        
        // Cargar la imagen
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        
        // Establecer el ícono redimensionado en el botón
        button.setIcon(new ImageIcon(image));
        
        // Cambiar el tamaño de los botones
        Dimension buttonSize = new Dimension(40, 40); // Ancho y alto de 40px (ajustar según sea necesario)
        button.setPreferredSize(buttonSize);
        
        // Cambiar el tamaño de la fuente a un valor muy pequeño para que no aparezca texto (aunque no debería tener texto)
        button.setFont(new Font("Arial", Font.BOLD, 1));

        // Hacer que el botón tenga forma circular
        button.setBorder(BorderFactory.createEmptyBorder()); // Eliminar borde
        button.setContentAreaFilled(false); // Eliminar el fondo del botón
        button.setOpaque(false); // Hacerlo transparente
        button.setFocusPainted(false); // Eliminar el borde cuando se selecciona

        // Establecer la forma circular (recorte circular en el botón)
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                // Redondear el borde del botón para que sea circular
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(c.getBackground());
                g2d.fillOval(0, 0, button.getWidth(), button.getHeight());
                super.paint(g, c);
            }
        });
        
        return button;
    }
}
