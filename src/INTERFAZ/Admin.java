package INTERFAZ;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Clase Admin que representa la interfaz gráfica para el inicio de sesión de administradores.
 * Proporciona métodos para cargar usuarios desde un archivo, manejar eventos de la interfaz y gestionar la autenticación.
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Base de datos de usuarios almacenada en un HashMap, donde la clave es el nombre de usuario y el valor es la contraseña.
     */
    HashMap<String, String> usersDB = new HashMap<>();

    /**
     * Constructor de la clase Admin.
     * Carga los usuarios desde un archivo y configura los componentes de la interfaz gráfica.
     */
    public Admin() {
        loadUsers();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Inicializa los componentes de la interfaz gráfica.
     * Este método es generado automáticamente por el diseñador de interfaces.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        acceder = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        adminField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel2.setText("Admin");

        userLabel.setText("Usuario :");

        passLabel.setText("Contraseña :");

        passwordField.setMinimumSize(new java.awt.Dimension(70, 22));
        passwordField.setPreferredSize(new java.awt.Dimension(70, 22));

        acceder.setText("Acceder");
        acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accederActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                                .addComponent(acceder))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(passLabel)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(adminField)
                                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(acceder))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción para el botón "Cancelar".
     * Cierra la ventana actual y abre la ventana de inicio de sesión.
     * 
     * @param evt El evento de acción generado al hacer clic en el botón.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.dispose();
        new Loggin();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Acción para el botón "Acceder".
     * Verifica las credenciales ingresadas y, si son correctas, abre la ventana de administración.
     * 
     * @param evt El evento de acción generado al hacer clic en el botón.
     */
    private void accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accederActionPerformed

        String user = this.adminField.getText().trim();
        String pass = new String(passwordField.getPassword()).trim();

        if (!usersDB.containsKey(user)) {
            JOptionPane.showMessageDialog(this, " No es Administrador o no existe.");
        } else if (!usersDB.get(user).equals(pass)) {
            JOptionPane.showMessageDialog(this, "Error en la contraseña del usuario.");
        } else {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            this.dispose();
            MenuAdmin admi = new MenuAdmin(this.adminField.getText());
            admi.setVisible(true);
        }
    }//GEN-LAST:event_accederActionPerformed

   
    /**
     * Carga los usuarios desde un archivo de texto y los almacena en el HashMap usersDB.
     * Cada línea del archivo debe tener el formato "usuario,contraseña".
     */
    private void loadUsers() { // Carga de archivos (como nombres,apellidos)
        String rutaAbsolutaArchivo = Paths.get("src/data/admin.txt").toAbsolutePath().toString();

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceder;
    private javax.swing.JTextField adminField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
