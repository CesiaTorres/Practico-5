/**
 * La clase Cabaña es un tipo de Alojamiento para personas.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Cabaña extends Alojamiento {
    //V.I
    private int nroHabitaciones;

    //CONSTRUCTOR
    /**
     * Cabaña con numero de habitacion.
     * 
     * @param p_nroHabitacion cantidad de habitaciones
     * @param p_nombre nombre de la cabaña
     * @param p_precioBase precio base por dia
     * @param p_dias cantidad de dias a alojarse
     */
    public Cabaña (int p_nroHabitaciones, 
                   String p_nombre, double p_precioBase, int p_dias) {
        super(p_nombre, p_precioBase, p_dias);
        this.setNroHabitaciones(p_nroHabitaciones);            
    }

    //SETTERS
    public void setNroHabitaciones(int p_nroHabitaciones) {
        this.nroHabitaciones = p_nroHabitaciones;
    }

    //GETTERS
    public int getNroHabitaciones() {
        return this.nroHabitaciones;
    }

    //METODOS DE COMPORTAMIENTO
    /**
     * Calcula y devuelve el costo total para el alojamiento cabaña.
     * Resulta de sumar el costo total de alojamiento mas $30 por dia por cada habitacion.
     * 
     * @return el costo total en formato double
     */
    @Override
    public double costo() {
        return super.costo() + (30 * this.getDias() * this.getNroHabitaciones());
    }

    /**
     * Muestra por pantalla la liquidacion del alquiler de la cabaña.
     */
    @Override
    public void liquidar() {
        super.liquidar();
        System.out.println("Cabaña con " + this.getNroHabitaciones() +
                " habitaciones\nTotal: -----> $" + (this.costo() + this.costoServicios()));
    }

    /**
     * Determina si el alojamiento pasado por parametro es una cabaña.
     * 
     * @param p_alojamiento alojamiento
     * @return 1 si es cabaña, 0 si no lo es
     */
    @Override
    public int contar(String p_alojamiento) {
        if(p_alojamiento.equalsIgnoreCase("Cabaña")) {
            return 1;
        } 
        else {
            return 0;
        }
    }
}

