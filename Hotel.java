/**
 * La clase Hotel es un tipo de Alojamiento para personas.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Hotel extends Alojamiento {
    //V.I
    private String tipoHabitacion;

    //CONSTRUCTOR
    /**
     * Hotel con tipo de habitacion.
     * 
     * @param p_tipoHabitacion tipo de habitacion
     * @param p_nombre nombre del hotel
     * @param p_precioBase precio base por dia
     * @param p_dias cantidad de dias a alojarse
     * 
     */
    public Hotel(String p_tipoHabitacion,
                String p_nombre, double p_precioBase, int p_dias) {
        super(p_nombre, p_precioBase, p_dias);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    //SETTERS
    private void setTipoHabitacion(String p_tipoHabitacion) {
        this.tipoHabitacion = p_tipoHabitacion;
    }

    //GETTERS
    public String getTipoHabitacion() {
        return this.tipoHabitacion;
    }

    //METODOS
    /**
     * Calcula y devuelve el costo total para el alojamiento hotel.
     * Resulta de sumar el costo total de alojamiento mas $20 por dia por cada habitacion
     * si es "Single" sino $35 si es "Double".
     * 
     * @return el costo total en formato double
     */
    @Override
    public double costo() {
        if(this.getTipoHabitacion().equalsIgnoreCase("Single")) {
            return super.costo() + (20 * this.getDias());
        }
        else {
            if(this.getTipoHabitacion().equalsIgnoreCase("Double")) {
                return super.costo() + (35 * this.getDias());
            }
            return super.costo();
        }
    }

    /**
     * Muestra por pantalla la liquidacion del alquiler de la cabaña.
     */
    @Override
    public void liquidar() {
        super.liquidar();
        System.out.println("Habitacion " + this.getTipoHabitacion() +
                "\nTotal: -----> $" + (this.costo() + this.costoServicios()));
    }

    /**
     * Determina si el alojamiento pasado por parametro es un hotel.
     * 
     * @param p_alojamiento alojamiento
     * @return 1 si es hotel, 0 si no lo es
     */
    @Override
    public int contar(String p_alojamiento) {
        if(p_alojamiento.equalsIgnoreCase("Hotel")) {
            return 1;
        } 
        else {
            return 0;
        }
    }

}