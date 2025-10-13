import java.util.*;
/**
 * La clase Individuo representa a un visitante individual con sus datos personales.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Individuo extends Visitante {
    //V.I
    private Persona persona;

    //CONSTRUCTOR
    /**
     * Crea un individuo con su nombre, fecha de visita y datos personales.
     * @param p_nombre nombre del individuo
     * @param p_fechaVisita fecha de visita
     * @param p_persona datos personales del individuo
     */
    public Individuo(String p_nombre, Calendar p_fechaVisita, 
                     Persona p_persona) {
        super(p_nombre, p_fechaVisita);
        this.setPersona(p_persona);
    }

    //SETTERS
    private void setPersona(Persona p_persona) {
        this.persona = p_persona;
    }

    //GETTERS
    public Persona getPersona() {
        return this.persona;
    }

    //METODOS
    /**
     * Devuelve el tipo de visitante "individuo".
     * @return el tipo de visitante en formato String
     */
    @Override
    public String tipoVisitante() {
        return "Individuo";
    }

    /**
     * Calcula y devuelve el monto de entrada del individuo.
     * @return el monto de entrada en formato double
     */
    @Override
    public double entrada() {
        return 10;
    }

    /**
     * Lista al individuo.
     * @return un conjunto de Personas compuesto por el individuo
     */
    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<Persona>();
        personas.add(this.getPersona());
        return personas;
    }
    
    /**
     * Muestra la informacion del individuo en el caso de haber 
     * sido visitante en una fecha determinada.
     * @param p_fecha la fecha a consultar
     * @param p_visitante el tipo de visitante a consultar
     */
    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
       if(this.getFechaVisita().equals(p_fecha) && this.tipoVisitante().equalsIgnoreCase(p_visitante)) {
           this.mostrar();
       }

    }

    /**
     * Muestra por pantalla la informacion del individuo.
     */
    @Override
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.getPersona().nomYApe() +
                           "\nDNI: " + this.getPersona().getNroDni() + "\tEdad: " +
                           this.getPersona().edad() + " años");
    }


}