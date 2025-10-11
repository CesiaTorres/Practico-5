import java.util.*;
/**
 * La clase Facultad representa una unidad academica que contiene
 * profesores. Esta clase gestiona la información de los profesores
 * asociados a la facultad y sus operaciones relacionadas.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Facultad {
    //V.I
    private String nombre;
    private HashMap<Integer, Profesor> profesores;
    //private ArrayList<Profesor> profesores; //Una facultad TIENE profesores (agregacion)
    
    //CONSTRUCTOR
    /**
     * Facultad con nombre y lista de profesores ingresadas por parametro.
     * 
     * @param p_nombre nombre de la facultad
     * @param p_profesores lista de profesores
     */
    public Facultad(String p_nombre, HashMap<Integer, Profesor> p_profesores) {
        this.setNombre(p_nombre);
        this.setProfesores(p_profesores);
    }
    
    /**
     * Facultad con nombre y sin profesores.
     * 
     * @param p_nombre nombre de la facultad
     */
    public Facultad(String p_nombre) {
        this.setNombre(p_nombre);
        this.setProfesores(new HashMap<Integer, Profesor>());
    }
    
    //SETTERS
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setProfesores(HashMap<Integer, Profesor> p_profesores) {
        this.profesores = p_profesores;
    }
    
    //GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public HashMap<Integer, Profesor> getProfesores() {
        return this.profesores;
    }
    
    //METODOS PARA EL MANEJO DE ARRAYLIST
    public Profesor agregarProfesor(Profesor p_profesor) {
        return this.getProfesores().put(p_profesor.getNroDni(), p_profesor);
    }
    public Profesor quitarProfesor(int p_dni) {
        return this.getProfesores().remove(p_dni);
    }
    public int contarProfesores() {
        return this.getProfesores().size();
    }
    public boolean esProfesor(int p_dni) {
       return this.getProfesores().containsKey(p_dni); 
    }
    public Profesor buscarProfesor(int p_dni) {
        return this.getProfesores().get(p_dni);
    }
    
    
    //METODOS DE COMPORTAMIENTO
    /**
     * Calcula y devuelve el monto total a pagar en concepto de sueldos.
     * 
     * @return un valor de tipo double
     */
    public double totalAPagar() {
        double sueldosTotales = 0;
        for(Profesor unProfesor : this.getProfesores().values()) {
            sueldosTotales += unProfesor.sueldoTotal();
        }
        return sueldosTotales;
    }
    
    /**
     * Muestra por pantalla la nomina de profesores junto con el total 
     * de sueldos a pagar.
     */
    public void nominaProfesores() {    
        System.out.println("*************** Nómina Facultad: " + this.getNombre());
        System.out.println("-------------------------------------------");
        for(Profesor unProfesor : this.getProfesores().values()) {
            System.out.println(unProfesor.mostrarLinea());
        }
        System.out.println("-------------------------------------------");
        System.out.println("Total a pagar: $" + this.totalAPagar());
    }
    
    /**
     * Muestra por pantalla la lista de cargos de todos los profesores.
     */
    public void listarProfesorCargos() {
        System.out.println("***** Detalle de Profesores y cargos de Facultad: " + 
                            this.getNombre() + "*****");
        System.out.println("--------------------------------------------------------------");
        for(Profesor unProfesor : this.getProfesores().values()) {
            System.out.println("------------------ **** -------------------");
            unProfesor.mostrar();
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("Hay %d profesores \n", this.getProfesores().size());
    }
}