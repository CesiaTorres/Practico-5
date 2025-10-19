/**
 * La clase Comun representa una etiqueta de tipo comun.
 * Cuenta con un costo base, un plus adicional y un sistema de 
 * descuentos segun la cantidad de etiquetas.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Comun extends Etiqueta {
    //V.I
    private double plus;

    //CONSTRUCTOR
    /**
     * Crea una etiqueta comun con un costo fijo de 100 y un plus adicional
     * @param p_plus costo adicional por etiqueta
     */
    public Comun(double p_plus) {
        super(100);
        this.setPlus(p_plus);
    }

    //SETTERS
    private void setPlus(double p_plus) {
        this.plus = p_plus;
    }
    //GETTERS
    public double getPlus() {
        return this.plus;
    }

    //METODOS DE COMPORTAMIENTO
    @Override
    /**
     * Metodo que calcula el precio de la etiqueta comun
     * @param p_q cantidad de etiquetas
     * @return precio total de las etiquetas
     */
    public double precio(int p_q) {
        double precioParcial = (this.getCosto() * p_q) + this.getPlus();
        return precioParcial - (precioParcial * this.descuento(p_q));
    }

    /**
     * Devuelve el descuento a aplicar segun la cantidad de etiquetas
     * @param p_q cantidad de etiquetas
     * @return descuento a aplicar
     */
    private double descuento(int p_q) {
        if(p_q > 10 && p_q <= 50) {
            return 0.02;
        }else if(p_q > 50 && p_q <= 100) {
            return 0.05;
        } else if(p_q > 100) {
            return (((p_q - 100)/10) * 0.01) + 0.05;
        } else {
            return 0;
        }
    }

    /**
     * Devuelve el tipo de etiqueta comun.
     * @return tipo de etiqueta en formato cadena
     */
    @Override
    protected String tipo() {
        return "Comun";
    }

    /**
     * Devuelve una cadena con el tipo y el costo de la etiqueta. Ademas,
     * al ser comun, incluye el diseño (plus).
     * @return tipo, costo y diseño en formato String
     */
    @Override
    public String toString() {
        return super.toString() + "Diseño: $" + this.getPlus();
    }

}
