/**
 * La clase abstracta Etiqueta representa una etiqueta con un costo base.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public abstract class Etiqueta {
    //V.I
    private double costo;

    //CONSTRUCTOR
    public Etiqueta(double p_costo) {
        this.setCosto(p_costo);
    }

    //SETTERS
    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }
    //GETTERS
    public double getCosto() {
        return this.costo;
    }

    //METODOS DE COMPORTAMIENTO
    
    /**
     * Calcula y devuelve el precio total de la etiqueta.
     */
    public abstract double precio(int p_q);

    /**
     * Devuelve una cadena con el tipo y el costo de la etiqueta
     * @return el tipo y costo en formato String
     */
    public String toString() {
        return "Tipo " + this.tipo() + " - Costo: $" + this.getCosto() +
                " - "; 
    }

    /**
     * Devuelve el tipo de etiqueta.
     */
    protected abstract String tipo();
}