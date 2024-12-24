package INTERFAZ;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que es el identificador de usuario
 */
public class Loggin implements ActionListener { //atributos de cada clase
    JFrame frame = new JFrame("Iniciar Sesión");
    JLabel iniciarSesion = new JLabel("INICIAR SESION");
    JLabel usuarioLabel = new JLabel("Usuario: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField usuarioField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton registrarseButton = new JButton("Registrarse");
    JButton accederButton = new JButton("Acceder");
    JButton cancelarButton = new JButton("Cancelar"); // Nuevo botón
    JButton AdminButton = new JButton("Admin"); // Nuevo botón
    
    HashMap<String, String> usersDB = new HashMap<>();


    public Loggin() {
        loadUsers();
        initComponents(); 
    }
     /**
     * Inicializa los componentes de la interfaz gráfica.
     */
    private void initComponents() { //atributos de cada clase
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        iniciarSesion.setBounds(120, 20, 156, 29);//posición y estilo de los componentes
        iniciarSesion.setFont(new Font("Arial", Font.BOLD, 20));
        
        usuarioLabel.setBounds(50, 70, 100, 30); //etiquetas y campos
        usuarioField.setBounds(150, 70, 200, 30);

        passwordLabel.setBounds(50, 120, 100, 30);
        passwordField.setBounds(150, 120, 200, 30);

        registrarseButton.setBounds(50, 180, 120, 30);
        accederButton.setBounds(200, 180, 120, 30);
        cancelarButton.setBounds(125, 220, 120, 30);
        
        AdminButton.setBounds(10, 10, 100, 30);
        AdminButton.addActionListener(this);
        registrarseButton.addActionListener(this); // Asignar acciones a los botones
        accederButton.addActionListener(this);
        cancelarButton.addActionListener(e -> frame.dispose()); 
        
        frame.add(AdminButton);
        frame.add(iniciarSesion); // Agregar componentes al marco
        frame.add(usuarioLabel);
        frame.add(usuarioField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(registrarseButton);
        frame.add(accederButton);
        frame.add(cancelarButton);
        
        frame.setVisible(true);
    }
    /**
     * Carga los usuarios desde un archivo.
     */
    private void loadUsers() { // Carga de archivos (como nombres,apellidos)
                   String rutaAbsolutaArchivo = Paths.get("src/data/users.txt").toAbsolutePath().toString();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaAbsolutaArchivo))) {
            String line;
            usersDB.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    usersDB.put(parts[0], parts[1]);
                }  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {  //Manejo de acciones como(las funcionavilidades de cada boton y mensajes de cada funcion o actividad realizada)
        if (e.getSource() == accederButton) {
            
            String user = usuarioField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            if (!usersDB.containsKey(user)) {
                JOptionPane.showMessageDialog(frame, " No  existe el usuario.");
            } else if (!usersDB.get(user).equals(pass)) {
                JOptionPane.showMessageDialog(frame, "Error en la contraseña del usuario.");
            } else {
                JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso");
               frame.dispose();
                new Menu(user).setVisible(true);
            }
        } else if (e.getSource() == registrarseButton) {
            frame.dispose();
            new Register();
        }
        if(e.getSource() == AdminButton){
            System.out.println("adminnnnnn");
            new Admin().setVisible(true);
           frame.dispose();
        }
        
    }
  /**
     * Recarga la lista de usuarios mientras la aplicación está en ejecución.
     */
    public void refreshUsers() { // metodo para cargar las listas mientras enta en ejecucion.
        loadUsers();
    }
    
    
   /**
     * Controla la visibilidad del marco.
     *
     * @param visible True para mostrar el marco, False para ocultarlo.
     */
    public void setVisible(boolean visible) { // controlar la visividad del marco.
        frame.setVisible(visible);
    }
}
