import java.util.*;
/**
 * Write a description of class Cargo here.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Cargo {
    //V.I
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;
    
    //CONSTRUCTOR
    /**
     * Cargo al que se le atribuye un nombre, un sueldo basico, 
     * un año de ingreso y horas que se cumplen en el mismo.
     */
    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso,
                    int p_horasDeDocencia) {
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
        this.setHorasDeDocencia(p_horasDeDocencia);
    }
    
    //SETTERS
    private void setNombreCargo(String p_nombreCargo) {
        this.nombreCargo = p_nombreCargo;
    }
    private void setSueldoBasico(double p_sueldo) {
        this.sueldoBasico = p_sueldo;
    }
    private void setAnioIngreso(int p_anio) {
        this.anioIngreso = p_anio;
    }   
    private void setHorasDeDocencia(int p_horas) {
        this.horasDeDocencia = p_horas;
    }
    
    //GETTERS
    private String getNombreCargo() {
        return this.nombreCargo;
    }
    private double getSueldoBasico() {
        return this.sueldoBasico;
    }
    private int getAnioIngreso() {
        return this.anioIngreso;
    }   
    private int getHorasDeDocencia() {
        return this.horasDeDocencia;
    }
    
    //METODOS
    /**
     * Calcula y devuelve la antiguedad en el cargo.
     * 
     * @return un valor de tipo int
     */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioActual = fechaHoy.get(Calendar.YEAR);
        return (anioActual - this.getAnioIngreso());
    }
    
    /**
     * Calcula y devuelve el adicional a cobrar por año de antiguedad en funcion
     * del sueldo basico.
     * 
     * @return un valor de tipo double
     */
    public double adicionalXAntiguedad() {
        return (this.getSueldoBasico() * 0.01) * this.antiguedad();
    }
    
    /**
     * Calcula y devuelve el sueldo total del cargo.
     * 
     * @return un valor de tipo double
     */
    public double sueldoDelCargo() {
        return this.sueldoBasico + this.adicionalXAntiguedad();
    }
    
    /**
     *  Muestra por pantalla los datos del cargo.
     */
    public void mostrarCargo() {
        System.out.println(this.getNombreCargo() + " - Sueldo Basico: $" +
                           this.getSueldoBasico() + " - Sueldo Cargo: $" + 
                           this.sueldoDelCargo() + " - Antiguedad: " +
                           this.antiguedad() + "\nHoras Docencia: " +
                           this.getHorasDeDocencia());
    }
}