/**
 * La clase Servicio representa un servicio adicional que puede ser agregado a un alojamiento.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Servicio {
    //V.I
    private String descripcion;
    private double precio;

    //CONSTRUCTOR
    /**
     * Crea un servicio con su descripcion y costo.
     * 
     * @param p_descripcion descripcion del servicio
     * @param p_costo costo del servicio
     */
    public Servicio(String p_descripcion, double p_precio) {
        this.setDescripcion(p_descripcion);
        this.setPrecio(p_precio);
    }

    //SETTERS
    private void setDescripcion(String p_descripcion) {
        this.descripcion = p_descripcion;
    }
    private void setPrecio(double p_precio) {
        this.precio = p_precio;
    }

    //GETTERS
    public String getDescripcion() {
        return this.descripcion;
    }
    public double getPrecio() {
        return this.precio;
    }
}