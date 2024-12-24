package INTERFAZ;

/**
 * Clase que representa una tarea con sus atributos principales.
 * Cada tarea tiene un ID único, nombre, estado, descripción, usuario asignado, prioridad y notas.
 */
public class Tarea {
    private static int idContador = 0;  // Mantiene el contador de IDs incrementando
    private String id;                 // Identificador único de la tarea
    private String nombre;             // Nombre de la tarea
    private String estado;             // Estado de la tarea (e.g., "Pendiente", "En Progreso", "Completada")
    private String descripcion;        // Descripción detallada de la tarea
    private String usuario;            // Usuario asignado a la tarea
    private String prioridad;          // Prioridad de la tarea (e.g., "Alta", "Media", "Baja")
    private String notas;              // Notas adicionales relacionadas con la tarea

    /**
     * Constructor de la clase Tarea.
     *
     * @param id Identificador único de la tarea.
     * @param nombre Nombre de la tarea.
     * @param estado Estado actual de la tarea.
     * @param descripcion Descripción detallada de la tarea.
     * @param usuario Usuario asignado a la tarea.
     * @param prioridad Prioridad de la tarea.
     * @param notas Notas adicionales relacionadas con la tarea.
     */
    public Tarea(String id, String nombre, String estado, String descripcion, String usuario, String prioridad, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.prioridad = prioridad;
        this.notas = notas;
    }

    // Métodos getters y setters

    /**
     * Obtiene el ID de la tarea.
     *
     * @return ID de la tarea.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID de la tarea.
     *
     * @param id Nuevo ID de la tarea.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la tarea.
     *
     * @return Nombre de la tarea.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la tarea.
     *
     * @param nombre Nuevo nombre de la tarea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el estado de la tarea.
     *
     * @return Estado de la tarea.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la tarea.
     *
     * @param estado Nuevo estado de la tarea.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la descripción de la tarea.
     *
     * @return Descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la tarea.
     *
     * @param descripcion Nueva descripción de la tarea.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el usuario asignado a la tarea.
     *
     * @return Usuario asignado a la tarea.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asignado a la tarea.
     *
     * @param usuario Nuevo usuario asignado a la tarea.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la prioridad de la tarea.
     *
     * @return Prioridad de la tarea.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Establece la prioridad de la tarea.
     *
     * @param prioridad Nueva prioridad de la tarea.
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Obtiene las notas adicionales de la tarea.
     *
     * @return Notas de la tarea.
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Establece las notas adicionales de la tarea.
     *
     * @param notas Nuevas notas de la tarea.
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Representa la tarea como una cadena de texto.
     *
     * @return Representación de la tarea con todos sus atributos.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Estado: " + estado + ", Descripción: " + descripcion +
                ", Usuario: " + usuario + ", Prioridad: " + prioridad + ", Notas: " + notas;
    }
}
