
/**
 * La clase Simple representa un tipo especial de Cargo.
 * Es una especialización de la clase Cargo, con caracteristicas
 * propias de los cargos simples.
 * 
 * @author Torres Jemina Cesia
 * @version 1.0
 */
public class Simple extends Cargo{ //HERENCIA -> ESPECIALIZACION
    
    //CONSTRUCTOR 
    public Simple (String p_nombreCargo, double p_sueldoBasico, 
                        int p_anioIngreso) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, 
                20);
    } 
    
    //METODOS
    /**
     * Muestra por pantalla el titulo del cargo simple.
     */
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter Simple----\n");
    }
}
