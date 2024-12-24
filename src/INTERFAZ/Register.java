/**
 * Clase para manejar el registro de nuevos usuarios mediante una interfaz gráfica.
 * Permite ingresar un nombre de usuario, contraseña y confirmar la contraseña.
 * También asigna roles de usuario (usuario o administrador) y guarda la información en un archivo.
 */
package INTERFAZ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Register implements ActionListener {

    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JFrame frame;
    private JComboBox<String> comboBox;

    /**
     * Constructor de la clase Register.
     * Inicializa la interfaz gráfica para el registro de nuevos usuarios.
     */
    public Register() {
        frame = new JFrame("Registrar Usuario");
        usuarioField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Guardar");
        JButton cancelButton = new JButton("Cancelar");

        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Etiquetas y campos de texto
        JLabel usuarioLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        JLabel confirmPasswordLabel = new JLabel("Confirme Contraseña:");

        usuarioLabel.setBounds(30, 20, 100, 30);
        usuarioField.setBounds(165, 20, 120, 30);
        passwordLabel.setBounds(30, 60, 100, 30);
        passwordField.setBounds(165, 60, 120, 30);
        confirmPasswordLabel.setBounds(30, 100, 150, 30);
        confirmPasswordField.setBounds(165, 100, 120, 30);

        // ComboBox para roles
        String[] items = {"usuario", "Administrador"};
        comboBox = new JComboBox<>(items);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                System.out.println("Item seleccionado: " + selectedItem);
            }
        });
        comboBox.setBounds(150, 150, 150, 25);

        // Botones
        registerButton.setBounds(30, 200, 120, 30);
        cancelButton.setBounds(160, 200, 120, 30);

        // Agregar componentes al marco
        frame.add(comboBox);
        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(registerButton);
        frame.add(cancelButton);

        // Configurar listeners
        registerButton.addActionListener(this);
        cancelButton.addActionListener(e -> frame.dispose());

        // Configuración final
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Maneja las acciones de los botones en la interfaz de registro.
     * Verifica las contraseñas y guarda el nuevo usuario en el archivo correspondiente.
     *
     * @param e El evento de acción generado por un botón.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = usuarioField.getText().trim();
        String contraseña = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        // Validar que las contraseñas coincidan
        if (!contraseña.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden. Inténtalo de nuevo.");
            return;
        }

        // Determinar el rol del usuario
        String rol = comboBox.getSelectedIndex() == 0 ? "users" : "admin";
        String rutaAbsolutaArchivo = Paths.get("src/data/" + rol + ".txt").toAbsolutePath().toString();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaAbsolutaArchivo, true))) {
            // Guardar usuario y contraseña
            escritor.write(usuario + "," + contraseña);
            escritor.newLine();
            escritor.flush();

            // Mensaje de éxito
            JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");

            // Crear directorio para el usuario
            crearDirectorio("src/usuarios/" + usuario + ".txt");

            // Cerrar la ventana y reiniciar la aplicación
            frame.dispose();
            new Loggin();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error al registrar el usuario.");
            ex.printStackTrace();
        }
    }

    /**
     * Crea un directorio o archivo para un usuario registrado.
     *
     * @param relativeFilePath La ruta relativa del archivo a crear.
     */
    public static void crearDirectorio(String relativeFilePath) {
        File file = new File(relativeFilePath);

        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs(); // Crear directorios si no existen
            }

            if (file.createNewFile()) {
                System.out.println("Archivo creado: " + file.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe o no se pudo crear: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
    }
}
