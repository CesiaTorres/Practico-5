import java.util.*;
/**
 * La clase Zoologico representa a un zoologico con su nombre y una lista de visitantes.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Zoologico {
    //V.I
    private String nombre;
    ArrayList<Visitante> visitantes;

    //CONSTRUCTOR
    /**
     * Crea un zoologico con su nombre y una lista vacia de visitantes.
     * @param p_nombre nombre del zoologico
     */
    public Zoologico(String p_nombre) {
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList<Visitante>());
    }

    //SETTERS
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setVisitantes(ArrayList<Visitante> p_visitantes) {
        this.visitantes = p_visitantes;
    }
    //GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public ArrayList<Visitante> getVisitantes() {
        return this.visitantes;
    }

    //METODOS PARA EL MANEJO DE VISITANTES
    public void inscribirVisitante(Visitante p_visitante) {
        this.getVisitantes().add(p_visitante);
    }
    public boolean eliminarVisitante(Visitante p_visitante) {
        return this.getVisitantes().remove(p_visitante);
    }
    public int cantidadVisitantes() {
        return this.getVisitantes().size();
    }
    public Visitante obtenerVisitante(int p_indice) {
        return this.getVisitantes().get(p_indice);
    }
    public Visitante obtenerVisitante(String p_nombre) {
        for (Visitante unVisitante : this.getVisitantes()) {
            if (unVisitante.getNombre().equalsIgnoreCase(p_nombre)) {
                return unVisitante;
            }
        }
        return null;
    }

    //METODOS
    /**
     * Muestra la informacion de los visitantes que hayan sido de un tipo 
     * determinado en una fecha determinada.
     * @param p_fecha la fecha a consultar
     */
    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitante) {
        System.out.println("-------------***---------------");
        for(Visitante unVisitante : this.getVisitantes()) {
            if(unVisitante.getFechaVisita().equals(p_fecha) && 
               unVisitante.tipoVisitante().equalsIgnoreCase(p_tipoVisitante)) {
                unVisitante.mostrar();
                System.out.println("-------------------------------");
            }
        }
    }

    /**
     * Muestra la informacion de los visitantes que hayan sido 
     * visitantes en una fecha determinada.
     * @param p_fecha la fecha a consultar
     */
    public void listarVisitantePorFecha(Calendar p_fecha) {
        System.out.println();
        System.out.println("-------------***---------------");
        for(Visitante unVisitante : this.getVisitantes()) {
            if(unVisitante.getFechaVisita().equals(p_fecha)) {
                unVisitante.mostrar();
                System.out.println("-------------------------------");
            }
        }
    }

    /**
     * Lista todas las personas que hayan visitado el zoologico.
     * @return un conjunto de Personas
     */
    public HashSet<Persona> listarPersonasQueVisitaronElZoo() {
        HashSet<Persona> personas = new HashSet<Persona>();
        for(Visitante unVisitante : this.getVisitantes()) {
            personas.addAll(unVisitante.listarPersonas());
            /* addAll mete todos los individuos de una delegacion
                a la coleccion como elementos separados*/
        }
        return personas;
    }

    /**
     * Calcula y devuelve la recaudacion del zoologico en un rango de fechas.
     * @param p_fecha fecha desde
     * @param p_fechaHasta fecha hasta
     * @return el monto recaudado en formato double
     */
    public double recaudacion(Calendar p_fecha, Calendar p_fechaHasta) {
        double total = 0;
        Calendar fechaVisita = null;

        for(Visitante unVisitante : this.getVisitantes()) {
            fechaVisita = unVisitante.getFechaVisita();
            
            if(fechaVisita.equals(p_fecha) || fechaVisita.equals(p_fechaHasta) ||
               (fechaVisita.after(p_fecha) && fechaVisita.before(p_fechaHasta))) {
                total += unVisitante.entrada();
            }
        }

        return total;
    }
    /*  fecha.before(otraFecha) → devuelve true si es anterior.
        fecha.after(otraFecha) → devuelve true si es posterior.
        fecha.equals(otraFecha) → devuelve true si son exactamente iguales.*/
}

