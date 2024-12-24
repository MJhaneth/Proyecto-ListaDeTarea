
package INTERFAZ;

/**
 * Es clase principal que se ejecuta y abre el programa.
 * 
 */
public class main {
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Loggin().setVisible(true);
            }
        });
        }
}
