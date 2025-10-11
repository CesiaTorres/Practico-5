import java.util.*;
/**
 * La clase Alumno representa a un estudiante con un número de 
 * libreta universitaria y dos notas.

 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Alumno extends Persona {
    //V.I
    private int lu;
    private double nota1;
    private double nota2;
    private ArrayList<Persona> personas;
    
    //CONSTRUCTOR
    /**
     * Constructor que inicializa LU, nombre y apellido.
     * Las notas se inicializan en cero.
     * 
     * @param p_lu numero de libreta universitaria
     * @param p_nombre nombre del alumno
     * @param p_apellido apellido del alumno
     */
    public Alumno(int p_dni, int p_lu, String p_nombre, 
                String p_apellido, Calendar p_fecha) {
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setLu(p_lu);
        this.setNota1(0);
        this.setNota2(0);
    }
    
    //SETTERS
    public void setLu(int p_lu) {
        this.lu = p_lu;
    }
    public void setNota1(double p_nota1) {
        this.nota1 = p_nota1;
    }
    public void setNota2(double p_nota2) {
        this.nota2 = p_nota2;
    }
    
    //GETTERS
    public int getLu() {
        return this.lu;
    }
    public double getNota1() {
        return this.nota1;
    }
    public double getNota2() {
        return this.nota2;
    }
    
    //METODOS   
    /**
     * Calcula si el alumno aprueba.
     * Condicion: promedio > 7 y ambas notas ≥ 6.
     * 
     * @return true si aprueba, false si no
     */
    private boolean aprueba() {
        if(promedio() > 7.0 && (getNota1() >= 6 && getNota2() >= 6)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Retorna la leyenda de aprobacion segun aprueba().
     * @return "APROBADO" o "DESAPROBADO"
     */
    private String leyendaAprueba() {
        if(this.aprueba()) {
            return "APROBADO";
        }
        else {
            return "DESAPROBADO";
        }
    }
    
    /**
     * Calcula el promedio de las dos notas.
     * @return promedio de notas
     */
    public double promedio() {
        return (this.getNota1() + this.getNota2()) / 2;
    }

    /**
     * Muestra por consola la información completa del alumno:
     * nombre y apellido, LU, notas, promedio y estado de aprobacion.
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("LU: " + this.getLu() + " \tNotas: " + 
                            this.getNota1() + " - " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + " - " +
                            this.leyendaAprueba());
    }
}