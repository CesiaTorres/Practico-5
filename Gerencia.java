import java.util.*;
/**
 * La clase Gerencia gestiona una coleccion de alojamientos.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Gerencia {
    //V.I
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados; //0...*

    //CONSTRUCTOR
    /**
     * Crea una gerencia con el nombre y sin alojamientos.
     * @param p_nombre nombre de la gerencia
     */
    public Gerencia(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlojamientosAlquilados(new ArrayList<Alojamiento>());
    }

    //SETTERS
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setAlojamientosAlquilados(ArrayList<Alojamiento> p_alojamientos) {
        this.alojamientosAlquilados = p_alojamientos;
    }

    //GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public ArrayList<Alojamiento> getAlojamientosAlquilados() {
        return this.alojamientosAlquilados;
    }

    //METODOS PARA EL MANEJO DE ALOJAMIENTOS
    /**
     * Agrega un alojamiento a la coleccion de alojamientos gestionados.
     * @param p_alojamiento alojamiento a agregar
     * @return true si se pudo agregar, false caso contrario
     */
    public boolean agregarAlojamiento(Alojamiento p_alojamiento) {
        return this.getAlojamientosAlquilados().add(p_alojamiento);
    }
    /**
     * Elimina un alojamiento de la coleccion de alojamientos gestionados.
     * @param p_alojamiento alojamiento a eliminar
     * @return true si se pudo eliminar, false caso contrario
     */
    public boolean eliminarAlojamiento(Alojamiento p_alojamiento) {
        return this.getAlojamientosAlquilados().remove(p_alojamiento);
    }
    /**
     * Busca y devuelve un alojamiento de la coleccion de alojamientos gestionados
     * segun su nombre en la coleccion.
     * @param p_nombre nombre del alojamiento a buscar
     * @return el objeto Alojamiento si se encontro, null caso contrario
     */
    public Alojamiento buscarAlojamiento(String p_nombre) {
        for(Alojamiento alojamiento : this.getAlojamientosAlquilados()) {
            if(alojamiento.getNombre().equalsIgnoreCase(p_nombre)) {
                return alojamiento;
            }
        }
        return null;
    }
    /**
     * Busca y devuelve un alojamiento de la coleccion de alojamientos gestionados
     * segun su indice en la coleccion.
     * @param p_indice indice del alojamiento a buscar
     * @return el objeto Alojamiento si se encontro, null caso contrario
     */
    public Alojamiento buscarAlojamiento(int p_indice) {
        if(p_indice >= 0 && p_indice < this.cantidadAlojamientos()) {
            return this.getAlojamientosAlquilados().get(p_indice);
        }
        return null;
    }
    /**
     * Devuelve la cantidad de alojamientos gestionados.
     * @return cantidad de alojamientos en formato int
     */
    public int cantidadAlojamientos() {
        return this.getAlojamientosAlquilados().size();
    }

    //METODOS DE COMPORTAMIENTO 
    /**
     * Cuenta y devuelve la cantidad de alojamientos del tipo pasado por parametro.
     * @param p_alojamiento tipo de alojamiento a contar
     * @return cantidad de alojamientos del tipo en formato int
     */
    public int contarAlojamiento(String p_alojamiento) {
        int contador = 0;
        for(Alojamiento alojamiento : this.getAlojamientosAlquilados()) {
            contador += alojamiento.contar(p_alojamiento);
        }
        return contador;
    
    }
    /**
     * Muestra por pantalla la liquidacion de todos los alojamientos gestionados.
     */
    public void liquidar() {
        System.out.println("Gerencia " + this.getNombre());
        System.out.println("Liquidacion ---------------------");
        for(Alojamiento unAlojamiento : this.getAlojamientosAlquilados()) {
            unAlojamiento.liquidar(); //POLIMORFISMO
        }
    }

    /**
     * Muestra por pantalla la liquidacion de todos los alojamientos gestionados.
     * Ademas muestra la cantidad de alojamientos por tipo.
     */
    public void mostrarLiquidacion() {
        this.liquidar();
        System.out.println("\nAlojamiento tipo Hotel -----> " + this.contarAlojamiento("Hotel"));
        System.out.println("Alojamiento tipo Cabaña -----> " + this.contarAlojamiento("Cabaña"));
    }
}

