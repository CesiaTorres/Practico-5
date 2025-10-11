import java.util.*;
/**
 * La clase Empleado representa a una persona con un numero de CUIL, un sueldo basico 
 * y una fecha de ingreso que trabaja para una empresa.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */

public class Empleado extends Persona {
    //V.I
    private long cuil;
    private double sueldoBasico;
    private Calendar fechaIngreso;

    //CONSTRUCTORES
    /**
     * Empleado con apellido, nombre, DNI, fecha de nacimiento, sueldo basico y año de ingreso.
     * 
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_dni número de DNI del empleado
     * @param p_fechaNacimiento fecha de nacimiento con dia, mes y año.
     * @param p_sueldoBasico sueldo basico del empleado
     * @param p_anioIngreso año de ingreso a la empresa del empleado
     */
    public Empleado (long p_cuil, String p_apellido, String p_nombre, int p_dni, 
            Calendar p_fechaNacimiento, double p_sueldoBasico, int p_anioIngreso) {
        super(p_dni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
    }
    
    /**
     * Empleado con apellido, nombre, DNI, fecha de nacimiento, sueldo basico y fecha de ingreso.
     * 
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_dni número de DNI del empleado
     * @param p_fechaNacimiento fecha de nacimiento con dia, mes y año.
     * @param p_sueldoBasico sueldo basico del empleado
     * @param p_fechaIngreso fecha de ingreso a la empresa con dia, mes y año.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, int p_dni, 
            Calendar p_fechaNacimiento, double p_sueldoBasico, Calendar p_fechaIngreso) {
        super(p_dni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_sueldoBasico);
        this.setFechaIngreso(p_fechaIngreso);
    }
    
    //SETTERS
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }
    private void setAnioIngreso(int p_anio){
        this.fechaIngreso = new GregorianCalendar(p_anio,0,1);
    }
    private void setFechaIngreso(Calendar p_fecha) {
        this.fechaIngreso = p_fecha;
    }
    private void setSueldoBasico (double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }
    
    //GETTERS
    public long getCuil() {
        return this.cuil;
    }
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }
    public int getAnioIngreso() {
        return this.fechaIngreso.get(Calendar.YEAR);
    }   
    public Calendar getFechaIngreso() {
        return this.fechaIngreso;
    }

    //METODOS
    /**
     * Devuelve los años de antiguedad del empleado.
     * 
     * @return valor de tipo int
     */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar(); 
        int anioHoy = fechaHoy.get(Calendar.YEAR); //Obtiene el año actual
        return (anioHoy - this.getAnioIngreso());
    }
    
    /**
     * Suma los descuentos en obra social que corresponde al 2% del sueldo basico y el seguro de vida que corresponde a $1500.
     * 
     * @return valor de tipo double
     */
    private double descuento() {
        return (this.getSueldoBasico() * 0.02) + 1500;
    }
    
    /**
     * Calcula el adicional a cobrar sobre el sueldo basico.
     * 
     * @return valor de tipo double
     */
    private double adicional() {    
        if (this.antiguedad() < 2) {
            return this.getSueldoBasico() * 0.02; 
        } else if (this.antiguedad() >= 2 && this.antiguedad() < 10){
            return this.getSueldoBasico() * 0.04; 
        } else {
            return this.getSueldoBasico() * 0.06; 
        }
        
    }
    
    /**
     * Devuelve el sueldo neto del empleado.
     * 
     * @return valor de tipo double
     */
    public double sueldoNeto() {
        return (this.getSueldoBasico() + this.adicional()) - this.descuento();
    }
    
    /**
     * Devuelve el Nombre y Apellido del empleado, en ese orden.
     * 
     * @return cadena de caracteres
     */
    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * Devuelve el Apellido y Nombre del empleado, en ese orden.
     * 
     * @return cadena de caracteres
     */
    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre();
    }
    
    /**
     * Muestra en pantalla la informacion del empleado.
     */
    public void mostrar() {
        super.mostrar();
        System.out.println ("CUIL: " + this.getCuil() + "\t" + "Antiguedad: " + this.antiguedad() + " años de servicio");
        System.out.println ("Sueldo Neto: $" + this.sueldoNeto());
    }
    
    /**
     * Devuelve una cadena de caracteres con la info del empleado.
     * 
     * @return cadena de caracteres
     */
    public String mostrarLinea() {
        return "\n" + this.getCuil() + "\t" + this.getApellido() + ", " + this.getNombre() + "  ................. $" + this.sueldoNeto(); 
    }
    
    public boolean esAniversario() {
        Calendar fechaHoy = new GregorianCalendar();
        return fechaHoy.get(Calendar.DAY_OF_MONTH) == this.getFechaIngreso().get(Calendar.DAY_OF_MONTH)
            && fechaHoy.get(Calendar.MONTH) == this.getFechaIngreso().get(Calendar.MONTH);
    }

}
    
    