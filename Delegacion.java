import java.util.*;
/**
 * La clase Delegacion representa a un grupo de individuos que visitan juntos.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Delegacion extends Visitante {
    //V.I
    ArrayList<Individuo> individuos;

    //CONSTRUCTOR
    /**
     * Crea una delegacion con su lista de individuos, nombre y fecha de visita.
     * @param p_individuos lista de individuos que componen la delegacion
     * @param p_nombre nombre de la delegacion
     * @param p_fechaVisita fecha de visita
     */
    public Delegacion(ArrayList<Individuo> p_individuos,
                    String p_nombre, Calendar p_fechaVisita) {
        super(p_nombre, p_fechaVisita);   
        this.setIndividuos(p_individuos);             
    }

    //SETTERS
    private void setIndividuos(ArrayList<Individuo> p_individuos) {
        this.individuos = p_individuos;
    }
    //GETTERS
    public ArrayList<Individuo> getIndividuos() {
        return this.individuos;
    }

    //METODOS PARA EL MANEJO DE INDIVIDUOS
    public void inscribirIndividuo(Individuo p_individuo) {
        if(!this.getIndividuos().contains(p_individuo)) {
            this.getIndividuos().add(p_individuo);
            System.out.println("¡Individuo inscripto en la delegacion con exito!.");
        }
        else {
            System.out.println("El individuo ya se encuentra inscripto en la delegacion.");
        }     
    }
    public boolean eliminarIndividuo(Individuo p_individuo) {
        return this.getIndividuos().remove(p_individuo);
    }
    public int cantidadIntegrantes() {
        return this.getIndividuos().size();
    }
    public Individuo obtenerIndividuo(int p_indice) {
        return this.getIndividuos().get(p_indice);
    }
    public Individuo obtenerIndividuo(String p_nombre) {
        for (Individuo unIndividuo : this.getIndividuos()) {
            if (unIndividuo.getNombre().equalsIgnoreCase(p_nombre)) {
                return unIndividuo;
            }
        }
        return null;
    }

    //METODOS DE COMPORTAMIENTO
    /**
     * Devuelve el tipo de visitante "delegacion".
     * @return el tipo de visitante en formato String
     */
    @Override
    public String tipoVisitante() {
        return "Delegacion";
    }

    /**
     * Calcula y devuelve el monto de entrada de la delegacion con un descuento del 10%.
     * @return el monto de entrada en formato double
     */
    @Override
    public double entrada() {
        int suma = 0;
        for (Individuo unIndividuo : this.getIndividuos()) {
            suma += unIndividuo.entrada();
        }
        return suma - (suma * 0.1); //Descuento del 10%
    }

    /**
     * Lista a los individuos de la delegacion.
     * @return un conjunto de objetos Personas
     */
    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<Persona>();
        for (Individuo unIndividuo : this.getIndividuos()) {
            personas.add(unIndividuo.getPersona());
        }
        return personas;
    }

    /**
     * Muestra la informacion de la delegacion en el caso de haber 
     * sido visitante en una fecha determinada.
     * @param p_fecha la fecha a consultar
     * @param p_visitante el tipo de visitante a consultar
     */
    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        for(Individuo unIndividuo : this.getIndividuos()) {
            if (unIndividuo.getFechaVisita().equals(p_fecha) && 
                unIndividuo.getNombre().equalsIgnoreCase(p_visitante)) {
                mostrar();
            }
        }
    }

    /**
     * Muestra la informacion de la delegacion y sus integrantes.
     */
    @Override
    public void mostrar() {
        
        System.out.println("Delegacion: " + this.getNombre());
        System.out.println("Integrantes:");
        System.out.println("...............................");
        for (Individuo unIndividuo : this.getIndividuos()) {
            unIndividuo.mostrar();
            System.out.println("...............................");
        }
        System.out.println("Cantidad de integrantes: " + this.cantidadIntegrantes());
        System.out.println("Monto total de entrada (-10%): $" + this.entrada());
    }

}
