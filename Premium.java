/**
 * La clase Premium representa una etiqueta de tipo premium. 
 * Cuenta con un costo base, una cantidad de colores y un adicional segun
 * la cantidad de colores. 
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Premium extends Etiqueta {
    //V.I
    private int colores;

    //CONSTRUCTOR
    /**
     * Crea una etiqueta premium con un costo base y una cantidad de colores.
     * @param p_costo costo base de la etiqueta
     * @param p_colores cantidad de colores en la etiqueta
     */
    public Premium(double p_costo,int p_colores) {
        super(p_costo);
        this.setColores(p_colores);
    }

    //SETTERS
    private void setColores(int p_colores) {
        this.colores = p_colores;
    }
    //GETTERS
    public int getColores() {
        return this.colores;
    }
    
    //METODOS DE COMPORTAMIENTO
    
    /**
     * Calcula y devuelve el precio total de las etiquetas premium.
     * @param p_q cantidad de etiquetas
     * @return precio total en formato double
     */
    @Override
    public double precio(int p_q) {
        double precioParcial = this.getCosto() * p_q;
        return precioParcial + (precioParcial * this.adicional());
         
    }

    /**
     * Calcula y devuelve el costo adicional a aplicar segun la cantidad de colores.
     * @return costo adicional en formato double
     */
    private double adicional() {
        if(this.getColores() == 2) {
            return 0.05;
        } else if(this.getColores() == 3) {
            return 0.07;
        } else if(this.getColores() > 3) {
             // se aplica 3% por cada color
            return this.getColores() * 0.03;
        } else {
            return 0;
        }
    }

    /**
     * Devuelve el tipo de etiqueta premium.
     * @return tipo de etiqueta en formato String
     */
    @Override
    protected String tipo() {
        return "Premium";
    }

    /**
     * Devuelve una cadena con el tipo y el costo de la etiqueta. Ademas,
     * al ser premium, incluye la cantidad de colores.
     * @return el tipo, costo y colores en formato String
     */
    @Override
    public String toString() {
        return super.toString() + "Colores: " + this.getColores();
    }
}
