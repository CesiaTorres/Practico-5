
import java.util.*;
/**
 * La clase Alojamiento simula un lugar de alojamiento para personas, 
 * gestionado por una Gerencia. 
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public abstract class Alojamiento {
    //V.I
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicios; //0...*

    //CONSTRUCTOR
    /**
     * Alojamiento con nombre y precio base. Se registra
     * ademas la cantidad de dias de alquiler.
     * 
     * @param p_nombre nombre del alojamiento
     * @param p_precioBase precio base por dia
     * @param p_dias cantidad de dias a alojarse
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_dias) {
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDias(p_dias);
        this.setServicios(new ArrayList<Servicio>());
    }

    //SETTERS
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setPrecioBase(double p_precioBase) {
        this.precioBase = p_precioBase;
    }
    private void setDias(int p_dias) {
        this.diasAlquiler = p_dias;
    }
    private void setServicios(ArrayList<Servicio> p_servicios) {
        this.servicios = p_servicios;
    }


    //GETTERS
    public String getNombre() {
        return this.nombre;
    }
    public double getPrecioBase() {
        return this.precioBase;
    }
    public int getDias() {
        return this.diasAlquiler;
    }
    public ArrayList<Servicio> getServicio() {
        return this.servicios;
    }


    //METODOS PARA EL MANEJO DE SERVICIOS  
    /**
     * Agrega un servicio a la coleccion de servicios utilizados.
     * @param p_servicio servicio a agregar
     * @return true si se pudo agregar, false caso contrario
     */
    public boolean agregarServicio(Servicio p_servicio) {
        return this.getServicio().add(p_servicio);
    }
    /**
     * Elimina un servicio de la coleccion de servicios utilizados.
     * @param p_servicio servicio a eliminar
     * @return true si se pudo eliminar, false caso contrario
     */
    public boolean quitarServicio(Servicio p_servicio) {
        return this.getServicio().remove(p_servicio);
    }
    /**
     * Busca y devuelve un servicio de la coleccion de servicios utilizados
     * segun su posicion en la coleccion.
     * @param p_posicion posicion del servicio a buscar
     * @return el objeto Servicio si se encontro, null caso contrario
     */
    public Servicio buscarServicio(int p_posicion) {
        if(p_posicion < 0 || p_posicion >= this.contarServicios()) {
            return null;
        }
        return this.getServicio().get(p_posicion);
    }
    /**
     * Busca y devuelve un servicio de la coleccion de servicios utilizados
     * segun su descripcion en la coleccion.
     * @param p_descripcion descripcion del servicio a buscar
     * @return el objeto Servicio si se encontro, null caso contrario
     */
    public Servicio buscarServicio(String p_descripcion) {
        for(Servicio unServicio : this.getServicio()) {
            if(unServicio.getDescripcion().equalsIgnoreCase(p_descripcion)) {
                return unServicio;
            }
        }
        return null;
    }
    /**
     * Devuelve la cantidad de servicios utilizados por el cliente.
     * @return cantidad de servicios en formato int
     */
    public int contarServicios() {
        return this.getServicio().size();
    }


    //METODOS DE COMPORTAMIENTO
    /**
     * Debe calcular y devolver la cantidad de alojamientos alquilados
     * 
     * @param p_alojamiento alojamiento alquilado
     * @return cantidad de alojamientos ocupados en formato int
     */
    public abstract int contar(String p_alojamiento);

    /**
     * Calcula y devuelve el costo total del alojamiento, considerando el
     * precio base del alojamiento y la cantidad de dias reservados.
     * 
     * @return costo total en formato double
     */
    public double costo() {
        return this.getPrecioBase() * this.getDias();
    }

    /**
     * Muestra por pantalla la lista de servicios utilizados por el cliente.
     */
    public void listarServicios() {
        int i = 1;
        for(Servicio unServicio : this.getServicio()) {
            System.out.println(i++ + ". " + unServicio.getDescripcion() +
                            ": $" + unServicio.getPrecio());
        }
    }

    /**
     * Calcula y devuelve el costo total de los servicios utilizados por el cliente.
     * 
     * @return costo total en formato double
     */
    public double costoServicios() {
        double total = 0;
        for(Servicio unServicio : this.getServicio()) {
            total += unServicio.getPrecio();
        }
        return total;
    }

    /**
     * Muestra por pantalla la liquidacion de estadia, incluido los servicios.
     */
    public void liquidar() {
        System.out.println("\nAlojamiento: " + this.getNombre() + "\nCosto por " +
                this.getDias() + " dias: $" + this.getPrecioBase());
        this.listarServicios();
        System.out.println("...............................");
    }
}   
