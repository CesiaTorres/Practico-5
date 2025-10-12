import java.util.*;
/**
 * La clase Visitante representa a un visitante con su nombre y fecha de visita.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public abstract class Visitante {
    //V.I
    private String nombre;
    private Calendar fechaVisita;

    //CONSTRUCTOR
    /**
     * Crea un visitante con su nombre y la fecha de visita.
     * @param p_nombre nombre del visitante
     * @param p_fechaVisita fecha de visita
     */
    public Visitante(String p_nombre, Calendar p_fechaVisita) {
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }
    //SETTERS
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setFechaVisita(Calendar p_fechaVisita) {
        this.fechaVisita = p_fechaVisita;
    }

    //GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public Calendar getFechaVisita() {
        return this.fechaVisita;
    }

    //METODOS
    /**
     * Muestra la informacion del visitante.
     */
    public abstract void mostrar();
    
    /**
     * Calcula y devuelve el monto de entrada del visitante.
     * @return el monto de entrada
     */
    public abstract double entrada();
    
    /**
     * Lista las visitas en una fecha determinada.
     * @param p_fecha la fecha a consultar
     * @param p_visitante visitante a consultar
     */
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);
    
    /**
     * Devuelve el tipo de visitante.
     * @return el tipo de visitante
     */
    public abstract String tipoVisitante();

    /**
     * Lista las personas asociadas a la visita.
     * @return un conjunto de personas asociadas
     */
    public abstract HashSet<Persona> listarPersonas();
}
