package Sistema_Agenda;

/**
 * La clase Estado representa el estado de una tarea dentro de un sistema de agenda.
 * Los estados posibles son: "Por Hacer", "En Progreso" y "Completada".
 * Esta clase permite gestionar y consultar el estado actual de una tarea.
 */
public class Estado {
    private boolean PorHacer;
    private boolean EnProgreso;
    private boolean Completada;

    /**
     * Constructor por defecto.
     * Inicializa el estado como "Por Hacer".
     */
    public Estado() {
        this.PorHacer = true;
        this.EnProgreso = false;
        this.Completada = false;
    }

    /**
     * Constructor parametrizado.
     * Permite inicializar el estado con valores personalizados.
     * 
     * @param completada indica si la tarea está completada.
     * @param enprogreso indica si la tarea está en progreso.
     * @param porhacer indica si la tarea está por hacer.
     */
    public Estado(boolean completada, boolean enprogreso, boolean porhacer) {
        this.PorHacer = porhacer;
        this.EnProgreso = enprogreso;
        this.Completada = completada;
    }

    /**
     * Verifica si el estado es "Por Hacer".
     * 
     * @return true si el estado es "Por Hacer"; false en caso contrario.
     */
    public boolean isPorHacer() {
        return PorHacer;
    }

    /**
     * Establece el estado como "Por Hacer".
     * 
     * @param PorHacer nuevo valor para el estado "Por Hacer".
     */
    public void setPorHacer(boolean PorHacer) {
        this.PorHacer = PorHacer;
    }

    /**
     * Verifica si el estado es "En Progreso".
     * 
     * @return true si el estado es "En Progreso"; false en caso contrario.
     */
    public boolean isEnProgreso() {
        return EnProgreso;
    }

    /**
     * Establece el estado como "En Progreso".
     * 
     * @param EnProgreso nuevo valor para el estado "En Progreso".
     */
    public void setEnProgreso(boolean EnProgreso) {
        this.EnProgreso = EnProgreso;
    }

    /**
     * Verifica si el estado es "Completada".
     * 
     * @return true si el estado es "Completada"; false en caso contrario.
     */
    public boolean isCompletada() {
        return Completada;
    }

    /**
     * Establece el estado como "Completada".
     * 
     * @param Completada nuevo valor para el estado "Completada".
     */
    public void setCompletada(boolean Completada) {
        this.Completada = Completada;
    }

    /**
     * Devuelve el estado actual como una cadena de texto.
     * 
     * @return "Completada", "Por Hacer" o "En Progreso" dependiendo del estado actual.
     */
    public String getEstado() {
        if (this.Completada) {
            return "Completada";
        } else if (this.PorHacer) {
            return "Por Hacer";
        } else {
            return "En Progreso";
        }
    }

    /**
     * Convierte una cadena de texto a un objeto Estado.
     * 
     * @param estadoStr cadena que representa el estado ("Por Hacer", "En Progreso" o "Completada").
     * @return un objeto Estado correspondiente a la cadena proporcionada.
     * @throws IllegalArgumentException si la cadena no coincide con un estado válido.
     */
    public static Estado valueOf(String estadoStr) {
        Estado estado = new Estado(); // Se crea un objeto Estado por defecto

        // Verifica los diferentes estados
        if ("Por Hacer".equalsIgnoreCase(estadoStr)) {
            estado.setPorHacer(true);
            estado.setEnProgreso(false);
            estado.setCompletada(false);
        } else if ("En Progreso".equalsIgnoreCase(estadoStr)) {
            estado.setPorHacer(false);
            estado.setEnProgreso(true);
            estado.setCompletada(false);
        } else if ("Completada".equalsIgnoreCase(estadoStr)) {
            estado.setPorHacer(false);
            estado.setEnProgreso(false);
            estado.setCompletada(true);
        } else {
            throw new IllegalArgumentException("Estado desconocido: " + estadoStr);
        }

        return estado;
    }
}
