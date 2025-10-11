
/**
 * La clase Exclusivo representa un tipo especial de Cargo.
 * Es una especialización de la clase Cargo, con caracteristicas
 * propias de los cargos exclusivos.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Exclusivo extends Cargo { //HERENCIA -> ESPECIALIZACION
    //V.I
    private int horasDeInvestigacion;
    private int horasDeExtension;
    
    //CONSTRUCTOR 
    public Exclusivo (String p_nombreCargo, double p_sueldoBasico, 
                        int p_anioIngreso, int p_horasDeDocencia,
                        int p_horasInvestigacion, int p_horasExtension) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, 
                p_horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasInvestigacion);  
        this.setHorasDeExtension(p_horasExtension);
    }

    //SETTERS
    private void setHorasDeInvestigacion(int p_horas) {
        this.horasDeInvestigacion = p_horas;
    }
    private void setHorasDeExtension(int p_horas) {
        this.horasDeExtension = p_horas;
    }
    
    //GETTERS
    public int getHorasDeInvestigacion() {
        return this.horasDeInvestigacion;
    }
    public int getHorasDeExtension() {
        return this.horasDeExtension;
    }
    
    //METODOS
    /**
     * Muestra por pantalla los datos del cargo exclusivo.
     */
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter Exclusivo----");
        System.out.println("Horas investigación: " + this.getHorasDeInvestigacion());
        System.out.println("Horas extension: : " + this.getHorasDeExtension() + "\n");
    }
}