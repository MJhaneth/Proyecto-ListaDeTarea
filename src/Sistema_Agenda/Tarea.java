package Sistema_Agenda;

/**
 * La clase Tarea representa una tarea dentro de un sistema de agenda.
 * Cada tarea tiene un identificador único, un nombre, un usuario asignado,
 * una prioridad, una descripción y un estado.
 */
public class Tarea {
    private static int idContador = 0;  // Mantiene el contador de IDs incrementando
    private int id;
    private String nombre;
    private String usuario;
    private Prioridad prioridad;
    private String descripcion;
    private Estado estado;

    /**
     * Constructor que inicializa una tarea con valores específicos.
     * 
     * @param id identificador único de la tarea.
     * @param usuario usuario asignado a la tarea.
     * @param nombre nombre de la tarea.
     * @param descripcion descripción de la tarea.
     * @param prioridad nivel de prioridad de la tarea.
     * @param est estado actual de la tarea.
     */
    public Tarea(int id, String usuario, String nombre, String descripcion, Prioridad prioridad, Estado est) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = est;
    }

    /**
     * Constructor que inicializa una tarea utilizando cadenas para los atributos.
     * 
     * @param idStr identificador de la tarea como cadena.
     * @param nombreTarea nombre de la tarea.
     * @param estadoStr estado de la tarea como cadena.
     * @param descripcion descripción de la tarea.
     * @param usuario usuario asignado a la tarea.
     * @param prioridadStr prioridad de la tarea como cadena.
     * @param notas notas adicionales de la tarea.
     */
    public Tarea(String idStr, String nombreTarea, String estadoStr, String descripcion, String usuario, String prioridadStr, String notas) {
        this.id = Integer.parseInt(idStr);  // Convierte el String a int
        this.nombre = nombreTarea;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.prioridad = Prioridad.valueOf(prioridadStr);  // Convierte el String a Prioridad
        this.estado = Estado.valueOf(estadoStr);  // Convierte el String a Estado
    }

    /**
     * Obtiene el siguiente ID único para una tarea.
     * 
     * @return el siguiente ID como cadena de texto.
     */
    public static String Idsiguiente() {
        idContador++;  // Incrementamos el contador
        return String.valueOf(idContador);  // Devolvemos el siguiente ID como String
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado est) {
        this.estado = est;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una representación en forma de cadena de la tarea.
     * 
     * @return una cadena con los atributos de la tarea.
     */
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", usuario=" + usuario +
                ", prioridad=" + prioridad.getPrioridad() +
                ", descripcion=" + descripcion +
                ", estado=" + estado.getEstado() +
                '}';
    }

    /**
     * Devuelve los atributos de la tarea como una cadena separada por comas.
     * 
     * @return una cadena con los atributos de la tarea.
     */
    public String getAtributos() {
        return getId() + "," + getUsuario() + "," + getNombre() + "," + getDescripcion() + "," + prioridad.getPrioridad() + "," + estado.getEstado();
    }

    // Métodos aún no implementados

    public String getNombreTarea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNotas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
