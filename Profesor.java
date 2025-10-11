import java.util.*;
/**
 * La clase Profesor representa a un tipo de Persona que ejerce
 * la docencia. Es una especializacion de la clase Persona.
 * Hereda los atributos y metodos de Persona (nombre, edad, etc.)
 * y agrega caracteristicas especificas de un Profesor, como un titulo 
 * profesional, cargos, etc.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Profesor extends Persona{
    //V.I
    private String titulo;
    private Cargo[] cargos; //1...3 Un profesor TIENE cargos (agregacion)
    
    //CONSTRUCTORES
    public Profesor(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha,
                    String p_titulo) {
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setTitulo(p_titulo);
        this.setCargos(new Cargo [3]);
    }
 
    //SETTERS
    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }
    private void setCargos(Cargo[] p_cargos) {
        this.cargos = p_cargos;
    }
    
    //GETTERS
    public String getTitulo() {
        return this.titulo;
    }
    public Cargo[] getCargos() {
        return this.cargos;
    }
    
    //METODOS PARA EL MANEJO DE ARRAY
    /**
     * Añade un cargo a la lista de cargos (max 3).
     * 
     * @param p_cargo cargo nuevo
     */
    public void agregarCargo(Cargo p_cargo) {
        for (int i = 0; i < this.getCargos().length; i++) {
            if (this.getCargos()[i] == null) {
                this.getCargos()[i] = p_cargo;
                return;
            }
        }
        System.out.println("No se pueden agregar mas cargos (maximo 3).");
    }
    
    /**
     * Quita un cargo de la lista.
     * 
     * @param p_pos posicion del cargo a quitar
     */
    public void quitarCargo(int p_pos) {
        if (p_pos >= 0 && p_pos < this.getCargos().length) {
            this.getCargos()[p_pos] = null;
        } else {
            System.out.println("Posicion invalida.");
        }
    }
    
    //METODOS DE COMPORTAMIENTO
    /**
     * Calcula y devuelve el sueldo total del profesor a partir de los
     * sueldos totales por cargos que tenga.
     * 
     * @return un valor de tipo double
     */
    public double sueldoTotal() {
        double suma = 0;
        for(Cargo unCargo : this.getCargos()) {
            if(unCargo != null) {
                suma += unCargo.sueldoDelCargo();
            }
        }
        return suma;
    }
    
    /**
     * Muestra por pantalla los datos de los cargos del profesor.
     */
    public void listarCargos() {
        System.out.println("\t-***** Cargos Asignados *****-");
        System.out.println("-----------------------------------------------");
        for(Cargo unCargo : this.getCargos()) {
            if(unCargo != null) {
                unCargo.mostrarCargo();
            }
        }
    }
    
    /**
     * Muestra por pantalla los datos basicos del profesor, su titulo, 
     * una lista con los datos de sus cargos y su sueldo total.
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("Titulo: " + this.getTitulo());
        this.listarCargos();
        System.out.println("** Sueldo Total: $" + this.sueldoTotal() + " **");
    }
    
    /**
     * Devuelve el DNI del profesor, nombre y apellido, y sueldo total percibido.
     * @return una cadena de caracteres
     */
    public String mostrarLinea() {
        return "DNI: " + super.getNroDni() + " - Nombre: " +
                super.nomYApe() + " - SueldoTotal: $" + this.sueldoTotal();
    }
}