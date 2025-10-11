
/**
 * La clase SemiExclusivo representa un tipo especial de Cargo.
 * Es una especialización de la clase Cargo, con caracteristicas
 * propias de los cargos semiexclusivos.
 * 
 * @author Torres Jemina Cesia 
 * @version 1.0
 */
public class SemiExclusivo extends Cargo { //HERENCIA -> ESPECIALIZACION
    //V.I
    private int horasDeInvestigacion;
    
    //CONSTRUCTOR
    /**
     * Cargo semiexclusivo de 20 horas. 
     * Un minimo de 10hs deben ser dedicados a docencia y las 10hs restantes 
     * a investigacion o docencia.
     * 
     * @param p_nombreCargo nombre del cargo
     * @param p_sueldoBasico sueldo basico del cargo
     * @param p_anioIngreso año de ingreso al cargo
     * @param p_horasInvestigacion horas de investigacion del el cargo
     */
    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, 
                        int p_anioIngreso, int p_horasDeDocenciaExtra,
                        int p_horasInvestigacion) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, 
                10 + p_horasDeDocenciaExtra);
        this.setHorasDeInvestigacion(p_horasInvestigacion);
    }
    
    //SETTERS
    private void setHorasDeInvestigacion(int p_horas) {
        this.horasDeInvestigacion = p_horas;
    }
    
    //GETTERS
    public int getHorasDeInvestigacion() {
        return this.horasDeInvestigacion;
    }
    
    //METODOS
    /**
     * Muestra por pantalla los datos del cargo exclusivo.
     */
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter SemiExclusivo----");
        System.out.println("Horas investigación: " + this.getHorasDeInvestigacion()+ "\n");
    }
}