
/**
 * La clase Elipse representa una figura geométrica elíptica en el plano cartesiano,
 * definida por su centro y las longitudes de sus semiejes mayor y menor.
 * Permite calcular su superficie, desplazar su posicion, medir la distancia a otra elipse
 * y determinar cual de dos elipses posee mayor superficie.
 * 
 * @author Torres Jemina Cesia
 * @author Reyes Kevin Josue
 * @version 1.0
 */
public class Elipse extends FiguraGeometrica{
    //ATRIBUTOS
    private double sEjeMayor;
    private double sEjeMenor;
    
    //CONSTRUCTOR
    /**
     * Elipse con centro, semieje mayor y semieje menor.
     * 
     * @param p_centro centro de la elipse
     * @param p_sEjeMayor semieje mayor de la elipse
     * @param p_sEjeMenor semieje menor de la elipse
     */
    public Elipse(Punto p_centro, double p_sEjeMayor, double p_sEjeMenor) {
        super(p_centro);
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }
    
    /**
     * Elipse con centro (0,0), semieje mayor y semieje menor.
     * 
     * @param p_sEjeMayor semieje mayor de la elipse
     * @param p_sEjeMenor semieje menor de la elipse
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor) {
        super(new Punto());
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }
    
    //SETTERS
    private void setSEjeMayor(double p_sEjeMayor) {
        this.sEjeMayor = p_sEjeMayor;
    }
    private void setSEjeMenor(double p_sEjeMenor) {
        this.sEjeMenor = p_sEjeMenor;
    }
    
    //GETTERS
    public double getSEjeMayor() {
        return this.sEjeMayor;
    }
    public double getSEjeMenor() {
        return this.sEjeMenor;
    }
    
    //METODOS
    /**
     * Devuelve el nombre de la figura.
     * 
     * @return una cadena de caracteres
     */
    public String nombreFigura() {
        return "****** Elipse ******";
    }
    
    /**
     * Devuelve la superficie de la elipse.
     * Superficie = Pi * r (semieje mayor) * s (semieje menor).
     * 
     * @return un valor de tipo double
     */
    public double superficie() {
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }
    
    /**
     * Desplaza el centro de la elipse.
     * 
     * @param p_dx nueva coordenada x
     * @param p_dy nueva coordenada y
     */
    public void desplazar(double p_dx, double p_dy) {
        this.getOrigen().desplazar(p_dx, p_dy);
    }
    
    /**
     * Calcula y devuelve la distancia desde el centro de la elipse
     * al centro de otra elipse.
     * 
     * @param otraElipse otra elipse
     * @return un valor de tipo double
     */
    public double distanciaA(Elipse otraElipse) {
        return this.getOrigen().distanciaA(otraElipse.getOrigen());
    }
    
    /**
     * Determina y devuelve la elipse de mayor superficie.
     * 
     * @param otraElipse otra elipse
     * @return un objeto de tipo Elipse
     */
    public Elipse elMayor(Elipse otraElipse) {
        if(this.superficie() >= otraElipse.superficie()) {
          return this;
      }
      else {
          return otraElipse;
      }
    }
    
    /**
     * Muestra por pantalla las caracteristicas de la elipse.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        System.out.println("Centro: " + this.getOrigen().coordenadas() + 
                "- Semieje Mayor: " + this.getSEjeMayor() + " - Semieje Menor: " +
                this.getSEjeMenor() + "\nSuperficie: " + this.superficie());
    }
}