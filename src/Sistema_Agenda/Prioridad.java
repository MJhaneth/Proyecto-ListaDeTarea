package Sistema_Agenda;

/**
 * La clase Prioridad representa el nivel de prioridad de una tarea dentro de un sistema de agenda.
 * Los niveles de prioridad posibles son: "Baja", "Media" y "Alta".
 * Esta clase permite gestionar y consultar la prioridad actual de una tarea.
 */
public class Prioridad {
    private boolean Baja;
    private boolean Media;
    private boolean Alta;

    /**
     * Constructor por defecto.
     * Inicializa la prioridad como "Alta".
     */
    public Prioridad() {
        this.Baja = false;
        this.Media = false;
        this.Alta = true;
    }

    /**
     * Constructor parametrizado.
     * Permite inicializar la prioridad con valores personalizados.
     * 
     * @param alta indica si la prioridad es alta.
     * @param media indica si la prioridad es media.
     * @param baja indica si la prioridad es baja.
     */
    public Prioridad(boolean alta, boolean media, boolean baja) {
        this.Baja = baja;
        this.Media = media;
        this.Alta = alta;
    }

    /**
     * Verifica si la prioridad es "Baja".
     * 
     * @return true si la prioridad es "Baja"; false en caso contrario.
     */
    public boolean isBaja() {
        return Baja;
    }

    /**
     * Establece la prioridad como "Baja".
     * 
     * @param Baja nuevo valor para la prioridad "Baja".
     */
    public void setBaja(boolean Baja) {
        this.Baja = Baja;
    }

    /**
     * Verifica si la prioridad es "Media".
     * 
     * @return true si la prioridad es "Media"; false en caso contrario.
     */
    public boolean isMedia() {
        return Media;
    }

    /**
     * Establece la prioridad como "Media".
     * 
     * @param Media nuevo valor para la prioridad "Media".
     */
    public void setMedia(boolean Media) {
        this.Media = Media;
    }

    /**
     * Verifica si la prioridad es "Alta".
     * 
     * @return true si la prioridad es "Alta"; false en caso contrario.
     */
    public boolean isAlta() {
        return Alta;
    }

    /**
     * Establece la prioridad como "Alta".
     * 
     * @param Alta nuevo valor para la prioridad "Alta".
     */
    public void setAlta(boolean Alta) {
        this.Alta = Alta;
    }

    /**
     * Devuelve la prioridad actual como una cadena de texto.
     * 
     * @return "Alta", "Media" o "Baja" dependiendo de la prioridad actual.
     */
    public String getPrioridad() {
        if (this.Alta) {
            return "Alta";
        } else if (this.Baja) {
            return "Baja";
        } else {
            return "Media";
        }
    }

    /**
     * Convierte una cadena de texto a un objeto Prioridad.
     * 
     * @param prioridadStr cadena que representa la prioridad ("Alta", "Media" o "Baja").
     * @return un objeto Prioridad correspondiente a la cadena proporcionada.
     * @throws IllegalArgumentException si la cadena no coincide con una prioridad válida.
     */
    public static Prioridad valueOf(String prioridadStr) {
        Prioridad prioridad = new Prioridad(); // Se crea un objeto Prioridad por defecto

        if ("Alta".equalsIgnoreCase(prioridadStr)) {
            prioridad.setAlta(true);
            prioridad.setMedia(false);
            prioridad.setBaja(false);
        } else if ("Media".equalsIgnoreCase(prioridadStr)) {
            prioridad.setAlta(false);
            prioridad.setMedia(true);
            prioridad.setBaja(false);
        } else if ("Baja".equalsIgnoreCase(prioridadStr)) {
            prioridad.setAlta(false);
            prioridad.setMedia(false);
            prioridad.setBaja(true);
        } else {
            throw new IllegalArgumentException("Prioridad desconocida: " + prioridadStr);
        }

        return prioridad;
    }
}
